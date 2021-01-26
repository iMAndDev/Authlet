package com.devmaksem.authlet.mainScreen

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.devmaksem.authlet.R
import com.devmaksem.authlet.base.BaseFragment
import com.devmaksem.authlet.data.SecretDao
import com.devmaksem.authlet.data.SecretRepository
import com.devmaksem.authlet.ext.updateCall
import com.devmaksem.authlet.ext.updateHashes
import com.devmaksem.authlet.mainScreen.dummy.listCodes
import com.devmaksem.authlet.mainScreen.item.ListItem
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment(R.layout.fragment_main) {

    private lateinit var secretRepository: SecretRepository
    private val timerLengthSeconds = 30L
    private var secondsRemaining = 30L
    private var timer: Timer? = null
    private var isTimerAvailable = true


    private lateinit var listAdapter: ListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar?.title = "Authlet"
        toolbar.setTitleTextColor(resources.getColor(R.color.colorSecondary))
        toolbar?.setNavigationIcon(R.drawable.smol_app_logo)

        settings.setOnClickListener {
            findNavController(it).navigate(R.id.action_mainFragment_to_settingsFragment)
        }

        listAdapter = ListAdapter { listItem ->
            copyCode(listItem.generatedHash)
        }

        sort_by_title.setOnClickListener {
        }

        sort_by_hash.setOnClickListener {
        }

        fab_add.setOnClickListener {
            findNavController(it).navigate(R.id.action_mainFragment_to_addCodeFragment)
        }


        setAdapter()
        initTimer()
    }

    override fun onPause() {
        super.onPause()
        isTimerAvailable = false
        countdown.progress = 0
        //timer!!.cancel()
    }


    override fun onResume() {
        super.onResume()
        isTimerAvailable = true
        updateCountdownUI()
    }


    private fun copyCode(desc: String) {
        val clipbrdMgr = requireContext()
            .getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        val clipData = ClipData.newPlainText("text", desc)
        clipbrdMgr.setPrimaryClip(clipData)

        Snackbar.make(containerMain, R.string.copied, 3000).show()
    }


    private fun setAdapter() {
        list.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
        }
        listAdapter.setItems(listCodes)
    }


    inner class Timer(millis: Long) : CountDownTimer(millis, 1000) {
        var millisUntilFinished = 0L

        override fun onTick(millisUntilFinished: Long) {

            updateCountdownUI()

            secondsRemaining = millisUntilFinished / 1000

            if ((millisUntilFinished < 1000L) || updateCall) {
                secondsRemaining = 30L
                updateTimer(secondsRemaining * 1000)
                updateCall = false
            }
        }

        override fun onFinish() {
            //Toast.makeText(context, "Refreshed", Toast.LENGTH_SHORT).show()
        }
    }


    private fun initTimer() {
        if (timer != null) {
            timer!!.cancel()
            countdown.progress = 0
        }
        countdown.max = timerLengthSeconds.toInt()
        startTimer()
    }


    private fun startTimer() {
        timer = Timer(secondsRemaining * 1000)
        timer!!.start()
    }


    private fun updateTimer(addMillis: Long) {

        if (timer != null) {
            val millis = timer!!.millisUntilFinished + addMillis

            timer!!.cancel()
            timer = Timer(millis)
            timer!!.start()
        } else {
            startTimer()
        }

        listCodes = updateHashes(listCodes)
        listAdapter.notifyDataSetChanged()
    }


    private fun updateCountdownUI() {
        if (isTimerAvailable) {
            countdown.progress = (timerLengthSeconds - secondsRemaining).toInt()
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val a = 1
    }
}
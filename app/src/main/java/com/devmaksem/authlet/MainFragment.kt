package com.devmaksem.authlet

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.devmaksem.authlet.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment(R.layout.fragment_main) {

    private val navigation: NavController by lazy { findNavController() }

    private val timerLengthSeconds = 30L
    private var secondsRemaining = 30L
    private var timer: Timer? = null

    private lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toast.makeText(context, "Done!", Toast.LENGTH_SHORT).show()

        //setContentView(R.layout.fragment_main)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar?.title = "Authlet"
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorSecondary))
        toolbar?.setNavigationIcon(R.drawable.smol_app_logo)


        listAdapter = ListAdapter() {listItem ->
            copyCode(listItem.description)
        }


        fab_add.setOnClickListener{
            androidx.navigation.Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_addCodeFragment)
        }

        countdown.max = timerLengthSeconds.toInt()
        setAdapter()
        startTimer()

        updateCountdownUI()
    }


    private fun copyCode(desc: String) {
        val clipbrdMgr = requireContext()
            .getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        val clipData = ClipData.newPlainText("text", desc)
        clipbrdMgr.setPrimaryClip(clipData)

        //Snackbar.make(, R.string.done_message, 1500).show()
    }


    private fun setAdapter() {
        list.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
        }
        listAdapter.setItems(listCodes)
    }


    inner class Timer(millis: Long): CountDownTimer(millis, 1000){
        var millisUntilFinished = 0L

        override fun onTick(millisUntilFinished: Long) {

            updateCountdownUI()

            secondsRemaining = millisUntilFinished / 1000
//            secText.text = secondsRemaining.toString()
            // TODO: make progress bar for list items

            if (millisUntilFinished < 1000L || updateCall) {
                secondsRemaining = 30L
                updateTimer(secondsRemaining * 1000)
                updateCall = false
            }
        }

        override fun onFinish() {
            Toast.makeText(context,"Done!", Toast.LENGTH_SHORT).show()
        }
    }


    private fun startTimer() {
        timer = Timer(secondsRemaining * 1000)
        timer!!.start()
    }


    private fun updateTimer(addMillis: Long) {

        if (timer != null){
            val millis = timer!!.millisUntilFinished + addMillis

            timer!!.cancel()
            timer = Timer(millis)
            timer!!.start()
        }
        else{
            startTimer()
        }

        updateHashes(listCodes)
    }


    private fun updateCountdownUI() {
        //countdown.progress = (timerLengthSeconds - secondsRemaining).toInt()
    }
}
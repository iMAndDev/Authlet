package com.devmaksem.authlet

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.devmaksem.authlet.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseFragment(R.layout.activity_main) {

    private val navigation: NavController by lazy { findNavController() }
//    private var secondsRemaining = 8L
//    private var timer: Timer? = null
//    private lateinit var randomSecretGenerator: RandomSecretGenerator
//    private lateinit var secret: ByteArray
//
//    private lateinit var listAdapter: ListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        toolbar?.setBackgroundColor(R.drawable.gradient_color)
        toolbar?.title = "  Authlet"
        toolbar?.setCollapseIcon(R.drawable.app_logo)

        //setContentView(R.layout.activity_main)
/*
        listAdapter = ListAdapter()

        setAdapter()

        //val clipbrd = getSystemService(Context.CLIPBOARD_SERVICE)

        randomSecretGenerator = RandomSecretGenerator()
        secret = randomSecretGenerator.createRandomSecret(HmacAlgorithm.SHA256)

        startTimer()*/
    }

//    private fun setAdapter() {
//        list.apply {
//            adapter = listAdapter
//            layoutManager = LinearLayoutManager(context)
//        }
//
//        val listCodes: ArrayList<ListItem> = arrayListOf(
//            ListItem("GitHub", "123456"),
//            ListItem("HRTC", "694200"),
//            ListItem("GitHub", "123456"),
//            ListItem("HRTC", "694200"),
//            ListItem("GitHub", "123456"),
//            ListItem("HRTC", "694200"),
//            ListItem("GitHub", "123456"),
//            ListItem("HRTC", "694200"),
//            ListItem("GitHub", "123456"),
//            ListItem("HRTC", "694200"),
//            ListItem("GitHub", "123456"),
//            ListItem("HRTC", "694200")
//        )
//
//        listAdapter.setItems(listCodes)
//    }
//
//    inner class Timer(millis: Long): CountDownTimer(millis, 1000){
//        var millisUntilFinished = 0L
//        override fun onFinish() = onTimerFinished()
//
//        override fun onTick(millisUntilFinished: Long) {
//            secondsRemaining = millisUntilFinished / 1000
//            checkTimerState()
//        }
//    }
//
//    private fun startTimer(){
//        timer = Timer(secondsRemaining * 1000)
//        timer!!.start()
//    }
//
//    private fun updateTimer(addMillis: Long) {
//        if (timer != null){
//            val millis = timer!!.millisUntilFinished + addMillis
//            timer!!.cancel()
//            timer = Timer(millis)
//
//            timer!!.start()
//        }
//        else{
//            startTimer()
//        }
//    }
//
//    private fun initTimer() {
//        startTimer()
//    }
//
//    private fun checkTimerState() {
//        //TODO: define checkTimerState
//    }
//
//    private fun onTimerFinished(){
//        //TODO: define onTimerFinished
//    }
//
//    private fun generateHash() {
//        val timestamp = Date(System.currentTimeMillis())
//        val code = GoogleAuthenticator(secret.toString()).generate(timestamp)
//        //generatedCode.text = "${SimpleDateFormat("HH:mm:ss").format(timestamp)} -> $code"
//    }
}
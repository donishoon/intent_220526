package com.dohn.intent_220526

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_message.*

class ViewMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_message)

//        화면에 들어오자마자 > 보내준 메시지를 추출해서 > 텍스트뷰에 반영

        val receivedMessage = intent.getStringExtra("msg")

        txtMessage.text = receivedMessage

    }
}
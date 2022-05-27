package com.dohn.intent_220526

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    1000이라는 숫자가 닉네임을 가지로 가는 거다 ㅡ 구별하기
    val REQ_CODE_NICKNAME = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMove.setOnClickListener {

//            다른 화면으로 이동하기
            val myIntent = Intent( this, OtherActivity::class.java )
            startActivity(myIntent)

        }

        btnSend.setOnClickListener {

//            1. 입력된 메시지를 변수에 저장
            val inputMessage = edtMessage.text.toString()

//            2. 메시지를 "들고" ViewMessage 화면으로 이동
            val myIntent = Intent(this, ViewMessageActivity::class.java)

//            myIntent에 메세지 첨부 후 이동
            myIntent.putExtra("msg", inputMessage)

            startActivity(myIntent)

        }

        btnEditN.setOnClickListener {

            val myIntent = Intent( this, EditNicknameActivity::class.java )
            startActivityForResult( myIntent, REQ_CODE_NICKNAME )

        }

        btnDial.setOnClickListener {

            val inputPhone = edtPhone.text.toString()

            val myUri = Uri.parse("tel:01058724832") // 띄어쓰기 끼어있으면 앱이 죽음

            val myIntent = Intent ( Intent.ACTION_DIAL, myUri )
            startActivity(myIntent)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        다른 화면에서 결과를 받아서 돌아오면 종류와 무관하게 무조건 실행되는 코드 영역(함수)

//        닉네임을 받으러 다녀온게 맞는지? > 대처방안만 코딩

        if (requestCode == REQ_CODE_NICKNAME) {

            if (resultCode == RESULT_OK) {

                val newNickname = data?.getStringExtra("nick")
                txtNickname.text = newNickname

            }

        }

    }

}
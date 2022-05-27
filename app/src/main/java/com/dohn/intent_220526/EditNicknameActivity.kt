package com.dohn.intent_220526

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nickname.*

class EditNicknameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nickname)

        btnOk.setOnClickListener {

//          입력한  닉네임을 들고 돌아가기

//            1. 입력한 내용을 변수로
            val inputNickname = edtNickname.text.toString()

//            2. 화면을 이동하는 길에 > 데이터 첨부 : Intent / putExtra

            val resultIntent = Intent() //

            resultIntent.putExtra("nick", inputNickname)

//            3. 화면의 결과 설정 (Ok 누른게 맞다 + 데이터 들고 돌아가도록)

            setResult(RESULT_OK, resultIntent)

//            4. 이전으로 복귀
            finish()

        }

    }
}
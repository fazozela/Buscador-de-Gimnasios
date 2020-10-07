package com.example.sucrefitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_send.setOnClickListener {
            var userName = edit_name.text.toString()

            var intentToMain = Intent(this, MainActivity::class.java)
            intentToMain.putExtra("keyName", userName)
            startActivity(intentToMain)
        }

    }
}
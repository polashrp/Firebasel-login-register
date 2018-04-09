package com.example.kotli.lukeapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var btnLogin:Button? =null
    private var btnSingup:Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         btnLogin = findViewById<Button>(R.id.button_login)
         btnSingup = findViewById(R.id.button_singup)

        btnLogin!!.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext,"Go to Login ",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@MainActivity,LoginActivity::class.java))
        })

        btnSingup!!.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext,"Go to Singup",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@MainActivity,SingupActivity::class.java))
        })


    }
}

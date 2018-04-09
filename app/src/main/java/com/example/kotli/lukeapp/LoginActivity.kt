package com.example.kotli.lukeapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    val mAuth  = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val login = findViewById<Button>(R.id.register) as Button
        val registerTxt = findViewById<View>(R.id.regTxt) as TextView

        login.setOnClickListener(View.OnClickListener {
            view-> loginFunction ()
        })
        registerTxt.setOnClickListener(View.OnClickListener {
            view -> register()
        })
    }

    private fun loginFunction() {
        val email = findViewById<EditText>(R.id.email) as EditText
        val password = findViewById<EditText>(R.id.password) as EditText

        var inputEmail = email.text.toString()
        var inputPass = password.text.toString()

        if (!inputEmail.isEmpty() && !inputPass.isEmpty()){
            mAuth.signInWithEmailAndPassword(inputEmail,inputPass).addOnCompleteListener(this, OnCompleteListener { task ->
              if (task.isSuccessful){
               startActivity(Intent(this@LoginActivity,AdminActivity::class.java))
                  Toast.makeText(this@LoginActivity,"Successly Login",Toast.LENGTH_SHORT).show()
              }else{
                  Toast.makeText(this@LoginActivity,"Error ",Toast.LENGTH_SHORT).show()
              }
            })

        }else{
            Toast.makeText(this@LoginActivity,"Please Enter your Email or Passsword" ,Toast.LENGTH_SHORT).show()
        }
    }
    private fun register(){
        startActivity(Intent(this@LoginActivity,SingupActivity::class.java))
    }
}

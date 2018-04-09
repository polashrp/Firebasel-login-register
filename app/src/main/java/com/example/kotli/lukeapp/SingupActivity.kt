package com.example.kotli.lukeapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SingupActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singup)


        val btnReg  = findViewById<Button>(R.id.register) as Button

        mDatabase = FirebaseDatabase.getInstance().getReference("Names")

        btnReg.setOnClickListener(View.OnClickListener {
            view -> register()
        })

    }

    private fun register() {
        val emailText = findViewById<EditText>(R.id.email) as EditText
        val passText = findViewById<EditText>(R.id.password) as EditText
        val nameText = findViewById<EditText>(R.id.name) as EditText

        var email_text = emailText.text.toString()
        var pass_text = passText.text.toString()
        var name_text = nameText.text.toString()

        if (!email_text.isEmpty() && !pass_text.isEmpty() && !name_text.isEmpty()){
            mAuth.createUserWithEmailAndPassword(email_text,pass_text).addOnCompleteListener(this, OnCompleteListener { task ->
                if (task.isSuccessful){
                    val user = mAuth.currentUser
                    val uid = user!!.uid
                    mDatabase.child(uid).child("Name").setValue(name_text)
                    Toast.makeText(this@SingupActivity,"Singup successfuly compleate ",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this@SingupActivity,"Error" ,Toast.LENGTH_SHORT).show()
                }
            })
        }else {
            Toast.makeText(this@SingupActivity,"Please enter Email Password Name " ,Toast.LENGTH_LONG).show()
        }
    }

}

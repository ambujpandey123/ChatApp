package com.example.chatapplicationap

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var edtEmail:EditText
    private lateinit var edtpass:EditText
    private lateinit var btnlogin:Button
    private lateinit var btnSignUp:Button
    private lateinit var mAuth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()

        edtEmail = findViewById(R.id.edt_email)
        edtpass = findViewById(R.id.edt_pass)
        btnlogin = findViewById(R.id.btnLogin)
        btnSignUp = findViewById(R.id.btnSignUp)

        btnSignUp.setOnClickListener{
            val intent = Intent(this,SignUp::class.java)
            startActivity(intent)
        }
        btnlogin.setOnClickListener{
            val email = edtEmail.text.toString()
            val password = edtpass.text.toString()

            login(email,password)
        }
    }

   private fun login(email:String,password:String){
    //logic for loging user

       mAuth.signInWithEmailAndPassword(email, password)
           .addOnCompleteListener(this) { task ->
               if (task.isSuccessful) {
                   // cogin success

                   val intent = Intent(this@Login,MainActivity::class.java)
                   finish()
                   startActivity(intent)

               } else {
                   Toast.makeText(this@Login,"User Doesn't exist",Toast.LENGTH_SHORT).show()
               }
           }
   }
}
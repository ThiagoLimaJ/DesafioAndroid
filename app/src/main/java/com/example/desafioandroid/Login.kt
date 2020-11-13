package com.example.desafioandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class Login : AppCompatActivity() {

    private lateinit var email: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var buttonRegister: MaterialButton
    private lateinit var buttonLogin: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonRegister = findViewById(R.id.btnRegister)
        buttonLogin = findViewById(R.id.btnLogin)
        email = findViewById(R.id.txtEmail)
        password = findViewById(R.id.txtPassword)

        buttonRegister.setOnClickListener() {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        buttonLogin.setOnClickListener() {
            verificaCamposLogin(email, password)
        }

    }

    private fun verificaCamposLogin(email: TextInputEditText, password: TextInputEditText) {
        when {
            email.text.toString().isEmpty() -> {
                email.error = "Campo email vazio"
            }
            password.text.toString().isEmpty() -> {
                password.error = "Campo password vazio"
            }
            password.text.toString().trim().length < 6 -> {
                password.error = "A senha deve ter pelo menos 6 caracteres"
            }
            else -> {
                val intent = Intent(this, ListaDeRestaurantes::class.java)
                startActivity(intent)
                finish()

            }
        }
    }
}
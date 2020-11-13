package com.example.desafioandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class Register : AppCompatActivity() {

    private lateinit var name: TextInputEditText
    private lateinit var email: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var confirmPassword: TextInputEditText
    private lateinit var registerButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        name = findViewById(R.id.txtRegisterName)
        email = findViewById(R.id.txtRegisterEmail)
        password = findViewById(R.id.txtRegisterPassword)
        confirmPassword = findViewById(R.id.txtRegisterRepeatPassword)
        registerButton = findViewById(R.id.btnRegisterRegister)

        registerButton.setOnClickListener() {
            validarRegistro()
        }

    }

    fun validarRegistro() {
        when {
            name.text.toString().isEmpty() -> {
                name.error = "Campo vazio"
                Toast.makeText(this, "Campo nome vazio", Toast.LENGTH_SHORT).show()
            }
            email.text.toString().isEmpty() -> {
                email.error = "Campo vazio"
                Toast.makeText(this, "Campo email vazio", Toast.LENGTH_SHORT).show()
            }
            password.text.toString().trim().isEmpty() -> {
                password.error = "Campo vazio"
                Toast.makeText(this, "Campo password vazio", Toast.LENGTH_SHORT).show()
            }
            password.text.toString().trim().length < 6 -> {
                password.error = "A senha digitada deve ter pelo menos 6 caracteres"
                Toast.makeText(this, "A senha digitada deve ter pelo menos 6 caracteres", Toast.LENGTH_SHORT).show()
            }
            password.text.toString().trim() != confirmPassword.text.toString().trim() -> {
                confirmPassword.error = "As duas senhas devem ser iguais"
                Toast.makeText(this, "As duas senhas devem ser iguais", Toast.LENGTH_SHORT).show()
            }
            else -> {
                val intent = Intent(this, ListaDeRestaurantes::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
package com.example.desafioandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetalhePrato : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_prato)

        val nome = intent.getStringExtra("NomePrato")
        val descricao = intent.getStringExtra("DescricaoPrato")
        val imagem = intent.getStringExtra("ImagemPrato")!!.toInt()
        val voltar = findViewById<ImageView>(R.id.imgBackPratoDetails)

        voltar.setOnClickListener() {
            onBackPressed()
        }

        val nomePrato = findViewById<TextView>(R.id.txtNomePratoDetails)
        nomePrato.text = nome
        val descricaoPrato = findViewById<TextView>(R.id.txtDescricaoPratoDetails)
        descricaoPrato.text = descricao
        val imagemPrato = findViewById<ImageView>(R.id.imgPratoDetails)
        imagemPrato.setImageResource(imagem)

    }
}
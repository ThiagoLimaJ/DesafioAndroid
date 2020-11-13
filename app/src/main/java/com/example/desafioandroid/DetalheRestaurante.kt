package com.example.desafioandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetalheRestaurante : AppCompatActivity() {

    private lateinit var restaurante: Restaurante
    private lateinit var nome: String
    private lateinit var viewManager: GridLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: DetalheRestauranteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_restaurante)

        nome = intent.getStringExtra("Nome")!!

        encontrarRestaurante(nome)

        val imagemRestaurante = findViewById<ImageView>(R.id.imgRestaurantView)
        imagemRestaurante.setImageResource(restaurante.imagem)
        val nomeRestaurante = findViewById<TextView>(R.id.txtRestaurantView)
        nomeRestaurante.text = restaurante.nome

        val back = findViewById<ImageView>(R.id.imgBackRestaurantDetails)

        back.setOnClickListener() {
            onBackPressed()
        }

        val pratos = restaurante.pratos

        viewManager = GridLayoutManager(this, 2)
        recyclerView = findViewById<RecyclerView>(R.id.pratosLista)
        viewAdapter = DetalheRestauranteAdapter(pratos) {
            val intent = Intent(this, DetalhePrato::class.java)
            intent.putExtra("NomePrato", it.nomePrato)
            intent.putExtra("DescricaoPrato", it.descricao)
            intent.putExtra("ImagemPrato", it.imagem.toString())
            startActivity(intent)

        }

        recyclerView.apply {
            setHasFixedSize(true)

            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    private fun encontrarRestaurante(nome: String) {
        Database.restaurant.forEach() {
            if (nome == it.nome) {
                restaurante = it
            }
        }
    }
}
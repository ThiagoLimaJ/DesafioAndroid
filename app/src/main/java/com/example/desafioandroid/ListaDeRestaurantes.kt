package com.example.desafioandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaDeRestaurantes : AppCompatActivity() {

    private lateinit var viewManager: GridLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: ListaDeRestaurantesAdapter
    private lateinit var listaRestaurantes: List<Restaurante>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_de_restaurantes)

        viewManager = GridLayoutManager(this, 1)
        listaRestaurantes = Database.restaurant

        recyclerView = findViewById(R.id.minhaLista)
        viewAdapter = ListaDeRestaurantesAdapter(listaRestaurantes) {
            val intent = Intent(this, DetalheRestaurante::class.java)
            intent.putExtra("Nome", it.nome)

            startActivity(intent)
        }

        recyclerView.apply {
            setHasFixedSize(true)

            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

}
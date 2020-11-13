package com.example.desafioandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaDeRestaurantesAdapter(private val restaurantes: List<Restaurante>,
                                 private val listener: (Restaurante) -> Unit): RecyclerView.Adapter<ListaDeRestaurantesAdapter.RestaurantViewHolder>() {

    class RestaurantViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val restaurantNome by lazy {view.findViewById<TextView>(R.id.txtCardNome)}
        private val restaurantEndereco by lazy {view.findViewById<TextView>(R.id.txtCardEndereco)}
        private val restaurantHorario by lazy {view.findViewById<TextView>(R.id.txtCardHorario)}
        private val restaurantImagem by lazy {view.findViewById<ImageView>(R.id.cardImage)}

        fun bind (restaurante: Restaurante) {
            restaurantNome.text = restaurante.nome
            restaurantEndereco.text = restaurante.endereco
            restaurantHorario.text = "Fecha às ${restaurante.horarioFechamento}."

            restaurantImagem.setImageResource(restaurante.imagem)
        }




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurantes_card_view, parent, false )

        return RestaurantViewHolder(view)    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val item = restaurantes[position]
        holder.bind(restaurantes[position])
        holder.itemView.setOnClickListener { listener(item) }    }

    override fun getItemCount() = restaurantes.size
}
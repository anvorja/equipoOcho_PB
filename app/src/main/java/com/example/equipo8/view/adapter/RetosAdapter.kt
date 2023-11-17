package com.example.equipo8.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.equipo8.databinding.ChallengesInventoryBinding
import com.example.equipo8.model.Reto
import com.example.equipo8.view.viewholder.RetoViewHolder

class RetosAdapter(private val lista_retos:MutableList<Reto>):RecyclerView.Adapter<RetoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetoViewHolder {
        val binding = ChallengesInventoryBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return RetoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RetoViewHolder, position: Int) {
        val reto = lista_retos[position]
        holder.cargarDatosReto(reto)
    }

    override fun getItemCount(): Int {
        return lista_retos.size
    }

}

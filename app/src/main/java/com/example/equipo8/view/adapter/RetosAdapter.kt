package com.example.equipo8.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.equipo8.databinding.ChallengesInventoryBinding
import com.example.equipo8.model.Retos
import com.example.equipo8.view.viewholder.RetosViewHolder

class RetosAdapter(private val laListaDeRetos:MutableList<Retos>):RecyclerView.Adapter<RetosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetosViewHolder {
        val binding = ChallengesInventoryBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return RetosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RetosViewHolder, position: Int) {
        val reto = laListaDeRetos[position]
        holder.cargarDatosReto(reto)
    }

    override fun getItemCount(): Int {
        return laListaDeRetos.size
    }

}

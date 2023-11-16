package com.example.equipo8.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.equipo8.databinding.ChallengesInventoryBinding
import com.example.equipo8.model.Retos

class RetosViewHolder (binding : ChallengesInventoryBinding):RecyclerView.ViewHolder(binding.root) {
    val bindingReto = binding

    fun cargarDatosReto(retos: Retos){
        bindingReto.descripcionDelReto.text =  retos.name
    }
}
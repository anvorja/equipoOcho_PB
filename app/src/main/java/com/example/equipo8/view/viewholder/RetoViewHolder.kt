package com.example.equipo8.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.equipo8.databinding.ChallengesInventoryBinding
import com.example.equipo8.model.Reto

class RetoViewHolder (binding : ChallengesInventoryBinding):RecyclerView.ViewHolder(binding.root) {
    val bindingReto = binding

    fun cargarDatosReto(retos: Reto){
        bindingReto.tvDescripcion.text =  retos.descripcion
        bindingReto.tvIcon.id =  retos.id
        //TODO: Cambiar por iconos, no textview (challenges_inventory)

        //bindingReto.tvEditDelete.text =  retos.descripcion
        //TODO: Cambiar por iconos, no textview (challenges_inventory)
    }
}
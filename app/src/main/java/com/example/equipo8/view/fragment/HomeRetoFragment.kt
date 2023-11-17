package com.example.equipo8.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.equipo8.R
import com.example.equipo8.databinding.FragmentHomeRetoBinding
import com.example.equipo8.model.Reto
import com.example.equipo8.view.adapter.RetosAdapter
import com.example.equipo8.viewmodel.RetosViewModel

class HomeRetoFragment : Fragment() {
    private lateinit var binding: FragmentHomeRetoBinding
    private val retosViewModel: RetosViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeRetoBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.contentToolbar.backToolbar.setOnClickListener{ findNavController().popBackStack() }
        controladores()
        observerViewModel()
    }

    private fun observerViewModel() {
        //observerListInventory()
    }
    /*private fun observerListInventory() {
        retosViewModel.obtenerListaDeRetos()
        retosViewModel.listInventory.observe(viewLifecycleOwner){ lista_retos->
            val recycler = binding.recyclerview
            val layoutManager = LinearLayoutManager(context)
            recycler.layoutManager = layoutManager
            val adapter = RetosAdapter(lista)
            recycler.adapter = adapter
            adapter.notifyDataSetChanged()
        }

    }*/

    private fun controladores() {
        binding.fbagregar.setOnClickListener {
            findNavController().navigate(R.id.action_listaRetos_to_agregarRetoFragment)
        }
    }
    fun recycler(){
        /*val lista_prueba = mutableListOf(
            Reto(id, descripcion = "Probando 1"),
            Reto(id, descripcion = "Probando 2"),
            Reto(id, descripcion = "Probando 3"),
            Reto(id, descripcion = "Probando 4")
        )


        val recycler = binding.recyclerview
        recycler.layoutManager = LinearLayoutManager(context)
        val adapter = RetosAdapter(lista_prueba)
        recycler.adapter = adapter
        adapter.notifyDataSetChanged()*/
    }

}

package com.example.equipo8.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.equipo8.databinding.FragmentRetoBinding
import com.example.equipo8.view.adapter.RetosAdapter
import com.example.equipo8.viewmodel.RetosViewModel

class reto : Fragment() {
    private lateinit var binding: FragmentRetoBinding
    private val retosViewModel: RetosViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRetoBinding.inflate(inflater)
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
        observerListInventory()
    }
    private fun observerListInventory() {
        retosViewModel.obtenerListaDeRetos()
        retosViewModel.listInventory.observe(viewLifecycleOwner){ lista->
            val recycler = binding.recyclerview
            val layoutManager = LinearLayoutManager(context)
            recycler.layoutManager = layoutManager
            val adapter = RetosAdapter(lista)
            recycler.adapter = adapter
            adapter.notifyDataSetChanged()
        }

    }

    private fun controladores() {

    }
    fun recycler(){

    }

}

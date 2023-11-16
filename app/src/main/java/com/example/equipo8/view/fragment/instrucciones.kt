package com.example.equipo8.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.equipo8.R
import com.example.equipo8.databinding.FragmentInstruccionesBinding

class instrucciones : Fragment() {
    private lateinit var binding: FragmentInstruccionesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentInstruccionesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this).asGif().load(R.drawable.ganador_gif).into(binding.ganarGif)
        binding.contentToolbar.backToolbar.setOnClickListener{ findNavController().popBackStack() }
    }

}

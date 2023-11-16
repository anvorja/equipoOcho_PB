package com.example.equipo8.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

}

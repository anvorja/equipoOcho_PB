package com.example.equipo8.view.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.equipo8.R
import com.example.equipo8.databinding.FragmentAgregarRetoBinding
import com.example.equipo8.model.Reto
import com.example.equipo8.viewmodel.RetosViewModel

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AgregarRetoFragment : Fragment(R.layout.fragment_agregar_reto) {
    private lateinit var binding: FragmentAgregarRetoBinding
    private val retoViewModel: RetosViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAgregarRetoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controladores()
    }

    private fun controladores() {
        validarDatos()
        binding.btnSaveChallenge.setOnClickListener {
            saveChallenge()
        }
    }

    private fun saveChallenge() {
        val name = binding.etName.text.toString()
        val reto = Reto(descripcion = name)
        Log.d("test", reto.toString())
        retoViewModel.saveChallenge(reto)
        Toast.makeText(context,"Artículo guardado !!", Toast.LENGTH_SHORT).show()
        findNavController().popBackStack()
    }

    private fun validarDatos() {
        val reto = binding.etName
        reto.addTextChangedListener {
            val validate = reto.text.isNotEmpty()
            binding.btnSaveChallenge.isEnabled = validate
        }
    }

}

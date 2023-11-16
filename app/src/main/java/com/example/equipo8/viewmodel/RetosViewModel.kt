package com.example.equipo8.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.equipo8.model.Retos
import com.example.equipo8.repository.RetosRepository
import kotlinx.coroutines.launch

class RetosViewModel(application: Application):AndroidViewModel(application) {
    val context = getApplication<Application>()
    private val retosRepository = RetosRepository(context)

    private val _listInventory = MutableLiveData<MutableList<Retos>>()

    val listInventory: LiveData<MutableList<Retos>> get() = _listInventory

    fun obtenerListaDeRetos(){
        viewModelScope.launch {
            _listInventory.value = retosRepository.obtenerListaRetos()

        }
    }
}

package com.example.equipo8.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
//import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.equipo8.model.Reto
import com.example.equipo8.repository.RetosRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//@HiltViewModel
class RetosViewModel(application: Application):AndroidViewModel(application) {
    val context = getApplication<Application>()
    private val retosRepository = RetosRepository(context)

    private val _listChallenge = MutableLiveData<MutableList<Reto>> ()
    val listChallenge: LiveData<MutableList<Reto>> get() = _listChallenge

    fun getChallenges() {
        viewModelScope.launch {
            _listChallenge.value = retosRepository.getChallenge()
        }
    }

    //Insertar Reto en RoomDB
    fun saveChallenge(reto: Reto) {
        viewModelScope.launch {
            retosRepository.saveChallenge(reto)
        }
    }
}

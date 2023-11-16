package com.example.equipo8.repository

import android.content.Context
import com.example.equipo8.data.RetosBaseDatos
import com.example.equipo8.data.RetosDao
import com.example.equipo8.model.Retos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RetosRepository(val context:Context) {
    private var  retosDao: RetosDao = RetosBaseDatos.getBaseDatos(context).retosDao()

    suspend fun obtenerListaRetos():MutableList<Retos>{
        return withContext(Dispatchers.IO){
            retosDao.obtenerListadoRetos()
        }
    }

}
package com.example.equipo8.repository

import android.content.Context
import com.example.equipo8.data.RetosBaseDatos
import com.example.equipo8.data.RetosDao
import com.example.equipo8.model.Retos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RetosRepository(val context:Context) {
    private var  retosDao: RetosDao = RetosBaseDatos.getDatabase(context).challengesDao()

    suspend fun getListInventory():MutableList<Retos>{
        return withContext(Dispatchers.IO){
            retosDao.getListInventory()
        }
    }

}
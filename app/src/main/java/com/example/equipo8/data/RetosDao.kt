package com.example.equipo8.data

import androidx.room.Dao
import androidx.room.Query
import com.example.equipo8.model.Reto

@Dao
interface RetosDao {
    @Query("SELECT * FROM Reto")
    suspend fun obtenerListadoRetos(): MutableList<Reto>
}

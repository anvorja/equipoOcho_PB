package com.example.equipo8.data

import androidx.room.Dao
import androidx.room.Query
import com.example.equipo8.model.Retos

@Dao
interface RetosDao {
    @Query("SELECT * FROM Retos")
    suspend fun getListInventory(): MutableList<Retos>
}

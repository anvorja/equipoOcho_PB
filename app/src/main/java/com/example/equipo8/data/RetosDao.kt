package com.example.equipo8.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.equipo8.model.Reto

@Dao
interface RetosDao {
    @Query("SELECT * FROM Reto")
    suspend fun getChallenge(): MutableList<Reto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveChallenge(reto : Reto)
}

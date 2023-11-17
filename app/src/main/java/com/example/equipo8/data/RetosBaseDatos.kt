package com.example.equipo8.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.equipo8.model.Reto
import com.example.equipo8.utils.Constants.NAME_BD

@Database(entities = [Reto::class], version = 1)
abstract class RetosBaseDatos : RoomDatabase() {

    abstract fun retosDao(): RetosDao

    companion object{
        fun getBaseDatos(context: Context): RetosBaseDatos {
            return Room.databaseBuilder(
                context.applicationContext,
                RetosBaseDatos::class.java,
                NAME_BD
            ).build()
        }
    }
}
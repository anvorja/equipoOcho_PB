package com.example.equipo8.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.equipo8.model.Retos
import com.example.equipo8.utils.Constants.NAME_BD

@Database(entities = [Retos::class], version = 1)
abstract class RetosBaseDatos : RoomDatabase() {

    abstract fun challengesDao(): RetosDao

    companion object{
        fun getDatabase(context: Context): RetosBaseDatos {
            return Room.databaseBuilder(
                context.applicationContext,
                RetosBaseDatos::class.java,
                NAME_BD
            ).build()
        }
    }
}

package com.example.furniture.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.furniture.data.entity.Offers
import com.example.furniture.data.remote.RoomDao


/**
 * To manage data items that can be accessed, updated
 * & maintain relationships between them
 *
 * @Created by NADA
 */
@Database(entities = [Offers::class,], version = 1, exportSchema = true)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {

  //  abstract val roomDao: RoomDao
    abstract fun getRoomDao(): RoomDao

    companion object {
       const val DB_NAME = "CommericDatabase.db"
    }
}

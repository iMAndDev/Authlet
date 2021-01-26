package com.devmaksem.authlet.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Secret::class], version = 1, exportSchema = false)
abstract class SecretDatabase: RoomDatabase() {

    abstract fun secretDao(): SecretDao

    companion object{
        @Volatile
        private var INSTANCE: SecretDatabase? = null

        fun getDatabase(context: Context): SecretDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) { return tempInstance }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SecretDatabase::class.java,
                    "secrets"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }

}
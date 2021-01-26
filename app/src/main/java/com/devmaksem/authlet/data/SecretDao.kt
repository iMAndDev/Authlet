package com.devmaksem.authlet.data

import android.app.LauncherActivity
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SecretDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addSecret(secret: Secret)

    @Query("SELECT * FROM secrets")
    fun readAllSecrets(): LiveData<List<Secret>>
}
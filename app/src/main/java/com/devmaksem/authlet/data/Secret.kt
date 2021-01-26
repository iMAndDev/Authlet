package com.devmaksem.authlet.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "secrets")
data class Secret(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val serviceName: String,
    val serviceSecret: String
)
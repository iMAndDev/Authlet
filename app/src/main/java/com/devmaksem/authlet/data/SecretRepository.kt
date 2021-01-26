package com.devmaksem.authlet.data

import androidx.lifecycle.LiveData

class SecretRepository (private val secretDao: SecretDao) {

    val readAllSecrets: LiveData<List<Secret>> = secretDao.readAllSecrets()

    suspend fun addSecret(secret: Secret){
        secretDao.addSecret(secret)
    }

}
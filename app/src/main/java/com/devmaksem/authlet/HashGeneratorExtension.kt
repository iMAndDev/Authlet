package com.devmaksem.authlet

import dev.turingcomplete.kotlinonetimepassword.GoogleAuthenticator
import java.util.*

fun generateHash(secret: String): String {
    val timestamp = Date(System.currentTimeMillis())

    return GoogleAuthenticator(secret).generate(timestamp)
    //generatedCode.text = "${SimpleDateFormat("HH:mm:ss").format(timestamp)} -> $code"
}

fun updateHashes(list: ArrayList<ListItem>) {
    for (i in list) { generateHash(i.description) }
}
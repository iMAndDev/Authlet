package com.devmaksem.authlet.ext

import com.devmaksem.authlet.mainScreen.item.ListItem
import dev.turingcomplete.kotlinonetimepassword.GoogleAuthenticator
import java.util.*

fun generateHash(secret: String): String {
    val timestamp = Date(System.currentTimeMillis())

    return GoogleAuthenticator(secret).generate(timestamp)
    //generatedCode.text = "${SimpleDateFormat("HH:mm:ss").format(timestamp)} -> $code"
}

fun updateHashes(list: ArrayList<ListItem>): ArrayList<ListItem> {
    for (item in list) {
        val newHash = generateHash(item.description)
        item.description = newHash
        //TODO: u know da way
    }

    return list
}
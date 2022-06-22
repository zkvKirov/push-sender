package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent())
        .setToken("faYbegiQSvuCQsQRD6lk86:APA91bGZ24EGhuAQUNElNlKMSIFocDCL7MDsOMwsY-wfVyYYCU3l1CgxzYZiYppoKse3ZHeMtScxDOxKnuy5MEy5RZWCvjwThEpHPB5IfzSEkaMIq3SnX3UNlUOXjNGQLsjut6QwCnqO")
        .build()

    FirebaseMessaging.getInstance().send(message)
}

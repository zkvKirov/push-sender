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

    val newPost = Message.builder()
        .putData("action", "NEW_POST")
        .putData("content", """{
          "id": 0,
          "author": "Maxim",          
          "content": "A basic notification usually includes a title, a line of text, and one or more actions the user can perform in response. To provide even more information, you can also create large, expandable notifications by applying one of several notification templates as described on this page",
          "published": 22.06.2022,
          "likes": 0,
          "likedByMe": false,
          "share": 0,
          "video": null
        }""".trimIndent())
        .setToken("faYbegiQSvuCQsQRD6lk86:APA91bGZ24EGhuAQUNElNlKMSIFocDCL7MDsOMwsY-wfVyYYCU3l1CgxzYZiYppoKse3ZHeMtScxDOxKnuy5MEy5RZWCvjwThEpHPB5IfzSEkaMIq3SnX3UNlUOXjNGQLsjut6QwCnqO")
        .build()

    FirebaseMessaging.getInstance().send(newPost)

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

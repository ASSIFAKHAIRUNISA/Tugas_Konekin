package com.example.tugaskonekin.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient { // ApiClient dideklarasikan sebagai sebuah object
    fun getInstance(): ApiService { //getInstance() fungsi yang mengembalikan instance dari ApiService
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        // membuat OkHttpClient dan menambahkan loggingInterceptor untuk mencatat log
        // dari semua permintaan yang dikirim.
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://reqres.in/api/") // Menentukan URL dasar untuk API
            .addConverterFactory(GsonConverterFactory.create()) //  yang memungkinkan Retrofit mengonversi JSON respons API menjadi objek Kotlin
            .client(client)
            .build()
            .create(ApiService::class.java)
    }
}

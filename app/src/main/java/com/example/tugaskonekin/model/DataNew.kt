package com.example.tugaskonekin.model

import com.google.gson.annotations.SerializedName

// mendefinisikan kelas data (data class) bernama DataNew, yang digunakan untuk merepresentasikan informasi
// tentang setiap pengguna yang diterima dari respons API dalam bentuk objek Kotlin
data class DataNew(
    @SerializedName("id")
    val id: Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("avatar")
    val avatar: String,
)

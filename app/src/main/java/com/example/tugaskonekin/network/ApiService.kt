package com.example.tugaskonekin.network

import com.example.tugaskonekin.model.DataCallback
import retrofit2.Call
import retrofit2.http.GET

//mendefinisikan endpoint API
interface ApiService {
    @GET("users?page=2")
    fun getAllUsers(): Call<DataCallback> // mengembalikan objek Call dengan tipe DataCallback
}

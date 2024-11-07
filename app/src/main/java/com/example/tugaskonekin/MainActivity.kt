package com.example.tugaskonekin

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.tugaskonekin.model.DataCallback
import com.example.tugaskonekin.network.ApiClient
import com.example.tugaskonekin.model.DataNew
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// Kode ini mengambil data pengguna dari API, menampilkannya dalam ListView, dan membuka DetailActivity saat pengguna diklik
class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var userList: List<DataNew>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.lv_nama)

        ApiClient.getInstance().getAllUsers().enqueue(object : Callback<DataCallback> {
            override fun onResponse(call: Call<DataCallback>, response: Response<DataCallback>) {
                if (response.isSuccessful) {
                    userList = response.body()?.data ?: listOf()
                    val adapter = UserAdapter(this@MainActivity, userList)
                    listView.adapter = adapter

                    // Set item click listener
                    listView.setOnItemClickListener { _, _, position, _ ->
                        val selectedUser = userList[position]
                        val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                            putExtra("user_id", selectedUser.id)
                            putExtra("user_name", "${selectedUser.firstName} ${selectedUser.lastName}")
                            putExtra("user_email", selectedUser.email)
                            putExtra("user_avatar", selectedUser.avatar)
                        }
                        startActivity(intent)
                    }
                }
            }

            override fun onFailure(call: Call<DataCallback>, t: Throwable) {
                // Handle failure
            }
        })
    }
}

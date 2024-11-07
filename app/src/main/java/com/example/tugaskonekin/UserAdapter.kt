package com.example.tugaskonekin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.tugaskonekin.model.DataNew
import com.squareup.picasso.Picasso

class UserAdapter(private val context: Context, private val userList: List<DataNew>) : BaseAdapter() {

    // Mengembalikan jumlah item dalam userList
    override fun getCount(): Int = userList.size
    // Mengembalikan objek DataNew pada posisi tertentu di userList
    override fun getItem(position: Int): Any = userList[position]
    // Mengembalikan ID unik dari item di userList pada posisi tertentu
    override fun getItemId(position: Int): Long = userList[position].id.toLong()
    // membuat dan mengembalikan tampilan (view) setiap item di ListView
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_user, parent, false)
        val user = userList[position]

        val ivAvatar = view.findViewById<ImageView>(R.id.iv_avatar)
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvEmail = view.findViewById<TextView>(R.id.tv_email)

        tvName.text = "${user.firstName} ${user.lastName}"
        tvEmail.text = user.email
        Picasso.get().load(user.avatar).into(ivAvatar)

        return view
    }
}

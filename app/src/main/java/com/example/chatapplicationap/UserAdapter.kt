package com.example.chatapplicationap

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val context: MainActivity, val userList: ArrayList<User>):
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
       val view : View = LayoutInflater.from(context).inflate(R.layout.user_layout,parent,false)
       return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
       val currentUser = userList[position]
        holder.textName.text = currentUser.name

        holder.itemView.setOnClickListener{
            val intent = Intent(context,ChatActiviy::class.java)
            intent.putExtra("name",currentUser.name)
            intent.putExtra("uid",currentUser.uid)



            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
       return userList.size
    }

    class UserViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val textName = itemView.findViewById<TextView>(R.id.text_name)
    }

}
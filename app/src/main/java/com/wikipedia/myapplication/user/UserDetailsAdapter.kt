package com.wikipedia.myapplication.user

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wikipedia.myapplication.R

import kotlinx.android.synthetic.main.item_user.view.*

class UserDetailsAdapter internal constructor(private val list: ArrayList<User>) : RecyclerView.Adapter<UserDetailsAdapter.UserViewHolder>() {


    var context: Context? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemLayoutView: View
        context = parent.context
        itemLayoutView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(itemLayoutView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindView(holder, position, context)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    inner class UserViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName = itemView.tvName
        var tvEmail = itemView.tvEmail
        var tvWebsite = itemView.tvWebsite
        fun bindView(viewHolder: UserViewHolder, position: Int, context: Context?) {
            val user: User = list.get(position)
           viewHolder.tvName.text ="Name :"+user.name
           viewHolder.tvEmail.text ="Email :"+user.email
           viewHolder.tvWebsite.text ="Website :"+user.website
        }
    }




}
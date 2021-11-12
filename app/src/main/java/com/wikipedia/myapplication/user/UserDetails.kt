package com.wikipedia.myapplication.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.wikipedia.myapplication.R
import kotlinx.android.synthetic.main.activity_user_details.*

class UserDetails : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        userViewModel.getUser()
        userViewModel.userListResponse.observe(this, {
            initRecyclerView(it)
        })
    }

    private fun initRecyclerView(userList: ArrayList<User>) {
        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        rv_users.layoutManager = llm
        val adapter = userList?.let { UserDetailsAdapter(it) }
        rv_users.adapter=adapter
    }


}
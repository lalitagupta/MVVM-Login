package com.wikipedia.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        login.setOnClickListener { loginClick() }

    }

    private fun loginClick() {
        val name = username.text.toString()
        val passwords = password.text.toString()
        if (TextUtils.isEmpty(name)) {
            username.setError("Enter an E-Mail Address");
            username.requestFocus();
        } else if (TextUtils.isEmpty(passwords)) {
            password.setError("Enter a Password");
            password.requestFocus();
        } else {
            loginViewModel.getUser(LoginUser(name, passwords))
        }
    }
}
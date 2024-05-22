package com.example.motivation

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences(context: Context) {

    private val shPreferences: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, str: String) {
        shPreferences.edit().putString(key, str).apply()
    }

    fun getString(Key: String): String {
        return shPreferences.getString(Key, "") ?: ""
    }
}
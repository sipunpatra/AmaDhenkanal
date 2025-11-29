package com.dhenkanal.amadhenkanal.repository

import com.dhenkanal.amadhenkanal.network.RetrofitInstance

class MainRepository {
    suspend fun getStories() = RetrofitInstance.api.getStories()
}
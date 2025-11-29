package com.dhenkanal.amadhenkanal.network

import com.dhenkanal.amadhenkanal.model.ImageItem
import com.dhenkanal.amadhenkanal.model.StoryItem
import retrofit2.http.GET


interface ApiService {
    @GET("/items") // e.g. your endpoint /stories
    suspend fun getStories(): List<StoryItem>

    @GET("images") // e.g. your endpoint /images
    suspend fun getImages(): List<ImageItem>
}

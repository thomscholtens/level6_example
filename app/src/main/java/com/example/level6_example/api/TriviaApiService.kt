package com.example.level6_example.api

import com.example.level6_example.model.Trivia
import retrofit2.http.GET

interface TriviaApiService {
    // The GET method needed to retrieve a random number trivia.
    @GET("/random/trivia?json")
    suspend fun getRandomNumberTrivia(): Trivia

}
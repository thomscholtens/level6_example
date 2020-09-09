package com.example.level6_example.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.level6_example.api.TriviaApi
import com.example.level6_example.api.TriviaApiService
import com.example.level6_example.model.Trivia
import kotlinx.coroutines.withTimeout

class TriviaRepository {
    private val triviaApiService: TriviaApiService = TriviaApi.createApi()

    private val _trivia: MutableLiveData<Trivia> = MutableLiveData()

    /**
     * Expose non MutableLiveData via getter
     * Encapsulation :)
     */
    val trivia: LiveData<Trivia>
        get() = _trivia

    /**
     * suspend function that calls a suspend function from the numbersApi call
     */
    suspend fun getRandomNumberTrivia()  {
        try {
            //timeout the request after 5 seconds
            val result = withTimeout(5_000) {
                triviaApiService.getRandomNumberTrivia()
            }

            _trivia.value = result
        } catch (error: Throwable) {
            throw TriviaRefreshError("Unable to refresh trivia", error)
        }
    }

    class TriviaRefreshError(message: String, cause: Throwable) : Throwable(message, cause)

}

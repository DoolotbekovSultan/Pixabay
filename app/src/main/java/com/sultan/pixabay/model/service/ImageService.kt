package com.sultan.pixabay.model.service

import com.sultan.pixabay.model.core.Either
import com.sultan.pixabay.model.models.ImageResponse
import jakarta.inject.Inject
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageService {
    @GET(".")
    suspend fun getImages(
        @Query("key") key : String = "49946678-1aeb7243f1cb6fb24af529adc",
        @Query("q") q : String
    ) : ImageResponse
}
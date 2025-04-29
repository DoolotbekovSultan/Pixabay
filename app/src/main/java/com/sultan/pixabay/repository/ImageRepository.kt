package com.sultan.pixabay.repository

import android.util.Log
import com.sultan.pixabay.model.core.Either
import com.sultan.pixabay.model.models.ImageResponse
import com.sultan.pixabay.model.service.ImageService
import javax.inject.Inject

class ImageRepository @Inject constructor(
    private val service : ImageService
) {
    suspend fun getImages(q : String) : Either<String, ImageResponse> {
        return try {
            Either.Right(service.getImages(q = q))
        } catch (e : Exception) {
            Log.e("ololo", "getImages: ${e.message}")
            Either.Left(e.message ?: "Unknown error")
        }
    }
}
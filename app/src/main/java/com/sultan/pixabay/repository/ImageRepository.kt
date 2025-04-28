package com.sultan.pixabay.repository

import com.sultan.pixabay.model.service.ImageService
import javax.inject.Inject

class ImageRepository @Inject constructor(
    private val service : ImageService
) {
    suspend fun getImages(q : String) = service.getImages(q = q)
}
package com.sultan.pixabay.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sultan.pixabay.model.models.ImageResponse
import com.sultan.pixabay.repository.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ImageRepository
) : ViewModel() {

    private val _image = MutableLiveData<ImageResponse>()
    val image : LiveData<ImageResponse> = _image

    fun getImages(q : String) {
        viewModelScope.launch {
            try {
                val response = repository.getImages(q)
                Log.e("ololo", "getImages: Response = ${response}")
                _image.value = response
            } catch (e : Exception) {
                Log.e("ololo", "getImages: Error ${e.message}")
                e.printStackTrace()
            }
        }
    }
}
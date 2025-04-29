package com.sultan.pixabay.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sultan.pixabay.model.core.Either
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

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage : LiveData<String> = _errorMessage


    fun getImages(q : String) {
        viewModelScope.launch {
            when (val response = repository.getImages(q)) {
                is Either.Left -> {
                    _errorMessage.value = response.error
                }
                is Either.Right -> {
                    _image.value = response.success
                }
            }
        }
    }
}
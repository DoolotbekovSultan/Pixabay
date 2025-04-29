package com.sultan.pixabay.model.core

sealed class Either<out L, out R> {
    data class Left<L>(val error : L) : Either<L, Nothing>()
    data class Right<R>(val success : R) : Either<Nothing, R>()
}
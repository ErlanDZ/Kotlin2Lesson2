package com.example.kotlin2lesson2.common.base

import com.example.kotlin2lesson2.common.resource.Resource
import kotlinx.coroutines.flow.flow

abstract class BaseRepository {
    protected fun <T> doRequest(request: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = request()))
        } catch (ioException: Exception) {
            emit(
                Resource.Error(
                    data = null, massage = ioException.localizedMessage ?: "Error Occurred!"
                )
            )
        }
    }
}
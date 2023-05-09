package com.dmendano.data.repositories

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

open class BaseRepository {

    suspend fun <T> safeCall(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        action: suspend () -> T
    ): Result<T> = withContext(dispatcher) {
        try {
            Result.success(action.invoke())
        } catch (throwable: Throwable) {
            // TODO: Do we want to manage all type of exceptions?
            when (throwable) {
                is IOException -> {
                    Result.failure(throwable)
                }
//                    is HttpException -> {
//                        val error = parseError(throwable)
//                        Result.failure(error)
//                    }
                else -> {
                    Result.failure(throwable)
                }
            }
        }
    }
}

package com.sunit.upstox.core.data.util

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.cancellation.CancellationException

internal suspend fun <T> suspendRunCatching(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    block: suspend () -> T,
): Result<T> = withContext(dispatcher) {
    try {
        Result.success(block())
    } catch (cancellationException: CancellationException) {
        throw cancellationException
    } catch (exception: Exception) {
        Log.i(
            "suspendRunCatching",
            "Failed to evaluate a suspendRunCatchingBlock. Returning failure Result",
            exception
        )
        Result.failure(exception)
    }
}

package app.ditsdev.core.utils

import android.os.Handler
import android.os.Looper
import androidx.annotation.VisibleForTesting
import java.util.concurrent.Executor

class AppExecutor @VisibleForTesting constructor(
    private val diskIO: Executor,
    private val networkIO: Executor,
    private val mainThread: Executor
) {
    companion object {
        private const val THREAD_COUNT = 3
    }

    //Will be inject the constructor after completed import required DI libs


    fun diskIO(): Executor = diskIO

    fun networkIO(): Executor = networkIO

    fun mainThread(): Executor = mainThread

    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())
        override fun execute(p0: Runnable) {
            mainThreadHandler.post(p0)
        }
    }
}
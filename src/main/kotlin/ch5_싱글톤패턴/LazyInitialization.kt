package ch5_싱글톤패턴

import java.util.concurrent.Executors

// Singleton object
class LazyInitialization private constructor() {
    companion object {
        @Volatile
        private var instance: LazyInitialization? = null

        fun getInstance(): LazyInitialization {
            return instance ?: synchronized(this) {
                instance ?: LazyInitialization().also { instance = it }
            }
        }
    }
}

fun main() {
    // 1. Array to hold Singleton instances
    val singletons = arrayOfNulls<LazyInitialization>(10)

    // 2. Create a thread pool
    val service = Executors.newCachedThreadPool()

    // 3. Submit 10 tasks to create Singleton instances concurrently
    for (i in singletons.indices) {
        service.submit {
            singletons[i] = LazyInitialization.getInstance()
        }
    }

    // 4. Shutdown the service
    service.shutdown()

    // 5. Print Singleton instance addresses
    singletons.forEach { singleton ->
        println(LazyInitialization.toString())
    }
}
package jp.watanave.fluxsample.data

import kotlinx.coroutines.delay

class TestApi {

    suspend fun process() : List<Int> {
        delay(2000)
        return (0..10).toList()
    }

}
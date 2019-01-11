package jp.watanave.fluxsample.data

class Repository(val api : TestApi = TestApi()) {

    suspend fun process() : List<Int> = this.api.process()

}
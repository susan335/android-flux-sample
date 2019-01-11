package jp.watanave.fluxsample.flux

import io.reactivex.Flowable
import io.reactivex.processors.BehaviorProcessor

class Dispatcher {

    private val actionProcessor = BehaviorProcessor.create<Action>()
    val actionFlowable : Flowable<Action> = this.actionProcessor.hide()

    fun dispatch(action: Action) {
        this.actionProcessor.onNext(action)
    }

    inline fun <reified T : Action> actionPublisher() : Flowable<T> = this.actionFlowable
        .filter { it is T }
        .map { it as T }
}
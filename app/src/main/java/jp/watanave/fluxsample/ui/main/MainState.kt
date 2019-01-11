package jp.watanave.fluxsample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import jp.watanave.fluxsample.flux.Action
import jp.watanave.fluxsample.flux.Dispatcher
import jp.watanave.fluxsample.flux.LoadState
import org.reactivestreams.Publisher

fun <T> Publisher<T>.toLiveData() :  LiveData<T> {
    return LiveDataReactiveStreams.fromPublisher(this)
}

class MainState(private val dispatcher: Dispatcher) {

    val result : LiveData<List<Int>> = this.dispatcher
        .actionPublisher<Action.DidFinishedProc>()
        .map(Action.DidFinishedProc::list)
        .toLiveData()

    val status : LiveData<LoadState> = this.dispatcher
        .actionPublisher<Action.LoadStateChanged>()
        .map(Action.LoadStateChanged::state)
        .toLiveData()
}
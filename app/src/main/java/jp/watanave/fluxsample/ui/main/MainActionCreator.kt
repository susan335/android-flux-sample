package jp.watanave.fluxsample.ui.main

import jp.watanave.fluxsample.data.Repository
import jp.watanave.fluxsample.flux.Action
import jp.watanave.fluxsample.flux.Dispatcher
import jp.watanave.fluxsample.flux.LoadState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActionCreator(private val dispatcher : Dispatcher,
                        private val repository : Repository) {

    fun process() {
        GlobalScope.launch {
            dispatcher.dispatch(Action.LoadStateChanged(LoadState.Loading))
            val result = repository.process()
            dispatcher.dispatch(Action.DidFinishedProc(result))
            dispatcher.dispatch(Action.LoadStateChanged(LoadState.Loaded))
        }
    }

}
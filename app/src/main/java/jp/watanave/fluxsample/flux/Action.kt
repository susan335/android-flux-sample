package jp.watanave.fluxsample.flux

sealed class Action {

    data class LoadStateChanged(val state: LoadState) : Action()
    data class DidFinishedProc(val list: List<Int>) : Action()

}

enum class LoadState {
    Loading, Loaded
}

package jp.watanave.fluxsample.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.shopify.livedataktx.observe
import jp.watanave.fluxsample.data.Repository
import jp.watanave.fluxsample.flux.Dispatcher
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    private val dispatcher = Dispatcher()
    private val repository = Repository()
    private val actionCreator = MainActionCreator(dispatcher, repository)
    private val state = MainState(dispatcher)


    private val ui : MainActivityUI by lazy {
        MainActivityUI().also {
            it.setContentView(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.ui

        this.state.result.observe(this) {
            Log.i("FluxSample", it.toString())
        }
        this.state.status.observe(this) {
            Log.i("FluxSample", it.toString())
        }

        this.actionCreator.process()
    }
}

class MainActivityUI : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
        frameLayout {  }
    }

}
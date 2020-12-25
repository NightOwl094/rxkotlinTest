package basic

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

class ObserverTest5 {
    private val observer: Observer<String> = object : Observer<String> {
        override fun onSubscribe(d: Disposable?) {
            println("Subscribed to $d")
        }

        override fun onNext(t: String?) {
            println("Next $t")
        }

        override fun onError(e: Throwable?) {
            println("Error Occurred $e")
        }

        override fun onComplete() {
            println("All Completed")
        }
    }

    private val future: Future<String> = object : Future<String> {
        override fun cancel(mayInterruptIfRunning: Boolean): Boolean = false

        override fun isCancelled(): Boolean = false

        override fun isDone(): Boolean = true

        override fun get(): String = "Hello From Future"

        override fun get(timeout: Long, unit: TimeUnit): String = "Hello From Future"
    }

    private val observableFromFuture: Observable<String> =
        Observable.fromFuture(future)

    fun run() {
        observableFromFuture.subscribe(observer)
    }

}
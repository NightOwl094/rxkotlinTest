package basic

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.Callable

class ObserverTest4 {
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

    private val callable = Callable { "From Callable" }
    private val observableFromCallable: Observable<String> =
        Observable.fromCallable(callable)

    fun run() {
        observableFromCallable.subscribe(observer)
    }

}
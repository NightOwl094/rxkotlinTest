package basic

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class ObserverTest3 {
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

    private val list = listOf("String 1", "String 2", "String 3", "String 4")
    private val observableFromIterable: Observable<String> =
        Observable.fromIterable(list)

    fun run() {
        observableFromIterable.subscribe(observer)
    }

}
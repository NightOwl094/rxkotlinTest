package basic

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.toObservable

class ObserverTest1 {
    private val observer: Observer<Any> = object : Observer<Any> {
        override fun onSubscribe(d: Disposable?) {
            println("Subscribed to $d")
        }

        override fun onNext(t: Any?) {
            println("Next $t")
        }

        override fun onError(e: Throwable?) {
            println("Error Occurred $e")
        }

        override fun onComplete() {
            println("All Completed")
        }
    }

    private val observable: Observable<Any> =
        listOf("one", 2, "three", "Four", 4.5, "Five", 6.0f).toObservable()

    private val observableOnList: Observable<List<Any>> =
        Observable.just(
            listOf("one", 2, "three", "Four", 4.5, "Five", 6.0f),
            listOf("List with Single Item"),
            listOf(1, 2, 3, 4, 5, 6)
        )

    fun run() {
        observable.subscribe(observer)
        observableOnList.subscribe(observer)
    }
}
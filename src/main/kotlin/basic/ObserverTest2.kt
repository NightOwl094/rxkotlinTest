package basic

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class ObserverTest2 {
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

    private val observable: Observable<String> = Observable.create<String> {
        it.onNext("Emit 1")
        it.onNext("Emit 2")
        it.onNext("Emit 3")
        it.onNext("Emit 4")
        it.onError(Exception("My Custom Exception"))
    }

    fun run() {
        observable.subscribe(observer)
    }

}
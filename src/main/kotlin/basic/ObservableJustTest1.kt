package basic

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class ObservableJustTest1 {
    private val observer: Observer<Any> = object : Observer<Any> {
        override fun onSubscribe(d: Disposable?) {
            println("-- Subscribed to $d")
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

    fun run() {
        Observable.just("A String").subscribe(observer)

        Observable.just("54").subscribe(observer)

        Observable.just(
            listOf("string 1", "string 2", "string 3", "string 4")
        ).subscribe(observer)

        Observable.just(
            mapOf(
                Pair("key 1", "value 1"),
                "key2" to "value 2",
                Pair("key 3", "value 3")
            )
        ).subscribe(observer)

        Observable.just(arrayListOf(1, 2, 3, 4, 5, 6)).subscribe(observer)

        Observable.just("String 1", "String 2", "String 3").subscribe(observer)
    }

}
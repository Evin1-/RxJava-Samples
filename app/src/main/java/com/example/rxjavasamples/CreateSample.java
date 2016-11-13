package com.example.rxjavasamples;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by evin on 11/3/16.
 */

public class CreateSample {
    public static void main(String[] args) {

        Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("Hello");
                subscriber.onNext("Hello");
                subscriber.onCompleted();
            }
        }).subscribe(new Observer<Object>() {
            @Override
            public void onCompleted() {
                System.out.println("Completed!");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Error" + e);
            }

            @Override
            public void onNext(Object o) {
                System.out.println(o);
            }
        });
    }
}

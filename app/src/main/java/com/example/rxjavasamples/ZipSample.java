package com.example.rxjavasamples;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;

/**
 * Created by evin on 11/12/16.
 */

public class ZipSample {
    public static void main(String[] args) {
        Observable<String> stringObservable1 = Observable.just("Hello", "World");
        Observable<String> stringObservable2 = Observable.just("Bye", "Friends");

        Observable.zip(stringObservable1, stringObservable2, new Func2<String, String, String>() {
            @Override
            public String call(String s, String s2) {
                return s + " - " + s2;
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
    }
}

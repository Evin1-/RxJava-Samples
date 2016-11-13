package com.example.rxjavasamples;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;

/**
 * Created by evin on 11/12/16.
 */

public class ZipSample {
    public static void main(String[] args) {
        Observable<String> string1 = Observable.just("Hello", "World");
        Observable<String> string2 = Observable.just("Bye", "Friends");

        string1.zipWith(string2, new Func2<String, String, String>() {
            @Override
            public String call(String s, String s2) {
                return s + " " + s2;
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String o) {
                System.out.println(o);
            }
        });
    }
}

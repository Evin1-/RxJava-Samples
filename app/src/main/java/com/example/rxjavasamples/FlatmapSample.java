package com.example.rxjavasamples;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by evin on 11/14/16.
 */

public class FlatmapSample {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5)
                .flatMap(new Func1<Integer, Observable<String>>() {
                    @Override
                    public Observable<String> call(Integer integer) {
                        //Observables instead of Strings
                        return Observable.just(integer + " " + integer);
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });

    }
}

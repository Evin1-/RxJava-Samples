package com.example.rxjavasamples;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by evin on 9/20/16.
 */

public class ConcatSample {
    public static void main(String[] args) {
        Observable<Integer> obsA = Observable.just(1, 2, 3, 4);
        Observable<Integer> obsB = Observable.just(5, 6, 7, 8);

        obsA.concatWith(obsB)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println(integer);
                    }
                });

        System.out.println("---------------------------");

        Observable.concat(obsB, obsA)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println(integer);
                    }
                });

        System.out.println("---------------------------");

        Observable.merge(obsA, obsB)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println(integer);
                    }
                });



    }
}

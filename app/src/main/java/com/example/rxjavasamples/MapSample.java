package com.example.rxjavasamples;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by evin on 11/14/16.
 */

public class MapSample {
    public static void main(String[] args) {

        Observable.just(1, 2, 3, 4, 5)
                .map(new Func1<Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer) {
                        return integer * integer;
                    }
                })
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println(integer);
                    }
                });
    }
}

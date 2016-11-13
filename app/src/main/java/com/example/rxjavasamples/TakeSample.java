package com.example.rxjavasamples;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by evin on 11/12/16.
 */

public class TakeSample {
    public static void main(String[] args) {
        Observable.from(new String[]{"1", "2", "3", "4", "5", "6"})
                .take(2)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });
    }
}

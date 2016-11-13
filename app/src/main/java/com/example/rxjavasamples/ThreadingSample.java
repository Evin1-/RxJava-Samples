package com.example.rxjavasamples;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by evin on 9/21/16.
 */

public class ThreadingSample {
    public static void main(String[] args) {

        Observable.just("Hello")
                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread()) // We would use this in Android
                .observeOn(Schedulers.immediate())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s + " " + Thread.currentThread());
                    }
                });

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

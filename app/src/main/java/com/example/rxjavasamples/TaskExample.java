package com.example.rxjavasamples;

import android.support.annotation.MainThread;

import java.util.EmptyStackException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by evin on 9/21/16.
 */

public class TaskExample {
    public static void main(String[] args) {

        Executor executor = new ThreadPoolExecutor(5, 5, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));

        Observable.just("Hello")
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        System.out.println(s + " " + Thread.currentThread());
                        return s.concat(s);
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.from(executor))
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

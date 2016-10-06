package com.example.rxjavasamples;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.observables.ConnectableObservable;
import rx.schedulers.Schedulers;

/**
 * Created by jonathanhavstad on 10/5/16.
 */

public class ListExample {
    public static void main(String[] args) {
        Executor executor =
                new ThreadPoolExecutor(5, 5, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));
        List<Integer> values = new ArrayList<>();
        ConnectableObservable observable = Observable
                .just(values)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.from(executor))
                .publish();
        Action1<List<Integer>> subscriber = new Action1<List<Integer>>() {
            @Override
            public void call(List<Integer> integers) {
                System.out.print("New values: ");
                for (Integer i : integers) {
                    System.out.print(i + " ");
                }
                System.out.println("");
            }
        };
        observable.subscribe(subscriber);
        values.add(0);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        values.add(1);
        values.add(2);
        observable.connect();    }
}

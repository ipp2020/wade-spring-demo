package com.wade.springboot.wadespringbootdemo.service;

import com.wade.springboot.wadespringbootdemo.vo.User;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

@Component
public class DataProcessor implements DisposableBean, Runnable {

    private Thread thread;
    private volatile boolean someCondition = true;

    private BlockingQueue<User> queue = new LinkedBlockingDeque<User>(1000);
    private List<User> list = new ArrayList<>();

    private long time;

    private DataProcessor() {
        this.thread = new Thread(this);
        this.thread.setName("DataProcessor");
        this.thread.start();
    }

    @Override
    public void run() {

        time = System.currentTimeMillis();

        while (someCondition) {
            try {
                doStuff();
                Thread.sleep(5000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void doStuff() throws Exception{
        System.out.println("do stuff.");

        if (queue.size() > 0) {
            User user = queue.take();
            list.add(user);
            if(list.size()>1000){
                save(list);
                list.clear();
            }

        } else {
            if (System.currentTimeMillis() - time > 3000L) {
                if (list.size() > 0) {
                    save(list);
                    list.clear();
                }
                time = System.currentTimeMillis() + (time + 3000L) - (System.currentTimeMillis() - time);
            }
        }


    }

    private void save(List<User> list) {
        //save data
        System.out.println("save data...");
    }

    @Override
    public void destroy() {
        someCondition = false;
    }

    public void addToQueue(User user) {
        try {
            queue.put(user);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

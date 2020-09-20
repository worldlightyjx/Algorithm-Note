package com.yang.multithread.aqs;


import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    private int queuSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<>(queuSize);
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();


    public static void main(String[] args) throws InterruptedException {
        ConditionTest conditionTest = new ConditionTest();
        Producer producer = conditionTest.new Producer();
        Consumer consumer = conditionTest.new Consumer();
        producer.start();
        consumer.start();
        Thread.sleep(10);
        producer.interrupt();
        consumer.interrupt();
    }

    class Consumer extends Thread{

        @Override
        public void run() {
            consume();
        }
        private boolean flag = true;
        private void consume(){
            while (flag){
                lock.lock();
                try {

                    while (queue.isEmpty()){

                        try {
                            System.out.println("队列空，等待");
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            flag=false;
                        }
                    }
                    queue.poll();
                    notFull.signal();
                    System.out.println("从队列取走一个元素，队列剩余"+queue.size()+"个元素");
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    class Producer extends Thread{

        @Override
        public void run() {
            produce();
        }
        private boolean flag = true;
        private void produce(){
            while (flag){
                lock.lock();
                try {
                    while (queue.size()==queuSize){
                        try {
                            System.out.println("队列满，等待");
                            notFull.await();
                        } catch (InterruptedException e) {
                            flag = false;
                        }
                    }
                    queue.offer(1);
                    System.out.println("队列中插入一个元素，队列剩余空间"+(queuSize-queue.size()));
                    notEmpty.signal();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
}

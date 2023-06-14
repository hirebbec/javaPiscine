package Controller;

import Model.CounterThread;

import java.util.Random;

public class Counter {

    private int numbers[];
    private int threadsCount;

    private CounterThread threads[];
    public Counter(int[] numbers, int threadsCount) {
        this.numbers = numbers;
        this.threadsCount = threadsCount;
        threads = new CounterThread[threadsCount];
    }

    public void count() {
        System.out.println("Sum: " + simpleCount());
        int threadsSum = threadsCount();
        for (int i = 0; i < threadsCount; i++) {
            if (threads[i] != null) {
                System.out.println("Thread " + (i + 1) + ": from " + threads[i].getStart() + " to " + threads[i].getEnd() + " sum is " + threads[i].getSum());
            }
        }
        System.out.println("Sum by threads: " + threadsSum);
    }

    private int threadsCount() {
        int sum = 0;
        if (threadsCount > numbers.length / 2) {
            int i;
            int begin;
            for (begin = 0, i = 0; begin + 2 < numbers.length && i < threadsCount; begin += 2, ++i) {
                threads[i] = new CounterThread(begin, begin + 2, numbers);
            }
            if (begin < numbers.length) {
                threads[i] = new CounterThread(begin, numbers.length, numbers);
            }
        } else {
            int gap = numbers.length / threadsCount;
            for (int i = 0, begin = 0; i < threadsCount; begin += gap, i++) {
                if (i == threadsCount - 1) {
                    threads[i] = new CounterThread(begin, numbers.length, numbers);
                } else {
                    threads[i] = new CounterThread(begin, begin + gap, numbers);
                }
            }
        }
        for (CounterThread thread : threads) {
            if (thread != null) {
                thread.start();
            }
        }
        for (CounterThread thread : threads) {
            if (thread != null) {
                try {
                    thread.join();
                    sum += thread.getSum();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return sum;
    }

    private int simpleCount() {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}

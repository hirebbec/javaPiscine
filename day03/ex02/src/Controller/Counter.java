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

    }

    private

    private int simpleCount() {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}

package Model;

public class CounterThread extends Thread {
    int start;
    int end;
    int numbers[];
    int sum;

    public CounterThread(int start, int end, int[] numbers) {
        this.start = start;
        this.end = end;
        this.numbers = numbers;
        sum = 0;
    }

    @Override
    public void run() {
        for (int i = start; i < end; ++i) {
            sum += numbers[i];
        }
    }

    public int getSum() {
        return sum;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

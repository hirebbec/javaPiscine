package edu.school21.numbers;

import edu.school21.exceptions.IllegalNumberException;

public class NumberWorker {
    public boolean isPrime(int num) {
        if (num < 2) {
            throw new IllegalNumberException();
        }
        for (int i = 2; i <= Math.sqrt(num); ++i) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public int digitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}

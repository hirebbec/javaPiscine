package edu.school21.numbers;

import edu.school21.exceptions.IllegalNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberWorkerTest {

    NumberWorker worker;
    @BeforeEach
    void beforeEachMethod() {
        worker = new NumberWorker();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 2, 11})
    public void isPrimeForPrimes(int num) {
        assertTrue(worker.isPrime(num));
    }
    @ParameterizedTest
    @ValueSource(ints = {12, 15, 77})
    public void isPrimeForNotPrimes(int num) {
        assertFalse(worker.isPrime(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0, -100})
    public void isPrimeForIncorrectNumbers(int num) {
        assertThrows(IllegalNumberException.class, () -> {worker.isPrime(num);});
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void digitSum(int num, int sum) {
        assertEquals(worker.digitSum(num), sum);
    }
}

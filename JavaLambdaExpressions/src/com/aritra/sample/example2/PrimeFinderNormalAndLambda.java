package com.aritra.sample.example2;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PrimeFinderNormalAndLambda {
    //Traditional approach
    private static boolean isPrime(int number) {
        if(number < 2) return false;
        for(int i=2; i<number; i++){
            if(number % i == 0) return false;
        }
        return true;
    }

    //Declarative approach
    private static boolean isPrimeLambda1(int number) {
        return number > 1
                && IntStream.range(2, number).noneMatch(
                index -> number % index == 0);
    }

    //Declarative approach using Behaviours or Predicates
    private static boolean isPrimeLambda2(int number) {
        IntPredicate isDivisible = index -> number % index == 0;

        return number > 1
                && IntStream.range(2, number).noneMatch(
                isDivisible);
    }
}

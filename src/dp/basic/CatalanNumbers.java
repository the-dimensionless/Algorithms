package dp.basic;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Catalan numbers are a sequence of natural numbers that occurs in many interesting counting problems like following.
 *
 * Count the number of expressions containing n pairs of parentheses which are correctly matched. For n = 3, possible expressions are ((())), ()(()), ()()(), (())(), (()()).
 * Count the number of possible Binary Search Trees with n keys (See this)
 * Count the number of full binary trees (A rooted binary tree is full if every vertex has either two children or no children) with n+1 leaves.
 * Given a number n, return the number of ways you can draw n chords in a circle with 2 x n points such that no 2 chords intersect.
 * The first few Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …
 *
 * Recursive Solution
 * Catalan numbers satisfy the following recursive formula.
 * C_0=1 \ and \ C_{n+1}=\sum_{i=0}^{n}C_iC_{n-i} \ for \ n\geq 0
 *
 */
public class CatalanNumbers {

    public static int catalanNumbersByRecursion(int N) {
        int num = 0;

        // base case
        if (N <= 1) {
            return 1;
        }

        for (int i = 0; i < N; i++) {
            num += catalanNumbersByRecursion(i) * catalanNumbersByRecursion(N - i - 1);
        }
        return num;
    }

    public static int catalanNumberByDP(int N) {
        int catalan[] = new int[N + 1];

        if (N <= 1) return 1;

        // base values;
        catalan[0] = catalan[1] = 1;

        for (int i = 2; i <= N; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }

        return catalan[N];
    }

    public static void main(String[] args) {
        System.out.println("Catalan Numbers By Recursion =>");
        IntStream.range(0, 11).forEach(i -> {
            System.out.print(catalanNumbersByRecursion(i) + " ");
        });

        System.out.println("\nCatalan Numbers By DP =>");
        IntStream.range(0, 11).forEach(i -> {
            System.out.print(catalanNumberByDP(i) + " ");
        });
    }
}

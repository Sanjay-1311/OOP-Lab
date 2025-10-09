package Lab_6.Maths;

import java.util.Scanner;

public class MathOperations {
    public int sum(int a, int b) {
        System.out.println("Called sum(int, int)");
        return a + b;
    }

    public double sum(double a, double b, double c) {
        System.out.println("Called sum(double, double, double)");
        return a + b + c;
    }

    public int sum(int... numbers) {
        System.out.println("Called sum(int...)");
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MathOperations mo = new MathOperations();
        System.out.print("Enter two integers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Sum of 2 ints: " + mo.sum(a, b));
        System.out.print("Enter three doubles: ");
        double d1 = sc.nextDouble();
        double d2 = sc.nextDouble();
        double d3 = sc.nextDouble();
        System.out.println("Sum of 3 doubles: " + mo.sum(d1, d2, d3));
        System.out.print("Enter how many integers to sum (varargs): ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("Sum using varargs: " + mo.sum(nums));
        sc.close();
    }
}
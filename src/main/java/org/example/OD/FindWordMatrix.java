package org.example.OD;

import java.util.Scanner;

public class FindWordMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String[] matrix = new String[n];
            for (int i = 0; i < n; i++) {
                matrix[i]=scanner.nextLine();
            }
        }
    }
}

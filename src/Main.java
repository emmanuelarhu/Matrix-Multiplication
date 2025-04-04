import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get dimensions and elements for Matrix A
        System.out.print("Enter dimensions of Matrix A (columns,rows): ");
        String[] dimensionsA = scanner.nextLine().split(",");
        int rowsA = Integer.parseInt(dimensionsA[0]);
        int colsA = Integer.parseInt(dimensionsA[1]);

        // Input matrix A
        System.out.println("Enter elements of Matrix A:");
        double[][] A = new double[rowsA][colsA];
        for (int i = 0; i < rowsA; i++) {
            String[] rowValues = scanner.nextLine().split(" ");
            for (int j = 0; j < colsA; j++) {
                A[i][j] = Double.parseDouble(rowValues[j]);
            }
        }

        // Get dimensions and elements for Matrix B
        System.out.print("Enter dimensions of Matrix B (columns,rows): ");
        String[] dimensionsB = scanner.nextLine().split(",");
        int rowsB = Integer.parseInt(dimensionsB[0]);
        int colsB = Integer.parseInt(dimensionsB[1]);

        // Check if multiplication is possible
        if (colsA != rowsB) {
            System.out.println("Error: Cannot multiply these matrices. Columns of A must equal rows of B.");
            scanner.close();
            return;
        }

        // Input matrix B
        System.out.println("Enter elements of Matrix B:");
        double[][] B = new double[rowsB][colsB];
        for (int i = 0; i < rowsB; i++) {
            String[] rowValues = scanner.nextLine().split(" ");
            for (int j = 0; j < colsB; j++) {
                B[i][j] = Double.parseDouble(rowValues[j]);
            }
        }

        // Perform matrix multiplication
        double[][] C = new double[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        // Display the result
        System.out.println("\nMatrix C:\n");
        for (int i = 0; i < rowsA; i++) {
            System.out.print("| ");
            for (int j = 0; j < colsB; j++) {
                // Format as integer if it's a whole number
                if (C[i][j] == (int) C[i][j]) {
                    System.out.print((int) C[i][j] + " ");
                } else {
                    System.out.print(C[i][j] + " ");
                }
            }
            System.out.println("|");
        }

        scanner.close();
    }
}


package com.mycompany.Product;

import java.util.Scanner;

public class SalesReport {

    public static void main(String[] args) {
        // The user will input the number into the system
       Scanner src = new Scanner(System.in);
      // Implement the 1D array 
      String [] products ={"Cozy Nights Monarch", "Restonic Barbos", "Sealy Phuket"};
       
       // Implement the 2D array to store all sales that happend
       // 2D Array to store sales (3 products x 3 months)
        int[][] sales = new int[3][3];

        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1) + " for " + products[i] + " mattress: ");
                sales[i][j] = src.nextInt();
            }
            System.out.println();
        }

        Product productReport = new Product(products, sales);
        PrintProduct printer = new PrintProduct();
        printer.printReport(productReport);

        src.close();
    }
}
       
       
       
       
       

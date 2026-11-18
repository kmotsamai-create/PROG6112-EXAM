
package com.mycompany.Product;


public class Product implements IProduct {
    
    private String[] productNames;
    // 2D array: rows = products, columns = months
    private int[][] salesData; 

    public Product(String[] productNames, int[][] salesData) {
        this.productNames = productNames;
        this.salesData = salesData;
    }

    @Override
   // this method is to get the total product sold
    public int GetTotalProductsSold() {
        int total = 0;
        for (int[] salesData1 : salesData) {
            for (int j = 0; j < salesData1.length; j++) {
                total += salesData1[j];
            }
        }
        return total;
    }

    @Override
    // this method is to get the average by / the sales and entiies
    public double GetAverageProductSold() {
        int totalSales = GetTotalProductsSold();
        int totalEntries = 0;
        for (int i = 0; i < salesData.length; i++) {
            totalEntries += salesData[i].length;
        }
        return (double) totalSales / totalEntries;
    }

    @Override
    public String GetMostPopularProduct() {
        int maxSales = -1;
        int bestProductIndex = 0;

        for (int i = 0; i < salesData.length; i++) {
            int currentProductTotal = 0;
            for (int j = 0; j < salesData[i].length; j++) {
                currentProductTotal += salesData[i][j];
            }
            if (currentProductTotal > maxSales) {
                maxSales = currentProductTotal;
                bestProductIndex = i;
            }
        }
        return productNames[bestProductIndex] + " (" + maxSales + ")";
    }

    @Override
    public String GetMostPopular() {
        throw new UnsupportedOperationException("Not supported yet.");
} 
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Product;

/**
 *
 * @author User
 */
public class PrintProduct {
     
        
      static void  PrintProduct(){
        
 
         System.out.println("PRODUCT SALES REPORT - 2026");
         System.out.println("");
         System.out.println("");
         System.out.println("************************************************");
         System.out.println("TOTAL PRODUCT: "+ Product.GetTotalProductsSold() );
         System.out.println("AVERAGE PRODUCT SALES: " + (int) Product.GetAverageProductSold() );
         System.out.println("MOST POPULAR: " + Product.GetMostPopularProduct());
        } 
}

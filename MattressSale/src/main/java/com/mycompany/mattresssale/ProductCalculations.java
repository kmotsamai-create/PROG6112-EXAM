/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mattresssale;

/**
 *
 * @author User
 */
public class ProductCalculations implements IProductCalculations {
    // Is private declaration of the prices
  private double price;

    public ProductCalculations(double price) {
        this.price = price;
    }
//  This method is to get VAT which is 15% of product price
    @Override
    public double GetVat() {
        return price * 0.15; 
    }
 //  This method is to get 5% of product price
    @Override
    public double GetCommission() {
        return price * 0.05;
    }
// This method is to get GetTotal which is(price + VAT + commission) = total
    @Override
    public double GetTotal() {
        return price + GetVat() + GetCommission();
    }
}  
    


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.Mattresssale;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author User
 */
public class MattressSale extends JFrame {
 String name,product;
 double prices;
 private final JLabel lblName = new JLabel("Customer Name:");
    private final JLabel lblPhone = new JLabel("Select Product:");
    private final JLabel lblCount = new JLabel("Enter Price: ");
    
    
    private final JTextField txtName = new JTextField(15);
    private final JTextField txtPhone = new JTextField(15);
     private final JTextField txtprices = new JTextField(15);
     
     
    private final JButton btnSave = new JButton("Process");
    String[]nmarjorArray = {"English" "Math" ""};
JcomboBox majorChoice = new JComboBox(majorArray);
private final Path filePath = Paths.get("contacts.txt");
    private final JTextArea txtDisplay =  new JTextArea(10,60);
    
  

public class ProductApp extends JFrame {
    private JTextField txtCustomerName, txtPrice;
    private JComboBox<String> cmbProduct;

    public ProductApp() {
        setTitle("Product App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu Bar Setup
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        processItem.addActionListener(e -> processSales());
        
        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(e -> clearFields());
        
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // Form Panel Layout
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField();
        panel.add(txtCustomerName);

        panel.add(new JLabel("Select Product:"));
        String[] products = { "Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket" };
        cmbProduct = new JComboBox<>(products);
        panel.add(cmbProduct);

        panel.add(new JLabel("Enter Price:"));
        txtPrice = new JTextField();
        panel.add(txtPrice);

        JButton btnProcess = new JButton("PROCESS");
        btnProcess.addActionListener(e -> processSales());
        panel.add(btnProcess);

        add(panel);
    }

    private void processSales() {
        try {
            String customerName = txtCustomerName.getText().trim();
            String productName = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText().trim());

            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            // Display Message Dialog
            String message = String.format("Customer Name: %s\nProduct: %s\nVAT: R %.1f\nCOMMISSION: R %.1f\nTOTAL: R %.1f",
                    customerName, productName, vat, commission, total);
            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Save to data.txt
            try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
                writer.println("DATA LOG");
                writer.println("*********************************************");
                writer.println("Customer Name: " + customerName);
                writer.println("Product: " + productName);
                writer.println(String.format("VAT: R %.1f", vat));
                writer.println(String.format("COMMISSION: R %.1f", commission));
                writer.println(String.format("TOTAL: R %.1f", total));
                writer.println("*********************************************");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving to file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric price.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
       new MattressSale();
    }
}

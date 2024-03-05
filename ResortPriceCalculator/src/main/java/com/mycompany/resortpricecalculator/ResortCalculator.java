/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.resortpricecalculator;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author LAPTOPVTC.VN
 */
public class ResortCalculator extends JFrame {

    double total;

    JPanel mainPanel, calculate, price, inputName, checkBox, inputValue;
    JLabel title, choose, cost, result;
    JTextField nameField;
    JCheckBox box1, box2, box3;
    JComboBox<String> comboBox;
    JButton calculateButton;

    public ResortCalculator() {
        setTitle("This is my first Frame");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc;

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 7;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.VERTICAL;
        title = new JLabel("Resort Price Calculator");
        Font font = new Font("Arial", Font.BOLD, 24);
        title.setFont(font);
        getContentPane().add(title, gbc);
        //
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 7;
        gbc.insets = new Insets(5, 20, 5, 20);
        gbc.fill = GridBagConstraints.VERTICAL;
        cost = new JLabel("Base price for a room is $200");
        font = new Font("Arial", Font.BOLD, 20);
        cost.setFont(font);
        getContentPane().add(cost, gbc);
        //
        gbc.gridy++;
        choose = new JLabel("Choose obtions that you want");
        choose.setFont(font);
        getContentPane().add(choose, gbc);
        //
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 5, 5, 0);
        gbc.anchor = GridBagConstraints.LINE_END;
        getContentPane().add(new JLabel("Guest Name: "), gbc);
        //
        gbc.gridx = 3;
        gbc.gridwidth = 5;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        nameField = new JTextField();
        getContentPane().add(nameField, gbc);
        //
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        box1 = new JCheckBox("Breakfast$20");
        getContentPane().add(box1, gbc);
        //
        gbc.gridx += 2;
        box2 = new JCheckBox("Gost$50");
        getContentPane().add(box2, gbc);
        //
        gbc.gridx += 2;
        box3 = new JCheckBox("Pool$15");
        getContentPane().add(box3, gbc);
        //
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(5, 20, 5, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        comboBox = new JComboBox<>();
        comboBox.addItem("Weekend(+30%)");
        comboBox.addItem("Week day(-10%)");
        getContentPane().add(comboBox, gbc);
        //
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 5, 5, 20);
        gbc.anchor = GridBagConstraints.CENTER;
        calculateButton = new JButton("Calculate");
        getContentPane().add(calculateButton, gbc);
        //
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 7;
        gbc.insets = new Insets(5, 20, 5, 20);
        gbc.fill = GridBagConstraints.VERTICAL;
        result = new JLabel("");
        font = new Font("Arial", Font.BOLD, 20);
        result.setFont(font);
        getContentPane().add(result, gbc);
        //

        calculateButton.addActionListener((e) -> {
            calculate();
        });
        
    }

    public void calculate() {
        String name = nameField.getText();
        if (nameField.getText().isEmpty()) {
            setColorBorder(nameField, Color.RED);
            JOptionPane.showMessageDialog(this, "Please enter your name");
            nameField.requestFocus();
        }
        double payment= 200;
        if(box1.isSelected()){
            payment+=20;
        }
        if(box2.isSelected()){
            payment+=50;
        }
         if(box3.isSelected()){
            payment+=15;
        }
        if(comboBox.getItemAt(comboBox.getSelectedIndex())=="Weekend(+30%)"){
            payment*=1.3;
        }else if(comboBox.getItemAt(comboBox.getSelectedIndex())=="Week day(-10%)"){
            payment*=0.9;
        }
        result.setText("Hello "+name+" Your payment is: $"+payment);
    }

    public void setColorBorder(JTextField textField, Color color) {
        Border newBorder = BorderFactory.createLineBorder(color);
        textField.setBorder(newBorder);
    }

}

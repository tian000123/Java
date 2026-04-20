package com.hbsd.elderlyos;

import javax.swing.*;
import java.awt.*;

public class HealthFrame extends JFrame {
    private JTextArea healthArea;
    private JButton btnAddRecord;
    private JButton btnBack;
    
    public HealthFrame() {
        setTitle("Health Records");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        
        initComponents();
        setupLayout();
        setupEventListeners();
        
        setVisible(true);
    }
    
    private void initComponents() {
        healthArea = new JTextArea();
        healthArea.setFont(new Font("Arial", Font.PLAIN, 18));
        healthArea.setEditable(false);
        healthArea.setText("Health Records:\n\n" +
                          "2026-04-15\n" +
                          "- Blood Pressure: 120/80 mmHg\n" +
                          "- Blood Sugar: 5.6 mmol/L\n" +
                          "- Temperature: 36.5°C\n\n" +
                          "2026-04-14\n" +
                          "- Blood Pressure: 125/85 mmHg\n" +
                          "- Blood Sugar: 5.8 mmol/L\n" +
                          "- Temperature: 36.4°C\n");
        
        btnAddRecord = createButton("Add Record", Color.ORANGE);
        btnBack = createButton("Back", Color.GRAY);
    }
    
    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setPreferredSize(new Dimension(200, 60));
        button.setFocusPainted(false);
        return button;
    }
    
    private void setupLayout() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(240, 240, 240));
        
        // Health records area
        JScrollPane scrollPane = new JScrollPane(healthArea);
        scrollPane.setPreferredSize(new Dimension(500, 300));
        
        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        buttonPanel.add(btnAddRecord);
        buttonPanel.add(btnBack);
        
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private void setupEventListeners() {
        btnAddRecord.addActionListener(e -> {
            String date = JOptionPane.showInputDialog(this, "Enter date (YYYY-MM-DD):", "Add Health Record", JOptionPane.PLAIN_MESSAGE);
            if (date != null && !date.isEmpty()) {
                String bloodPressure = JOptionPane.showInputDialog(this, "Enter blood pressure:", "Add Health Record", JOptionPane.PLAIN_MESSAGE);
                String bloodSugar = JOptionPane.showInputDialog(this, "Enter blood sugar:", "Add Health Record", JOptionPane.PLAIN_MESSAGE);
                String temperature = JOptionPane.showInputDialog(this, "Enter temperature:", "Add Health Record", JOptionPane.PLAIN_MESSAGE);
                
                if (bloodPressure != null && bloodSugar != null && temperature != null) {
                    healthArea.append(date + "\n" +
                                    "- Blood Pressure: " + bloodPressure + "\n" +
                                    "- Blood Sugar: " + bloodSugar + "\n" +
                                    "- Temperature: " + temperature + "\n\n");
                    JOptionPane.showMessageDialog(this, "Health record added successfully!");
                }
            }
        });
        
        btnBack.addActionListener(e -> dispose());
    }
}
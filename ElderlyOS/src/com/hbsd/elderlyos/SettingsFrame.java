package com.hbsd.elderlyos;

import javax.swing.*;
import java.awt.*;

public class SettingsFrame extends JFrame {
    private JButton btnLargeFont;
    private JButton btnNormalFont;
    private JButton btnHighContrast;
    private JButton btnNormalContrast;
    private JButton btnBack;
    
    public SettingsFrame() {
        setTitle("Settings");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        
        initComponents();
        setupLayout();
        setupEventListeners();
        
        setVisible(true);
    }
    
    private void initComponents() {
        btnLargeFont = createButton("Large Font Mode", Color.BLUE);
        btnNormalFont = createButton("Standard Font", Color.GRAY);
        btnHighContrast = createButton("High Contrast", Color.GREEN);
        btnNormalContrast = createButton("Standard Contrast", Color.GRAY);
        btnBack = createButton("Back", Color.GRAY);
    }
    
    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setPreferredSize(new Dimension(250, 60));
        button.setFocusPainted(false);
        return button;
    }
    
    private void setupLayout() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1, 20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        mainPanel.setBackground(new Color(240, 240, 240));
        
        mainPanel.add(btnLargeFont);
        mainPanel.add(btnNormalFont);
        mainPanel.add(btnHighContrast);
        mainPanel.add(btnNormalContrast);
        mainPanel.add(btnBack);
        
        add(mainPanel);
    }
    
    private void setupEventListeners() {
        btnLargeFont.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Large font mode enabled!");
        });
        
        btnNormalFont.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Standard font enabled!");
        });
        
        btnHighContrast.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "High contrast mode enabled!");
        });
        
        btnNormalContrast.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Standard contrast enabled!");
        });
        
        btnBack.addActionListener(e -> dispose());
    }
}
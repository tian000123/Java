package com.hbsd.elderlyos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElderlyOSMain extends JFrame {
    private JButton btnEmergency;
    private JButton btnContacts;
    private JButton btnCalendar;
    private JButton btnHealth;
    private JButton btnSettings;
    private JButton btnExit;
    
    public ElderlyOSMain() {
        setTitle("Elderly OS");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        initComponents();
        setupLayout();
        setupEventListeners();
    }
    
    private void initComponents() {
        // Create large buttons for elderly users
        btnEmergency = createButton("Emergency", Color.RED, new Font("Arial", Font.BOLD, 24));
        btnContacts = createButton("Contacts", Color.BLUE, new Font("Arial", Font.BOLD, 24));
        btnCalendar = createButton("Calendar", Color.GREEN, new Font("Arial", Font.BOLD, 24));
        btnHealth = createButton("Health", Color.ORANGE, new Font("Arial", Font.BOLD, 24));
        btnSettings = createButton("Settings", Color.GRAY, new Font("Arial", Font.BOLD, 24));
        btnExit = createButton("Exit", Color.LIGHT_GRAY, new Font("Arial", Font.BOLD, 24));
    }
    
    private JButton createButton(String text, Color color, Font font) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(font);
        button.setPreferredSize(new Dimension(300, 80));
        button.setFocusPainted(false);
        return button;
    }
    
    private void setupLayout() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 2, 20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        mainPanel.setBackground(new Color(240, 240, 240));
        
        mainPanel.add(btnEmergency);
        mainPanel.add(btnContacts);
        mainPanel.add(btnCalendar);
        mainPanel.add(btnHealth);
        mainPanel.add(btnSettings);
        mainPanel.add(btnExit);
        
        add(mainPanel);
    }
    
    private void setupEventListeners() {
        btnEmergency.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Emergency function triggered!");
            }
        });
        
        btnContacts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContactsFrame();
            }
        });
        
        btnCalendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CalendarFrame();
            }
        });
        
        btnHealth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HealthFrame();
            }
        });
        
        btnSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SettingsFrame();
            }
        });
        
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ElderlyOSMain().setVisible(true);
            }
        });
    }
}
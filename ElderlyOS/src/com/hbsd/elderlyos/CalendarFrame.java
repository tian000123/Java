package com.hbsd.elderlyos;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class CalendarFrame extends JFrame {
    private JLabel dateLabel;
    private JButton btnAddReminder;
    private JButton btnBack;
    private JTextArea reminderArea;
    
    public CalendarFrame() {
        setTitle("Calendar");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        
        initComponents();
        setupLayout();
        setupEventListeners();
        
        setVisible(true);
    }
    
    private void initComponents() {
        // Display current date
        Calendar calendar = Calendar.getInstance();
        String dateStr = calendar.get(Calendar.YEAR) + "-" + 
                        (calendar.get(Calendar.MONTH) + 1) + "-" + 
                        calendar.get(Calendar.DAY_OF_MONTH);
        dateLabel = new JLabel(dateStr, SwingConstants.CENTER);
        dateLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        reminderArea = new JTextArea();
        reminderArea.setFont(new Font("Arial", Font.PLAIN, 18));
        reminderArea.setEditable(false);
        reminderArea.setText("Today's Reminders:\n\n" +
                           "- 8:00 AM Take medicine\n" +
                           "- 10:00 AM Medical checkup\n" +
                           "- 3:00 PM Exercise\n");
        
        btnAddReminder = createButton("Add Reminder", Color.GREEN);
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
        
        // Date display
        JPanel datePanel = new JPanel();
        datePanel.add(dateLabel);
        
        // Reminder area
        JScrollPane scrollPane = new JScrollPane(reminderArea);
        scrollPane.setPreferredSize(new Dimension(500, 250));
        
        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        buttonPanel.add(btnAddReminder);
        buttonPanel.add(btnBack);
        
        mainPanel.add(datePanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private void setupEventListeners() {
        btnAddReminder.addActionListener(e -> {
            String reminder = JOptionPane.showInputDialog(this, "Enter reminder content:", "Add Reminder", JOptionPane.PLAIN_MESSAGE);
            if (reminder != null && !reminder.isEmpty()) {
                String time = JOptionPane.showInputDialog(this, "Enter reminder time:", "Add Reminder", JOptionPane.PLAIN_MESSAGE);
                if (time != null && !time.isEmpty()) {
                    reminderArea.append("- " + time + " " + reminder + "\n");
                    JOptionPane.showMessageDialog(this, "Reminder added successfully!");
                }
            }
        });
        
        btnBack.addActionListener(e -> dispose());
    }
}
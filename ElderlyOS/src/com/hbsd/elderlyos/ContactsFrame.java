package com.hbsd.elderlyos;

import javax.swing.*;
import java.awt.*;

public class ContactsFrame extends JFrame {
    private JList<String> contactList;
    private DefaultListModel<String> listModel;
    private JButton btnAddContact;
    private JButton btnBack;
    
    public ContactsFrame() {
        setTitle("Contacts");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        
        initComponents();
        setupLayout();
        setupEventListeners();
        
        setVisible(true);
    }
    
    private void initComponents() {
        listModel = new DefaultListModel<>();
        // Add default contacts
        listModel.addElement("Child - 13800138000");
        listModel.addElement("Spouse - 13900139000");
        listModel.addElement("Doctor - 120");
        listModel.addElement("Community - 110");
        
        contactList = new JList<>(listModel);
        contactList.setFont(new Font("Arial", Font.PLAIN, 20));
        contactList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        btnAddContact = createButton("Add Contact", Color.BLUE);
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
        
        // Contact list
        JScrollPane scrollPane = new JScrollPane(contactList);
        scrollPane.setPreferredSize(new Dimension(500, 300));
        
        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        buttonPanel.add(btnAddContact);
        buttonPanel.add(btnBack);
        
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private void setupEventListeners() {
        btnAddContact.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Enter contact name:", "Add Contact", JOptionPane.PLAIN_MESSAGE);
            if (name != null && !name.isEmpty()) {
                String phone = JOptionPane.showInputDialog(this, "Enter phone number:", "Add Contact", JOptionPane.PLAIN_MESSAGE);
                if (phone != null && !phone.isEmpty()) {
                    listModel.addElement(name + " - " + phone);
                    JOptionPane.showMessageDialog(this, "Contact added successfully!");
                }
            }
        });
        
        btnBack.addActionListener(e -> dispose());
        
        // Double click to call
        contactList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int index = contactList.locationToIndex(evt.getPoint());
                    if (index >= 0) {
                        String contact = listModel.getElementAt(index);
                        JOptionPane.showMessageDialog(null, "Calling: " + contact);
                    }
                }
            }
        });
    }
}
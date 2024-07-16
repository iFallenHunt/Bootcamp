package com.bootcamp.ui;

import com.bootcamp.domain.Bootcamp;
import com.bootcamp.domain.Dev;

import javax.swing.*;
import java.awt.*;

public class DevsManager extends JFrame {

    private JList<Dev> devJList;
    private DefaultListModel<Dev> devListModel;

    private JList<Bootcamp> bootcampJList;

    private JButton enrollButton;
    private JButton progressButton;
    private JButton calculateXPButton;

    public DevsManager() {
        setTitle("Devs Manager");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        initListeners();

        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel devPanel = new JPanel();
        devPanel.setLayout(new GridLayout(1, 2, 10, 10));

        devListModel = new DefaultListModel<>();
        devJList = new JList<>(devListModel);
        JScrollPane devScrollPane = new JScrollPane(devJList);
        devPanel.add(devScrollPane);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));

        enrollButton = new JButton("Enroll in Bootcamp");
        progressButton = new JButton("Progress");
        calculateXPButton = new JButton("Calculate XP");

        buttonPanel.add(enrollButton);
        buttonPanel.add(progressButton);
        buttonPanel.add(calculateXPButton);

        devPanel.add(buttonPanel);

        panel.add(devPanel, BorderLayout.WEST);

        bootcampJList = new JList<>();
        JScrollPane bootcampScrollPane = new JScrollPane(bootcampJList);

        panel.add(bootcampScrollPane, BorderLayout.CENTER);

        add(panel);
    }

    private void initListeners() {
        enrollButton.addActionListener(_ -> enrollInBootcamp());
        progressButton.addActionListener(_ -> progressDev());
        calculateXPButton.addActionListener(_ -> calculateXP());

        // Add additional listeners if needed
    }

    private void enrollInBootcamp() {
        int devIndex = devJList.getSelectedIndex();
        int bootcampIndex = bootcampJList.getSelectedIndex();
        if (devIndex != -1 && bootcampIndex != -1) {
            Dev dev = devListModel.getElementAt(devIndex);
            Bootcamp bootcamp = bootcampJList.getModel().getElementAt(bootcampIndex);
            dev.enrollInBootcamp(bootcamp);
            JOptionPane.showMessageDialog(this, dev.getName() + " enrolled in Bootcamp " + bootcamp.getName());
        } else {
            JOptionPane.showMessageDialog(this, "Select a Dev and a Bootcamp for enrollment.");
        }
    }

    private void progressDev() {
        int devIndex = devJList.getSelectedIndex();
        if (devIndex != -1) {
            Dev dev = devListModel.getElementAt(devIndex);
            dev.progress();
            JOptionPane.showMessageDialog(this, "Progress made for " + dev.getName());
        } else {
            JOptionPane.showMessageDialog(this, "Select a Dev to progress.");
        }
    }

    private void calculateXP() {
        int devIndex = devJList.getSelectedIndex();
        if (devIndex != -1) {
            Dev dev = devListModel.getElementAt(devIndex);
            double totalXP = dev.calculateTotalXp();
            JOptionPane.showMessageDialog(this, "Total XP for " + dev.getName() + ": " + totalXP);
        } else {
            JOptionPane.showMessageDialog(this, "Select a Dev to calculate XP.");
        }
    }

    public void addBootcamp(Bootcamp bootcamp) {
        // Add bootcamp to the bootcamp list or update the JList accordingly
        // This method seems incomplete in the original code
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DevsManager::new);
    }
}

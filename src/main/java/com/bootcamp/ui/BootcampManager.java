package com.bootcamp.ui;

import com.bootcamp.domain.Bootcamp;
import com.bootcamp.domain.Course;
import com.bootcamp.domain.Mentoring;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BootcampManager extends JFrame {
    private final List<Bootcamp> bootcamps = new ArrayList<>();

    private JList<Bootcamp> bootcampJList;
    private DefaultListModel<Bootcamp> bootcampListModel;

    private JTextField nameField;
    private JTextArea descriptionArea;
    private JButton createBootcampButton;
    private JButton deleteBootcampButton;

    public BootcampManager() {
        setTitle("Bootcamp Manager");
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

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionArea = new JTextArea();
        descriptionArea.setLineWrap(true);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);

        createBootcampButton = new JButton("Create Bootcamp");
        deleteBootcampButton = new JButton("Delete Bootcamp");

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(descriptionLabel);
        formPanel.add(descriptionScrollPane);
        formPanel.add(createBootcampButton);
        formPanel.add(deleteBootcampButton);

        panel.add(formPanel, BorderLayout.WEST);

        bootcampListModel = new DefaultListModel<>();
        bootcampJList = new JList<>(bootcampListModel);
        JScrollPane bootcampScrollPane = new JScrollPane(bootcampJList);

        panel.add(bootcampScrollPane, BorderLayout.CENTER);

        add(panel);
    }

    private void initListeners() {
        createBootcampButton.addActionListener(_ -> createBootcamp());
        deleteBootcampButton.addActionListener(_ -> deleteBootcamp());

        bootcampJList.addListSelectionListener(_ -> displaySelectedBootcamp());
    }

    private void createBootcamp() {
        String name = nameField.getText();
        String description = descriptionArea.getText();
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setName(name);
        bootcamp.setDescription(description);
        bootcamp.addContent(new Course());
        bootcamp.addContent(new Mentoring());
        bootcampListModel.addElement(bootcamp);
        bootcamps.add(bootcamp);
        clearFields();
    }

    private void deleteBootcamp() {
        int selectedIndex = bootcampJList.getSelectedIndex();
        if (selectedIndex != -1) {
            bootcampListModel.remove(selectedIndex);
            bootcamps.remove(selectedIndex);
        }
    }

    private void displaySelectedBootcamp() {
        int selectedIndex = bootcampJList.getSelectedIndex();
        if (selectedIndex != -1) {
            Bootcamp bootcamp = bootcampListModel.getElementAt(selectedIndex);
            JOptionPane.showMessageDialog(this, bootcamp.toString());
        }
    }

    private void clearFields() {
        nameField.setText("");
        descriptionArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BootcampManager::new);
    }
}

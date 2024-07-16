package com.bootcamp.service;

import com.bootcamp.domain.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import javax.swing.JOptionPane;

public class BootcampService {

    private final Map<String, Dev> devs = new HashMap<>();
    private final Set<Bootcamp> bootcamps = new HashSet<>();

    public void start() {
        boolean continueRunning = true;
        while (continueRunning) {
            String option = JOptionPane.showInputDialog("Choose an option:\n1. Create Bootcamp\n2. Delete Bootcamp\n3. List Bootcamps\n4. Register Dev\n5. Enroll Dev\n6. Progress Dev\n7. Calculate Total XP\n8. Show Courses\n9. Exit");
            switch (option) {
                case "1":
                    createBootcamp();
                    break;
                case "2":
                    deleteBootcamp();
                    break;
                case "3":
                    listBootcamps();
                    break;
                case "4":
                    registerDev();
                    break;
                case "5":
                    enrollDev();
                    break;
                case "6":
                    progressDev();
                    break;
                case "7":
                    calculateTotalXP();
                    break;
                case "8":
                    showCourse();
                    break;
                case "9":
                    continueRunning = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option");
                    break;
            }
        }
    }

    private void createBootcamp() {
        String name = JOptionPane.showInputDialog("Bootcamp Name:");
        String description = JOptionPane.showInputDialog("Bootcamp Description:");

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setName(name);
        bootcamp.setDescription(description);

        boolean addContent = true;
        while (addContent) {
            String contentType = JOptionPane.showInputDialog("Add Content:\n1. Course\n2. Mentoring\n3. Finish");
            switch (contentType) {
                case "1":
                    Course course = new Course();
                    course.setTitle(JOptionPane.showInputDialog("Course Title:"));
                    course.setDescription(JOptionPane.showInputDialog("Course Description:"));
                    course.setWorkload(Integer.parseInt(JOptionPane.showInputDialog("Duration (hours):")));
                    bootcamp.getContents().add(course);
                    break;
                case "2":
                    Mentoring mentoring = new Mentoring();
                    mentoring.setTitle(JOptionPane.showInputDialog("Mentoring Title:"));
                    mentoring.setDescription(JOptionPane.showInputDialog("Mentoring Description:"));
                    mentoring.setDate(LocalDate.parse(JOptionPane.showInputDialog("Date (YYYY-MM-DD):")));
                    bootcamp.getContents().add(mentoring);
                    break;
                case "3":
                    addContent = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option");
                    break;
            }
        }

        bootcamps.add(bootcamp);
        JOptionPane.showMessageDialog(null, "Bootcamp " + name + " created successfully!");
    }

    private void deleteBootcamp() {
        String name = JOptionPane.showInputDialog("Name of Bootcamp to delete:");
        Bootcamp bootcampToRemove = null;
        for (Bootcamp bootcamp : bootcamps) {
            if (bootcamp.getName().equals(name)) {
                bootcampToRemove = bootcamp;
                break;
            }
        }
        if (bootcampToRemove != null) {
            bootcamps.remove(bootcampToRemove);
            JOptionPane.showMessageDialog(null, "Bootcamp " + name + " deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Bootcamp not found!");
        }
    }

    private void listBootcamps() {
        if (bootcamps.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No bootcamps available.");
        } else {
            StringBuilder bootcampList = new StringBuilder("Available Bootcamps:\n");
            for (Bootcamp bootcamp : bootcamps) {
                bootcampList.append(bootcamp.getName()).append(" - ").append(bootcamp.getDescription()).append("\n");
            }
            JOptionPane.showMessageDialog(null, bootcampList.toString());
        }
    }

    private void registerDev() {
        String devName = JOptionPane.showInputDialog("Dev Name:");
        if (devs.containsKey(devName)) {
            JOptionPane.showMessageDialog(null, "Dev already registered!");
        } else {
            Dev dev = new Dev();
            dev.setName(devName);
            devs.put(devName, dev);
            JOptionPane.showMessageDialog(null, "Dev " + devName + " registered successfully!");
        }
    }

    private void enrollDev() {
        String devName = JOptionPane.showInputDialog("Dev Name:");
        Dev dev = devs.get(devName);
        if (dev != null) {
            String bootcampName = JOptionPane.showInputDialog("Bootcamp Name:");
            Bootcamp bootcamp = getBootcampByName(bootcampName);
            if (bootcamp != null) {
                dev.enrollInBootcamp(bootcamp);
                JOptionPane.showMessageDialog(null, "Dev " + devName + " enrolled in Bootcamp " + bootcampName + " successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Bootcamp not found!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Dev not found! Please register the Dev first.");
        }
    }

    private Bootcamp getBootcampByName(String name) {
        for (Bootcamp bootcamp : bootcamps) {
            if (bootcamp.getName().equals(name)) {
                return bootcamp;
            }
        }
        return null;
    }

    private void progressDev() {
        String devName = JOptionPane.showInputDialog("Dev Name:");
        Dev dev = devs.get(devName);
        if (dev != null) {
            dev.progress();
            JOptionPane.showMessageDialog(null, "Progress made successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Dev not found!");
        }
    }

    private void calculateTotalXP() {
        String devName = JOptionPane.showInputDialog("Dev Name:");
        Dev dev = devs.get(devName);
        if (dev != null) {
            double xp = dev.calculateTotalXp();
            JOptionPane.showMessageDialog(null, "Total XP for " + devName + ": " + xp);
        } else {
            JOptionPane.showMessageDialog(null, "Dev not found!");
        }
    }

    private void showCourse() {
        String devName = JOptionPane.showInputDialog("Dev Name:");
        Dev dev = devs.get(devName);
        if (dev != null) {
            StringBuilder contents = new StringBuilder();
            for (Content content : dev.getEnrolledContents()) {
                contents.append(content.getTitle()).append("\n");
            }
            JOptionPane.showMessageDialog(null, "Enrolled courses of " + devName + ":\n" + contents.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Dev not found!");
        }
    }
}

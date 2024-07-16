package com.bootcamp.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
public class Dev {
    @Setter
    private String name;
    private final Set<Content> enrolledContents = new LinkedHashSet<>();
    private final Set<Content> completedContents = new LinkedHashSet<>();

    public void enrollInBootcamp(Bootcamp bootcamp) {
        bootcamp.addDev(this);
        this.enrolledContents.addAll(bootcamp.getContents());
    }

    public void progress() {
        if (!enrolledContents.isEmpty()) {
            Content content = enrolledContents.iterator().next();
            completedContents.add(content);
            enrolledContents.remove(content);
        } else {
            System.err.println("You are not enrolled in any content!");
        }
    }

    public double calculateTotalXp() {
        return completedContents.stream()
                .mapToDouble(Content::calculateXp)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(name, dev.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Dev{" +
                "name='" + name + '\'' +
                ", enrolledContents=" + enrolledContents +
                ", completedContents=" + completedContents +
                '}';
    }
}
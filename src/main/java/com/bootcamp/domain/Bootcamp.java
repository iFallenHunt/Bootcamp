package com.bootcamp.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
public class Bootcamp {
    @Setter
    private String name;
    @Setter
    private String description;
    private final LocalDate startDate = LocalDate.now();
    private final LocalDate endDate = startDate.plusDays(45);
    private final Set<com.bootcamp.domain.Dev> enrolledDevs = new HashSet<>();
    private final Set<com.bootcamp.domain.Content> contents = new LinkedHashSet<>();

    public void addContent(Content content) {
        contents.add(content);
    }

    public void addDev(Dev dev) {
        enrolledDevs.add(dev);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(name, bootcamp.name) && Objects.equals(description, bootcamp.description) && Objects.equals(startDate, bootcamp.startDate) && Objects.equals(endDate, bootcamp.endDate) && Objects.equals(enrolledDevs, bootcamp.enrolledDevs) && Objects.equals(contents, bootcamp.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, startDate, endDate, enrolledDevs, contents);
    }

    @Override
    public String toString() {
        return "Bootcamp{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", enrolledDevs=" + enrolledDevs +
                ", contents=" + contents +
                '}';
    }
}
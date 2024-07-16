package com.bootcamp.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Course extends Content {
    private int workload;

    @Override
    public double calculateXp() {
        return DEFAULT_XP * workload;
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", workload=" + workload +
                '}';
    }
}
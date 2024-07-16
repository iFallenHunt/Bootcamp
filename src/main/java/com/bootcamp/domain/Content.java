package com.bootcamp.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Content {
    protected static final double DEFAULT_XP = 10d;

    private String title;
    private String description;

    public abstract double calculateXp();

    @Override
    public String toString() {
        return "Content{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
package com.ucb.FrankyService;

public record WorkFlow(
        String name,
        String description
) {
    // Getters
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

}

package com.example.cardgame.model;

public enum Sample {
    A (1),
    B (2);

    int sample;


    private Sample(int i) {
        sample = i;
    }
    public int i() {
        return sample;
    }
}

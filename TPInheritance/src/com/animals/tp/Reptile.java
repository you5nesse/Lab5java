package com.animals.tp;

public class Reptile extends Animal {
    private String typeEcailles;

    public Reptile(String nom, int age, String typeEcailles) {
        super(nom, age);
        this.typeEcailles = typeEcailles;
    }

    public void seChauffer() {
        System.out.println(nom + " se chauffe au soleil.");
    }

    @Override
    public String toString() {
        return super.toString() +
               " {Reptile, écailles=" + typeEcailles + "}";
    }
}
package org.example;

public class Main {
    public static void main(String[] args) {
        Voiture v = new Voiture();
        v.setMoteur(new Moteur());
        v.rouler();
    }
}
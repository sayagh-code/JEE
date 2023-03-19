package org.example;

public class Batterie implements IMoteur{
    @Override
    public void demarrer(){
        System.out.println("La batterie fonctionne!");
    }
}

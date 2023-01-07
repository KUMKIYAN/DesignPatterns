package com.example.demo.controller;

public abstract class ComputerTemplate {
    public void buildComputer() {
        collectComponents();
        assembleComponents();
        installOS();
        startComputer();
        System.out.println("System is On");
    }

    private void collectComponents() {
        System.out.println("collecting all system components");
    }

    private void startComputer() {
        System.out.println("system is booting");
    }

    public abstract void assembleComponents();

    public abstract void installOS();
}

class Laptop extends ComputerTemplate {
    @Override
    public void assembleComponents() {
        System.out.println("joining the units, plus 4 HDMI ports");
    }

    @Override
    public void installOS() {
        System.out.println("installing windows");
    }
}

class Server extends ComputerTemplate {
    @Override
    public void assembleComponents() {
        System.out.println("joining the units, plus 1 VGA port");
    }

    @Override
    public void installOS() {
        System.out.println("installing ubuntu");
    }
}

class Store {
    public static void main(String[] args) {
        ComputerTemplate system1 = new Laptop();
        ComputerTemplate system2 = new Server();
        system1.buildComputer();
        system2.buildComputer();
        /*
        collecting all system components
        joining the units, plus 4 HDMI ports
        installing windows
        system is booting
        System is On
        collecting all system components
        joining the units, plus 1 VGA port
        installing ubuntu
        system is booting
        System is On
         */
    }
}

package structural_patterns.facade;

public class ComputerFacade {
    Computer computer;

    public ComputerFacade(Computer computer){
        this.computer = computer;
    }

    public void turnOn(){
        computer.getElectricalShock();
        computer.makeSound();
        computer.showLoadingScreen();;
        computer.bam();
    }

    public void turnOff(){
        computer.closeEverything();
        computer.pullCurrent();
        computer.sooth();
    }

}

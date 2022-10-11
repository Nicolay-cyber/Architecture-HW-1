package structural_patterns;

import structural_patterns.adapter.AfricanLion;
import structural_patterns.adapter.Hunter;
import structural_patterns.adapter.WildDog;
import structural_patterns.adapter.WildDogAdapter;
import structural_patterns.composite.Designer;
import structural_patterns.composite.Developer;
import structural_patterns.composite.Organization;
import structural_patterns.decorator.MilkCoffee;
import structural_patterns.decorator.SimpleCoffee;
import structural_patterns.decorator.VanillaCoffee;
import structural_patterns.decorator.WhipCoffee;
import structural_patterns.bridge.pages.About;
import structural_patterns.bridge.pages.Careers;
import structural_patterns.bridge.themes.DarkTheme;
import structural_patterns.facade.Computer;
import structural_patterns.facade.ComputerFacade;
import structural_patterns.proxy.Door;
import structural_patterns.proxy.LabDoor;
import structural_patterns.proxy.SecuredDoor;

public class main {
    public static void main(String[] args) {
        System.out.println("1. Adapter:\n");
        WildDog wildDog = new WildDog();
        WildDogAdapter wildDogAdapter = new WildDogAdapter(wildDog);
        AfricanLion africanLion = new AfricanLion();
        Hunter hunter = new Hunter();
        hunter.hunt(africanLion);
        hunter.hunt(wildDogAdapter);

        System.out.println("\n2. Bridge:\n");
        DarkTheme darkTheme = new DarkTheme();
        About about = new About(darkTheme);
        Careers careers = new Careers(darkTheme);
        System.out.println(about.getContent());
        System.out.println(careers.getContent());

        System.out.println("\n3. Composite:\n");
        Developer john = new Developer("John Doe", 12000);
        Designer jane  = new Designer("Jane  Doe", 15000);
        Organization organization = new Organization();
        organization.addEmployee(jane);
        organization.addEmployee(john);
        System.out.println("Net salary: " + organization.getNetSalaries());

        System.out.println("\n4. Decorator:\n");
        SimpleCoffee coffee = new SimpleCoffee();
        System.out.println(coffee.getCost());
        System.out.println(coffee.getDescription());

        MilkCoffee milkCoffee = new MilkCoffee(coffee);
        System.out.println(milkCoffee.getCost());
        System.out.println(milkCoffee.getDescription());

        WhipCoffee whipCoffee = new WhipCoffee(milkCoffee);
        System.out.println(whipCoffee.getCost());
        System.out.println(whipCoffee.getDescription());

        VanillaCoffee vanillaCoffee = new VanillaCoffee(whipCoffee);
        System.out.println(vanillaCoffee.getCost());
        System.out.println(vanillaCoffee.getDescription());

        System.out.println("\n5. Facade:\n");
        ComputerFacade computer = new ComputerFacade(new Computer());
        computer.turnOn();
        computer.turnOff();

        System.out.println("\n6. Proxy\n");
        SecuredDoor door = new SecuredDoor(new LabDoor());
        door.open("invalid");
        door.open("$ecr@t");
        door.close();
    }
}

package structural_patterns.adapter;

public class AfricanLion implements Lion{
    @Override
    public void roar() {
        System.out.println("Rahhh!");
    }
}

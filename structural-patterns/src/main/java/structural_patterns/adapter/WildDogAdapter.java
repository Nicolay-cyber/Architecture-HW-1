package structural_patterns.adapter;

public class WildDogAdapter implements Lion{
    WildDog wildDog;

    public WildDogAdapter(WildDog wildDog) {
        this.wildDog = wildDog;
    }

    @Override
    public void roar() {
        wildDog.bark();
    }
}

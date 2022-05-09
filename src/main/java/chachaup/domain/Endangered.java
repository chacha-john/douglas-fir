package chachaup.domain;

public class Endangered extends Animal{

    private String health;
    private int age;

    public static final String HEALTHY = "healthy";

    public Endangered(String animalName) {
        super(animalName);

    }
}

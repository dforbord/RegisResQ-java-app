package RegisResQ.application;

public class Cat extends Animal {

    public Cat() {
        super();
        this.species = "cat";
    }

    public Cat(String breed, String name, Boolean sterilized, String dateArrived) {
        super(breed, name, sterilized, dateArrived);
        this.species = "cat";
    }
}

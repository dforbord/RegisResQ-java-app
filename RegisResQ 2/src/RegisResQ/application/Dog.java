package RegisResQ.application;

public class Dog extends Animal {

    public Dog() {
        super(); // Calls Animal’s no-arg constructor
        this.species = "dog"; // Subclass can set species now
    }

    public Dog(String breed, String name, Boolean sterilized, String dateArrived) {
        super(breed, name, sterilized, dateArrived); // Sets other fields
        this.species = "dog";
    }
}

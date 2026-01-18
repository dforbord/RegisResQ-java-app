package RegisResQ.application;

public abstract class Animal {
    protected String species;
    protected String breed;
    protected String name;
    protected Boolean sterilized;
    protected String dateArrived;

    public Animal() {
        this.breed = null;
        this.name = null;
        this.sterilized = false;
        this.dateArrived = null;
    }

    public Animal(String breed, String name, Boolean sterilized, String dateArrived) {
        this.breed = breed;
        this.name = name;
        this.sterilized = sterilized;
        this.dateArrived = dateArrived;
    }

    public String getSpecies() {
        return species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSterilized() {
        return sterilized;
    }

    public void setSterilized(Boolean sterilized) {
        this.sterilized = sterilized;
    }

    public String getDateArrived() {
        return dateArrived;
    }

    public void setDateArrived(String dateArrived) {
        this.dateArrived = dateArrived;
    }

    @Override
    public String toString() {
        return species + " " + breed + " " + name + " " + sterilized + " " + dateArrived;
    }

    public boolean validate() {
        if (breed == null || breed.isEmpty()) return false;
        if (name == null || name.isEmpty()) return false;
        if (sterilized == null) return false;
        if (dateArrived == null || dateArrived.isEmpty()) return false;

        // Check format: YYYY-MM-DD
        if (!dateArrived.matches("\\d{4}-\\d{2}-\\d{2}")) return false;

        try {
            String[] parts = dateArrived.split("-");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);

            if (month < 1 || month > 12) return false;

            int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

            // Leap year check
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                daysInMonth[1] = 29;
            }

            return day >= 1 && day <= daysInMonth[month - 1];

        } catch (Exception e) {
            return false;
        }
    }
}

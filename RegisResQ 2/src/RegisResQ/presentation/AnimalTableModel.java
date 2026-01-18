package RegisResQ.presentation;

import RegisResQ.application.Animal;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class AnimalTableModel extends AbstractTableModel {
    private List<Animal> animals;
    private final String[] columnNames = 
    {"Type", "Breed", "Name", "Sterilized", "Arrived"};

    public AnimalTableModel() {
        animals = null;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public int getRowCount() {
        return animals == null ? 0 : animals.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Animal a = animals.get(row);
        return switch (column) {
            case 0 -> a.getSpecies();
            case 1 -> a.getBreed();
            case 2 -> a.getName();
            case 3 -> a.getSterilized() ? "Yes" : "No";
            case 4 -> a.getDateArrived();  // Format: YYYY-MM-DD
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}

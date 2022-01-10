package answers.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Building {
    public Building(int numberOfApartments) {
        this.families = new Family[numberOfApartments];
    }

    private final Family[] families;
}

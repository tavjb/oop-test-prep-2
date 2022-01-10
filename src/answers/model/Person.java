package answers.model;

import answers.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Person {
    private String name;
    private int age;
    private Gender gender;
}

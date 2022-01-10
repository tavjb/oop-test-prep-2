package answers.model;

import answers.exceptions.ImpossibleChildAgeException;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@Data
public class Family {
    public Family(final Person parent1, final Person[] children) throws ImpossibleChildAgeException {
        this.parents = new Person[] { parent1 };
        for (Person child : children) {
            if (child.getAge() >= parent1.getAge()) {
                throw new ImpossibleChildAgeException(child.getAge(), parent1.getAge());
            }
            this.children.add(child);
        }
    }

    public Family(final Person parent1, final Person parent2, final Person[] children) throws ImpossibleChildAgeException {
        this.parents = new Person[] { parent1, parent2 };
        for (Person child : children) {
            if (child.getAge() >= parent1.getAge() || child.getAge() >= parent2.getAge()) {
                throw new ImpossibleChildAgeException(child.getAge(), parent1.getAge());
            }
        }
    }

    public final Person[] parents;
    private final List<Person> children = new ArrayList<>();
    private final Set<Family> friendFamilies = new HashSet<>();

    public void addChild(final Person child) throws ImpossibleChildAgeException {
        for (Person parent : parents) {
            if (child.getAge() >= parent.getAge()) {
                throw new ImpossibleChildAgeException(child.getAge(), parent.getAge());
            }
        }
    }

    public void becomeFriendsWithFamily(final Family family) {
        friendFamilies.add(family);
        family.becomeFriendsWithFamily(this);
    }
}

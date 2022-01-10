package answers;

import answers.model.Building;
import answers.model.Family;
import answers.model.Person;
import answers.model.enums.Gender;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

    }

    public static int getAverageChildAge(final Building building) {
        int childCount = 0;
        int childAgeSum = 0;
        for (Family family : building.getFamilies()) {
            for (Person child : family.getChildren()) {
                childCount++;
                childAgeSum += child.getAge();
            }
        }
        return childAgeSum / childCount;
    }

    public static int getAverageAge(final Building building) {
        int personCount = 0;
        int personAgeSum = 0;
        for (Family family : building.getFamilies()) {
            for (Person parent : family.getParents()) {
                personCount++;
                personAgeSum += parent.getAge();
            }

            for (Person child : family.getChildren()) {
                personCount++;
                personAgeSum += child.getAge();
            }
        }
        return personAgeSum / personCount;

    }

    public static Family[] getSingleParentFamilies(final Building building) {
        Set<Family> singleParentFamiliesSet = new HashSet<>();
        for (Family family : building.getFamilies()) {
            if (family.getParents().length == 1) {
                singleParentFamiliesSet.add(family);
            }
        }

        Family[] singleParentFamilies = new Family[singleParentFamiliesSet.size()];
        for (int i = 0; i < singleParentFamilies.length; i++) {
            singleParentFamilies[i] = singleParentFamiliesSet.iterator().next();
        }

        return  singleParentFamilies;
    }

    public static Family[] getSingleChildGenderFamilies(final Building building) {
        Set<Family> singleChildGenderFamiliesSet = new HashSet<>();
        for (Family family : building.getFamilies()) {
            Gender prevChildGender = family.getChildren().get(0).getGender();
            boolean isSingleChildGenderFamily = true;
            for (Person child : family.getChildren()) {
                if (child.getGender() != prevChildGender) {
                    isSingleChildGenderFamily = false;
                    break;
                }
                prevChildGender = child.getGender();
            }

            if (isSingleChildGenderFamily) {
                singleChildGenderFamiliesSet.add(family);
            }
        }

        Family[] singleChildGenderFamilies = new Family[singleChildGenderFamiliesSet.size()];
        for (int i = 0; i < singleChildGenderFamilies.length; i++) {
            singleChildGenderFamilies[i] = singleChildGenderFamiliesSet.iterator().next();
        }

        return singleChildGenderFamilies;
    }
}

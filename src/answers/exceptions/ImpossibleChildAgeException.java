package answers.exceptions;

public class ImpossibleChildAgeException extends Exception {
    public ImpossibleChildAgeException(int childAge, int parentAge) {
        super("Child age: " + childAge + " is not lower than parent's: " + parentAge);
    }
 }

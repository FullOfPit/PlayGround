package records;

import java.util.Objects;

public record Person(String name, String address, int age) {
    public Person {
        Objects.requireNonNull(name);
    }
}

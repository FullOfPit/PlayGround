package records;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void generateNewPerson_WhenRecordIsInstantiated() {
        //Given
        Person newPerson = new Person("Christian", "Zwickau", 31);
        //When
        String name = newPerson.name();
        String address = newPerson.address();
        int age = newPerson.age();
        //Then
        Assertions.assertEquals("Christian", name);
        Assertions.assertEquals("Zwickau", address);
        Assertions.assertEquals(31, age);
    }

    @Test
    void generateNewPerson_returnsStringWhenToStringMethodCalled(){
        //Given
        Person newPerson = new Person("Christian", "Zwickau", 31);
        //When
        String actual = newPerson.toString();
        //Then
        Assertions.assertEquals("Person[name=Christian, address=Zwickau, age=31]", actual);
    }

    @Test
    void generateNewPerson_checkNonNullNameField() {
        //Given
        Person firstTestPerson = new Person("Christian", null, 31);
        //When
        String actual = firstTestPerson.toString();
        //Then
        Assertions.assertEquals("Person[name=Christian, address=null, age=31]", actual);
    }

    @Test
    void generateNewPerson_checkNullField() {
        //Given
        try {
            Person newPerson = new Person(null, null, 21);
            Assertions.fail();
        } catch (Exception e) {
            Assertions.assertEquals(NullPointerException.class, e.getClass());
        }
    }

}
import java.io.Serializable;
import java.util.Objects;

public class Person {
    private String personName;
    private String personSurname;

    public Person(){}
    public Person(String name, String surname) {
        this.personName = name;
        this.personSurname = surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + personName + '\'' +
                ", lastName='" + personSurname + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return personName.equals( person.personName ) && personSurname.equals( person.personSurname );
    }

    @Override
    public int hashCode() {
        return Objects.hash( personName, personSurname );
    }

    public String getFirstName() {
        return personName;
    }

    public void setFirstName(String firstName) {
        this.personName = firstName;
    }

    public String getPersonSurname() {
        return personSurname;
    }

    public void setPersonSurname(String personSurname) {
        this.personSurname = personSurname;
    }
}
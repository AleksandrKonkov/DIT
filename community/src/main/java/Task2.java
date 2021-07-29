import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Person person = new Person();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter person's name and surname: ");
        person.setFirstName(sc.next());
        person.setPersonSurname(sc.next());
        System.out.println("Person entered: " + person.getFirstName() + " " + person.getPersonSurname());
        sc.close();
    }
}


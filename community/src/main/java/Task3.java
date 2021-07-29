import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        while (true) {
        System.out.println( "Enter the person's name and surname, if you want to finish entering, write \"print\"" );
            String personName = scanner.next();
            if (personName.equals("print"))
                break;
            String personSurname = scanner.next();
            Person person = new Person(personName, personSurname);
            personList.add(person);
        }
        for (Person person : personList);

    }
}



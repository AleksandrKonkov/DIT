import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        while (true) {
            System.out.println("Menu:");
            System.out.println("1.Add");
            System.out.println("2.Show");
            System.out.println("3.Exit");
            String point = scanner.next();
            switch (point) {
                case "1":
                    System.out.println("Enter the person's name and surname you want add to the list:");
                    String name = scanner.next();
                    String surname = scanner.next();
                    Person newPerson = new Person(name, surname);
                    personList.add(newPerson);
                    break;
                case "2":
                    for (Person person : personList)
                        System.out.println(person);
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }
}
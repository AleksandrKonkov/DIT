import java.util.*;
import java.util.stream.Collectors;

public class Task5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        while (true) {
            System.out.println("Menu:");
            System.out.println("1.Add");
            System.out.println("2.Show");
            System.out.println("3.Exit");
            System.out.println("4.Show sorted unique");
            String decision = scanner.next();
            switch (decision) {
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
                case "4":
//                    Оптимизировать с помощью с treeset - в переопределении equals выделить только сравнение фамилий
                    Map<String, Person> uniquePersonMap = new HashMap<>();
                    for (Person person : personList)
                        uniquePersonMap.put(person.getPersonSurname(), person);
                    List<Person> uniquePersonList = new ArrayList<>(uniquePersonMap.values());
                    List<Person> sortedUniquePersonList = uniquePersonList.stream()
                            .sorted( Comparator.comparing( Person::getPersonSurname ) )
                            .collect( Collectors.toList());
                    for (Person person : sortedUniquePersonList)
                        System.out.println(person);
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }
}
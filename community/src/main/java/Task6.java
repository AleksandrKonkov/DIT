import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Task6 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        while (true) {
            System.out.println("Menu:");
            System.out.println("1.Add");
            System.out.println("2.Show");
            System.out.println("3.Exit");
            System.out.println("4.Show sorted unique");
            System.out.println("5.Save to file");
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
                    System.out.println("----------");
                    for (Person person : personList)
                        System.out.println(person);
                    System.out.println("----------");
                    break;
                case "3":
                    System.exit(0);
                    break;
                case "4":
                    Map<String, Person> uniquePersonMap = new HashMap<>();
                    for (Person person : personList)
                        uniquePersonMap.put(person.getPersonSurname(), person);
                    List<Person> listOfuniquePersons = new ArrayList<>(uniquePersonMap.values());
                    List<Person> sortedUniquePersonList = listOfuniquePersons.stream()
                            .sorted(Comparator.comparing(Person::getPersonSurname))
                            .collect( Collectors.toList());
                    System.out.println("----------");
                    for (Person person : sortedUniquePersonList)
                        System.out.println(person);
                    System.out.println("----------");
                    break;
                case "5":
                    try (FileWriter fileWriter = new FileWriter("persons.txt")) {
                        fileWriter.write(String.valueOf(personList));
                        fileWriter.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }
}



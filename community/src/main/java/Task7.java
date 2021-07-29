import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Task7 {

    private interface Exec {
        void exec(List<Person> data) throws Exception;
    }

    private static class MenuItem {
        private final String name;
        private final Exec exec;

        public MenuItem(String name, Exec exec) {
            this.name = name;
            this.exec = exec;
        }

        public String getName() {
            return name;
        }

        public Exec getExec() {
            return exec;
        }
    }

    private static class Menu {
        private final List<MenuItem> items;
        private final Scanner scanner;

        public Menu(Scanner scanner) {
            this.scanner = scanner;
            items = new ArrayList<>();
            items.add(0, new MenuItem("Wrong input", data -> {
                System.out.println("----------");
                System.out.println("Wrong input");
                System.out.println("----------");
            } ));
            items.add(1, new MenuItem("Add", data -> System.out.println(data.get(data.size() - 1) + " was added.") ));
            items.add(2, new MenuItem("Show", data -> {
                System.out.println("----------");
                for (Person person : data)
                    System.out.println(person);
                System.out.println("----------");
            } ));
            items.add(3, new MenuItem("Exit", data -> System.exit(0) ));
            items.add(4, new MenuItem("Show sorted unique", data -> {
                // оптимизировать с помощью treeSet - в person при переопределении equals выделить только фамилию
                Map<String, Person> uniquePersonMap = new HashMap<>();
                for (Person person : data)
                    uniquePersonMap.put(person.getPersonSurname(), person);
                List<Person> uniquePersonList = new ArrayList<>(uniquePersonMap.values());
                List<Person> sortedUniquePersonList = uniquePersonList.stream()
                        .sorted(Comparator.comparing(Person::getPersonSurname))
                        .collect( Collectors.toList());
                System.out.println("----------");
                for (Person person : sortedUniquePersonList)
                    System.out.println(person);
                System.out.println("----------");
            } ));
            items.add(5, new MenuItem("Save to file", data -> {
                try (FileWriter fileWriter = new FileWriter("persons.txt")) {
                    fileWriter.write(String.valueOf(data));
                    fileWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } ));
        }

        public void getDecision(List<Person> personList) {
            try {
                if (!scanner.hasNextInt()) {
                    items.get(0).getExec().exec(personList);
                    return;
                }
                int decision = scanner.nextInt();
                if (decision >= items.size()) {
                    items.get(0).getExec().exec(personList);
                    return;
                }
                if (decision == 1) {
                    System.out.println("Enter the person's name and surname you want add to the list:");
                    String firstName = scanner.next();
                    String surname = scanner.next();
                    Person newPerson = new Person(firstName, surname);
                    personList.add(newPerson);
                }
                items.get(decision).getExec().exec(personList);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        while (true) {
            for (int j = 1; j < menu.items.size(); j++) {
                System.out.println(j + "." + menu.items.get(j).getName());
            }
            menu.getDecision(personList);
        }


    }
}


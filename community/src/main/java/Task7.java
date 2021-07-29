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
            items.add(0, new MenuItem("Add", data -> {
                System.out.println("Please enter first name and last name to add to the list:");
                String firstName = scanner.next();
                String lastName = scanner.next();
                Person newPerson = new Person(firstName, lastName);
                data.add(newPerson);
                System.out.println(data.get(data.size() - 1) + " was added.");

            }));
            items.add(1, new MenuItem("Show", data -> {
                System.out.println("----------");
                for (Person person : data)
                    System.out.println(person);
                System.out.println("----------");
            } ));
            items.add(2, new MenuItem("Exit", data -> System.exit(0) ));
            items.add(3, new MenuItem("Show sorted unique", data -> {
                Map<String, Person> uniquePersonMap = new HashMap<>();
                for (Person person : data)
                    uniquePersonMap.put(person.getPersonSurname(), person);
                List<Person> uniquePersonList = new ArrayList<>(uniquePersonMap.values());
                List<Person> sortedUniquePersonList = uniquePersonList.stream()
                        .sorted(Comparator.comparing(Person::getPersonSurname))
                        .collect(Collectors.toList());
                System.out.println("----------");
                for (Person person : sortedUniquePersonList)
                    System.out.println(person);
                System.out.println("----------");
            } ));
            items.add(4, new MenuItem("Save to file", data -> {
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
                String decision = scanner.next();
                int command = 0;
                try {
                    command = Integer.parseInt( decision );
                    if(command >= items.size()){
                        throw new IllegalArgumentException();
                    }
                    items.get(command).getExec().exec(personList);
                } catch (Exception e) {
                    System.out.println("Wrong input, please try again");
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        Menu menu = new Menu(new Scanner(System.in));
        while (true) {
            for (int j = 0; j < menu.items.size(); j++) {
                System.out.println(j + "." + menu.items.get(j).getName());
            }
            menu.getDecision(personList);
        }
    }
}
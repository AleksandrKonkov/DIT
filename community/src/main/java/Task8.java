import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Task8 {
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
        private final List<MenuItem> menuItemList;
        private final Scanner scanner;

        public Menu(Scanner scanner) {
            this.scanner = scanner;
            menuItemList = new ArrayList<>();
            menuItemList.add(0, new MenuItem("Wrong input", data -> {
                System.out.println("----------");
                System.out.println("Wrong input");
                System.out.println("----------");
            } ));
            menuItemList.add(1, new MenuItem("Add", data -> System.out.println(data.get(data.size() - 1) + " was added.") ));
            menuItemList.add(2, new MenuItem("Show", data -> {
                System.out.println("----------");
                for (Person person : data)
                    System.out.println(person);
                System.out.println("----------");
            } ));
            menuItemList.add(3, new MenuItem("Exit", data -> System.exit(0) ));
            menuItemList.add(4, new MenuItem("Show sorted unique", data -> {
                // оптимизировать с помощью treeSet - в person при переопределении equals выделить только фамилию
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
            menuItemList.add(5, new MenuItem("Save to file", data -> {
                try (FileWriter fileWriter = new FileWriter("persons.txt")) {
                    fileWriter.write(String.valueOf(data));
                    fileWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } ));
            menuItemList.add(6, new MenuItem("Read from file", data -> {
                try (BufferedReader br = new BufferedReader(new FileReader("persons.txt"))) {
                    String s;
                    while ((s = br.readLine()) != null) {
                        System.out.println(s);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } ));
            menuItemList.add(7, new MenuItem("Clear data in memory", data -> data.clear() ));
        }

        public void getDecision(List<Person> personList) {
            try {
                if (!scanner.hasNextInt()) {
                    menuItemList.get(0).getExec().exec(personList);
                    return;
                }
                int decision = scanner.nextInt();
                if (decision >= menuItemList.size()) {
                    menuItemList.get(0).getExec().exec(personList);
                    return;
                }
                if (decision == 1) {
                    System.out.println("Enter the person's name and surname you want add to the list:");
                    String firstName = scanner.next();
                    String lastName = scanner.next();
                    Person newPerson = new Person(firstName, lastName);
                    personList.add(newPerson);
                }
                menuItemList.get(decision).getExec().exec(personList);

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
            System.out.println("Menu:");
            for (int j = 1; j < menu.menuItemList.size(); j++) {
                System.out.println(j + "." + menu.menuItemList.get(j).getName());
            }
            menu.getDecision(personList);
        }
    }
}


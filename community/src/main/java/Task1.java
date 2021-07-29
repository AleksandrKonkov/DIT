
public class Task1 {

    public static void main(String[] args) {

        if (args.length == 2) {
           new Person(args[0],args[1]);

            System.out.println("Person's parameters passed: " + args[0] + " " + args[1]);
        } else {
            System.out.println("Wrong parameters!");
        }
    }
}
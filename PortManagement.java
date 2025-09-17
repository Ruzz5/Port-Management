package rizz;

import java.util.*;

public class PortManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Container> containerStack = new ArrayDeque<>();
        ArrayDeque<Ship> shipQueue = new ArrayDeque<>();
        int choice;

        do {
            System.out.println("\nPort Container Management System");
            System.out.println("[1] Store container");
            System.out.println("[2] View port containers");
            System.out.println("[3] Register arriving ship)");
            System.out.println("[4] View waiting ships");
            System.out.println("[5] Load next ship");
            System.out.println("[0] Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: "); String id = sc.nextLine();
                    System.out.print("Enter description: "); String desc = sc.nextLine();
                    System.out.print("Enter weight (kg): "); int w = sc.nextInt(); sc.nextLine();
                    Container c = new Container(id, desc, w);
                    containerStack.push(c);
                    System.out.println("Stored: " + c);
                }
                case 2 -> {
                    System.out.println("\nTOP →");
                    containerStack.forEach(System.out::println);
                    System.out.println("← BOTTOM");
                }
                case 3 -> {
                    System.out.print("Enter ship name: "); String name = sc.nextLine();
                    System.out.print("Enter captain: "); String cap = sc.nextLine();
                    Ship s = new Ship(name, cap);
                    shipQueue.offer(s);
                    System.out.println("Registered: " + s);
                }
                case 4 -> {
                    System.out.println("\nFRONT →");
                    shipQueue.forEach(System.out::println);
                    System.out.println("← REAR");
                }
                case 5 -> {
                    if (containerStack.isEmpty() || shipQueue.isEmpty())
                        System.out.println("No containers or ships available.");
                    else {
                        Container c = containerStack.pop();
                        Ship s = shipQueue.poll();
                        System.out.println("Loaded: " + c + " → " + s);
                        System.out.println("Remaining containers: " + containerStack.size());
                        System.out.println("Remaining ships waiting: " + shipQueue.size());
                    }
                }
            }
        } while (choice != 0);
        sc.close();
    }
}

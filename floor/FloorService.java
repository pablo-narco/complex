package floor;

import java.util.Scanner;

public class FloorService {
    private Scanner scanner = new Scanner(System.in);
    private Floor[] floors = new Floor[2];

    public void crud() {
        System.out.println("What do you want to do on the floor section?");
        System.out.println("""
                1=> Create,  2=> List,
                3=> Update,  4=> Delete
                """);
        int buyruq = scanner.nextInt();
        scanner = new Scanner(System.in);
        if (buyruq == 1) {
            create();
        } else if (buyruq == 2) {
            list();
        } else if (buyruq == 3) {
            update();
        } else if (buyruq == 4) {
            delete();
        } else {
            System.out.println("Not properly command");
            crud();
        }
    }

    //edge cases -> unique name
    private void create() {
        System.out.println("Enter floor name: ");
        String name = scanner.nextLine();
        for (int i = 0; i < floors.length; i++) {
            if (floors[i] != null && floors[i].getName().equals(name)) {
                System.out.println("A floor with this name already exists. Please enter a unique name.");
                create();
                return;
            }
        }
        Floor floor = new Floor(name);

        boolean full = true;
        for (int i = 0; i < floors.length; i++) {
            if (floors[i] == null) {
                floors[i] = floor;
                full = false;
                break;
            }
        }

        if (full) {
            Floor[] newFloors = new Floor[floors.length * 2];
            for (int i = 0; i < floors.length; i++)
                newFloors[i] = floors[i];

            newFloors[floors.length] = floor;
            floors = newFloors;
        }

    }

    private void list() {
        for (int i = 0; i < floors.length; i++) {
            Floor floor = floors[i];
            if (floor != null)
                System.out.println(i+1 + ". " + floor.getName());
        }
    }

    //edge case-> unique name
    private void update() {
        System.out.println("Choose updating floor number: ");
        list();
        int idx = scanner.nextInt();
        if (idx < 1 || idx > floors.length) {
            System.out.println("Incorrect number");
            update();
        } else {
            scanner = new Scanner(System.in);
            System.out.println("Enter new name");
            String newName = scanner.nextLine();
            for (Floor floor : floors) {
                if (floor != null && floor.getName().equals(newName)) {
                    System.out.println("A floor with this name already exists. Please enter a unique name.");
                    update();
                    return;
                }
            }
            Floor floor = floors[idx - 1];
            if (floor == null) {
                System.out.println("Enter correct number");
                update();
            } else {
                floor.setName(newName);
                System.out.println("Successfully updated");
            }

        }

    }

    private void delete() {
        System.out.println("Choose deleting floor number: ");
        list();
        int idx = scanner.nextInt();
        if (idx < 1 || idx > floors.length) {
            System.out.println("Incorrect number");
            delete();
        } else {
            for (int i = idx - 1; i < floors.length - 1; i++) {
                floors[i] = floors[i + 1];
            }
            floors[floors.length - 1] = null;
        }

    }
}

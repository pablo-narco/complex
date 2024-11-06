package entrace;

import floor.Floor;

import java.util.Scanner;

public class EntranceService {
    private Scanner entranceScan = new Scanner(System.in);

    private Entrance[] entrances = new Entrance[10];

    public void crud() {
        System.out.println("What do you want to do on the entrance section?");
        System.out.println("""
                1=> Create,  2=> List,
                3=> Update,  4=> Delete
                """);
        int buyruq = entranceScan.nextInt();
        entranceScan = new Scanner(System.in);
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

    private void create() {
        System.out.println("Enter entrance name: ");
        String name = entranceScan.nextLine();
        for (int i = 0; i < entrances.length; i++) {
            if (entrances[i] != null && entrances[i].getName().equals(name)) {
                System.out.println("An entrance with this name already exists. Please enter a unique name.");
                create();
                return;
            }
        }
        Entrance entrance = new Entrance(name);

        boolean full = true;
        for (int i = 0; i < entrances.length; i++) {
            if (entrances[i] == null) {
                entrances[i] = entrance;
                full = false;
                break;
            }
        }

        if (full) {
            Entrance[] newEnterences = new Entrance[entrances.length * 2];
            for (int i = 0; i < entrances.length; i++)
                newEnterences[i] = entrances[i];

            newEnterences[entrances.length] = entrance;
            entrances = newEnterences;
        }

    }

    private void list() {
        for (int i = 0; i < entrances.length; i++) {
            Entrance entrance = entrances[i];
            if (entrance != null)
                System.out.println(i+1 + ". " + entrance.getName());
        }
    }

    //edge case-> unique name
    private void update() {
        System.out.println("Choose updating entrance number: ");
        list();
        int idx = entranceScan.nextInt();
        if (idx < 1 || idx > entrances.length) {
            System.out.println("Incorrect number");
            update();
        } else {
            entranceScan = new Scanner(System.in);
            System.out.println("Enter new name");
            String newName = entranceScan.nextLine();
            for (Entrance entrance : entrances) {
                if (entrance != null && entrance.getName().equals(newName)) {
                    System.out.println("An entrance with this name already exists. Please enter a unique name.");
                    update();
                    return;
                }
            }
            Entrance entrance = entrances[idx - 1];
            if (entrance == null) {
                System.out.println("Enter correct number");
                update();
            } else {
                entrance.setName(newName);
                System.out.println("Successfully updated");
            }

        }

    }

    private void delete() {
        System.out.println("Choose deleting entrance number: ");
        list();
        int idx = entranceScan.nextInt();
        if (idx < 1 || idx > entrances.length) {
            System.out.println("Incorrect number");
            delete();
        } else {
            for (int i = idx - 1; i < entrances.length - 1; i++) {
                entrances[i] = entrances[i + 1];
            }
            entrances[entrances.length - 1] = null;
        }

    }

}

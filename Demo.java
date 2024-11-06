import entrace.Entrance;
import entrace.EntranceService;
import floor.Floor;
import floor.FloorService;

import java.util.Scanner;

public class Demo {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        FloorService flService = new FloorService();
        EntranceService entranceClass = new EntranceService();

        int command = -1;
        while (command != 0) {
            System.out.println("""
                    Choose one of the commands:
                    0=> Terminate, 1=> Floor CRUD
                    2=> Entrance CRUD, 3=>...
                    """);
            command = scanner.nextInt();
            switch (command) {
                case 1:
                    flService.crud();
                    break;

                case 2:
                    entranceClass.crud();
                    break;

            }
        }
    }
}

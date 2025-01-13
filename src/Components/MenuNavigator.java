package Components;

import java.util.Scanner;

import Actions.ShowFlights;
import Actions.ShowOrders;

public class MenuNavigator {
    public static void main(String[] args) {
        String[] options = {
            "Option 1: View Flight Schedule",
            "Option 2: View Orders",
            "Option 3: Exit"
        };

        runMenu(options);
    }

    public static void runMenu(String[] options) {
        Scanner scanner = new Scanner(System.in);
        int currentSelection = 0;
        boolean onMenu = true;

        while (onMenu) {
            renderMenu(options, currentSelection);

            System.out.println("\nUse W/S to navigate the menu and Enter to select the desired option.");
            String userInput = scanner.nextLine().toLowerCase();

            switch (userInput) {
                case "w":
                    currentSelection = Math.max(currentSelection - 1, 0);
                    break;
                case "s":
                    currentSelection = Math.min(currentSelection + 1, options.length - 1);
                    break;
                case "":
                    onMenu = handleSelection(currentSelection);
                    break;
                default:
                    System.out.println("Invalid input. Use W/S to navigate the menu and Enter to select the desired option.");
            }
        }
        scanner.close();
    }

    private static void renderMenu(String[] options, int currentSelection) {
        System.out.println("\n--- Main Menu ---");
        for (int i = 0; i < options.length; i++) {
            if (i == currentSelection) {
                System.out.println(">> " + options[i]);
            } else {
                System.out.println("   " + options[i]);
            }
        }
    }

    private static boolean handleSelection(int currentSelection) {
        switch (currentSelection) {
            case 0:
                // Call FlightSchedule to display the flights
                ShowFlights.printFlightInfo();
                break;
            case 1:
                ShowOrders.printOrderInfo();
                break;
            case 2:
                System.out.println("Exiting...");
                return false;
            default:
                System.out.println("Invalid selection.");
        }
        return true;
    }
}
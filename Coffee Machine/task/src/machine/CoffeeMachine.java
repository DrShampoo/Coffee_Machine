package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static final Scanner scanner = new Scanner(System.in);
    private static int cash = 550;
    private static int water = 400;
    private static int coffee = 120;
    private static int milk = 540;
    private static int cups = 9;
    private static boolean flag = true;

    public static boolean resourceToMake(int waterToMake, int milkToMake, int coffeeToMake, int cupsToMake) {
        if (water / waterToMake == 0) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (milk / milkToMake == 0) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (coffee / coffeeToMake == 0) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (cups / cupsToMake == 0) {
            System.out.println("Sorry, not enough cups!");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
    }

    public static boolean resourceToMake(int waterToMake, int coffeeToMake, int cupsToMake) {
        if (water / waterToMake == 0) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (coffee / coffeeToMake == 0) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (cups / cupsToMake == 0) {
            System.out.println("Sorry, not enough cups!");
            return false;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            return true;
        }
    }


    public static void espressoMake() {
        if (resourceToMake(250, 16, 1)) {
            water -= 250;
            coffee -= 16;
            cash += 4;
            cups -= 1;
        }
    }

    public static void latteMake() {
        if (resourceToMake(350, 75, 20, 1)) {
            water -= 350;
            milk -= 75;
            coffee -= 20;
            cash += 7;
            cups -= 1;
        }
    }

    public static void cappuccinoMake() {
        if (resourceToMake(200, 100, 12, 1)) {
            water -= 200;
            milk -= 100;
            coffee -= 12;
            cash += 6;
            cups -= 1;
        }
    }

    public static void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        switch (scanner.nextLine()) {
            case "1":
                espressoMake();
                break;
            case "2":
                latteMake();
                break;
            case "3":
                cappuccinoMake();
                break;
            case "back":
                break;
            default:
                System.out.println("Unknown position");
                break;
        }
    }

    public static void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        water += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many ml of milk do you want to add:");
        milk += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffee += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += Integer.parseInt(scanner.nextLine());
        System.out.println();
    }

    public static void takeCash() {
        System.out.println("I gave you $" + cash + "\n");
        cash = 0;
    }

    public static void stateMachine() {
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffee + " of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println(cash + " of money\n");
    }


    public static void main(String[] args) {
        while (flag) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            switch (scanner.nextLine()) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    takeCash();
                    break;
                case "remaining":
                    stateMachine();
                    break;
                case "exit":
                    flag = false;
                    break;
            }
        }
    }
}

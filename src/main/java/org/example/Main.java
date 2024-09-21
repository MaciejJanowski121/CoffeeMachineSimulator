package org.example;



import java.util.Scanner;

public class Main  {

    static int waterSupply = 400;
    static int milkSupply = 540;
    static int coffeeBeans = 120;
    static int cups = 9;
    static int money = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean onOff = false;
        while (!onOff) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();

            switch (action) {
                case "buy":
                    buyCoffee(scanner);
                    break;
                case "fill":
                    fillSupplies(scanner);
                    break;
                case "take":
                    takeMoney();
                    break;

                case "remaining":
                    printState();
                    break;
                case "exit":
                    System.out.println();
                    onOff = true;
                    break;
                default:
                    return;

            }


        }
    }

    static void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(waterSupply + " ml of water");
        System.out.println(milkSupply + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println(money + "$ of money");
        System.out.println();
    }

    static void buyCoffee(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeChoice = scanner.nextLine();

        switch (coffeeChoice) {
            case "1":
                if (waterSupply >= 250 && coffeeBeans >= 16 && cups >= 1) {
                    waterSupply -= 250;
                    coffeeBeans -= 16;
                    money += 4;
                    cups -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                } else {
                    System.out.println("Sorry, not enough resources!");
                }
                break;
            case "2":
                if (waterSupply >= 350 && milkSupply >= 75 && coffeeBeans >= 20 && cups >= 1) {
                    waterSupply -= 350;
                    milkSupply -= 75;
                    coffeeBeans -= 20;
                    money += 7;
                    cups -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                } else {
                    System.out.println("Sorry, not enough resources!");
                }
                break;
            case "3":
                if (waterSupply >= 200 && milkSupply >= 100 && coffeeBeans >= 12 && cups >= 1) {
                    waterSupply -= 200;
                    milkSupply -= 100;
                    coffeeBeans -= 12;
                    money += 6;
                    cups -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                } else {
                    System.out.println("Sorry, not enough resources!");
                }
                break;
            case "back":
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    static void fillSupplies(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add: ");
        int waterFill = scanner.nextInt();
        waterSupply += waterFill;

        System.out.println("Write how many ml of milk you want to add: ");
        int milkFill = scanner.nextInt();
        milkSupply += milkFill;

        System.out.println("Write how many grams of coffee beans you want to add:");
        int coffeeFill = scanner.nextInt();
        coffeeBeans += coffeeFill;

        System.out.println("Write how many disposable cups you want to add: ");
        int cupsFill = scanner.nextInt();
        cups += cupsFill;

        scanner.nextLine(); // consume the remaining newline
    }

    static void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }
}
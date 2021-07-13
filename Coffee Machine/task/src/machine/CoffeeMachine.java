
package machine;
import java.util.Scanner;
public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String action ;
        String buyChoice;

//        printMachineSupply();

        machineProcess: while(true){
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = scanner.nextLine();

            switch(action){
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    buyChoice = scanner.nextLine();
                    coffeeOrder(buyChoice);
                    break;

                case "fill":
                    fillMachine();
                    break;

                case "take":
                    System.out.println("I gave you $"+Supplies.money);
                    Supplies.money=0;
                    break;

                case "remaining":
                    printMachineSupply();
                    break;

                case "exit":
                    break machineProcess;
            }
        }

    }

    public static void coffeeOrder(String a){
        if(a.equals("1")){
            if((Supplies.water-250)>=0 && (Supplies.coffee-16)>=0  && (Supplies.cups-1)>=0 ){
                System.out.println("I have enough resources, making you a coffee!");
                Supplies.water-=250;
                Supplies.coffee-=16;
                Supplies.money+=4;
                Supplies.cups--;
            } else{
                String lowResource = (Supplies.water-250)<0 ? "water!": (Supplies.coffee-16)< 0 ? "coffee beans!" : "cups!";
                System.out.println("Sorry, not enough "+lowResource);
            }

        }
        else if(a.equals("2")){
            if((Supplies.water-350)>=0 && (Supplies.coffee-20)>=0  && (Supplies.milk-75)>=0 && (Supplies.cups-1)>=0 ){
                System.out.println("I have enough resources, making you a coffee!");
                Supplies.water-=350;
                Supplies.milk-=75;
                Supplies.coffee-=20;
                Supplies.money+=7;
                Supplies.cups--;
            }
            else{
                String lowResource = (Supplies.water-350)<0 ? "water!": (Supplies.coffee-20)< 0 ? "coffee beans!" : (Supplies.milk-75)< 0 ? "milk!":"cups!";
                System.out.println("Sorry, not enough "+lowResource);
            }

        }
        else if(a.equals("3")){
            if((Supplies.water-200)>=0 && (Supplies.coffee-12)>=0  && (Supplies.milk-100)>=0 && (Supplies.cups-1)>=0 ){
                Supplies.water-=200;
                Supplies.milk-=100;
                Supplies.coffee-=12;
                Supplies.money+=6;
                Supplies.cups--;
            }
            else{
                String lowResource = (Supplies.water-200)<0 ? "water!": (Supplies.coffee-12)< 0 ? "coffee beans!" : (Supplies.milk-100)< 0 ? "milk!":"cups!";
                System.out.println("Sorry, not enough "+lowResource);
            }
        }
        else;

    }

    public static void fillMachine(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        Supplies.water+= scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        Supplies.milk+= scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        Supplies.coffee+= scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        Supplies.cups+= scanner.nextInt();
    }

    public static void printMachineSupply(){
        System.out.println("The coffee machine has:\n" +
                Supplies.water+" ml of water\n" +
                Supplies.milk+" ml of milk\n" +
                Supplies.coffee+" g of coffee beans\n" +
                Supplies.cups+" disposable cups\n$" +
                Supplies.money+" of money");
    }
}
class Supplies{
    static int money = 550;
    static int water = 400;
    static int milk = 540;
    static int coffee = 120;
    static int cups = 9;

}

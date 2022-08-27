package Controller;

import java.util.Scanner;

public class CommandProcessor {
    private Manager manager;
    private Scanner scanner;
    private float amount;
    private int buyPrice;
    private int sellPrice;

    public CommandProcessor(Manager manager) {
        this.manager = manager;
        scanner = new Scanner(System.in);
    }

    public void processAddUncountableGood(String[] splitInput){
        for (Good good : manager.goods) {
            if (good.getName().equals(splitInput[3])){
                float finalAmount = good.getAmount()+ amount;
                good.setAmount(finalAmount);
                System.out.println("Uncountable good" + splitInput[3] + "added. Total inventory : " + good.getAmount() + "kg");
            } else {
                manager.addUncountableGood(splitInput[3],"unCountable",buyPrice ,sellPrice ,0, amount);
                System.out.println("Uncountable good" + splitInput[3] + "added. Total inventory : " + amount + "kg");
            }
        }

    }



    public void run(){
        String input;
        System.out.println("Enter Your command :");
        while (!(input = scanner.nextLine()).equalsIgnoreCase("exit")){
            if (input.startsWith("add uncountable good")){
                System.out.println("Enter amount :");
                amount = scanner.nextFloat();
                System.out.println("Enter sell and buy price :");
                sellPrice = scanner.nextInt();
                buyPrice = scanner.nextInt();
                processAddUncountableGood(input.split("\\s"));
            }

        }
    }

}

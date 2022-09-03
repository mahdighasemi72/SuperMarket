package Controller;

import java.util.Scanner;

public class CommandProcessor {
    private Manager manager;
    private Scanner scanner;
    private float amount;
    private int count ;
    private int buyPrice;
    private int sellPrice;

    public CommandProcessor(Manager manager) {
        this.manager = manager;
        scanner = new Scanner(System.in);
    }

    public void processAddUncountableGood(String[] splitInput){
        if(manager.goods.size()!=0){
            for (Good good : manager.goods) {
                if (good.getName().equals(splitInput[3])){
                    float finalAmount = good.getAmount()+ amount;
                    good.setAmount(finalAmount);
                    System.out.println("Uncountable good " + splitInput[3] + " added. Total inventory : " + good.getAmount() + "kg");
                } else {
                    manager.addUncountableGood(splitInput[3],"unCountable",buyPrice ,sellPrice ,0, amount);
                    System.out.println("Uncountable good " + splitInput[3] + " added. Total inventory : " + amount + "kg");
                    break;
                }
            }
        } else {
            manager.addUncountableGood(splitInput[3],"unCountable",buyPrice ,sellPrice ,0, amount);
            System.out.println("Uncountable good " + splitInput[3] + " added. Total inventory : " + amount + "kg");
        }
    }


    public void processAddCountableGood(String[] splitInput){


        if (manager.goods.size()!= 0) {
            for (Good good : manager.goods) {

                if (good.getName().equals(splitInput[3])) {

                    int finalCount = good.getCount() + count;
                    good.setBuyPrice(buyPrice);
                    good.setSellPrice(sellPrice);
                    good.setCount(finalCount);
                    System.out.println("countable good" + splitInput[3] + "added. Total inventory : " + good.getCount() + "kg");
                } else {
                    manager.addCountableGood(splitInput[3], "Countable", buyPrice, sellPrice, count, 0);
                    System.out.println("Countable good" + splitInput[3] + "added. Total inventory : " + count + "kg");
                    break;
                }
            }
        }else {
            manager.addCountableGood(splitInput[3], "Countable", buyPrice, sellPrice, count, 0);
            System.out.println("countable good" + splitInput[3] + "added. Total inventory : " + count + "kg");
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
            }else if (input.startsWith("add countable good")){
                System.out.println("Enter count :");
                count = scanner.nextInt();
                System.out.println("Enter sell and buy price :");
                sellPrice = scanner.nextInt();
                buyPrice = scanner.nextInt();
                processAddCountableGood(input.split("\\s"));
            } else if (input.startsWith("new order from")) {

            } else  {
                System.err.println("Please Enter Correctly");
            }


        }
    }

}

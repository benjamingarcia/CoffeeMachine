package org.coffeemachine;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: benji
 * Date: 03/12/12
 * Time: 07:04
 */
public class CoffeeMachine {

    private static Map<DrinkType, Integer> price = new HashMap<DrinkType, Integer>(0);
    private static Map<DrinkType, Integer> receipts = new HashMap<DrinkType, Integer>(0);



    static {
        price.put(DrinkType.T, 40);
        price.put(DrinkType.H, 50);
        price.put(DrinkType.C, 60);
        price.put(DrinkType.O, 60);

        resetReceipts();
    }

    public static void resetReceipts() {
        receipts.put(DrinkType.T, 0);
        receipts.put(DrinkType.H, 0);
        receipts.put(DrinkType.C, 0);
        receipts.put(DrinkType.O, 0);
    }


    /**
     *
     * @param order an coffee machine order
     * @return order translate for machine
     */
    public static String TransformOrder(Order order) {

        int diff = price.get(order.getDrink())-order.getMoney();
        if(diff<=0){
            int current = receipts.get(order.getDrink());
            receipts.put(order.getDrink(), current+1);
            return order.getDrink()+getHotValue(order.isExtraHot(), order.getDrink())
                    +":"+getSugarValue(order.getSugar())+":"+getStickValue(order.isStick());
        }else{
            return "M:Miss "+diff+" cents.";

        }
    }

    /**
     *
     * @param sugar sugar quantity
     * @return String for sugar
     */
    private static String getSugarValue(int sugar){
       if(sugar==0){
           return "";
       }else{
           return ""+sugar;
       }
    }

    private static String getStickValue(boolean stick){
        if(stick){
            return "0";
        }else{
            return "";
        }
    }

    private static String getHotValue(boolean extraHot, DrinkType type){
        if(extraHot && !type.equals(DrinkType.O)){
            return "h";
        }else{
            return "";
        }
    }

    public static String giveReport() {
        int coffeCount = receipts.get(DrinkType.C);
        int chocolateCount = receipts.get(DrinkType.H);
        int teaCount = receipts.get(DrinkType.T);
        int orangeJuiceCount = receipts.get(DrinkType.O);
        return "coffee : "+coffeCount+", chocolate : "+chocolateCount+", tea : "+teaCount+", orange juice : "+orangeJuiceCount+". \n" +
                " total : "+giveSum()+".";
    }

    private static int giveSum() {
        int total = 0;
        for (DrinkType drinkType : price.keySet()) {
            int drinkPrice = price.get(drinkType);
            int drinkReceipt = receipts.get(drinkType);
            total = total + drinkPrice*drinkReceipt;

        }
        return total;
    }
}

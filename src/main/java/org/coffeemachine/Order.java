package org.coffeemachine;

/**
 * Created with IntelliJ IDEA.
 * User: benji
 * Date: 03/12/12
 * Time: 06:57
 */
public class Order {

    private DrinkType drink;

    private int sugar;

    private boolean stick;

    private int money;

    private boolean extraHot;

    public Order(DrinkType drink, int sugar, boolean stick, int money, boolean extraHot) {
        this.drink = drink;
        this.sugar = sugar;
        this.stick = stick;
        this.money = money;
        this.extraHot = extraHot;
    }

    public DrinkType getDrink() {
        return drink;
    }

    public int getSugar() {
        return sugar;
    }

    public boolean isStick() {
        return stick;
    }

    public int getMoney() {
        return money;
    }

    public boolean isExtraHot() {
        return extraHot;
    }

}

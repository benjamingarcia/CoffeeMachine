package org.coffeemachine;


import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: benji
 * Date: 03/12/12
 * Time: 06:52
 */
public class CoffeeMachineTest{

    @Test
    public void should_have_chocolate_without_sugar(){
        Order order = new Order(DrinkType.H, 0, false, 50, false);
        Assert.assertEquals("H::", CoffeeMachine.TransformOrder(order));
    }

    @Test
    public void should_have_tea_with_one_sugar(){
        Order order = new Order(DrinkType.T, 1, true, 40, false);
        Assert.assertEquals("T:1:0", CoffeeMachine.TransformOrder(order));
    }

    @Test
    public void should_have_coffee_with_two_sugar(){
        Order order = new Order(DrinkType.C, 2, true, 60, false);
        Assert.assertEquals("C:2:0", CoffeeMachine.TransformOrder(order));
    }

    @Test
    public void should_have_orange_juice(){
        Order order = new Order(DrinkType.O, 0, false, 60, false);
        Assert.assertEquals("O::", CoffeeMachine.TransformOrder(order));
    }

    @Test
    public void should_have_chocolate_without_sugar_without_good_price(){
        Order order = new Order(DrinkType.H, 0, false, 40, false);
        Assert.assertEquals("M:Miss 10 cents.", CoffeeMachine.TransformOrder(order));
    }

    @Test
    public void should_have_tea_with_one_sugar_without_good_price(){
        Order order = new Order(DrinkType.T, 1, true, 20, false);
        Assert.assertEquals("M:Miss 20 cents.", CoffeeMachine.TransformOrder(order));
    }

    @Test
    public void should_have_coffee_with_two_sugar_without_good_price(){
        Order order = new Order(DrinkType.C, 2, true, 30, false);
        Assert.assertEquals("M:Miss 30 cents.", CoffeeMachine.TransformOrder(order));
    }

    @Test
    public void should_have_orange_juice_without_good_price(){
        Order order = new Order(DrinkType.O, 0, false, 10, false);
        Assert.assertEquals("M:Miss 50 cents.", CoffeeMachine.TransformOrder(order));
    }

    @Test
    public void should_have_chocolate_without_sugar_hot(){
        Order order = new Order(DrinkType.H, 0, false, 50, true);
        Assert.assertEquals("Hh::", CoffeeMachine.TransformOrder(order));
    }

    @Test
    public void should_have_tea_with_one_sugar_hot(){
        Order order = new Order(DrinkType.T, 1, true, 40, true);
        Assert.assertEquals("Th:1:0", CoffeeMachine.TransformOrder(order));
    }

    @Test
    public void should_have_coffee_with_two_sugar_hot(){
        Order order = new Order(DrinkType.C, 2, true, 60, true);
        Assert.assertEquals("Ch:2:0", CoffeeMachine.TransformOrder(order));
    }

    @Test
    public void should_have_orange_juice_hot(){
        Order order = new Order(DrinkType.O, 0, false, 60, true);
        Assert.assertNotSame("Oh::", CoffeeMachine.TransformOrder(order));
    }

    @Test
    public void should_have_chocolate_without_sugar_without_good_price_hot(){
        Order order = new Order(DrinkType.H, 0, false, 40, true);
        Assert.assertEquals("M:Miss 10 cents.", CoffeeMachine.TransformOrder(order));
    }

    @Test
    public void should_have_tea_with_one_sugar_without_good_price_hot(){
        Order order = new Order(DrinkType.T, 1, true, 20, true);
        Assert.assertEquals("M:Miss 20 cents.", CoffeeMachine.TransformOrder(order));
    }

    @Test
    public void should_have_coffee_with_two_sugar_without_good_price_hot(){
        Order order = new Order(DrinkType.C, 2, true, 30, true);
        Assert.assertEquals("M:Miss 30 cents.", CoffeeMachine.TransformOrder(order));
    }


    @Test
    public void should_have_report(){
        CoffeeMachine.resetReceipts();
        Order order01 = new Order(DrinkType.H, 0, false, 50, false);
        CoffeeMachine.TransformOrder(order01);
        Order order02 = new Order(DrinkType.T, 1, true, 40, false);
        CoffeeMachine.TransformOrder(order02);
        Order order03 = new Order(DrinkType.C, 2, true, 60, false);
        CoffeeMachine.TransformOrder(order03);
        Order order04 = new Order(DrinkType.O, 0, false, 60, false);
        CoffeeMachine.TransformOrder(order04);
        Order order05 = new Order(DrinkType.H, 0, false, 40, false);
        CoffeeMachine.TransformOrder(order05);
        Order order06 = new Order(DrinkType.T, 1, true, 20, false);
        CoffeeMachine.TransformOrder(order06);
        Order order07 = new Order(DrinkType.H, 0, false, 50, true);
        CoffeeMachine.TransformOrder(order07);
        Order order08 = new Order(DrinkType.T, 1, true, 40, true);
        CoffeeMachine.TransformOrder(order08);
        Order order09 = new Order(DrinkType.C, 2, true, 60, true);
        CoffeeMachine.TransformOrder(order09);
        Order order10 = new Order(DrinkType.O, 0, false, 60, true);
        CoffeeMachine.TransformOrder(order10);
        Order order11 = new Order(DrinkType.H, 0, false, 40, true);
        CoffeeMachine.TransformOrder(order11);
        Order order12 = new Order(DrinkType.T, 1, true, 20, true);
        CoffeeMachine.TransformOrder(order12);
        Order order13 = new Order(DrinkType.C, 2, true, 30, false);
        CoffeeMachine.TransformOrder(order13);
        Order order14 = new Order(DrinkType.C, 2, true, 30, true);
        CoffeeMachine.TransformOrder(order14);
        Order order15 = new Order(DrinkType.O, 0, false, 10, true);
        CoffeeMachine.TransformOrder(order15);


        Assert.assertEquals("coffee : 2, chocolate : 2, tea : 2, orange juice : 2. \n total : 420.", CoffeeMachine.giveReport());
    }
}

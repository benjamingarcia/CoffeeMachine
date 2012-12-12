package org.coffeemachine;


import junit.framework.Assert;
import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * User: benji
 * Date: 03/12/12
 * Time: 06:52
 */
public class CoffeeMachineTest{

    private static EmailNotifier emailNotifier;
    private static BeverageQuantityChecker checker;

    @Test
    public void should_have_chocolate_without_sugar(){
        Order order = new Order(DrinkType.H, 0, false, 50, false);
        Assert.assertEquals("H::", CoffeeMachine.TransformOrder(order, checker, emailNotifier));
    }

    @Test
    public void should_have_tea_with_one_sugar(){
        Order order = new Order(DrinkType.T, 1, true, 40, false);
        Assert.assertEquals("T:1:0", CoffeeMachine.TransformOrder(order, checker, emailNotifier));
    }

    @Test
    public void should_have_coffee_with_two_sugar(){
        Order order = new Order(DrinkType.C, 2, true, 60, false);
        Assert.assertEquals("C:2:0", CoffeeMachine.TransformOrder(order, checker, emailNotifier));
    }

    @Test
    public void should_have_orange_juice(){
        Order order = new Order(DrinkType.O, 0, false, 60, false);
        Assert.assertEquals("O::", CoffeeMachine.TransformOrder(order, checker, emailNotifier));
    }

    @Test
    public void should_have_chocolate_without_sugar_without_good_price(){
        Order order = new Order(DrinkType.H, 0, false, 40, false);
        Assert.assertEquals("M:Miss 10 cents.", CoffeeMachine.TransformOrder(order, checker, emailNotifier));
    }

    @Test
    public void should_have_tea_with_one_sugar_without_good_price(){
        Order order = new Order(DrinkType.T, 1, true, 20, false);
        Assert.assertEquals("M:Miss 20 cents.", CoffeeMachine.TransformOrder(order, checker, emailNotifier));
    }

    @Test
    public void should_have_coffee_with_two_sugar_without_good_price(){
        Order order = new Order(DrinkType.C, 2, true, 30, false);
        Assert.assertEquals("M:Miss 30 cents.", CoffeeMachine.TransformOrder(order, checker, emailNotifier));
    }

    @Test
    public void should_have_orange_juice_without_good_price(){
        Order order = new Order(DrinkType.O, 0, false, 10, false);
        Assert.assertEquals("M:Miss 50 cents.", CoffeeMachine.TransformOrder(order, checker, emailNotifier));
    }

    @Test
    public void should_have_chocolate_without_sugar_hot(){
        Order order = new Order(DrinkType.H, 0, false, 50, true);
        Assert.assertEquals("Hh::", CoffeeMachine.TransformOrder(order, checker, emailNotifier));
    }

    @Test
    public void should_have_tea_with_one_sugar_hot(){
        Order order = new Order(DrinkType.T, 1, true, 40, true);
        Assert.assertEquals("Th:1:0", CoffeeMachine.TransformOrder(order, checker, emailNotifier));
    }

    @Test
    public void should_have_coffee_with_two_sugar_hot(){
        Order order = new Order(DrinkType.C, 2, true, 60, true);
        Assert.assertEquals("Ch:2:0", CoffeeMachine.TransformOrder(order, checker, emailNotifier));
    }

    @Test
    public void should_have_orange_juice_hot(){
        Order order = new Order(DrinkType.O, 0, false, 60, true);
        Assert.assertNotSame("Oh::", CoffeeMachine.TransformOrder(order, checker, emailNotifier));
    }

    @Test
    public void should_have_chocolate_without_sugar_without_good_price_hot(){
        Order order = new Order(DrinkType.H, 0, false, 40, true);
        Assert.assertEquals("M:Miss 10 cents.", CoffeeMachine.TransformOrder(order, checker, emailNotifier));
    }

    @Test
    public void should_have_tea_with_one_sugar_without_good_price_hot(){
        Order order = new Order(DrinkType.T, 1, true, 20, true);
        Assert.assertEquals("M:Miss 20 cents.", CoffeeMachine.TransformOrder(order, checker, emailNotifier));
    }

    @Test
    public void should_have_coffee_with_two_sugar_without_good_price_hot(){
        Order order = new Order(DrinkType.C, 2, true, 30, true);
        Assert.assertEquals("M:Miss 30 cents.", CoffeeMachine.TransformOrder(order, checker, emailNotifier));
    }


    @Test
    public void should_have_report(){
        CoffeeMachine.resetReceipts();
        Order order01 = new Order(DrinkType.H, 0, false, 50, false);
        CoffeeMachine.TransformOrder(order01, checker, emailNotifier);
        Order order02 = new Order(DrinkType.T, 1, true, 40, false);
        CoffeeMachine.TransformOrder(order02, checker, emailNotifier);
        Order order03 = new Order(DrinkType.C, 2, true, 60, false);
        CoffeeMachine.TransformOrder(order03, checker, emailNotifier);
        Order order04 = new Order(DrinkType.O, 0, false, 60, false);
        CoffeeMachine.TransformOrder(order04, checker, emailNotifier);
        Order order05 = new Order(DrinkType.H, 0, false, 40, false);
        CoffeeMachine.TransformOrder(order05, checker, emailNotifier);
        Order order06 = new Order(DrinkType.T, 1, true, 20, false);
        CoffeeMachine.TransformOrder(order06, checker, emailNotifier);
        Order order07 = new Order(DrinkType.H, 0, false, 50, true);
        CoffeeMachine.TransformOrder(order07, checker, emailNotifier);
        Order order08 = new Order(DrinkType.T, 1, true, 40, true);
        CoffeeMachine.TransformOrder(order08, checker, emailNotifier);
        Order order09 = new Order(DrinkType.C, 2, true, 60, true);
        CoffeeMachine.TransformOrder(order09, checker, emailNotifier);
        Order order10 = new Order(DrinkType.O, 0, false, 60, true);
        CoffeeMachine.TransformOrder(order10, checker, emailNotifier);
        Order order11 = new Order(DrinkType.H, 0, false, 40, true);
        CoffeeMachine.TransformOrder(order11, checker, emailNotifier);
        Order order12 = new Order(DrinkType.T, 1, true, 20, true);
        CoffeeMachine.TransformOrder(order12, checker, emailNotifier);
        Order order13 = new Order(DrinkType.C, 2, true, 30, false);
        CoffeeMachine.TransformOrder(order13, checker, emailNotifier);
        Order order14 = new Order(DrinkType.C, 2, true, 30, true);
        CoffeeMachine.TransformOrder(order14, checker, emailNotifier);
        Order order15 = new Order(DrinkType.O, 0, false, 10, true);
        CoffeeMachine.TransformOrder(order15, checker, emailNotifier);


        Assert.assertEquals("coffee : 2, chocolate : 2, tea : 2, orange juice : 2. \n total : 420.", CoffeeMachine.giveReport());
    }

    @Test
    public void should_have_no_more_chocolate(){
        Order order = new Order(DrinkType.H, 0, false, 50, false);
        BeverageQuantityChecker checkerFalse = new BeverageQuantityCheckerMockFalse();
        Assert.assertEquals("M:No more liquid", CoffeeMachine.TransformOrder(order, checkerFalse, emailNotifier));
    }

    @Test
    public void should_have_no_more_tea(){
        Order order = new Order(DrinkType.T, 1, true, 40, false);
        BeverageQuantityChecker checkerFalse = new BeverageQuantityCheckerMockFalse();
        Assert.assertEquals("M:No more liquid", CoffeeMachine.TransformOrder(order, checkerFalse, emailNotifier));
    }

    @Test
    public void should_have_no_more_coffee(){
        Order order = new Order(DrinkType.C, 2, true, 60, false);
        BeverageQuantityChecker checkerFalse = new BeverageQuantityCheckerMockFalse();
        Assert.assertEquals("M:No more liquid", CoffeeMachine.TransformOrder(order, checkerFalse, emailNotifier));
    }

    @Test
    public void should_have_no_more_orange_juice(){
        Order order = new Order(DrinkType.O, 0, false, 60, false);
        BeverageQuantityChecker checkerFalse = new BeverageQuantityCheckerMockFalse();
        Assert.assertEquals("M:No more liquid", CoffeeMachine.TransformOrder(order, checkerFalse, emailNotifier));
    }

    @BeforeClass
    public static void initialize(){
        BasicConfigurator.configure();
        emailNotifier = new EmailNotifierMock();
        checker = new BeverageQuantityCheckerMockTrue();
    }
}

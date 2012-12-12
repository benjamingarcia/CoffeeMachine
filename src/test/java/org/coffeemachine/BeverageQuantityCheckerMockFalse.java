package org.coffeemachine;

/**
 * User: benji
 * Date: 07/12/12
 * Time: 19:51
 */
public class BeverageQuantityCheckerMockFalse implements BeverageQuantityChecker{

    @Override
    public boolean isEmpty(String drink) {
        return false;
    }
}

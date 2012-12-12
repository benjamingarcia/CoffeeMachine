package org.coffeemachine;

/**
 * User: benji
 * Date: 07/12/12
 * Time: 19:51
 */
public class BeverageQuantityCheckerMockTrue implements BeverageQuantityChecker{

    @Override
    public boolean isEmpty(String drink) {
        return true;
    }
}

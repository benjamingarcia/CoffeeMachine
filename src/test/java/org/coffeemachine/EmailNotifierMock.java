package org.coffeemachine;

import org.apache.log4j.Logger;

/**
 * User: benji
 * Date: 07/12/12
 * Time: 19:50
 */
public class EmailNotifierMock implements EmailNotifier{

    private static final Logger log = Logger.getLogger(EmailNotifierMock.class);

    @Override
    public void notifyMissingDrink(String drink) {
        DrinkType type = DrinkType.valueOf(drink);
        switch (type){
            case C:
                log.info("no more water");
                break;
            case H:
                log.info("no more milk");
                break;
            case O:
                log.info("no more orange juice");
                break;
            case T:
                log.info("no more water");
                break;
            default:
                break;
        }
    }
}

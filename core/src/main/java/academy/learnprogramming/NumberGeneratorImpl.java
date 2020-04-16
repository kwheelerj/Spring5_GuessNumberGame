package academy.learnprogramming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

//@Component("generator")
@Component
public class NumberGeneratorImpl implements NumberGenerator {

    private final Random random = new Random();
//    private int maxNumber = 100;
//    @Autowired
//    @MaxNumber
    private final int maxNumber;
//    @Autowired
//    @MinNumber
    private final int minNumber;
    /* Instead of using @Autowired on fields, it is better to use a constructor
     *  and add the @Autowired annotation on the constructor itself.
     */
    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }
}

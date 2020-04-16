package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class GameImpl implements Game {

    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    @Autowired
    private NumberGenerator numberGeneratorField;   // A dependency for GameIpl bean
//    private int guessCount = 10;
    @Autowired
    @GuessCount
    private int guessCount;
    private int number;
    private int guess;
    private int smallest;
    private int largest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    // for "constructor-based dependency injection"
//    public GameImpl(NumberGenerator numberGenerator) {
//        this.numberGeneratorField = numberGenerator;
//    }
    // for "setter-based dependency injection"
//    public void setNumberGeneratorField(NumberGenerator numberGenerator) {
//        this.numberGeneratorField = numberGenerator;
//    }
    // Explicit Autowiring is not needed with Autowiring

    @PostConstruct
    @Override
    public void reset() {
        log.info("in GameImpl reset()");
        smallest = numberGeneratorField.getMinNumber();
        guess = 0;
        remainingGuesses = guessCount;
        largest = numberGeneratorField.getMaxNumber();
        number = numberGeneratorField.next();
        log.debug("number is {}", number);
    }

    @PreDestroy
    public void preDestroy() {
        log.info("in GameImpl preDestroy()");
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getLargest() {
        return largest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    @Override
    public int getGuessCount() {
        return guessCount;
    }

    @Override
    public void check() {
        checkValidNumberRange();
        if (validNumberRange) {
            if (guess > number) {
                largest = guess - 1;
            }
            if (guess < number) {
                smallest = guess + 1;
            }
            remainingGuesses--;
        }
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    // private methods
    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= largest);
    }
}

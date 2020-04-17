package academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    private final Game gameField;

    @Autowired
    public MessageGeneratorImpl(Game gameField) {
        this.gameField = gameField;
    }

    @PostConstruct
    public void init() {
        log.info("game = {}", gameField);
    }

    @PreDestroy
    public void preDestroy() {
        log.info("in MessageGeneratorImpl preDestroy()");
    }

    @Override
    public String getMainMessage() {
        return "Number is between " + gameField.getSmallest() +
                " and " + gameField.getLargest() +
                ".  Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if (gameField.isGameWon())
            return "You guessed it!  The number was " + gameField.getNumber();
        else if (gameField.isGameLost())
            return "You lost.  The number was " + gameField.getNumber();
        else if (!gameField.isValidNumberRange())
            return "Invalid number range!";
        else if (gameField.getRemainingGuesses() == gameField.getGuessCount())
            return "What is your first guess?";
        else {
            String direction = "Lower";
            if (gameField.getGuess() < gameField.getNumber())
                direction = "Higher";
            return direction + "!  You have " +
                        gameField.getRemainingGuesses() + " guesses left.";
        }
    }
}

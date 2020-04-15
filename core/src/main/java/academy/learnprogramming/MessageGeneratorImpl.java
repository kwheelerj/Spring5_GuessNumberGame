package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MessageGeneratorImpl implements MessageGenerator {

    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game gameField;
    private int guessCount = 10;

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
        return "getMainMessage() called";
    }

    @Override
    public String getResultMessage() {
        return "getResultMessage() called";
    }
}

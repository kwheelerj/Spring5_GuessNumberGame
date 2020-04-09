package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";


    public static void main(String[] args) {
        log.info("Guess the number game");

        // create context (container) first
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        // get the number generator bean from the context (container)
        log.debug("before creating numberGenerator");
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        // call method to get a random number
        int number = numberGenerator.next();

        log.info("number = {}", number);

        // get the game bean from the context (container)
        Game game = context.getBean(Game.class);

        // call reset method
        game.reset();

        // close context (container); prevent memory resource leaks
        context.close();
    }
}

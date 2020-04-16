package academy.learnprogramming.console;

import academy.learnprogramming.MessageGenerator;
import academy.learnprogramming.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
//    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the number game");

        // create context (container) first
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
//                new ClassPathXmlApplicationContext(CONFIG_LOCATION);

//        // get the number generator bean from the context (container)
//        log.debug("before creating numberGenerator");
//        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
//
//        // call method to get a random number
//        int number = numberGenerator.next();
//
//        log.info("number = {}", number);

        // get MessageGenerator bean from context
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("getMainMessage = {}", messageGenerator.getMainMessage());
        log.info("getResultMessage = {}", messageGenerator.getResultMessage());

        // close context (container); prevent memory resource leaks
        context.close();
    }
}

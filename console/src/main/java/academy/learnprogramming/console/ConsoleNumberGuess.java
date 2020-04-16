package academy.learnprogramming.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
//public class ConsoleNumberGuess implements ApplicationListener<ContextRefreshedEvent> {
public class ConsoleNumberGuess {
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    // ContextRefreshedEvent is published when the ApplicationContext is init or refreshed.
    @EventListener
    public void start(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("start -> Container ready for use.");
    }
}

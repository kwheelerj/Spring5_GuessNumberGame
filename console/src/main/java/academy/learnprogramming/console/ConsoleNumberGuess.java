package academy.learnprogramming.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ConsoleNumberGuess implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // ContextRefreshedEvent is published when the ApplicationContext is init or refreshed.
        log.info("Container ready for use.");
    }
}

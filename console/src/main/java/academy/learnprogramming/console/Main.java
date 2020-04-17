package academy.learnprogramming.console;

import academy.learnprogramming.config.GameConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("app started");
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(GameConfig.class);

        context.close();
    }
}

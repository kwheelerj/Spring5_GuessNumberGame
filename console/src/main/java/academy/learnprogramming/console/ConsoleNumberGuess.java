package academy.learnprogramming.console;

import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
//public class ConsoleNumberGuess implements ApplicationListener<ContextRefreshedEvent> {
public class ConsoleNumberGuess {
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    @Autowired
    private Game game;
    @Autowired
    private MessageGenerator messageGenerator;


//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    // ContextRefreshedEvent is published when the ApplicationContext is init or refreshed.
    @EventListener
    public void start(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("start -> Container ready for use.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();     // handle "Enter" key
            game.setGuess(guess);
            game.check();

            if (game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/N?");

                String playAgainString = scanner.nextLine().trim();
                if ( ! playAgainString.equalsIgnoreCase("y"))
                    break;
                game.reset();
            }
        }
    }
}

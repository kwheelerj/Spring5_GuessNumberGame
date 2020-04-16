package academy.learnprogramming.config;

import academy.learnprogramming.GuessCount;
import academy.learnprogramming.MaxNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {
//        private int maxNumber = 100;
//        private int guessCount = 10;
    @Value("${game.maxNumber}")
    private int maxNumber;
    @Value("${game.guessCount}")
    private int guessCount;

        @Bean
        @MaxNumber
        public int getMaxNumber() {
            return maxNumber;
        }

        @Bean
        @GuessCount
        public int getGuessCount() {
            return guessCount;
        }
}

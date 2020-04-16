package academy.learnprogramming.config;

import academy.learnprogramming.GuessCount;
import academy.learnprogramming.MaxNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

        private int maxNumber = 100;
        private int guessCount = 10;

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

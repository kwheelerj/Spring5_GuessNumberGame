package academy.learnprogramming.config;

import academy.learnprogramming.GuessCount;
import academy.learnprogramming.MaxNumber;
import academy.learnprogramming.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {
//        private int maxNumber = 100;
//        private int guessCount = 10;
    @Value("${game.maxNumber:50}")
    private int maxNumber;
    @Value("${game.guessCount:8}")
    private int guessCount;
    @Value("${game.minNumber:1}")
    private int minNumber;

    @Bean
    @MaxNumber
    public int getMaxNumber() {
        return maxNumber;
    }

    @Bean
    @MinNumber
    public int getMinNumber() {
        return minNumber;
    }

    @Bean
    @GuessCount
    public int getGuessCount() {
        return guessCount;
    }
}

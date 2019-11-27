package academy.learnprogramming.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration

@ComponentScan(basePackages = "academy.learnprogramming")

@PropertySource("classpath:config/game.properties")
public class GameConfig {
    // == fields ==
    @Value("${game.maxNumber:500}")
    private int maxNumber2 ;

    @Value("${game.guessCount}")
    private int guessCount ;

    @Value("${game.minNumber:99}")
    private int minNumber ;

    // == bean methods ==
    @Bean
    public int maxNumber(){
        return maxNumber2;
    }

    @Bean
    public int guessCount(){
        return guessCount;
    }

    @Bean
    public int minNumber(){
        return minNumber;
    }
}

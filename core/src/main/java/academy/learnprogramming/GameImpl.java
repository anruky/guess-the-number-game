package academy.learnprogramming;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Getter
@Component
public class GameImpl implements Game {

    // == constants ==
//    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    // == fields ==
    @Getter(AccessLevel.NONE)
    private final NumberGenerator numberGenerator;

    private final int guessCount;

    private int number;  // the target of the guess
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @Setter
    private int guess;   // the number user guessed

    //== constructor ==/
    //@Autowired
    public GameImpl(NumberGenerator numberGenerator, int guessCount) {
        log.info("in  GameImpl- constructor");
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    // == init ==
    @PostConstruct
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        biggest = numberGenerator.getMaxNumber();
        guess = numberGenerator.getMinNumber();
        remainingGuesses = guessCount;
        number = numberGenerator.next();
        log.info("in GameImpl - reset(): the number is {}",number);
    }

    @PreDestroy
    public void preDestroy() {
        log.info("in gameImpl -- preDestroy()");
    }
//    // == constructors based dependency injection ==
//    public GameImpl(NumberGenerator numberGenerator) {
//        this.numberGenerator = numberGenerator;
//    }

    // == public methods ==

    @Override
    public void check() {
        checkValidNumberRange();

        if(validNumberRange){
            if(guess> number) {
                biggest = guess -1;
            }

            if(guess<number){
                smallest = guess +1;
            }
        }

        remainingGuesses--;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <=0;
    }

    // == private methods ==
    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}

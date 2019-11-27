package academy.learnprogramming;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator{

    // == fields ==//
    private final Game game;

    // ==constructor ==
    public MessageGeneratorImpl(Game game) {
        log.info("in MessageGeneratorImpl - constructor");
        this.game = game;
    }

    // == init ==
    @PostConstruct
    public void init() {
        log.info("in messageGenerator Init, guess count= {}",game.getRemainingGuesses());
        log.info("in messageGenerator Init, game= {}",game);
    }

    @PreDestroy
    public void preDestroy() {
        log.info("in MessageGenerator preDestroy");
    }

    // == public methods ==
    @Override
    public String getMainMessage() {
        return "Number is between " +
                game.getSmallest() +
                " and " +
                game.getBiggest() +
                ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {

        if(game.isGameWon()) {
            return "You guessed it! The number was " + game.getNumber();
        } else if(game.isGameLost()) {
            return "You lost. The number was " + game.getNumber();
        } else if(!game.isValidNumberRange()) {
            return "Invalid number range!";
        } else if(game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is your first guess?";
        } else {
            String direction = "The number is Lower";

            if(game.getGuess() < game.getNumber()) {
                direction = "The number is Higher";
            }

            return direction + "! You have " + game.getRemainingGuesses() + " guess left";
        }
    }
}

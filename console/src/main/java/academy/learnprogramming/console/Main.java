package academy.learnprogramming.console;


import academy.learnprogramming.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

//    private static final Logger log= LoggerFactory.getLogger(Main.class);

//    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("in Main - Guess The Number Game start");

        // create context (container)
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);

//        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
//
//        //call method to get a random number
//        int number = numberGenerator.next();
//
//        log.info("in main, number = {}", number);
//
//        // get game bean from context
//        Game game = context.getBean(Game.class);
//
//        log.info("in main, game = {}", game);
//
////        //call reset method
////        game.reset();
//
//        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
//        log.info("in main, getMainMessage = {}", messageGenerator.getMainMessage());
//        log.info("in main, getResultMessage = {}", messageGenerator.getResultMessage());

        //close container
        context.close();
    }
}

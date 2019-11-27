package academy.learnprogramming;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Getter
@Component
public class NumberGeneratorImpl implements NumberGenerator {

    // == fields ==//
    @Getter(AccessLevel.NONE)
    private final Random random = new Random();

    private final int maxNumber;

    private final int minNumber;

    // == constructor == //

    //@Autowired
    public NumberGeneratorImpl(int maxNumber, int minNumber) {
        log.info("in  NumberGeneratorImpl- constructor");
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }


    // == public methods ==//

    @Override
    public int next() {
        log.info("in  NumberGeneratorImpl- next()");
        return random.nextInt(maxNumber - minNumber) + minNumber;

    }

}

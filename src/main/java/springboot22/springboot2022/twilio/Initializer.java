package springboot22.springboot2022.twilio;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Initializer {

    private TwilioConfig twilioConfig;

    private final Logger LOGGER = LoggerFactory.getLogger(Initializer.class);

    @Autowired
    public void initTwilio(TwilioConfig twilioConfig){
        this.twilioConfig = twilioConfig;

        Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
        LOGGER.info("Twilio is initialized with {} ...", twilioConfig.getAccountSid());
    }
}

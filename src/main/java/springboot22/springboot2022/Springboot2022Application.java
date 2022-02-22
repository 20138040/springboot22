package springboot22.springboot2022;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springboot22.springboot2022.twilio.TwilioConfig;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableScheduling
public class Springboot2022Application {

//	@Autowired
//	private TwilioConfig twilioConfig;

	public static void main(String[] args) {
		SpringApplication.run(Springboot2022Application.class, args);
	}

//	@PostConstruct
//	public void initTwilio(){
//		Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
//	}
}

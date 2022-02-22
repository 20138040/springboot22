package springboot22.springboot2022.twilio;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot22.springboot2022.entity.OTP;
import springboot22.springboot2022.entity.OtpResponse;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class SmsSenderService implements SmsSender{

    @Autowired
    private TwilioConfig twilioConfig;

    private final Logger LOGGER = LoggerFactory.getLogger(SmsSenderService.class);
    private Map<String, OtpResponse> optmap = new HashMap<>();

    @Override
    public void sendSms(OTP msg) {

        String otp = generateOTP();
        String message = "Your OTP is : "+ otp;

        if(isValidNumber(msg.getPhoneNumber())){
            MessageCreator creator = Message.creator(new PhoneNumber(msg.getPhoneNumber()),
                    new PhoneNumber(twilioConfig.getTrialNumber()),
                    message);

            creator.create();
            optmap.put(msg.getUserName(), new OtpResponse(otp, LocalDateTime.now()));
            LOGGER.info("Sms Sent to ...", msg.getPhoneNumber());

        }else{
            throw  new IllegalArgumentException("Phone number is not valid "+ msg.getPhoneNumber());
        }

    }

    public String verifyOTP(String userOTP, String userName){

         OtpResponse response = optmap.get(userName);
         if(response != null && response.getOtp().equals(userOTP)){
             LocalDateTime validity = response.getValid_till().plus(Duration.of(60, ChronoUnit.SECONDS));
             LocalDateTime current = LocalDateTime.now();

             if(current.compareTo(validity) >= 0){
                 return "OTP is expired ... request again for the otp";
             }else{
                 return "Verified Successfully...";
             }
         }

         return "Wrong OTP .....";
    }

    public String generateOTP(){
        return new DecimalFormat("000000")
                .format(new Random().nextInt(999999));
    }

    private boolean isValidNumber(String phoneNumber) {
        return true;
    }
}

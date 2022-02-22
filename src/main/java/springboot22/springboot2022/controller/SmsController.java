package springboot22.springboot2022.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot22.springboot2022.entity.OTP;
import springboot22.springboot2022.twilio.SmsSender;
import springboot22.springboot2022.twilio.SmsSenderService;

@RestController
@RequestMapping("/otp")
public class SmsController {

    @Autowired
    private SmsSenderService smsSender;

    /*
    http://localhost:8080/otp/generate
    {
    "phoneNumber": "+917054164684",
    "userName": "Krishna"
    }
     */
    @PostMapping("/generate")
    public String requestOTP(@RequestBody OTP otp){

        smsSender.sendSms(otp);
        return "OTP sent successfully ...";
    }


    // http://localhost:8080/otp/verify?otp=613150&userName=Krishna
    @PostMapping("/verify")
    public String verifyOTP(@RequestParam String otp, @RequestParam String userName){

        return smsSender.verifyOTP(otp, userName);
    }
}

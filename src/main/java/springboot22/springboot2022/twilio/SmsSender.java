package springboot22.springboot2022.twilio;

import springboot22.springboot2022.entity.OTP;

public interface SmsSender {

    void sendSms(OTP msg);
}

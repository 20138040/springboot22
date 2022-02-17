package springboot22.springboot2022.scheduler;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.slf4j.*;
import springboot22.springboot2022.entity.CustomMessage;
import springboot22.springboot2022.queues.queue_config;

import java.util.Date;
import java.util.UUID;

@Service
public class schedulerTest {

    private final Logger LOGGER = LoggerFactory.getLogger(schedulerTest.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    static int counter = 0;


    public void sendSimpleEmail(String toEmail, String subject, String body){
        LOGGER.info("Sending mail to ..."+ toEmail);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("devwanshikrish@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        javaMailSender.send(message);
        LOGGER.info("Successfully sent mail to ..."+ toEmail);
    }

//    @Scheduled(fixedRate = 1000 * 60)
//    public void test(){
//        Date d = new Date();
//        LOGGER.info("printing the date "+d.toString());
//    }

    @Scheduled(fixedRate = 1000 * 60 * 5)
    public void sendMail(){
        sendSimpleEmail("18krishnadevwanshi09@gmail.com",
                "Test mail from spring boot","Test mail body");
    }

    @Scheduled(fixedRate = 1000)
    public void publishMessages(){
        counter++;
        String msg = "my message " + counter;
        LOGGER.info("Publishing the message ......");
        CustomMessage message = new CustomMessage(UUID.randomUUID().toString(), msg, new Date());
        rabbitTemplate.convertAndSend(queue_config.EXCHANGE, queue_config.ROUTING_KEY, message);
        LOGGER.info("Published the message ");
    }


}

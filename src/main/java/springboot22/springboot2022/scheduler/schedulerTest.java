package springboot22.springboot2022.scheduler;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.slf4j.*;
import springboot22.springboot2022.entity.CustomMessage;
import springboot22.springboot2022.queues.queue_config;

import java.io.*;
import java.util.Date;
import java.util.UUID;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

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

    public void sendEmailWithAttachment(String toEmail, String body, String subject, String filepath) throws MessagingException {

        LOGGER.info("Sending mail to ..."+ toEmail);

        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom("devwanshikrish@gmail.com");
            mimeMessageHelper.setTo(toEmail);
            mimeMessageHelper.setText(body);
            mimeMessageHelper.setSubject(subject);

            Resource resource = new ClassPathResource(filepath);

            mimeMessageHelper.addAttachment(resource.getFilename(), resource);
            System.out.println(mimeMessageHelper);
            System.out.println(mimeMessage);
            javaMailSender.send(mimeMessage);
            LOGGER.info("Successfully sent mail to ..."+ toEmail);
        }catch (Exception  ex){
            LOGGER.error(ex.getMessage(), ex.getStackTrace());
        }

    }

//    @Scheduled(fixedRate = 1000 * 60)
//    public void test(){
//        Date d = new Date();
//        LOGGER.info("printing the date "+d.toString());
//    }

//    @Scheduled(fixedRate = 1000 * 60 * 5)
//    public void sendMail(){
//        sendSimpleEmail("18krishnadevwanshi09@gmail.com",
//                "Test mail from spring boot","Test mail body");
//    }

    @Scheduled(fixedRate = 1000 * 60 * 2)
    public void sendMailAttachment() throws MessagingException, IOException {

        sendEmailWithAttachment("18krishnadevwanshi09@gmail.com", "Test mail from spring boot",
                "Test mail with attachment", "static/testfile.txt");


         // File file = new File(getClass().getResource("/static/testfile.txt").getFile());

//        Resource resource = new ClassPathResource("static/testfile.txt");
//        InputStream input = resource.getInputStream();
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(input));
//        String st;
//        while ((st = br.readLine()) != null)
//            System.out.println(st);
    }

//    @Scheduled(fixedRate = 1000)
//    public void publishMessages(){
//        counter++;
//        String msg = "my message " + counter;
//        LOGGER.info("Publishing the message ......");
//        CustomMessage message = new CustomMessage(UUID.randomUUID().toString(), msg, new Date());
//        rabbitTemplate.convertAndSend(queue_config.EXCHANGE, queue_config.ROUTING_KEY, message);
//        LOGGER.info("Published the message ");
//    }


}

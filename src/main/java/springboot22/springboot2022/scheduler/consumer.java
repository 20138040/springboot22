package springboot22.springboot2022.scheduler;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import springboot22.springboot2022.entity.CustomMessage;
import springboot22.springboot2022.queues.queue_config;

@Component
public class consumer {

    @RabbitListener(queues = queue_config.QUEUE)
    public void consume(CustomMessage message){
        System.out.println("Message is : "+ message);
    }
}

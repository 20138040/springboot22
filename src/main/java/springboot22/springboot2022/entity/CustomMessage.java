package springboot22.springboot2022.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class CustomMessage implements Serializable {

    private String messageId;
    private String message;
    private Date messageDate;

}

package springboot22.springboot2022.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OtpResponse {

    private String otp;
    private LocalDateTime valid_till;
}

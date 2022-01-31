package springboot22.springboot2022.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import springboot22.springboot2022.entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class ExceptionHandlerClass extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleDepartmentNotFound(DepartmentNotFoundException departmentNotFoundException,
                                                                WebRequest request){

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage(HttpStatus.NOT_FOUND, departmentNotFoundException.getMessage()));

    }
}

package springboot22.springboot2022.error;

import java.util.function.Supplier;

public class DepartmentNotFoundException extends Exception{
    public DepartmentNotFoundException() {
        super();
    }

    public DepartmentNotFoundException(String msg){
        super(msg);
    }

    public DepartmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotFoundException(Throwable cause) {
        super(cause);
    }

    protected DepartmentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

package global.exceptions;

public class ValidationException extends RuntimeException{
    public ValidationException(String message) {
        super(message);
        //예외에 메세지를 넣어서 알림(상위 부모에 메세지)
    }
}

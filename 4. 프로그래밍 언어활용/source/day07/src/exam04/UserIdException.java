package exam04;
//상속 시켜서 정의해놓음
public class UserIdException extends RuntimeException {
    public UserIdException(String message) {
        super(message);
    }
}

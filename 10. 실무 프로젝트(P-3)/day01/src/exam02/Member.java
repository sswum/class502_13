package exam02;

import java.time.LocalDateTime;

public class Member {
    private String userId;
    private String email;
    private LocalDateTime regDt;

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getRegDt() {
        return regDt;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

package exam01;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Member {
    private long USER_N0;
    private String USER_ID;
    private String USER_PW;
    private String USER_NM;
    private String MOBILE;
    private LocalDateTime REG_DT;

}

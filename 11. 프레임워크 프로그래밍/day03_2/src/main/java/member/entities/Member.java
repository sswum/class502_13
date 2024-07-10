package member.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
//쿼리 메소드로 조회 가능!
@Data
@Builder
public class Member {
private long seq;
private String email;
private String password;
private String userName;
private LocalDateTime regDt;
}

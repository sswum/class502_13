package member;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Builder
@Data
public class Member {
    private long userNo; //원칙이 DB 필드 컬럼명과 변수이름(EX)USER_NO)이랑 같아야 한다.
    private String userId;
    private String userPw;
    private String userNm;
    private String mobile;
    private LocalDateTime regDt;
    private LocalDateTime modDt;


}

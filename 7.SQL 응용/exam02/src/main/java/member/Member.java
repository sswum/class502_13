package member;

import lombok.*;

import java.time.LocalDateTime;

/*
import java.time.LocalDateTime;
@EqualsAndHashCode
@Getter @Setter @ToString */
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE) //기본 생성자 밑에 있는 멤버변수가 생성자 매개변수로 변함
@AllArgsConstructor
@RequiredArgsConstructor //이걸 쓰러면 NONNULL이 필수  ID랑 비밀번호는 초기화 시키는거당.
public class Member {
    @NonNull
    private String userId;
    @NonNull
    private String userNm;
    private String email;
    @ToString.Exclude
    private LocalDateTime regDt; // 투스트링 익스클루드 배제하기


}

package org.choongang.global.rests;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class JSONData { //많이 쓰는 것은 고정하는 게 좋다. =true , HttpStatus.OK ,
    private HttpStatus status = HttpStatus.OK; //상태코드
    private boolean success = true; //성공했는지 실패했는지 확인하기 위해서
    private Object message; //실패시엔 메세지가 오게끔
    @NonNull //어떤 경우는 내용을 바꿀 수 있기때문에 생성자로 만들어줌.
    private Object data;


}

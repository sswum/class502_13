package org.choongang.global.rests;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class JSONData { //통일성 있게 만들려고 틀을 만들어서
                         // 어떤 응답을 하든 이렇게 반환하게끔 만든 것
    //많이 쓰는 것들은 고정하는 게 좋다. =true , HttpStatus.OK ,
    private HttpStatus status = HttpStatus.OK; //상태코드
    private boolean success = true; //성공했는지 실패했는지 확인하기 위해서
    private Object message; //실패시엔 메세지가 오게끔
    @NonNull //생성자 매개변수로 넣을 수 있게끔 @NonNUll을 넣고 @RequiredArg..넣고
    private Object data;


}

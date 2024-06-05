package org.choongang;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor //?
@NoArgsConstructor //?
@Data //롬복의 데이타 정의

public class SocketData {
    private String from; //보내는 쪽
    private String to; //받는 쪽
    private String message;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;




}

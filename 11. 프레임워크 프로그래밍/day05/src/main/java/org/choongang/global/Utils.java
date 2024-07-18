package org.choongang.global;


import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Locale.filter;
import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor

public class Utils { //에러객체가 넘어오면 메세지 코드를 필드명과 오류 코드를 갖고와서 가공할 클래스

    private final MessageSource messageSource;
    private final HttpServletRequest request;

    public Map<String, List<String>> getErrorMessage(Errors errors) { //맵[키,값]형태로 가공해보겠다.
        Map<String, List<String>> messages = errors.getFieldErrors()
                .stream()
                .collect(Collectors.toMap(FieldError::getField, e -> getCodeMessages(e.getCodes())));

        // GlobalErrors
        List<String> gMessages = errors.getGlobalErrors()
                .stream()
                .flatMap(e -> getCodeMessages(e.getCodes()).stream()).toList();
        if (!gMessages.isEmpty()) {

        }
        messages.put("global", gMessages);

        return messages;
    }

    public List<String> getCodeMessages(String[] codes) {
        List<String> messages = Arrays.stream(codes)
                .map(c -> messageSource.getMessage(c, null, request.getLocale()))
                .filter(s -> s !=null && !s.isBlank())
                .toList();

        return messages;
    }
}

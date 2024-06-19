package choongang.global.config.containers;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BeanContainer {
    private static BeanContainer instance;

    private Map<String , Object> beans;

    public BeanContainer() {
        beans = new HashMap<>();
    }

    public void loadBeans() {
        //패키지 경로 기준으로 스캔 파일 경로 조회
        try{
            String rootPath
        }

    }

}

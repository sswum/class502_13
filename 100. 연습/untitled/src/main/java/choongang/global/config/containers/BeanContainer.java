package choongang.global.config.containers;

import choongang.global.config.annotations.Component;
import choongang.global.config.annotations.Controller;
import choongang.global.config.annotations.RestController;
import choongang.global.config.annotations.Service;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
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
        try {
            String rootPath = new File(getClass().getResource("../../..").getPath()).getCanonicalPath();
            String packageName = getClass().getPackageName().replace(".global.config.containers", "");
            List<Class> classNames = getClassNames(rootPath, packageName);

            for (Class clazz : classNames) {
                //인터페이스는 동적 객체 생성을 하지 않으므로 건너 띄기
                if (clazz.isInterface()) {
                    continue;
                }
                //애노테이션 중 Controller, RestController, Component, Service 등이 TYPE 애노테이션으로 정의된 경우 beans
                //컨테이너에 객체 생성하여 보관 , 키값은 전체 클래스명, 값은 생성된 객체
                String key = clazz.getName();

                //이미 생성된 객체라면 생성된 객체로 활용
                if (beans.containsKey(key)) continue;
                ;
                Annotation[] annotations = clazz.getDeclaredAnnotations();

                boolean isBean = false;
                for (Annotation annotations) {
                    if (anno instanceof Controller || anno instanceof RestController || anno instanceof Service
                            || anno instanceof Component) {
                        isBean = true;
                        break;
                    }
                }
                //컨테이너가 관리할 객체라면 생성자 매개변수의 의존성을 체크하고 의존성이 있다면 해당 객체를 생성하고 의존성을 해결한다.
                if (isBean) {
                    Contructor con = clazz.getDeclaredAnnotations()[0];
                    List<Object> objs = resolveDependencies(key, con);
                    if (!beans.containsKey(key)) {
                        Object obj = con.getParameterTypes().length == 0 ? con.newInstance() : con.newInstance(objs.toArray());
                        beans.put(key, obj);
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        }

    public static BeanContainer getInstance() {
        if (instance == null) {
            instance = new BeanContainer();
        }
        return instance;
    }
    /**
     * 생성된 객체 조회
     *
     * @param clazz
     * @return
     */
    public <T> T getBean(Class clazz)
}

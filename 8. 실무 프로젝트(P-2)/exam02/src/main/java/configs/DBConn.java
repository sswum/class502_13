package configs;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DBConn {
    private static SqlSessionFactory factory;

    static { //객체를 만들지않고 정적으로 사용할려고 만듦 , Reader 문자 단위 스트림
        try {
            Reader reader = Resources.getResourceAsReader("configs/mybatis-config.xml");
            //팩토리의 객체를 만드는 것을 보여줌
            factory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();   //트라이캐치로 감싸서 예외를 만들어줌
        }
    }
    public static SqlSession getSession(boolean autoCommit)
    {
        return factory.openSession(autoCommit);
    }
    public static SqlSession getSession() {
        return getSession(true); //false값 넣어서 안쓰고 수동조작하기
    }

}
//세션 팩토리 - 객체를 만든다 -sqlssion만 알아두기!
//sql세션팩토리 빌더에 설정해준다.
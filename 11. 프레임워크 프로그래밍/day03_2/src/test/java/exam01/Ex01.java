package exam01;

import config.AppCtx;
import member.entities.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.w3c.dom.ls.LSOutput;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//확장기능을 넣으면 의존성 주입!
@ContextConfiguration(classes = AppCtx.class)
@ExtendWith(SpringExtension.class)
public class Ex01 {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    void test1() {
    String sql = "INSERT INTO MEMBER (SEQ, EMAIL, PASSWORD, USER_NAME) " +
            "VALUES (SEQ_MEMBER.NEXTVAL, ?, ?, ?)"; //가변적으로 콤마 물음표 콤마 물음표 하면 쿼리 작성 될 것임
        int result =jdbcTemplate.update(sql, "user03@test.org","12345678","사용자3");
        System.out.println(result);
    }

    @Test
    void test2() {
        List<Member> members= jdbcTemplate.query("SELECT * FROM MEMBER",this::mapper);
        members.forEach(System.out::println);
    }


    @Test
    void test3() {
        String email = "user01@test.org";
        try {
            // 참조자료형::메서드명
            // 참조변수::메서드명
            Member member = jdbcTemplate.queryForObject("SELECT * FROM MEMBER WHERE EMAIL = ?", this::mapper, email);
            System.out.println(member);

        } catch (Exception e) {
            System.out.println("없음");
        }
        }

        @Test
        void test4() {
            int total = jdbcTemplate.queryForObject("SELECT COUNT (*) FROM MEMBER", int.class);

            //return

        }

    private Member mapper(ResultSet rs,int num) throws SQLException {

        return Member.builder()
                .seq(rs.getLong("SEQ"))
                .email(rs.getString("EMAIL"))
                .password(rs.getString("PASSWORD"))
                .userName(rs.getString("USER_NAME"))
                .regDt(rs.getTimestamp("REG_DT").toLocalDateTime())
                .build();

    }

}

package exam01;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class Ex01Test {
    @Test
    void test1() {
        //Locale.KOREAN  한국어로 할려고 할 때 요렇게 쓰기
        Faker faker = new Faker(Locale.JAPANESE);
        String name = faker.name().fullName();
        System.out.println(name);

    }

    @Test
    void test2() {
        Faker faker = new Faker(Locale.KOREAN);
        String address = faker.address().zipCode() + " " + faker.address().cityName() + faker.address().streetAddress();
        String addressSub = faker.address().secondaryAddress();
        System.out.println(address + " " + addressSub);


    }
}

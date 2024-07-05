package exam01.member;


import exam01.member.dao.MemberDao;
import exam01.member.services.JoinService;
import exam01.member.validators.JoinValidator;

//객체 조립기
public class Assembler {

    public MemberDao memberDao() {
        return new MemberDao();
    }

    public JoinValidator joinValidator() {
        JoinValidator validator = new JoinValidator();
        validator.setMemberDao(memberDao());
        //새로 가입한 멤버 데이터를 다시 업데이트해서 유효성 검사 하는...
        return validator;

    }

    public JoinService joinService() {
        //return new JoinService(joinValidator(), memberDao());
 return new JoinService();
    }
}

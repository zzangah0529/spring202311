package models.member;

import commons.exceptions.BadRequestException;
import commons.valdators.RequiredValidator;
import commons.valdators.Validator;

public class JoinValidator implements Validator<Member>, RequiredValidator {

    private MemberDao memberDao;

    public JoinValidator(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void validate(Member member) {

        /* 필수 항목 검증(아이디, 비밀번호, 비밀번호 확인, 회원명) */

        String userId = member.getUserId();
        String userPw = member.getUserPw();
        String confirmPw = member.getConfirmPw();
        String userNm = member.getUserNm();

        // 필수 항목 - null 또는 빈 공백 문자    "    "
        // RuntimeException e = new BadRequestException
        checkRequired(userId, new BadRequestException("아이디를 입력하세요."));
        checkRequired(userPw, new BadRequestException("비밀번호를 입력하세요."));
        checkRequired(confirmPw, new BadRequestException("비밀번호를 확인하세요."));
        checkRequired(userNm, new BadRequestException("회원명을 입력하세요."));

        // 아이디가 이미 등록되어 있는지 체크
        checkFalse(memberDao.exists(userId), new BadRequestException("이미 등록된 아이디 입니다."));

        // 비밀번호, 비밀번호 확인시 일치 여부
        checkTrue(userPw.equals(confirmPw), new BadRequestException("비밀번호가 일치하지 않습니다."));
    }
}

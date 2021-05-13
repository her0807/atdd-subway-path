package wooteco.subway.member.dto;

import wooteco.subway.member.domain.LoginMember;
import wooteco.subway.member.domain.Member;

public class MemberResponse {
    private Long id;
    private String email;
    private Integer age;

    public MemberResponse() {
    }

    public MemberResponse(Long id, String email, Integer age) {
        this.id = id;
        this.email = email;
        this.age = age;
    }

    public static MemberResponse of(Member member) {
        return new MemberResponse(member.getId(), member.getEmail(), member.getAge());
    }

    public static MemberResponse of(LoginMember loginMember) {
        return new MemberResponse(loginMember.getId(), loginMember.getEmail(), loginMember.getAge());
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public Member toMember() {
        return new Member(id, email, age);
    }

    public LoginMember toLoginMember() {
        return new LoginMember(toMember());
    }
}

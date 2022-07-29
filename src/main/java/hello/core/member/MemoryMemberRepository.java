package hello.core.member;

import java.util.HashMap;
import java.util.Map;
// 완전 자바 순수 코드로 작성한 회원 관리 백엔드
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}

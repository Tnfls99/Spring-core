package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    // 여기도 마찬가지로 인터페이스먼 가지고 있기 때문에 구현에 대해 전혀 모르는 상태임!
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository; // 참조값이 들어간다.
        this.discountPolicy = discountPolicy; // 참조값이 들어간다.
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 회원 정보 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); // 확장성을 고려해서 member 전체를 넘겼고, grade 만 넘겨줘도 상관은 없음

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

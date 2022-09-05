package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    } // 역할

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    } // 구현

    // 위와 같이 분리하여 작성하면 역할이 뚜렷하게 드러남.

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}

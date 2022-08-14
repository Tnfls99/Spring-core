package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfing = new AppConfig();
        MemberService memberService = appConfing.memberService();
        OrderService orderService = appConfing.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order =  orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order); // Order 에 있는 toString으로 출력
    }
}

package Digimon;

import Digimon.Service.CardService;
import Digimon.Service.MemberService;
import Digimon.common.CommonVariables;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberService memberService = new MemberService();
        CardService cardService = new CardService();
        boolean run1 = true;
        boolean run2 = true;
        boolean run3 = true;
        boolean run4 = true;
        int selectNum1 = 0;
        int selectNum2 = 0;
        int selectNum3 = 0;
        int selectNum4 = 0;
        while (run1) {
            System.out.println("메인메뉴");
            System.out.println("----------------------------------------------");
            System.out.println("1.멤버 | 2.카드 | 3.관리자 | 0.종료");
            System.out.println("----------------------------------------------");
            selectNum1 = scanner.nextInt();
            if (selectNum1 == 1) {
                //멤버
                run2 = true;
                while (run2) {
                    System.out.println("회원메뉴");
                    System.out.println("----------------------------------------------------------------------------------");
                    System.out.println("1.회원가입 | 2.로그인 | 3.회원목록 | 4.회원수정 | 5.회원탈퇴 | 6.로그아웃 | 0.메인메뉴");
                    System.out.println("----------------------------------------------------------------------------------");
                    selectNum2 = scanner.nextInt();
                    if (selectNum2 == 1) {
                        memberService.saveMember();
                    } else if (selectNum2 == 2) {
                        memberService.login();
                    } else if (selectNum2 == 3) {
                        memberService.findAll();
                    } else if (selectNum2 == 4) {
                        memberService.updateMember();
                    } else if (selectNum2 == 5) {
                        memberService.deleteMember();
                    } else if (selectNum2 == 6) {
                        memberService.logout();
                    } else if (selectNum2 == 0) {
                        System.out.println("메인메뉴로 돌아갑니다.");
                        run2 = false;
                    } else {
                        System.out.println("메뉴상의 숫자를 입려해 주세요");
                    }
                }
            } else if (selectNum1 == 2) {
                //카드
                run3 = true;
                while (run3) {
                    System.out.println("카드메뉴");
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println("1.카드목록 | 2.카드검색 | 3.덱구축 | 4.덱목록 | 5.덱조회 | 6.덱검색 | 7.덱수정 | 8.덱삭제 | 0.메인메뉴");
                    System.out.println("------------------------------------------------------------------------------------------------");
                    selectNum3 = scanner.nextInt();
                    if (selectNum3 == 1) {
                        cardService.findAll();
                    } else if (selectNum3 == 2) {
                        cardService.search();
                    } else if (selectNum3 == 3) {
                        cardService.saveDeck();
                    } else if (selectNum3 == 4) {
                        cardService.showDeck();
                    } else if (selectNum3 == 5) {
                        cardService.findDeckId();
                    } else if (selectNum3 == 6) {
                        cardService.searchDeck();
                    } else if (selectNum3 == 7) {
//                        cardService.updateDeck();
                    } else if (selectNum3 == 8) {
//                        cardService.deleteDeck();
                    } else if (selectNum3 == 0) {
                        System.out.println("메인메뉴로 돌아갑니다.");
                        run3 = false;
                    } else {
                        System.out.println("메뉴상의 숫자를 입려해 주세요");
                    }
                }
            } else if (selectNum1 == 3) {
                //관리자
                run4 = true;
                while (run4) {
                    System.out.println("관리자메뉴");
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("1.관리자등록 | 2.관리자삭제 | 3.관리자목록 | 4.카드등록 | 5.카드수정 | 6.카드삭제 | 0.메인메뉴");
                    System.out.println("----------------------------------------------------------------------------------------");
                    selectNum4 = scanner.nextInt();
                    if (selectNum4 == 1) {
                        System.out.println("관리자등록");
                        memberService.saveAdmin();
                    } else if (selectNum4 == 2) {
                        System.out.println("관리자삭제");
                        memberService.deleteAdmin();
                    } else if (selectNum4 == 3) {
                        System.out.println("관리자목록");
                        memberService.findAdmin();
                    } else if (selectNum4 == 4) {
                        System.out.println("카드등록");
                        cardService.saveCard();
                    } else if (selectNum4 == 5) {
                        System.out.println("카드수정");
                        cardService.updateCard();
                    } else if (selectNum4 == 6) {
                        System.out.println("카드삭제");
                        cardService.deleteCard();
                    } else if (selectNum4 == 0) {
                        System.out.println("메인메뉴로 돌아갑니다.");
                        run4 = false;
                    } else {
                        System.out.println("메뉴상의 숫자를 입려해 주세요");
                    }
                }
            } else if (selectNum1 == 0) {
                System.out.println("시스템을 종료합니다.");
                run1 = false;
            } else {
                System.out.println("메뉴상의 숫자를 입력해 주세요");
            }
        }
    }
}

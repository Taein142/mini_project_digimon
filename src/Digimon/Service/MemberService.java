package Digimon.Service;

import Digimon.DTO.MemberDTO;
import Digimon.Repository.AdminRepository;
import Digimon.Repository.MemberRepository;

import java.util.Scanner;

public class MemberService {
    Scanner scanner = new Scanner(System.in);
    MemberRepository memberRepository = new MemberRepository();
    AdminRepository adminRepository = new AdminRepository();

    public void saveMember() {
        String memberEmail;
        MemberDTO memberDTO = null;
        do {
            System.out.print("이메일: ");
            memberEmail = scanner.next();
            memberDTO = memberRepository.checkEmail(memberEmail);
            if (memberDTO == null) {
                System.out.println("사용 가능한 이메일입니다.");
            } else {
                System.out.println("이미 사용중인 이메일입니다.");
            }
        } while (memberDTO != null);
        System.out.print("비밀번호: ");
        String memberPass = scanner.next();
        System.out.print("이름: ");
        String memberName = scanner.next();
        System.out.print("전화번호: ");
        String memberMobile = scanner.next();
        MemberDTO dto = new MemberDTO(memberEmail, memberPass, memberName, memberMobile);
        boolean result = memberRepository.save(dto);
        if (result) {
            System.out.println("가입 완료되었습니다.");
        } else {
            System.out.println("예상치 못한 오류로 인하여 작업이 중지되었습니다")
            System.out.println("다시 시도해주세요.");
        }
    }

    public void login() {
        System.out.print("이메일: ");
        String memberEmail = scanner.next();
        System.out.print("비밀번호: ");
        String memberPass = scanner.next();
        MemberDTO loginResult = memberRepository.login(memberEmail, memberPass);
        if (loginResult != null){
            System.out.println("로그인되었습니다.");
        }else {
            System.out.println("이메일 혹은 비밀번호가 틀렸습니다.");
        }
    }
}

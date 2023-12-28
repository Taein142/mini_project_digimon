package Digimon.Service;

import Digimon.DTO.AdminDTO;
import Digimon.DTO.MemberDTO;
import Digimon.Repository.AdminRepository;
import Digimon.Repository.MemberRepository;
import Digimon.common.CommonVariables;


import java.util.ArrayList;
import java.util.List;
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
            if (dto.getId() == 0L) {
                AdminDTO adminDTO = new AdminDTO(dto.getId(), memberEmail);
                boolean adminResult = adminRepository.saveAdmin(adminDTO);
                if (adminResult) {
                    System.out.println("관리자로 임명되었습니다.");
                }
            }
        } else {
            System.out.println("예상치 못한 오류로 인하여 작업이 중지되었습니다");
            System.out.println("다시 시도해주세요.");
        }
    }

    public void login() {
        System.out.print("이메일: ");
        String memberEmail = scanner.next();
        System.out.print("비밀번호: ");
        String memberPass = scanner.next();
        MemberDTO loginResult = memberRepository.login(memberEmail, memberPass);
        if (loginResult != null) {
            System.out.println("로그인되었습니다.");
            CommonVariables.loginEmail = memberEmail;
        } else {
            System.out.println("이메일 혹은 비밀번호가 틀렸습니다.");
        }
    }

    public void findAll() {
        List<MemberDTO> memberDTOList = memberRepository.findAll();
        for (MemberDTO memberDTO : memberDTOList) {
            System.out.println("memberDTO = " + memberDTO);
        }
    }

    public void updateMember() {
        if (CommonVariables.loginEmail != null) {
            System.out.println("수정할 정보를 입력해주세요");
            System.out.print("이름: ");
            String memberName = scanner.next();
            System.out.print("전화번호: ");
            String memberMobile = scanner.next();
            boolean result = memberRepository.updateMember(CommonVariables.loginEmail, memberName, memberMobile);
            if (result) {
                System.out.println("정보가 수정되었습니다.");
            } else {
                System.out.println("수정이 완료되지 않았습니다.");
            }
        } else {
            System.out.println("로그인해야 이용할 수 있는 서비스 입니다.");
        }
    }

    public void deleteMember() {
        if (CommonVariables.loginEmail != null) {
            System.out.print("이메일: ");
            String memberEmail = scanner.next();
            System.out.print("비밀번호: ");
            String memberPass = scanner.next();
            MemberDTO check = memberRepository.login(memberEmail, memberPass);
            if (check != null) {
                boolean result = memberRepository.deleteMember(memberEmail, memberPass);
                if (result) {
                    System.out.println("탈퇴가 완료되었습니다.");
                } else {
                    System.out.println("예상치 못한 오류로 인하여 작업이 중단되었습니다.");
                }
            }
        } else {
            System.out.println("로그인해야 이용할 수 있는 서비스 입니다.");
        }
    }

    public void logout() {
        if (CommonVariables.loginEmail != null) {
            CommonVariables.loginEmail = null;
            System.out.println("로그아웃 되었습니다.");
        }
    }

    public void saveAdmin() {
//        if (CommonVariables.loginEmail.equals(adminDTO.getAdminEmail())) {
        System.out.println("등록할 사람의 아이디와 이메일을 입력해주세요");
        System.out.print("아이디: ");
        Long id = scanner.nextLong();
        System.out.print("이메일: ");
        String adminEmail = scanner.next();
        AdminDTO adminDTO = new AdminDTO(id, adminEmail);
        boolean adminResult = adminRepository.saveAdmin(adminDTO);
        if (adminResult) {
            System.out.println("관리자로 임명되었습니다.");
        } else {
            System.out.println("거부되었습니다.");
        }
//        } else {
//            System.out.println("관리자만 이용할 수 있는 서비스입니다.");
//        }
    }

    public void deleteAdmin() {
        System.out.println("삭제할 관리자 id: ");
        Long id = scanner.nextLong();
        boolean result = adminRepository.deleteAdmin(id);
        if (result) {
            System.out.println("해당 관리자가 퇴출되었습니다.");
        } else {
            System.out.println("관리자 삭제에 실패하였습니다.");
        }
    }

    public void findAdmin() {
        List<AdminDTO> adminDTOList = adminRepository.findAdmin();
        for (AdminDTO adminDTO : adminDTOList) {
            System.out.println("adminDTO = " + adminDTO);
        }
    }
}

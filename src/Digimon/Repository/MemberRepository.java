package Digimon.Repository;

import Digimon.DTO.MemberDTO;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    public static List<MemberDTO> memberDTOList = new ArrayList<>();

    public MemberDTO checkEmail(String memberEmail) {
        for (MemberDTO memberDTO : memberDTOList) {
            if (memberEmail.equals(memberDTO.getMemberEmail())) {
                return memberDTO;
            }
        }
        return null;
    }

    public boolean checkId(Long id) {
        boolean result = false;
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (id.equals(memberDTOList.get(i).getId())) {
                result = true;
            }
        }
        return result;
    }

    public MemberDTO login(String memberEmail, String memberPass) {
        for (MemberDTO memberDTO : memberDTOList) {
            if (memberEmail.equals(memberDTO.getMemberEmail()) && memberPass.equals(memberDTO.getMemberPass())) {
                return memberDTO;
            }
        }
        return null;
    }

    public boolean save(MemberDTO dto) {
        return memberDTOList.add(dto);
    }

    public List<MemberDTO> findAll() {
        return memberDTOList;
    }

    public boolean updateMember(String loginEmail, String memberName, String memberMobile) {
        boolean result = false;
        for (MemberDTO memberDTO : memberDTOList) {
            if (loginEmail.equals(memberDTO.getMemberEmail())) {
                memberDTO.setMemberName(memberName);
                memberDTO.setMemberMobile(memberMobile);
                result = true;
            }
        }
        return result;
    }

    public boolean deleteMember(String memberEmail, String memberPass) {
        boolean result = false;
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (memberEmail.equals(memberDTOList.get(i).getMemberEmail()) && memberPass.equals(memberDTOList.get(i).getMemberPass())) {
                memberDTOList.remove(i);
                result = true;
            }
        }
        return result;
    }


}

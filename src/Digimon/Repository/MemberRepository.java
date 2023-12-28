package Digimon.Repository;

import Digimon.DTO.MemberDTO;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    List<MemberDTO> memberDTOList = new ArrayList<>();

    public MemberDTO checkEmail(String memberEmail) {
        for (MemberDTO memberDTO : memberDTOList) {
            if (memberEmail.equals(memberDTO.getMemberEmail())) {
                return memberDTO;
            }
        }
        return null;
    }

    public MemberDTO checkPass(String memberPass) {
        for (MemberDTO memberDTO : memberDTOList) {
            if (memberPass.equals(memberDTO.getMemberPass())) {
                return memberDTO;
            }
        }
        return null;
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

}

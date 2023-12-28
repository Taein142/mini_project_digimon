package Digimon.Repository;

import Digimon.DTO.AdminDTO;
import Digimon.DTO.MemberDTO;

import java.util.ArrayList;
import java.util.List;

public class AdminRepository {
    public static List<AdminDTO> adminDTOList = new ArrayList<>();

    public boolean saveAdmin(AdminDTO adminDTO) {
        return adminDTOList.add(adminDTO);
    }
}

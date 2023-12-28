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

    public List<AdminDTO> findAdmin() {
        return adminDTOList;
    }

    public boolean deleteAdmin(Long id) {
        boolean result = false;
        for (AdminDTO adminDTO : adminDTOList) {
            if (id.equals(adminDTO.getId())) {
                adminDTOList.remove(adminDTO);
            }
        }
        return result;
    }
}

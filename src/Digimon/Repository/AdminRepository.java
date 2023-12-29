package Digimon.Repository;

import Digimon.DTO.AdminDTO;

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
        for (int i = 0; i < adminDTOList.size(); i++) {
            if (id.equals(adminDTOList.get(i).getId())) {
                adminDTOList.remove(i);
                result = true;
            }
        }
        return result;
    }
}

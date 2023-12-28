package Digimon.Repository;

import Digimon.DTO.DeckDTO;

import java.util.ArrayList;
import java.util.List;

public class DeckRepository {
    public static List<DeckDTO> deckDTOList = new ArrayList<>();

    public boolean updateHits(Long id) {
        boolean result = false;
        for (DeckDTO deckDTO : deckDTOList) {
            if (id.equals(deckDTO.getId())) {
                long hits = deckDTO.getHits();
                hits += 1;
                deckDTO.setHits(hits);
                result = true;
            }
        }
        return result;
    }
}

package Digimon.Repository;

import Digimon.DTO.CardDTO;
import Digimon.DTO.DeckDTO;

import java.util.ArrayList;
import java.util.List;

public class DeckRepository {
    List<CardDTO> cardDTOList = new ArrayList<>();
    private static List<DeckDTO> deckDTOList = new ArrayList<>();

    public boolean updateCount(String serialNumber) {
        boolean result = false;
        for (CardDTO cardDTO : cardDTOList) {
            if (serialNumber.equals(cardDTO.getSerialNum())) {
                int count = cardDTO.getCount();
                count += 1;
                cardDTO.setCount(count);
                result = true;
            }
        }
        return result;
    }

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

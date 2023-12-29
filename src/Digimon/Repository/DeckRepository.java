package Digimon.Repository;

import Digimon.DTO.CardDTO;
import Digimon.DTO.DeckDTO;
import Digimon.common.CommonVariables;

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

    public List<DeckDTO> showDeck() {
        return deckDTOList;
    }

    public boolean saveDeck(DeckDTO deckDTO) {
        return deckDTOList.add(deckDTO);
    }

    public DeckDTO finDeckId(Long id) {
        for (DeckDTO deckDTO : deckDTOList) {
            if (id.equals(deckDTO.getId())) {
                return deckDTO;
            }
        }
        return null;
    }

    public List<DeckDTO> searchDeck(String searchTitle) {
        List<DeckDTO> searchTitleList = new ArrayList<>();
        for (DeckDTO deckDTO : deckDTOList) {
            if (deckDTO.getDeckTitle().contains(searchTitle)) {
                searchTitleList.add(deckDTO);
            }
        }
        return searchTitleList;
    }

    public DeckDTO updateDeckTitle(Long id, String deckTitle) {
        for (DeckDTO deckDTO : deckDTOList) {
            if (id.equals(deckDTO.getId())) {
                deckDTO.setDeckTitle(deckTitle);
                return deckDTO;
            }
        }
        return null;
    }

    public DeckDTO updateDeckAll(Long id, String deckTitle, List<CardDTO> cardContents) {
        for (DeckDTO deckDTO : deckDTOList) {
            if (id.equals(deckDTO.getId())) {
                deckDTO.setDeckTitle(deckTitle);
                deckDTO.setCardContents(cardContents);
                return deckDTO;
            }
        }
        return null;
    }

    public DeckDTO checkEmail(String loginEmail, Long id) {
        for (DeckDTO deckDTO : deckDTOList) {
            if (id.equals(deckDTO.getId()) && loginEmail.equals(deckDTO.getCreatedEmail())) {
                return deckDTO;
            }
        }
        return null;
    }

    public boolean deleteDeck(Long id) {
        boolean result = false;
        for (int i = 0; i < deckDTOList.size(); i++) {
            if (id.equals(deckDTOList.get(i).getId())) {
                deckDTOList.remove(i);
                result = true;
            }
        }
        return result;
    }
}

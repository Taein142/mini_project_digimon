package Digimon.Repository;

import Digimon.DTO.CardDTO;
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

//    public boolean saveDeck(List<CardDTO> cardContents) {
//        List<DeckDTO> deckList = new ArrayList<>();
//        deckList.add(new DeckDTO(cardContents));
//        return deckDTOList.add((DeckDTO) cardContents);
//    }

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
        for (DeckDTO deckDTO: deckDTOList){
            if (deckDTO.getDeckTitle().contains(searchTitle)){
                searchTitleList.add(deckDTO);
            }
        }
        return searchTitleList;
    }
}

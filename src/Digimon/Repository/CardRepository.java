package Digimon.Repository;

import Digimon.DTO.CardDTO;

import java.util.ArrayList;
import java.util.List;

public class CardRepository {
    List<CardDTO> cardDTOList = new ArrayList<>();

    public boolean saveCard(CardDTO cardDTO) {
        return cardDTOList.add(cardDTO);
    }

    public List<CardDTO> findAll() {
        return cardDTOList;
    }

    public List<CardDTO> searchName(String word) {
        List<CardDTO> cardNameList = new ArrayList<>();
        for (CardDTO cardDTO : cardDTOList) {
            if (cardDTO.getCardName().contains(word)) {
                cardNameList.add(cardDTO);
            }
        }
        return cardNameList;
    }

    public List<CardDTO> searchBooster(String word) {
        List<CardDTO> bossterList = new ArrayList<>();
        for (CardDTO cardDTO : cardDTOList) {
            if (cardDTO.getCardName().contains(word)) {
                bossterList.add(cardDTO);
            }
        }
        return bossterList;
    }

    public CardDTO findBySerialNum(String word) {
        for (CardDTO cardDTO : cardDTOList) {
            if (word.equals(cardDTO.getSerialNum())) {
                return cardDTO;
            }
        }
        return null;
    }
}

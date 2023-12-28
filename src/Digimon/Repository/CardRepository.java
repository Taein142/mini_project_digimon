package Digimon.Repository;

import Digimon.DTO.CardDTO;

import java.util.ArrayList;
import java.util.List;

public class CardRepository {
    List<CardDTO> cardDTOList = new ArrayList<>();

    public boolean saveCard(CardDTO cardDTO) {
        return cardDTOList.add(cardDTO);
    }
}

package Digimon.Repository;

import Digimon.DTO.CardDTO;

import java.util.ArrayList;
import java.util.List;

public class CardRepository {
    public static List<CardDTO> cardDTOList = new ArrayList<>();

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
            if (cardDTO.getBoosterNum().contains(word)) {
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

    public CardDTO check(Long id) {
        for (CardDTO cardDTO : cardDTOList) {
            if (id.equals(cardDTO.getId())) {
                return cardDTO;
            }
        }
        return null;
    }

    public CardDTO updateCard(Long id, String cardName, String category, int level, int power, String effect, String booster, String serialNum) {
        for (int i = 0; i < cardDTOList.size(); i++) {
            if (id.equals(cardDTOList.get(i).getId())) {
                cardDTOList.get(i).setCardName(cardName);
                cardDTOList.get(i).setCategory(category);
                cardDTOList.get(i).setLevel(level);
                cardDTOList.get(i).setPower(power);
                cardDTOList.get(i).setCardEffects(effect);
                cardDTOList.get(i).setBoosterNum(booster);
                cardDTOList.get(i).setSerialNum(serialNum);
                return cardDTOList.get(i);
            }
        }
        return null;
    }

    public boolean deleteCard(Long id) {
        boolean result = false;
        for (int i = 0; i < cardDTOList.size(); i++) {
            if (id.equals(cardDTOList.get(i).getId())) {
                cardDTOList.remove(i);
                result = true;
            }
        }
        return result;
    }

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
}

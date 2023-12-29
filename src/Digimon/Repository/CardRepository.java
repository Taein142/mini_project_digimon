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
        // 카드 아이디를 체크
        for (CardDTO cardDTO : cardDTOList) {
            if (id.equals(cardDTO.getId())) {
                return cardDTO;
            }
        }
        return null;
    }

    public CardDTO updateCard(Long id, String cardName, String category, int level, int power, String MainEffect,String SideEffect, String booster, String serialNum) {
        for (int i = 0; i < cardDTOList.size(); i++) {
            if (id.equals(cardDTOList.get(i).getId())) {
                cardDTOList.get(i).setCardName(cardName);
                cardDTOList.get(i).setCategory(category);
                cardDTOList.get(i).setLevel(level);
                cardDTOList.get(i).setPower(power);
                cardDTOList.get(i).setCardMainEffects(MainEffect);
                cardDTOList.get(i).setCardSideEffects(SideEffect);
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
        // 카드 매수를 증가시키는 메서드
        boolean result = false;
        for (CardDTO cardDTO : cardDTOList) {
            if (serialNumber.equals(cardDTO.getSerialNum())) {
                int count = cardDTO.getCount();
                if (count<4){
                    count += 1;
                    cardDTO.setCount(count);
                }else {
                    System.out.println("4장까지 넣을 수 있습니다.");
                }
                result = true;
            }
        }
        return result;
    }

    public boolean checkCard(List<CardDTO> deckContents, String serialNum) {
        // 덱에 입력한 시리얼넘버의 카드가 들어있는지 확인하는 메서드
        boolean result = false;
        for (int i = 0; i < deckContents.size(); i++) {
            if (serialNum.equals(deckContents.get(i).getSerialNum())){
                result = true;
            }
        }
        return result;
    }
}

package Digimon.Service;

import Digimon.DTO.CardDTO;
import Digimon.Repository.AdminRepository;
import Digimon.Repository.CardRepository;
import Digimon.Repository.DeckRepository;
import Digimon.common.CommonVariables;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardService {
    Scanner scanner = new Scanner(System.in);
    CardRepository cardRepository = new CardRepository();
    AdminRepository adminRepository = new AdminRepository();
    DeckRepository deckRepository = new DeckRepository();

    public void saveCard() {
        System.out.println("카드의 정보를 입력해주세요");
        System.out.print("이름: ");
        String cardName = scanner.next();
        System.out.print("종류: ");
        String cardCategory = scanner.next();
        System.out.print("레벨: ");
        int cardLevel = scanner.nextInt();
        System.out.print("파워: ");
        int cardPower = scanner.nextInt();
        System.out.print("효과: ");
        String blank = scanner.nextLine();
        String cardEffect = scanner.nextLine();
        System.out.print("발매정보: ");
        String cardBooster = scanner.next();
        System.out.print("시리얼넘버: ");
        String cardSerialNum = scanner.next();
        CardDTO cardDTO = new CardDTO(cardName, cardCategory, cardLevel, cardPower, cardEffect, cardBooster, cardSerialNum);
        boolean result = cardRepository.saveCard(cardDTO);
        if (result) {
            System.out.println("카드가 등록되었습니다.");
        } else {
            System.out.println("카드가 등록되지 않았습니다.");
        }
    }

    public void findAll() {
        List<CardDTO> cardDTOList = cardRepository.findAll();
        listPrint(cardDTOList);
    }

    public void search() {
        System.out.println("어떤것으로 검색 하시겠습니까?");
        int searchNum = 0;
        boolean run = true;
        while (run) {
            System.out.println("---------------------------------------------");
            System.out.println("1.이름 | 2.부스터 | 3.시리얼넘버 | 0.메인메뉴");
            System.out.println("---------------------------------------------");
            searchNum = scanner.nextInt();
            if (searchNum == 1) {
                searchByName();
            } else if (searchNum == 2) {
                searchByBooster();
            } else if (searchNum == 3) {
                System.out.println("시리얼 넘버를 정확하게 입력해주세요");
                findBySerialNum();
            } else if (searchNum == 0) {
                System.out.println("이전 메뉴로 돌아갑니다.");
                run = false;
            }
        }
    }

    private void searchByName() {
        System.out.println("검색어를 입력해주세요");
        System.out.print("검색어> ");
        String word = scanner.next();
        List<CardDTO> cardNameList = cardRepository.searchName(word);
        if (cardNameList.size() > 0) {
            listPrint(cardNameList);
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
    }

    private void searchByBooster() {
        System.out.println("검색어를 입력해주세요");
        System.out.print("검색어> ");
        String word = scanner.next();
        List<CardDTO> boosterList = cardRepository.searchBooster(word);
        if (boosterList.size() > 0) {
            listPrint(boosterList);
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
    }

    private void findBySerialNum() {
        System.out.println("검색어를 입력해주세요");
        System.out.print("검색어> ");
        String word = scanner.next();
        CardDTO cardDTO = cardRepository.findBySerialNum(word);
        System.out.println("cardDTO = " + cardDTO);
    }

    private void listPrint(List<CardDTO> cardDTOList) {
        System.out.println("cardName\t" + "category\t" + "level\t" + "power\t" + "cardEffect\t" + "serialNum\t");
        for (CardDTO cardDTO : cardDTOList) {
            System.out.println(cardDTO.getCardName() + "\t" + cardDTO.getCategory() + "\t" + cardDTO.getLevel() + "\t"
                    + cardDTO.getPower() + "\t" + cardDTO.getCardEffects() + "\t" + cardDTO.getSerialNum() + "\t");
        }
    }

    public void updateCard() {
        System.out.println("수정할 카드의 아이디를 입력해주세요");
        System.out.print("아이디: ");
        Long id = scanner.nextLong();
        CardDTO checkCard = cardRepository.check(id);
        if (checkCard != null) {
            System.out.println("수정할 정보를 입력해주세요.");
            System.out.print("이름: ");
            String cardName = scanner.next();
            System.out.print("카테고리: ");
            String category = scanner.next();
            System.out.print("레벨: ");
            int level = scanner.nextInt();
            System.out.print("파워: ");
            int power = scanner.nextInt();
            System.out.print("효과: ");
            String blank = scanner.nextLine();
            String effect = scanner.nextLine();
            System.out.print("부스터: ");
            String booster = scanner.next();
            System.out.print("시리얼넘버: ");
            String serialNum = scanner.next();
            CardDTO cardDTO = cardRepository.updateCard(id, cardName, category, level, power, effect, booster, serialNum);
            if (cardDTO != null) {
                System.out.println("수정되었습니다.");
            } else {
                System.out.println("수정에 실패했습니다.");
            }
        } else {
            System.out.println("id가 틀렸습니다.");
        }
    }

    public void deleteCard() {
        System.out.println("삭제하실 카드의 아이디를 입력해주세요");
        System.out.print("id: ");
        Long id = scanner.nextLong();
        CardDTO checkCard = cardRepository.check(id);
        if (checkCard != null) {
            System.out.println("정말 삭제하시겠습니까?");
            System.out.println("삭제하시려면 1번, 아니라면 2번을 눌러주세요");
            int delete = scanner.nextInt();
            if (delete == 1) {
                boolean result = cardRepository.deleteCard(id);
                if (result) {
                    System.out.println("카드가 소멸하였습니다.");
                } else {
                    System.out.println("내성으로 소멸을 버텼습니다.");
                }
            } else if (delete == 2) {
                System.out.println("이전메뉴로 돌아갑니다.");
            }
        } else {
            System.out.println("id를 다시 확인해주세요");
        }
    }

    public void saveDeck() {
        if (CommonVariables.loginEmail != null) {
            System.out.println("덱 이름을 입력해주세요");
            System.out.print("덱 이름: ");
            String deckName = scanner.next();
            String cardName = scanner.next();
//            List<CardDTO> deckContents = cardRepository.deckBuild();

        } else {
            System.out.println("로그인해야 이용할 수 있는 서비스 입니다.");
        }
    }
}

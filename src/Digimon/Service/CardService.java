package Digimon.Service;

import Digimon.DTO.AdminDTO;
import Digimon.DTO.CardDTO;
import Digimon.DTO.DeckDTO;
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
        List<AdminDTO> adminDTOList = adminRepository.findAdmin();
        for (int i = 0; i < adminDTOList.size(); i++) {
            // 관리자만 카드 등록 할 수 있도록 함.
            if (adminDTOList.get(i).getAdminEmail().equals(CommonVariables.loginEmail)) {
                System.out.println("카드의 정보를 입력해주세요");
                System.out.print("이름: ");
                String cardName = scanner.next();
                System.out.print("종류: ");
                String cardCategory = scanner.next();
                System.out.print("레벨: ");
                int cardLevel = scanner.nextInt();
                System.out.print("파워: ");
                int cardPower = scanner.nextInt();
                System.out.print("메인 효과: ");
                String blank = scanner.nextLine();
                String cardMainEffect = scanner.nextLine();
                System.out.print("진화원 효과: ");
                blank = scanner.nextLine();
                String cardSideEffect = scanner.nextLine();
                System.out.print("발매정보: ");
                String cardBooster = scanner.next();
                System.out.print("시리얼넘버: ");
                String cardSerialNum = scanner.next();
                CardDTO cardDTO = new CardDTO(cardName, cardCategory, cardLevel, cardPower, cardMainEffect, cardSideEffect, cardBooster, cardSerialNum);
                boolean result = cardRepository.saveCard(cardDTO);
                if (result) {
                    System.out.println("카드가 등록되었습니다.");
                } else {
                    System.out.println("카드가 등록되지 않았습니다.");
                }
                break;
            } else {
                System.out.println("관리자만 이용할 수 있는 서비스입니다.");
            }
        }
    }

    public void findAll() {
        List<CardDTO> cardDTOList = cardRepository.findAll();
        listPrint1(cardDTOList);
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
            listPrint1(cardNameList);
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
            listPrint1(boosterList);
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

    public void updateCard() {
        List<AdminDTO> adminDTOList = adminRepository.findAdmin();
        for (int i = 0; i < adminDTOList.size(); i++) {
            if (adminDTOList.get(i).getAdminEmail().equals(CommonVariables.loginEmail)) {
                System.out.println("수정할 카드의 아이디를 입력해주세요");
                System.out.print("아이디: ");
                Long id = scanner.nextLong();
                CardDTO checkCard = cardRepository.checkID(id);
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
                    System.out.print("메인 효과: ");
                    String blank = scanner.nextLine();
                    String cardMainEffect = scanner.nextLine();
                    System.out.print("진화원 효과: ");
                    blank = scanner.nextLine();
                    String cardSideEffect = scanner.nextLine();
                    System.out.print("부스터: ");
                    String booster = scanner.next();
                    System.out.print("시리얼넘버: ");
                    String serialNum = scanner.next();
                    CardDTO cardDTO = cardRepository.updateCard(id, cardName, category, level, power, cardMainEffect, cardSideEffect, booster, serialNum);
                    if (cardDTO != null) {
                        System.out.println("수정되었습니다.");
                    } else {
                        System.out.println("수정에 실패했습니다.");
                    }
                } else {
                    System.out.println("id가 틀렸습니다.");
                }
                break;
            } else {
                System.out.println("관리자만 이용할 수 있는 서비스입니다.");
            }
        }
    }

    public void deleteCard() {
        List<AdminDTO> adminDTOList = adminRepository.findAdmin();
        for (int i = 0; i < adminDTOList.size(); i++) {
            if (adminDTOList.get(i).getAdminEmail().equals(CommonVariables.loginEmail)) {
                System.out.println("삭제하실 카드의 아이디를 입력해주세요");
                System.out.print("id: ");
                Long id = scanner.nextLong();
                CardDTO checkCard = cardRepository.checkID(id);
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
                break;
            } else {
                System.out.println("관리자만 이용할 수 있는 서비스입니다.");
            }
        }
    }

    public void saveDeck() {
        /*입력한 카드와 같은 카드를 cardDTO에서 끌어와서 그 정보들을 contents저장
         * 추가로 같은 시리얼넘버를 가진 카드라면 매수를 추가한다.*/
        if (CommonVariables.loginEmail != null) {
            System.out.println("덱 이름을 입력해주세요");
            System.out.print("덱 이름: ");
            String deckName = scanner.next();
            List<CardDTO> cardContents = new ArrayList<>();
            String serialNum;
            do {
                System.out.print("시리얼 넘버: ");
                serialNum = scanner.next();
                if (!serialNum.equals("00")) {
                    boolean checkCard = cardRepository.checkCard(cardContents, serialNum);
                    CardDTO card = cardRepository.findBySerialNum(serialNum);
                    if (card != null) {
                        if (checkCard) {
                            // 덱에 동일한 시리얼넘버를 가진 카드가 있다면 카운트를 늘린다
                            boolean countResult = cardRepository.updateCount(serialNum);
                            if (countResult) {
                                System.out.println(card.getCardName() + "의 매수 +1");
                            } else {
                                System.out.println("오류발생. 카드 매수 추가 실패");
                            }
                        } else {
                            // 없다면 덱에 추가한다.
                            cardContents.add(card);
                            System.out.println("카드 추가: " + card.getCardName());
                        }
                    } else {
                        System.out.println("해당 카드가 존재하지 않습니다.");
                    }
                }
            } while (!serialNum.equals("00"));
            // 00을 입력할 때 까지 덱 리스트에 카드 추가
            listPrint2(cardContents);
            DeckDTO deckDTO = new DeckDTO(deckName, cardContents, CommonVariables.loginEmail);
            boolean deckResult = deckRepository.saveDeck(deckDTO);
            if (deckResult) {
                System.out.println("덱이 생성되었습니다.");
            } else {
                System.out.println("오류로 인하여 덱이 생성되지 않았습니다.");
            }
        } else {
            System.out.println("로그인해야 이용할 수 있는 서비스 입니다.");
        }
    }

    public void showDeck() {
        List<DeckDTO> deckDTOList = deckRepository.showDeck();
        listPrint3(deckDTOList);
    }

    public void findDeckId() {
        System.out.println("찾고자 하는 덱의 ID를 입력해주세요");
        Long id = scanner.nextLong();
        boolean hitsResult = deckRepository.updateHits(id);
        if (hitsResult) {
            DeckDTO deckDTO = deckRepository.finDeckId(id);
            listPrint4(deckDTO);
            listPrint5(deckDTO.getCardContents());
        } else {
            System.out.println("존재하지 않는 덱입니다..");
        }
    }

    public void searchDeck() {
        System.out.println("찾고자 하는 덱의 이름을 입력해주세요");
        String searchTitle = scanner.next();
        List<DeckDTO> searchTitleList = deckRepository.searchDeck(searchTitle);
        if (searchTitleList.size() > 0) {
            System.out.println("검색 결과");
            listPrint3(searchTitleList);
            System.out.println("상세검색 하시겠습니까?");
            System.out.println("1.상세검색 | 2.뒤로");
            int selectNum = scanner.nextInt();
            if (selectNum == 1) {
                findDeckId();
            }
        } else {
            System.out.println("검색결과가 없습니다.");
        }
    }

    public void updateDeck() {
        System.out.println("수정하실 덱의 ID를 입력해주세요");
        Long id = scanner.nextLong();
        // 현재 로그인 한 사람과 덱 만든 사람이 같은지 확인하는 메서드
        DeckDTO deckDTO = deckRepository.checkEmail(CommonVariables.loginEmail, id);
        if (deckDTO != null) {
            // 로그인유저의 이메일과 이 덱을 만든 이메일이 같다면
            System.out.println("수정할 정보를 입력해주세요");
            System.out.print("덱 이름");
            String deckTitle = scanner.next();
            System.out.println("덱 구성도 다시 만드시겠습니까?");
            System.out.println("1.네 | 2.아니오");
            DeckDTO updateResult = null;
            int selectNum = scanner.nextInt();
            if (selectNum == 1) {
                List<CardDTO> cardContents = new ArrayList<>();
                String serialNum;
                // do while문 자체는 세이브 메서드와 똑같음.
                do {
                    System.out.print("시리얼 넘버: ");
                    serialNum = scanner.next();
                    if (!serialNum.equals("00")) {
                        boolean checkCard = cardRepository.checkCard(cardContents, serialNum);
                        CardDTO card = cardRepository.findBySerialNum(serialNum);
                        if (card != null) {
                            if (checkCard) {
                                // 덱에 동일한 시리얼넘버를 가진 카드가 있다면 카운트를 늘린다
                                boolean countResult = cardRepository.updateCount(serialNum);
                                if (countResult) {
                                    System.out.println(card.getCardName() + "의 매수 +1");
                                } else {
                                    System.out.println("오류발생. 카드 매수 추가 실패");
                                }
                            } else {
                                // 없다면 덱에 추가한다.
                                cardContents.add(card);
                                System.out.println("카드 추가: " + card.getCardName());
                            }
                        } else {
                            System.out.println("해당 카드가 존재하지 않습니다.");
                        }
                    }
                } while (!serialNum.equals("00"));
                updateResult = deckRepository.updateDeckAll(id, deckTitle, cardContents);
            } else {
                updateResult = deckRepository.updateDeckTitle(id, deckTitle);
                System.out.println("이전 메뉴로 돌아갑니다.");
            }
            if (updateResult != null) {
                System.out.println("덱 수정 완료");
            } else {
                System.out.println("덱 수정 실패");
            }
        } else {
            System.out.println("덱 작성자가 아닙니다.");
        }
    }

    public void deleteDeck() {
        System.out.println("수정할 덱의 id를 입력해주세요");
        Long id = scanner.nextLong();
        DeckDTO deckDTO = deckRepository.checkEmail(CommonVariables.loginEmail, id);
        if (deckDTO != null) {
            boolean result = deckRepository.deleteDeck(id);
            if (result) {
                System.out.println("사마준이 당신의 덱을 바다 속으로 던져버렸습니다.");
            } else {
                System.out.println("조이가 당신의 덱을 잘 지켜내었습니다.");
            }
        } else {
            System.out.println("덱 작성자가 아닙니다.");
        }
    }

    private void listPrint1(List<CardDTO> cardDTOList) {
        System.out.println("카드이름\t" + "카테고리\t" + "레벨\t" + "파워\t" + "메인 효과\t" + "진화원 효과\t" + "시리얼넘버\t");
        for (CardDTO cardDTO : cardDTOList) {
            System.out.println(cardDTO.getCardName() + "\t" + cardDTO.getCategory() + "\t" + cardDTO.getLevel() + "\t"
                    + cardDTO.getPower() + "\t" + cardDTO.getCardMainEffects() + "\t" + cardDTO.getCardSideEffects() + "\t" + cardDTO.getSerialNum() + "\t");
        }
    }

    private void listPrint2(List<CardDTO> cardDTOList) {
        System.out.println("카드이름\t" + "카테고리\t" + "레벨\t" + "파워\t" + "카드매수\t" + "메인 효과\t" + "진화원 효과\t" + "시리얼넘버\t");
        for (CardDTO cardDTO : cardDTOList) {
            System.out.println(cardDTO.getCardName() + "\t" + cardDTO.getCategory() + "\t" + cardDTO.getLevel() + "\t"
                    + cardDTO.getPower() + "\t" + cardDTO.getCount() + "\t" + cardDTO.getCardMainEffects() + "\t" + cardDTO.getCardSideEffects() + "\t" + cardDTO.getSerialNum());
        }
    }

    private void listPrint3(List<DeckDTO> deckDTOList) {
        System.out.println("id\t" + "작성자\t" + "덱이름\t" + "조회수\t" + "생성시간\t");
        for (DeckDTO deckDTO : deckDTOList) {
            System.out.println(deckDTO.getId() + "\t" + deckDTO.getCreatedEmail() + "\t" + deckDTO.getDeckTitle() + "\t" + deckDTO.getHits() + "\t" + deckDTO.getCreatedAt());
        }
    }

    private void listPrint4(DeckDTO deckDTO) {
        System.out.println("id\t" + "작성자\t" + "덱이름\t" + "조회수\t" + "생성시간");
        System.out.println(deckDTO.getId() + "\t" + deckDTO.getCreatedEmail() + "\t" + deckDTO.getDeckTitle() + "\t" + deckDTO.getHits() + "\t" + deckDTO.getCreatedAt());
        System.out.println(" ");
        System.out.println("덱구성: ");
    }

    private void listPrint5(List<CardDTO> cardContents) {
        System.out.println("카드이름\t" + "카테고리\t" + "레벨\t" + "파워\t" + "카드매수\t" + "메인 효과\t" + "진화원 효과\t" + "시리얼넘버\t");
        for (CardDTO cardDTO : cardContents) {
            System.out.println(cardDTO.getCardName() + "\t" + cardDTO.getCategory() + "\t" + cardDTO.getLevel() + "\t"
                    + cardDTO.getPower() + "\t" + cardDTO.getCount() + "\t" + cardDTO.getCardMainEffects() + "\t" + cardDTO.getCardSideEffects() + "\t" + cardDTO.getSerialNum());
        }
    }
}
package Digimon.Service;

import Digimon.DTO.CardDTO;
import Digimon.Repository.AdminRepository;
import Digimon.Repository.CardRepository;

import java.util.Scanner;

public class CardService {
    Scanner scanner = new Scanner(System.in);
    CardRepository cardRepository = new CardRepository();
    AdminRepository adminRepository = new AdminRepository();

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
        if (result){
            System.out.println("카드가 등록되었습니다.");
        }else {
            System.out.println("카드가 등록되지 않았습니다.");
        }
    }
}

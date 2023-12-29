package Digimon.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CardDTO {
    private Long id;
    private String cardName;
    private String category;
    private int level;
    private int power;
    private String cardEffects;
    private String boosterNum;
    private String serialNum;
    private String createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getCardEffects() {
        return cardEffects;
    }

    public void setCardEffects(String cardEffects) {
        this.cardEffects = cardEffects;
    }

    public String getBoosterNum() {
        return boosterNum;
    }

    public void setBoosterNum(String boosterNum) {
        this.boosterNum = boosterNum;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public CardDTO() {
    }

    private static Long inValue = 1L;
    private int count;

    public CardDTO(String cardName, String category, int level, int power, String cardEffects, String boosterNum, String serialNum) {
        this.id = inValue++;
        this.cardName = cardName;
        this.category = category;
        this.level = level;
        this.power = power;
        this.cardEffects = cardEffects;
        this.boosterNum = boosterNum;
        this.serialNum = serialNum;
        this.count = 1;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-d HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "CardDTO{" +
                "id=" + id +
                ", cardName='" + cardName + '\'' +
                ", category='" + category + '\'' +
                ", level=" + level +
                ", power=" + power +
                ", cardEffects='" + cardEffects + '\'' +
                ", boosterNum='" + boosterNum + '\'' +
                ", serialNum='" + serialNum + '\'' +
                ", count=" + count +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}

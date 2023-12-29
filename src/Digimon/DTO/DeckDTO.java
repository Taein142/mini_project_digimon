package Digimon.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DeckDTO { ;
    private Long id;
    private String deckTitle;
    private List<CardDTO> cardContents;
    private long hits;
    private String createdEmail;
    private String createdAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeckTitle() {
        return deckTitle;
    }

    public void setDeckTitle(String deckTitle) {
        this.deckTitle = deckTitle;
    }

    public List<CardDTO> getCardContents() {
        return cardContents;
    }

    public void setCardContents(List<CardDTO> CardContents) {
        this.cardContents = CardContents;
    }

    public long getHits() {
        return hits;
    }

    public void setHits(long hits) {
        this.hits = hits;
    }


    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedEmail() {
        return createdEmail;
    }

    public void setCreatedEmail(String createdEmail) {
        this.createdEmail = createdEmail;
    }

    public DeckDTO() {
    }
    public DeckDTO(List<CardDTO> cardContents) {
    }
    private static Long inValue = 1L;
    public DeckDTO(String deckTitle, List<CardDTO> cardContents, String createdEmail) {
        this.id = inValue++;
        this.deckTitle = deckTitle;
        this.cardContents = cardContents;
        this.createdEmail = createdEmail;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-d HH:mm:ss"));
        this.hits = 0;
    }

    @Override
    public String toString() {
        return "DeckDTO{" +
                "id=" + id +
                ", deckTitle='" + deckTitle + '\'' +
                ", cardContents=" + cardContents +
                ", hits=" + hits +
                ", createdEmail='" + createdEmail + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}

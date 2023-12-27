package Digimon.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DeckDTO {
    private Long id;
    private String deckTitle;
    private String deckContents;
    private long hits;
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

    public String getDeckContents() {
        return deckContents;
    }

    public void setDeckContents(String deckContents) {
        this.deckContents = deckContents;
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

    public DeckDTO() {
    }
    private static Long inValue = 1L;
    public DeckDTO(String deckTitle, String deckContents) {
        this.id = inValue++;
        this.deckTitle = deckTitle;
        this.deckContents = deckContents;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-d HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "DeckDTO{" +
                "id=" + id +
                ", deckTitle='" + deckTitle + '\'' +
                ", deckContents='" + deckContents + '\'' +
                ", hits=" + hits +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}

package Digimon.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DeckDTO {
    private Long id;
    private String deckTitle;
    private List<CardDTO> deckContents;
    private long hits;
//    private int count;
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

    public List<CardDTO> getDeckContents() {
        return deckContents;
    }

    public void setDeckContents(List<CardDTO> deckContents) {
        this.deckContents = deckContents;
    }

    public long getHits() {
        return hits;
    }

    public void setHits(long hits) {
        this.hits = hits;
    }

//    public int getCount() {
//        return count;
//    }
//
//    public void setCount(int count) {
//        this.count = count;
//    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public DeckDTO() {
    }
    private static Long inValue = 1L;
    public DeckDTO(String deckTitle, List<CardDTO> deckContents) {
        this.id = inValue++;
        this.deckTitle = deckTitle;
        this.deckContents = deckContents;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-d HH:mm:ss"));
        this.hits = 0;
//        this.count = 1;
    }

    @Override
    public String toString() {
        return "DeckDTO{" +
                "id=" + id +
                ", deckTitle='" + deckTitle + '\'' +
                ", deckContents='" + deckContents + '\'' +
                ", hits=" + hits +
//                ", count=" + count +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}

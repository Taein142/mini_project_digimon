package Digimon.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdminDTO {
    private Long id;
    private Long memberId;
    private String adminEmail;
    private String createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public AdminDTO() {
    }

    private static Long inValue = 0L;

    public AdminDTO(Long memberId, String adminEmail) {
        this.id = inValue++;
        this.memberId = memberId;
        this.adminEmail = adminEmail;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", adminEmail='" + adminEmail + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}

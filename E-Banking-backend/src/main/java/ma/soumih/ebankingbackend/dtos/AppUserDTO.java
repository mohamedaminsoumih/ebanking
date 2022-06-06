package ma.soumih.ebankingbackend.dtos;

import lombok.Data;

@Data
public class AppUserDTO {
    private String userId;
    private String username;
    private String userType;
}

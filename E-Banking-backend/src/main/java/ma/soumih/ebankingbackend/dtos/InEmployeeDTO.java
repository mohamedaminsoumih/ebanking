package ma.soumih.ebankingbackend.dtos;

import lombok.Data;

@Data
public class InEmployeeDTO {
    private String username;
    private String password;
    private boolean active;
    private String employeeId;
}

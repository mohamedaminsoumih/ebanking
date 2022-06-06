package ma.soumih.ebankingbackend.dtos;

import lombok.Data;
import ma.soumih.ebankingbackend.enums.OperationType;

import java.util.Date;


@Data
public class AccountOperationDTO {
    private Long id;
    private Date operationDate;
    private double amount;
    private String description;
    private OperationType type;
}

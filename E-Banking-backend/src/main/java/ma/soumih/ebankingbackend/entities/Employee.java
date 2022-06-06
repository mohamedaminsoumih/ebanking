package ma.soumih.ebankingbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.soumih.ebankingbackend.security.entities.AppUser;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EMPLOYEE")
@Data @NoArgsConstructor @AllArgsConstructor
public class Employee extends AppUser {
    private String employeeId;
}

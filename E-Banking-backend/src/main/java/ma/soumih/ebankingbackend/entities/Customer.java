package ma.soumih.ebankingbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.soumih.ebankingbackend.security.entities.AppUser;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("CUSTOMER")
@Data @NoArgsConstructor @AllArgsConstructor
public class Customer extends AppUser {
    //@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;
    private String name;
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<BankAccount> bankAccounts;
}

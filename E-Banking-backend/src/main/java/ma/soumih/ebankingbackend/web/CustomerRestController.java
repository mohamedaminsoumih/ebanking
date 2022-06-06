package ma.soumih.ebankingbackend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.soumih.ebankingbackend.dtos.BankAccountDTO;
import ma.soumih.ebankingbackend.dtos.CustomerDTO;
import ma.soumih.ebankingbackend.dtos.InCustomerDTO;
import ma.soumih.ebankingbackend.exceptions.AppRoleNotFoundException;
import ma.soumih.ebankingbackend.exceptions.CustomerNotFoundException;
import ma.soumih.ebankingbackend.exceptions.EmployeeNotFoundException;
import ma.soumih.ebankingbackend.mappers.BankAccountMapper;
import ma.soumih.ebankingbackend.services.BankAccountService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class CustomerRestController {

    private BankAccountService bankAccountService;
    private BankAccountMapper dtoMapper;

    @GetMapping("/customers")
    private List<CustomerDTO> customerList() {
        // print security context
        log.info("Security context: " + SecurityContextHolder.getContext().getAuthentication());
        return bankAccountService.listCustomers();
    }

    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomer(@PathVariable(name = "id", required = true) String id) throws CustomerNotFoundException {
        return bankAccountService.getCustomer(id);
    }

    // save customer
    @PostMapping("/customers")
    public CustomerDTO saveCustomer(@RequestBody InCustomerDTO customerDTO) throws AppRoleNotFoundException, EmployeeNotFoundException {
        return bankAccountService.saveCustomer(customerDTO);
    }

    // update customer
    @PutMapping("/customers/{id}")
    public CustomerDTO updateCustomer(@PathVariable String id, @RequestBody InCustomerDTO customerDTO) throws CustomerNotFoundException {
        customerDTO.setUserId(id);
        return bankAccountService.updateCustomer(customerDTO);
    }

    // delete customer
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable(name = "id", required = true) String id) throws CustomerNotFoundException {
        bankAccountService.deleteCustomer(id);
    }

    @GetMapping("/customers/{id}/accounts")
    public List<BankAccountDTO> getCustomerAccounts(@PathVariable(name = "id", required = true) String id) throws CustomerNotFoundException {
        return bankAccountService.getCustomerAccounts(id);
    }

    // search customer
    @GetMapping("/customers/search")
    public List<CustomerDTO> searchCustomer(@RequestParam(name = "name", defaultValue = "") String name) {
        System.out.println("name " + name);
        return bankAccountService.searchCustomer(name);
    }

    /*
    @GetMapping("/customers/current")
    public CustomerDTO getCurrentUser(HttpServletRequest request) throws CustomerNotFoundException {
        String token = request.getHeader(JWTUtility.HEADER_STRING).substring(JWTUtility.TOKEN_PREFIX.length());
        String username = JWTUtility.validateToken(token);
        System.out.println("Username: "+username);
        return bankAccountService.getCustomerByUsername(username);
    }*/

}

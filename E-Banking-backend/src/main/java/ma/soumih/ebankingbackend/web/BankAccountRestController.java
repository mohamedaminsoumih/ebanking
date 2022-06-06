package ma.soumih.ebankingbackend.web;

import lombok.AllArgsConstructor;
import ma.soumih.ebankingbackend.dtos.*;
import ma.soumih.ebankingbackend.exceptions.BankAccountNotFoundException;
import ma.soumih.ebankingbackend.exceptions.CustomerNotFoundException;
import ma.soumih.ebankingbackend.exceptions.InsufficientBalanceException;
import ma.soumih.ebankingbackend.services.BankAccountService;
import me.janah.ebankingbackend.dtos.*;
import me.soumih.ebankingbackend.dtos.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class BankAccountRestController {

    private BankAccountService bankAccountService;

    // all bank accounts
    @GetMapping("/accounts")
    public List<BankAccountDTO> getAllBankAccounts() {
        return bankAccountService.getAllBankAccounts();
    }

    @GetMapping("/accounts/{id}")
    public BankAccountDTO getBankAccountById(@PathVariable String id) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(id);
    }

    @PostMapping("/accounts")
    public BankAccountDTO saveBankAccount(@RequestBody InBankAccountDTO bankAccountDTO) throws CustomerNotFoundException {
        return bankAccountService.saveBankAccount(bankAccountDTO);
    }

    @GetMapping("/accounts/{id}/operations")
    public List<AccountOperationDTO> getAccountHistory(@PathVariable String id) throws BankAccountNotFoundException {
        return bankAccountService.accountOperationsHistory(id);
    }

    @GetMapping("/accounts/{id}/pageOperations")
    public AccountHistoryDTO getAccountHistory(@PathVariable String id,
                                               @RequestParam(name = "page", defaultValue = "0") int page,
                                               @RequestParam(name = "size", defaultValue = "5") int size) throws BankAccountNotFoundException {
        return bankAccountService.getAccountHistory(id, page, size);
    }

    @PostMapping("/accounts/credit")
    public HashMap<String, String> credit(@RequestBody CreditRequestDTO creditRequestDTO) throws BankAccountNotFoundException {
        bankAccountService.credit(creditRequestDTO.getAccountId(), creditRequestDTO.getAmount(), creditRequestDTO.getDescription());

        return new HashMap<String, String>() {{
                    put("message", "Operation successful");
                }};
    }

    @PostMapping("/accounts/debit")
    public HashMap<String, String> debit(@RequestBody DebitRequestDTO debitRequestDTO) throws BankAccountNotFoundException, InsufficientBalanceException {
        bankAccountService.debit(debitRequestDTO.getAccountId(), debitRequestDTO.getAmount(), debitRequestDTO.getDescription());

        return new HashMap<String, String>() {{
            put("message", "Operation successful");
        }};
    }

    @PostMapping("/accounts/transfer")
    public HashMap<String, String> transfer(@RequestBody TransferRequestDTO transferRequestDTO) throws BankAccountNotFoundException, InsufficientBalanceException {
        bankAccountService.transfer(transferRequestDTO.getFromAccountId(), transferRequestDTO.getToAccountId(),
                transferRequestDTO.getAmount(), transferRequestDTO.getDescription());

        return new HashMap<String, String>() {{
            put("message", "Operation successful");
        }};
    }
}

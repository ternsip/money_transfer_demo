import java.math.BigDecimal;

public class TransactionService {

    private AccountRepository accountRepository;

    public TransactionService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void passTransaction(AccountTransaction accountTransaction) {
        if (accountTransaction.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("You can't operate with that sum");
        }
        Account accountFrom = accountRepository.read(accountTransaction.getFromAccountId());
        Account accountTo = accountRepository.read(accountTransaction.getToAccountId());
        if (accountFrom.getBalance().compareTo(accountTransaction.getAmount()) >= 0) {
            accountTo.setBalance(accountTo.getBalance().add(accountTransaction.getAmount()));
            accountFrom.setBalance(accountFrom.getBalance().subtract(accountTransaction.getAmount()));
        } else {
            throw new IllegalArgumentException("Insufficient funds on the sender's account");
        }
        accountRepository.save(accountFrom);
        accountRepository.save(accountTo);
    }

}

import java.io.IOException;
import java.math.BigDecimal;

public class ApplicationDemo {

    public static void main(String[] args) throws IOException {

        // Key-Value account database in-memory embedded
        AccountRepository accountRepository = new AccountRepository();

        // Service to make balance transactions, single-threaded
        TransactionService transactionService = new TransactionService(accountRepository);

        // Starting HTTP server on port 8000
        RestServer restServer = new RestServer(8000, transactionService, accountRepository);

        // Pre-defined accounts
        Account account1 = new Account("1", "Ben", BigDecimal.valueOf(100L));
        Account account2 = new Account("2", "Randy", BigDecimal.valueOf(200L));
        Account account3 = new Account("3", "Bill", BigDecimal.valueOf(10L));
        accountRepository.save(account1);
        accountRepository.save(account2);
        accountRepository.save(account3);

        /*
         * By default it is allowed only to read_all (via http://localhost:8000/accounts)
         * and transfer money via (http://localhost:8000/send)
         * For transferring money use POST BODY - {"amount": "23","fromAccountId": "1","toAccountId": "2"}
         */

    }

}

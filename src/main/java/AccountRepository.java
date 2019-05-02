import lombok.SneakyThrows;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AccountRepository {

    private Map<String, Account> accounts = new HashMap<>();

    @SneakyThrows
    public Account read(String id) {
        Account account = accounts.get(id);
        if (account == null) {
            throw new IllegalArgumentException("Account not found with id: " + id);
        }
        return account;
    }

    @SneakyThrows
    public void save(Account account) {
        accounts.put(account.getId(), account);
    }

    public Collection<Account> readAll() {
        return accounts.values();
    }
}

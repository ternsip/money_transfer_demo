import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import lombok.SneakyThrows;

class AccountsHandler extends BaseHandler {

    private AccountRepository accountRepository;

    public AccountsHandler(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @SneakyThrows
    public void handle(HttpExchange httpExchange) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(accountRepository.readAll());
            finish(httpExchange, json, 200);
        } catch (Exception e) {
            finish(httpExchange, "Transaction can not be completed: " + e.getMessage(), 400);
        }
    }

}

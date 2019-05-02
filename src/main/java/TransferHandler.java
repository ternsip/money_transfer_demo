import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import lombok.SneakyThrows;

class TransferHandler extends BaseHandler {

    private TransactionService transactionService;

    TransferHandler(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @SneakyThrows
    public void handle(HttpExchange httpExchange) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            AccountTransaction accountTransaction = objectMapper.readValue(
                    httpExchange.getRequestBody(),
                    AccountTransaction.class
            );
            transactionService.passTransaction(accountTransaction);
            finish(httpExchange, "Transaction has been completed", 200);
        } catch (Exception e) {
            finish(httpExchange, "Transaction can not be completed: " + e.getMessage(), 400);
        }
    }

}

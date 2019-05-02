import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class RestServer {

    private TransactionService transactionService;
    private AccountRepository accountRepository;

    public RestServer(
            int port,
            TransactionService transactionService,
            AccountRepository accountRepository
    ) throws IOException {
        this.transactionService = transactionService;
        this.accountRepository = accountRepository;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/send", new TransferHandler(this.transactionService));
        server.createContext("/accounts", new AccountsHandler(this.accountRepository));
        server.setExecutor(null);
        server.start();
    }


}

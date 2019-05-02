import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import lombok.SneakyThrows;

import java.io.OutputStream;

abstract class BaseHandler implements HttpHandler {

    @SneakyThrows
    void finish(HttpExchange httpExchange, String responseBody, int code) {
        httpExchange.sendResponseHeaders(code, responseBody.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(responseBody.getBytes());
        os.close();
    }

}

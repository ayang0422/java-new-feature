package icu.zheteng;

import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletionStage;

/**
 * @author yancy
 * @date 2023年04月11日
 */

public class WebSocketTest {

    static WebSocket.Listener listener = new WebSocket.Listener() {
        @Override
        public void onOpen(WebSocket webSocket) {
            System.out.println("123");
            webSocket.sendText("Hello, WebSocket!", true);
        }

        @Override
        public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
            System.out.println("Received message: " + data);
            webSocket.sendText("1", true);
            return null;
        }

        @Override
        public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
            System.out.println("WebSocket closed with status code " + statusCode + ", reason: " + reason);
            return null;
        }

        @Override
        public void onError(WebSocket webSocket, Throwable error) {
            System.out.println("WebSocket error: " + error.getMessage());
        }
    };

    public static void main(String[] args) throws Exception {

        // 启动 websocket 服务端
        WebServerEnum.server.init(new MsgWebSocketServer(8090));

        HttpClient client = HttpClient.newHttpClient();
        WebSocket webSocket = client.newWebSocketBuilder()
                .connectTimeout(Duration.of(10L, ChronoUnit.SECONDS))
                .buildAsync(URI.create("ws://localhost:8090"), listener).join();

        Thread.sleep(5000); // wait for 5 seconds
        webSocket.sendText("How are you?", true);

        Thread.sleep(5000); // wait for 5 seconds
        webSocket.sendClose(java.net.http.WebSocket.NORMAL_CLOSURE, "Goodbye, WebSocket").join();

        WebServerEnum.server.shutdown();

    }


    static class MsgWebSocketServer extends WebSocketServer {
        public MsgWebSocketServer(int port) {
            super(new InetSocketAddress(port));
        }

        @Override
        public void onOpen(org.java_websocket.WebSocket conn, ClientHandshake handshake) {
            System.out.println("is open");
        }

        @Override
        public void onClose(org.java_websocket.WebSocket conn, int code, String reason, boolean remote) {
            System.out.println("is close");
        }

        @Override
        public void onMessage(org.java_websocket.WebSocket conn, String message) {
            System.out.println("get message : " + message);
        }

        @Override
        public void onError(org.java_websocket.WebSocket conn, Exception ex) {
            System.out.println("is error:" + ex.getMessage());
        }

        /**
         * 当服务器成功启动时调用
         */
        @Override
        public void onStart() {
            System.out.println("------------------onStart-------------------");
        }
    }

    public enum WebServerEnum {

        server;

        private static MsgWebSocketServer socketServer = null;

        public static void init(MsgWebSocketServer server) {
            socketServer = server;
            if (socketServer != null) {
                socketServer.start();
            }
        }

        public static void shutdown() throws IOException, InterruptedException {
            socketServer.stop();
        }
    }
}

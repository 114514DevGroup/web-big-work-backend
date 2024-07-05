package com.DevGroup114514;
/*
 * @Author 古佳乐
 * @Date 2024/7/5
 * @Description
 */

import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.InetSocketAddress;

import com.google.gson.Gson;

public class Server {
    private static Controller controller;
    private static final Gson gson = new GsonBuilder().create();

    public static void main(String[] args) {
        controller = new Controller();

        HttpServer httpServer = null;
        try {
            httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        httpServer.createContext("/userManager/register", new UserManagerRegister());
        httpServer.createContext("/userManager/login", new UserManagerLogin());
        // httpServer.createContext("/userManager/delate", new UserManagerDelete());
        // httpServer.createContext("/userManager/setting", new UserManagerSetting());

        // httpServer.createContext("/videoManager/send/sendVedio",new VideoManageSendVideo());
        httpServer.createContext("/videoManager/send/getRandomVedio", new VideoManageGetRandomVideo());
        // httpServer.createContext("/videoManager/change/deleteVedio", new VideoManageDeleteVideo());

        // httpServer.createContext("/userCount/setting", new UserCountSetting());

        httpServer.setExecutor(null);
    }


    static class UserManagerRegister implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            if (httpExchange.getRequestMethod().equals("POST")) {
                Reader reader = new InputStreamReader(httpExchange.getRequestBody());
                UserLogin userLogin = gson.fromJson(reader, UserLogin.class);

                if (controller.register(userLogin.username, userLogin.password)) {
                    String response = gson.toJson(controller.login(userLogin.username, userLogin.password));

                    httpExchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
                    httpExchange.sendResponseHeaders(200, response.getBytes().length);
                    OutputStream os = httpExchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                } else {
                    httpExchange.sendResponseHeaders(401, 0);
                }
            }
        }
    }

    static class UserManagerLogin implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            if (httpExchange.getRequestMethod().equals("POST")) {
                Reader reader = new InputStreamReader(httpExchange.getRequestBody());
                UserLogin userLogin = gson.fromJson(reader, UserLogin.class);

                User user = controller.login(userLogin.username, userLogin.password);

                if (user != null) {
                    String response = gson.toJson(user);

                    httpExchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
                    httpExchange.sendResponseHeaders(200, response.getBytes().length);
                    OutputStream os = httpExchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                } else {
                    httpExchange.sendResponseHeaders(401, 0);
                }
            }
        }
    }

// static class UserManagerDelete implements HttpHandler {
//     @Override
//     public void handle(HttpExchange httpExchange) throws IOException {
//         if (httpExchange.getRequestMethod().equals("DELETE")) {
//
//         }
//     }
// }
//
// static class UserManagerSetting implements HttpHandler {
//     @Override
//     public void handle(HttpExchange httpExchange) throws IOException {
//         if (httpExchange.getRequestMethod().equals("POST")) {
//
//         }
//     }
// }
// static class VideoManageSendVideo implements HttpHandler {
//     @Override
//     public void handle(HttpExchange httpExchange) throws IOException {
//         if (httpExchange.getRequestMethod().equals("POST")) {
//
//         }
//     }
// }

static class VideoManageGetRandomVideo implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            if (httpExchange.getRequestMethod().equals("GET")) {
                Video[] videos = controller.getRandomVideo();

                if (videos != null) {
                    String response = gson.toJson(videos);

                    httpExchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
                    httpExchange.sendResponseHeaders(200, response.getBytes().length);
                    OutputStream os = httpExchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                }
            }
        }
    }

// static class VideoManageDeleteVideo implements HttpHandler {
//     @Override
//     public void handle(HttpExchange httpExchange) throws IOException {
//         if (httpExchange.getRequestMethod().equals("DELETE")) {
//
//         }
//     }
// }
// static class UserCountSetting implements HttpHandler {
//         @Override
//         public void handle(HttpExchange httpExchange) throws IOException {
//             if (httpExchange.getRequestMethod().equals("PUT")) {
//
//             }
//         }
//     }

class UserLogin {
        String username;
        String password;
    }
}

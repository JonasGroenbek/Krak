package krak.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

public class CorsUtil {

    public static ResponseBuilder cors(ResponseBuilder response) {
        response.header("Access-Control-Allow-Origin", "*");
        response.header("Access-Control-Allow-Credentials", "True");
        response.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        response.header("Access-Control-Allow-Headers", "Origin, Accept, Content-Type");
        
        return response;
    }

}

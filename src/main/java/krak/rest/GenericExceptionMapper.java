package krak.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import krak.exception.ErrorMessage;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Response toResponse(Throwable exception) {
        ErrorMessage errorMessage = new ErrorMessage(
                "An error occurred.",
                500,
                "This message has been displayed, because the data was inavalid, please use another parameter as data",
                exception.getCause());
        return Response.status(Status.NOT_FOUND).entity(gson.toJson(errorMessage)).build();
    }
}

package Rest;

import exception.ErrorMessage;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(),
                500,
                "This message has been displayed, because the data was inavalid, please use another parameter as data");
        return Response.status(Status.NOT_FOUND).type(MediaType.APPLICATION_JSON).entity(errorMessage).build();
    }
}

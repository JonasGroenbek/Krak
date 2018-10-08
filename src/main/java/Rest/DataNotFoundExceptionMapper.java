/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import exception.DataNotFoundException;
import exception.DataNotFoundException;
import exception.ErrorMessage;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author kristoffer
 */
//denne annotation, registrere at vi har mappet en exception til JAX-RS klienten
// dette svarer til at deklare en klasse i java 
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

    @Override
    public Response toResponse(DataNotFoundException exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(),
                404,
                "This message has been displayed, because the data was inavalid, please use another parameter as data");
        return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
    }

}

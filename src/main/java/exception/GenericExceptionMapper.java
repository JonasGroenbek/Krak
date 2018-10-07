/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

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

//dette fungere ligesom et hierki, så først, kommer de laveste i hierkiet, og denne bliver kaldt, hvis der ikke er andre exceptions, der er fundet inden
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {



    @Override
    public Response toResponse(Throwable exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(),
                500,
                "This message has been displayed, because the data was inavalid, please use another parameter as data");
        return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
    }
    }



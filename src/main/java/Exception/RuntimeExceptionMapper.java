/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author kristoffer
 */
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException>{

    @Override
    public Response toResponse(RuntimeException exception) {
        return Response.status(Status.INTERNAL_SERVER_ERROR).header("x-resaon", exception.getMessage()).build();
    }
    
}

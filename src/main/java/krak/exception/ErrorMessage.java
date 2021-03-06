/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package krak.exception;

/**
 *
 * @author kristoffer
 */
 public class ErrorMessage {
    
    private String errorMessage;
    private int errorCode;
    private String documentation;
    private Throwable cause;

    public ErrorMessage(String errorMessage, int errorCode, String documentation, Throwable cause) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.documentation = documentation;
        this.cause = cause;
    }

    public ErrorMessage() {
    }

    public ErrorMessage(String message, int i, String this_message_has_been_displayed_because_t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }
    
    
}

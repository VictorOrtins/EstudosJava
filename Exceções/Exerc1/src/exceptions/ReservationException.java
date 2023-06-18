package exceptions;

public class ReservationException extends Exception{
    private String message;

    public ReservationException(){
        message = null;
    }

    public ReservationException(String message) {
        this.message = message;
    }


    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

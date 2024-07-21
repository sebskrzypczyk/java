package model;

import helpers.Functions;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mail {
    private String to;
    private String subject;
    private String message;

    public Mail(String to) {
        this.to = to;
        String dateNow = Functions.getDateNow();
        this.subject = "Subject " + dateNow;
        this.message = "Message " + dateNow;
    }
}

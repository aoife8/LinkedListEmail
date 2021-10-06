package activity;

public class Gmail {
    private String sender;
    private String recipient;
    private Emails email;
    private String subject;
    private String message;
    private Emails attachment;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String Recipient) {
        this.recipient = recipient;
    }

    public Emails getEmail() {
        return email;
    }

    public void setEmail(Emails email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Emails getAttachment() {
        return attachment;
    }

    public void setAttachment(Emails attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "Sender: " + sender + "\nRecepient: " + email + "\nSubject: " + subject + "\nMessage: "+message + "\nAttachment: " + attachment;
    }
}


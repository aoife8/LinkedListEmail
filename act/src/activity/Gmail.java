package activity;

import java.io.File;
import java.util.Objects;

public class Gmail {
    private String sender;
    private MyList<String> recipient;
    private String subject;
    private String message;
    private MyList<File> attachment;
    public Gmail(){

    }
    public Gmail(String sender, MyList<String> recipient, String subject, String message, MyList<File> attachment) {
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
        this.message = message;
        this.attachment = attachment;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public MyList<String> getRecipient() {
        return recipient;
    }

    public void setRecipient(MyList<String> recipient) {
        this.recipient = recipient;
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

    public MyList<File> getAttachment() {
        return attachment;
    }

    public void setAttachment(MyList<File> attachment) {
        this.attachment = attachment;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Gmail other = (Gmail) obj;
        if (!Objects.equals(this.sender, other.sender)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "----------------------------------"+
                "\nSender: " + sender +
                "\nRecepient: " + recipient +
                "\nSubject: " + subject +
                "\nMessage: "+message +
                "\nAttachment: " + attachment+
                "\n----------------------------------";
    }
}

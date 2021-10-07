package activity;

import java.io.File;
import java.util.Objects;

public class Gmail {
    private String sender;
    private MyLinkedList<String> recipient;
    private String subject;
    private String message;
    private MyLinkedList<File> attachment;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public MyLinkedList<String> getRecipient() {
        return recipient;
    }

    public void setRecipient(MyLinkedList<String> recipient) {
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

    public MyLinkedList<File> getAttachment() {
        return attachment;
    }

    public void setAttachment(MyLinkedList<File> attachment) {
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
        return "Sender: " + sender + "\nRecepient: " + email + "\nSubject: " + subject + "\nMessage: "+message + "\nAttachment: " + attachment;
    }
}

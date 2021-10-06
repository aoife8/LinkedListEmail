package activity;

public class Compose {

    private Emails email;
    private String subject;
    private String message;
    private MyLinkedList<String> attachment;


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

    public MyLinkedList<String> getAttachment() {
        return attachment;
    }

    public void setAttachment(MyLinkedList<String> attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "-------------------------------------------------" +
                "\nRecipient: " + email +
                "\nSubject: Re: " + subject +
                "\nMessage: "+ message +
                "\nAttachments: \n" + attachment +
                "\n-------------------------------------------------";
    }
}
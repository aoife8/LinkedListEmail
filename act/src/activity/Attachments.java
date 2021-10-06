package activity;

public class Attachments {
    private MyLinkedList<String> attachments;

    public MyLinkedList<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(MyLinkedList<String> attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return " " + attachments;
    }
}

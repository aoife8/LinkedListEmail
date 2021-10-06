import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class MyClass {
    public static void main(String[] args) {
        String[] choices = { "Exit", "Send Email", "See History", "Search
                Email", "See OutBox",
                "Display Last Send Email" };
        User user = new User();
        Scanner sc = new Scanner(System.in);
        while (true) {
            for (int i = 0; i < choices.length; i++) {
                System.out.println("[" + (i) + "] " + choices[i]);
            }
            System.out.println("Enter Yor choice ffrom [0 to 5]");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                //exit case
                case 0: {
                    return;
                }
                //send email
                case 1: {
                    System.out.println("Enter sender email Id");
                    String from = sc.nextLine();
                    System.out.println("Enter Receipt email Id");
                    String to = sc.nextLine();
                    System.out.println("Enter Subject of email");
                    String subject = sc.nextLine();
                    System.out.println("Enter text of email");
                    String text = sc.nextLine();
                    Email email = new Email(from, to, subject, text);
                    user.sendEmail(email);
                    //below code will call removeFromOutBox() after sending
                    mail after 5 second to empty outbox
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            user.removeFromOutBox();
                        }
                    }, 5000);
                    break;
                }
                //history of mail
                case 2: {
                    ArrayList<Email> historyOfSentEmail =
                            user.historyOfSentEmail();
                    if(historyOfSentEmail.size() == 0){
                        System.out.println("\n\tNo Emails In sent box Please
                                look into out box");
                    }
                    historyOfSentEmail.forEach(email ->
                            System.out.println(email));
                    break;
                }
                //searching of text in sent box
                case 3: {
                    System.out.println("enter text to search");
                    String text = sc.nextLine();
                    ArrayList<Email> searchEmail = user.searchEmail(text);
                    if(searchEmail.size() == 0){
                        System.out.println("\n\tNo Emails found which
                                contains this text = ["+text+"]");
                    }
                    searchEmail.forEach(email -> System.out.println(email));
                    break;
                }
                case 4: {
                    // display out box
                    ArrayList<Email> historyOfOutBox =
                            user.historyOfOutBox();
                    if(historyOfOutBox.size() == 0){
                        System.out.println("\n\tNo Emails In out box Please
                                look into sent box");
                    }
                    historyOfOutBox.forEach(email ->
                            System.out.println(email));
                    break;
                }
                // display last sent mail
                case 5: {
                    Email lastSent = user.LastSent();
                    if(lastSent == null){
                        System.out.println("Your sent box is empty. send your
                                first mail");
                    }
                    else{
                        System.out.println(lastSent);
                    }
                    break;
                }
                default: {
                    System.out.println("Invalid Choice");
                }
            }
        }
    }
}
class User {
    class Node {
        Email data;
        Node next;
        public Node(Email data) {
            this.data = data;
        }
    }
    Node outBox = null;
    Node sentbox = null;
    public ArrayList<Email> searchEmail(String text) {
        ArrayList<Email> searchResult = new ArrayList<Email>();
        Node temp = sentbox;
        while (temp != null) {
            //search text in (from, to ,subject and text ) for each email in
            sent box once found add into list
            if (temp.data.getText().contains(text) ||
                    temp.data.getSubject().contains(text)
                    || temp.data.getFrom().contains(text) ||
                    temp.data.getTo().contains(text))
                searchResult.add(temp.data);
            temp = temp.next;
        }
        return searchResult;
    }
    //returns last sent mail
    public Email LastSent() {
        if (sentbox != null)
            return sentbox.data;
        else
            return null;
    }
    //retus history of sent box
    public ArrayList<Email> historyOfSentEmail() {
        ArrayList<Email> historyOfSentEmail = new ArrayList<Email>();
        Node temp = sentbox;
        while (temp != null) {
            historyOfSentEmail.add(temp.data);
            temp = temp.next;
        }
        return historyOfSentEmail;
    }
    public ArrayList<Email> historyOfOutBox() {
        ArrayList<Email> historyOfOutBox = new ArrayList<Email>();
        Node temp = outBox;
        while (temp != null) {
            historyOfOutBox.add(temp.data);
            temp = temp.next;
        }
        return historyOfOutBox;
    }
    public void sendEmail(Email email) {
        addIntoOutBox(email);
    }
    public void addIntoOutBox(Email email) {
        Node newNode = new Node(email);
        if (outBox == null) {
            // tail's next will point to null, as it is the last node of the
            list
                    outBox = newNode;
        } else {
            Node temp = outBox;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    //add removed mail of outbox into sent box
    public void addIntoSentBox(Email email) {
        Node newNode = new Node(email);
        if (sentbox == null) {
            sentbox = newNode;
        } else {
            newNode.next = sentbox;
            sentbox = newNode;
        }
    }
    //removes email form out box and add into sent box
    public void removeFromOutBox() {
        if (outBox == null) {
            return;
        } else {
            Email remove = outBox.data;
            outBox = outBox.next;
            addIntoSentBox(remove);
        }
    }
}
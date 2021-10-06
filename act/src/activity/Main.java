package activity;

import java.util.Objects;
import java.util.Scanner;


public class Main {
    Scanner keyboard = new Scanner(System.in);
    public static void main(String [] args){
        MyLinkedList<Gmail> gmail = new MyLinkedList<>();
        MyLinkedList<Emails> email = new MyLinkedList<>();

        Emails a = new Emails();
        a.setEmail("abc@gmail.com");
        Emails b = new Emails();
        b.setEmail("def@gmail.com");
        Emails c = new Emails();
        c.setEmail("ghi@gmail.com");
        Emails d = new Emails();
        d.setEmail("jkl@gmail.com");

        email.add(a);
        email.add(b);
        email.add(c);
        email.add(d);

        Gmail gmail1 = new Gmail();
        gmail1.setEmail(a);
        gmail1.setEmail(c);
        gmail1.setMessage("Hello!");

        Gmail gmail2 = new Gmail();
        gmail2.setEmail(b);
        gmail2.setMessage("What?");

        gmail.add(gmail1);
        gmail.add(gmail2);


        System.out.println(gmail);
        gmail.delete(gmail1);
        System.out.println(gmail);

        /*
        Emails as = new Emails();
        Emails a = new Emails(email.add(as),message.add("Hello?"););
        message.add(a.setMessage("Hi I am abc"));
        a.setEmail("abc");
        email.add(a);
        Emails b = new Emails();
        message.add(b.setMessage("What are you doing?"));
        b.setEmail("def");
        email.add(b);
        System.out.println(email.getElement(a).getMessage());
         */

        Main runner = new Main();
//        runner.compose();
        runner.search(gmail);
    }
    public void search(MyLinkedList<Gmail> gmail){
        Scanner scan = new Scanner(System.in);
        String e;
        String g;
        Gmail inp = new Gmail();
        Emails ser = new Emails();
        System.out.println("Search");
        System.out.println("Enter email");
        e = scan.nextLine();
        System.out.println("Enter message");
        g = scan.nextLine();
        ser.setEmail(e);
        inp.setEmail(ser);
        inp.setMessage(g);
        if(gmail.search(inp)){
            System.out.println(gmail.getElement(inp).toString());
        }

    }
    public void compose(){
        System.out.println("Create new email");
        MyLinkedList<Gmail> gmail = new MyLinkedList<>();
        MyLinkedList<Emails> email = new MyLinkedList<>();

        Gmail newGmail = new Gmail();

        Emails sender = new Emails();
        Emails recipient = new Emails();
        Emails subject = new Emails();
        Emails message = new Emails();
        Emails attachment = new Emails();
        for (int i = 0; i < 5; i++){
            if (i == 1){
                System.out.print("How many Recipients?: ");
                int getNumber = Integer.parseInt(keyboard.nextLine());
                for (int j = 0; j < getNumber; j++){
                    System.out.print("Recipient: ");
                    String recipients = keyboard.nextLine();
                    recipient.setEmail(recipients);
                }
                email.add(recipient);
                newGmail.setEmail(recipient);
            } else if (i == 4){
                System.out.print("How many Attachments?: ");
                int getNumber = Integer.parseInt(keyboard.nextLine());
                for (int j = 0; j < getNumber; j++){
                    System.out.print("Recipient: ");
                    String attachments = keyboard.nextLine();
                    attachment.setEmail(attachments);
                }
                email.add(attachment);
            } else{
                String temp = "";
                if (i == 0){
                    System.out.print("Sender: ");
                    temp = keyboard.nextLine();
                    sender.setEmail(temp);
                    newGmail.setSender(temp);
                    email.add(sender);
                } else if (i == 2){
                    System.out.print("Subject: ");
                    temp = keyboard.nextLine();
                    subject.setEmail(temp);
                    email.add(subject);
                } else if (i == 3){
                    System.out.print("Message: ");
                    temp = keyboard.nextLine();
                    message.setEmail(temp);
                    newGmail.setMessage(temp);
                    email.add(message);
                }
            }
        }
        gmail.add(newGmail);
        System.out.println();
        System.out.println("This is the contents of the newly made email:");
        System.out.println("---------------------------------------------");
        System.out.println(gmail);
        System.out.println("---------------------------------------------");
    }
}

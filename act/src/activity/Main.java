package activity;

import java.util.Objects;
import java.util.Scanner;


public class Main {
    static Gmail gmail1 = new Gmail();
    static Gmail gmail2 = new Gmail();
    static Gmail gmail3 = new Gmail();
    static Gmail gmail4 = new Gmail();
    static Gmail gmail5 = new Gmail();

    static Emails a = new Emails();
    static Emails b = new Emails();
    static Emails c = new Emails();
    static Emails d = new Emails();
    static Emails e = new Emails();



    public static void main(String [] args){


        Main runner = new Main();
        runner.run();
    }
    public void run(){
        Scanner keyboard = new Scanner(System.in);
        MyLinkedList<Gmail> gmail = new MyLinkedList<>();
        MyLinkedList<Emails> email = new MyLinkedList<>();
        MyLinkedList<Compose> sent = new MyLinkedList<>();
        settingEmail(email);
        settingGmail(gmail);
        int i=0;
        do{
            System.out.println("1. inbox");
            System.out.println("2. compose");
            System.out.println("3. search");
            i = keyboard.nextInt();
            switch (i){
                case 1: inbox(gmail,email);
                    break;
                case 2: compose(sent,email);
                    break;
                case 3: search(gmail);
                    break;
            }
        }while (i!=4);


    }
    public static void inbox(MyLinkedList<Gmail> gmail,MyLinkedList<Emails> email){
        Scanner kbd =new Scanner(System.in);
        String keyboard = "";
        if(email.search("keyboard")) {
            try {
                do {
                    System.out.println("------------------");
                    System.out.println("      INBOX");
                    System.out.println("------------------");
                    System.out.println(email);
                    System.out.println("------------------\n");
                    System.out.println("Type back to exit!");
                    System.out.print("Please type the email you want to access: ");
                    keyboard = kbd.nextLine();
                    if (email.getElement(a).getEmail().equals(keyboard)) {
                        System.out.println(gmail1);
                        deleteExit(gmail1, gmail, email, a);
                    } else if (email.getElement(b).getEmail().equals(keyboard)) {
                        System.out.println(gmail2);
                        deleteExit(gmail2, gmail, email, b);
                    } else if (email.getElement(c).getEmail().equals(keyboard)) {
                        System.out.println(gmail3);
                        deleteExit(gmail3, gmail, email, c);
                    }
                    else if (email.getElement(d).getEmail().equals(keyboard)) {
                        System.out.println(gmail4);
                        deleteExit(gmail4, gmail, email, d);
                    } else if (email.getElement(e).getEmail().equals(keyboard)) {
                        System.out.println(gmail5);
                        deleteExit(gmail5, gmail, email, e);
                    } else if (keyboard.equalsIgnoreCase("back")) {
                        return;
                    }
                } while (email.search(keyboard));
            }catch (NullPointerException e){
                System.out.println("Email not found");
                return;
            }
        }
        System.out.println("How many emails are there?: " + gmail.getSize());
    }

    private static void settingEmail(MyLinkedList<Emails> email){
        a.setEmail("apple@gmail.com");
        b.setEmail("banana@gmail.com");
        c.setEmail("cake@gmail.com");
        d.setEmail("donut@gmail.com");
        e.setEmail("egg@gmail.com");

        email.add(a);
        email.add(b);
        email.add(c);
        email.add(d);
        email.add(e);
    }
    private static void settingGmail(MyLinkedList<Gmail> gmail){
        //1st email
        MyLinkedList<String> attach1 = new MyLinkedList<>(); //list of attachments
        attach1.add("Resume.pdf");
        attach1.add("Job.docs");

        gmail1.setEmail(a); //set recipient/email for gmail1
        gmail1.setSubject("Who are you?"); //set subject for gmail1
        gmail1.setMessage("Is this really you?"); //set message for gmail 1
        gmail1.setAttachment(attach1); //set attachments for gmail 1

        //2nd email
        MyLinkedList<String> attach2 = new MyLinkedList<>(); //list of attachments
        attach2.add("foods.pdf");
        attach2.add("diagram.docs");
        attach2.add("pyramid.pdf");

        //create new Gmail named gmail1
        gmail2.setEmail(b);
        gmail2.setSubject("Submission of activity ");
        gmail2.setMessage("Activity is due today");
        gmail2.setAttachment(attach2);

        //3rd email
        MyLinkedList<String> attach3 = new MyLinkedList<>(); //list of attachments
        attach3.add("act1.pdf");
        attach3.add("act2.docs");
        attach3.add("act3.pdf");

        //create new Gmail named gmail1
        gmail3.setEmail(c);
        gmail3.setSubject("Start Up");
        gmail3.setMessage("Start Up is coming soon, Ready your Gear!");

        //4th email
        MyLinkedList<String> attach4 = new MyLinkedList<>();
        attach4.add("Wedding.pdf");
        attach4.add("WedInvitation.docs");
        attach4.add("graduation.pdf");

        //create new Gmail
        gmail4.setEmail(d);
        gmail4.setSubject("Wedding ");
        gmail4.setMessage("Will you marry me?");
        gmail4.setAttachment(attach4);

        //5th email
        MyLinkedList<String> attach5 = new MyLinkedList<>(); //list of attachments
        attach5.add("Avocado.pdf");
        attach5.add("Farm of Avocado.docs");
        attach5.add("Ripe avocado.pdf");

        //create new Gmail
        gmail5.setEmail(e);
        gmail5.setSubject("Farm");
        gmail5.setMessage("The farm is full of avocado, come here to get all!");
        gmail5.setAttachment(attach5);

        //Adds the new gmails/emails to gmail
        gmail.add(gmail1);
        gmail.add(gmail2);
        gmail.add(gmail3);
        gmail.add(gmail4);
        gmail.add(gmail5);
    }

    public static void deleteExit(Gmail gmailClass,MyLinkedList<Gmail> gmailList,MyLinkedList<Emails> email,Emails letter){
        Scanner kbd = new Scanner(System.in);
        String mouse = "";
        System.out.println("Delete? Type delete");
        System.out.println("Exit? Type back");
        mouse = kbd.nextLine();
        if(mouse.equalsIgnoreCase("delete")){
            gmailList.delete(gmailClass);
            email.delete(letter);
            inbox(gmailList,email);
        }else if(mouse.equalsIgnoreCase("back")){
            inbox(gmailList,email);
        }
    }


    public void search( MyLinkedList<Gmail> gmail){
        Scanner scan = new Scanner(System.in);
        Object e;
        System.out.println("Search");
        System.out.println("Type the email you want to search");
        e = scan.nextLine();
        gmail.search(e);
        if(gmail.search(e)){
            System.out.println(gmail.getElement(e));
        }
    }

    public void compose(MyLinkedList<Compose> sent,MyLinkedList<Emails> email){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Create new email");
        Compose sent1 = new Compose();

        //Store these all on gmail or make a new class for sent emails

        //ask how many recipients
        System.out.print("Recipient: ");
        Emails f  = new Emails();
        f.setEmail(keyboard.nextLine());
        email.add(f);
        sent1.setEmail(f);
        System.out.print("Subject: ");
        sent1.setSubject(keyboard.nextLine());
        System.out.print("Message: ");
        sent1.setMessage(keyboard.nextLine());
        //ask how many attachments
        System.out.print("Attachments: ");
        MyLinkedList<String> attach6 = new MyLinkedList<>();
        attach6.add(keyboard.nextLine());
        sent1.setAttachment(attach6);

        sent.add(sent1);
        System.out.println();
        System.out.println("This is the contents of the newly made email:");
        System.out.println("---------------------------------------------");
        System.out.println("Recipient: " + sent1.getEmail());
        System.out.println("Subject: " + sent1.getSubject());
        System.out.println("Message: " + sent1.getMessage());
        System.out.println("Sender: " + sent1.getAttachment());
        System.out.println("Size ni email: " + email.getSize());
        System.out.println("---------------------------------------------");
        System.out.println();
        System.out.println("Lahat ng Sent:");
        System.out.println(sent);
        System.out.println("Ilang sent na meron?: " + sent.getSize());
        System.out.println();
    }
/*
    public void compose(MyLinkedList<Gmail> gmail,MyLinkedList<Emails> email){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Create new email");
        Gmail newGmail = new Gmail();
        Emails newEmail = new Emails();
        Emails newAttachment = new Emails();

        Emails sender = new Emails(); //String
        MyLinkedList<String> recipient = new MyLinkedList();//List
        Emails subject = new Emails();//String
        Emails message = new Emails();//String
        MyLinkedList<String> attachment = new MyLinkedList();//List



        for (int i = 0; i < 5; i++){
            if (i == 1){
                System.out.print("How many Recipients?: ");
                int getNumber = Integer.parseInt(keyboard.nextLine());
                for (int j = 0; j < getNumber; j++){
                    System.out.print("Recipient: ");
                    String recipients = keyboard.nextLine();
                    recipient.add(recipients);
                }
                newEmail.setLinkedListEmail(recipient);
                email.add(newEmail);
                newGmail.setEmail(recipient);
            } else if (i == 4){
                System.out.print("How many Attachments?: ");
                int getNumber = Integer.parseInt(keyboard.nextLine());
                for (int j = 0; j < getNumber; j++){
                    System.out.print("Attachment: ");
                    String attachments = keyboard.nextLine();
                    attachment.add(attachments);
                }
                newAttachment.setLinkedListAttachment(attachment);
                email.add(newAttachment);
                newGmail.setAttachment(attachment);
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
                    newGmail.setSubject(temp);
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
        System.out.println("Sender: " + newGmail.getSender());
        System.out.println("Recipient: " + newGmail.getEmail());
        System.out.println("Subject: " + newGmail.getSubject());
        System.out.println("Message: " + newGmail.getMessage());
        System.out.println("Sender: " + newGmail.getAttachment());
        System.out.println("Size ni email: " + email.getSize());
        System.out.println("---------------------------------------------");
        System.out.println();
        System.out.println("All Emails:");
        System.out.println(gmail);
        System.out.println("How many emails are there?: " + gmail.getSize());
        System.out.println();
    }

 */
}

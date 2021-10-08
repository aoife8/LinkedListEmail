package activity;
import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static MyList<Gmail> inbox = new MyLinkedList<>();
    static MyList<Gmail> sent = new MyLinkedList<>();

    static Gmail sentMail = new Gmail();

    static Gmail gmail1 = new Gmail();
    static Gmail gmail2 = new Gmail();
    static Gmail gmail3 = new Gmail();

    static MyList<String> emailAddress = new MyLinkedList<>();
    static MyList<String> listOfSubjects = new MyLinkedList<>();

    static Scanner keyboard = new Scanner(System.in);
    public static void main(String [] args){

        settingGmail(inbox);
        setListOfSubjects(listOfSubjects);
        listEmail(emailAddress);
        Main runner = new Main();
        runner.run();
    }

    public void run(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("EMAIL MENU");
        System.out.println("-----------");
        int i=0;
        do{
            System.out.println("1. inbox");
            System.out.println("2. compose");
            System.out.println("3. search");
            System.out.println("4. sent");
            i = keyboard.nextInt();
            switch (i){
                case 1: inbox();
                    break;
                case 2: compose();
                    break;
                //               case 3: search();
//                    break;
                case 4: sent();
                    break;
            }
        }while (i!=5);
    }
    public static void inbox(){

        Scanner kbd =new Scanner(System.in);
        String keyboard = "";
        System.out.println("Choose an account");
        System.out.println("Type the account you want to choose");
        System.out.println("-----------------------------------");
        System.out.println(emailAddress);
        System.out.println("-----------------------------------");
        System.out.println("Type 'back' to go to the main menu.");
        keyboard = kbd.nextLine();

        if (keyboard.equalsIgnoreCase("back")) {
            Main son = new Main();
            son.run();
            return;
        }
        if(emailAddress.search(keyboard)){
            try {
                if (emailAddress.search(keyboard) ==("pawsociety@gmail.com".equalsIgnoreCase(keyboard))) {
                    System.out.println(gmail1);
                    deleteExit(gmail1, keyboard);
                } else if (emailAddress.search(keyboard) ==("violet@gmail.com".equalsIgnoreCase(keyboard))) {
                    System.out.println(gmail2);
                    deleteExit(gmail2, keyboard);
                } else if (emailAddress.search(keyboard) ==("andrews@gmail.com".equalsIgnoreCase(keyboard))) {
                    System.out.println(gmail3);
                    deleteExit(gmail3, keyboard);
                }else if ("back".equalsIgnoreCase(keyboard)) {
                    exit(keyboard);
                } else
                    System.out.println("Email not found");
                inbox();
            }catch (NullPointerException e){
                System.out.println("Email not found");
            }
        }else
            inbox();
    }
    private static void listEmail(MyList<String> emailAddress){
        emailAddress.add(gmail1.getSender());
        emailAddress.add(gmail2.getSender());
        emailAddress.add(gmail3.getSender());
    }
    private static void settingGmail(MyList<Gmail> gmail){
        MyList<String> reci = new MyLinkedList<>();
        reci.add("violet@gmail.com");
        //1st email
        MyLinkedList<File> attach1 = new MyLinkedList<>(); //list of attachments
        attach1.add(new File("receipt.txt"));
        attach1.add(new File("donation.docs"));

        gmail1.setRecipient(reci); //set recipient/email for gmail1
        gmail1.setSender("pawsociety@gmail.com");
        gmail1.setSubject("Adoption is open"); //set subject for gmail1
        gmail1.setMessage("Would you want to adopt a dog?"); //set message for gmail 1
        gmail1.setAttachment(attach1); //set attachments for gmail 1

        //2nd email
        MyLinkedList<File> attach2 = new MyLinkedList<>(); //list of attachments
        attach2.add(new File("wedding_plan.pdf"));

        //create new Gmail named gmail1
        gmail2.setRecipient(reci);
        gmail2.setSender("andrews@gmail.com");
        gmail2.setSubject("Are you ready?");
        gmail2.setMessage("I can't wait to marry you.");
        gmail2.setAttachment(attach2);

        //3rd email
        MyLinkedList<File> attach3 = new MyLinkedList<>(); //list of attachments
        attach3.add(new File("photos.pdf"));

        //create new Gmail named gmail1
        gmail3.setRecipient(reci);
        gmail3.setSender("violet@gmail.com");
        gmail3.setSubject("I love it!");
        gmail3.setMessage("Check the photos I sent you.");
        gmail3.setAttachment(attach3);


        //Adds the new gmails/emails to gmail
        gmail.add(gmail1);
        gmail.add(gmail2);
        gmail.add(gmail3);

    }
    public static void deleteExit(Gmail gmailClass,String keyboard){
        Scanner kbd = new Scanner(System.in);
        String mouse = "";
        System.out.println("Delete? Type delete");
        System.out.println("Exit? Type back");
        mouse = kbd.nextLine();
        if(mouse.equalsIgnoreCase("delete")){
            inbox.delete(gmailClass);
            emailAddress.delete(keyboard);
            inbox();
        }else if(mouse.equalsIgnoreCase("back")){
            inbox();
        }
    }public static void exit(String mouse){
        if(mouse.equalsIgnoreCase("back")){
            Main main = new Main();
            main.run();
        }
    }
    /* NEED HELP HERE!!!
        public void search(){
            Scanner scan = new Scanner(System.in);
            Object e;
            System.out.println("Search");
            System.out.println("Type the email you want to search");
            e = scan.nextLine();
            inbox.search(e);
            if(inbox.search(e)){
                System.out.println(inbox.getElement((Gmail) e));
            }
        }

     */
    public static void setListOfSubjects(MyList<String> listOfSubjects){

    }
    public void compose(){

        MyLinkedList<String> recipient = new MyLinkedList<>();
        String subject = "";
        String message = "";
        MyLinkedList<File> attachment = new MyLinkedList<>();
        String sender = "owner@gmail.com";

        System.out.println("CREATE NEW EMAIL");
        System.out.println("----------------");

        for (int i = 0; i < 5; i++){
            if (i == 1){
                recipient = new MyLinkedList<>();
                System.out.print("How many Recipients?: ");
                int getNumber = Integer.parseInt(keyboard.nextLine());
                for (int j = 0; j < getNumber; j++){
                    System.out.print("Recipient: ");
                    recipient.add(keyboard.nextLine());
                }
            } else if (i == 4){
                System.out.print("How many Attachments?: ");
                int getNumber = Integer.parseInt(keyboard.nextLine());
                for (int j = 0; j < getNumber; j++){
                    System.out.print("Attachment: ");
                    attachment.add(new File(keyboard.nextLine()));
                }

            }else
            if (i == 2){
                System.out.print("Subject: ");
                subject = keyboard.nextLine();

            } else if (i == 3) {
                System.out.print("Message: ");
                message = keyboard.nextLine();
            }

        }
        sentMail = new Gmail(sender,recipient,subject,message,attachment);

        sent.add(sentMail);
        System.out.println();
        System.out.println("This is the contents of the newly made email:");
        System.out.println("---------------------------------------------");
        System.out.println(sentMail);
        System.out.println("---------------------------------------------");
        System.out.println(sent);
        System.out.println(sent.getSize());
    }

    public void sent() {
        System.out.println(sent.getElement(sentMail).getSubject());

    }
}

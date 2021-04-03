package shollowdeepcopy;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Email email = new Email();
        email.subject ="Main";
        email.body="resdftyuiokjhgf";
        ArrayList<String> receiver = new ArrayList<>();
        receiver.add("sss@sss.com");
        email.receivers = receiver;
        List<Attachment> attachments = new ArrayList<>();

        Attachment attachment = new Attachment();
        attachment.length = 111;
        attachment.attachmentData ="pppp";

        attachments.add(attachment);
        email.attachmentList = attachments;

        Email shallowCopy = (Email) email.clone();
        for (Attachment att: shallowCopy.attachmentList) {
            System.out.println(att.getLength());
            System.out.println(att.getAttachmentData());
            System.out.println(email.subject);
        }
        System.out.println("_______*****" + email.toString());
        email.subject ="RRRR";
        Attachment attachment2 = new Attachment();
        attachment2.length = 222;
        attachment2.attachmentData ="eeeee";
        List<Attachment> attachments2 = new ArrayList<>();
        attachments2.add(attachment2);
        //email.attachmentList = attachments;
        shallowCopy.attachmentList = attachments2;
        for (Attachment att: shallowCopy.attachmentList) {
            System.out.println(att.getLength());
            System.out.println(att.getAttachmentData());
            System.out.println(email.subject);
        }
        System.out.println("_______*****" + shallowCopy.toString());

    }
}

package shollowdeepcopy;

import java.util.List;

public class Email implements Cloneable {
    String subject;
    String body;
    List<String> receivers;
    List<Attachment> attachmentList;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
}
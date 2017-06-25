package concurrency;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sun.javaws.jnl.XMLFormat;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by sudhirkumar on 6/1/17.
 */
public class Threads {

    public static void main(String[] args) throws ParseException, JsonProcessingException {
        Thread t = new MyThreadTest();
        System.out.println(t.getState());

        t.start();

        System.out.println(t.getState());
        System.out.println(Thread.currentThread().getName());

        /*JSONParser parser = new JSONParser();

        Emp foo = new Emp();
        foo.setAge("12");
        foo.setMessages(new String[]{"test", "eee"});
foo.setBlog("ttuioiuytyuio");

        XmlMapper xmlMapper = new XmlMapper();
        System.out.println(xmlMapper.writeValueAsString(foo));*/

    }
    }




class MyThreadTest extends Thread{


    @Override
    public synchronized void start() {
        run();
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread .. " + currentThread().getName()
        + currentThread().getPriority());
        super.run();
        System.out.println(currentThread().getState());

    }
}


class Emp {
    private String name;

    private String age;

    private String blog;

    private String[] messages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String[] getMessages() {
        return messages;
    }

    public void setMessages(String[] messages) {
        this.messages = messages;
    }
}
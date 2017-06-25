package java8;

import org.json.simple.JSONObject;

/**
 * Created by sudhirkumar on 5/31/17.
 */
public interface CustomRead {
    void write();

    default boolean read(){
        System.out.println(" From Interface ....");
        return true;
    }
}


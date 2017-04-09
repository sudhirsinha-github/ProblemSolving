package connectionpool.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by sudhirkumar on 3/12/17.
 */
public class Customer extends BaseService {
    public Customer() {
        super();
    }

    private static String getCustomerJson() {
        JSONObject object = new JSONObject();
        object.put("name", "Sudhir");
        object.put("company", "testco");

        return object.toJSONString();
    }

}

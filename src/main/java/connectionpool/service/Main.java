package connectionpool.service;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mongodb.MongoClient;

/**
 * Created by sudhirkumar on 3/12/17.
 */
public class Main {
    public static void main(String[] args) {

        Injector i = Guice.createInjector(new AppInj());

BaseService baseService = i.getInstance(BaseService.class);
baseService.insertDocument("{\n" +
        " \"Name\": {\n" +
        "   \"Title\": \"Mr\",\n" +
        "   \"GivenName\": \"Sudhir\",\n" +
        "   \"MiddleInitials\": \"\",\n" +
        "   \"FamilyName\": \"K\"\n" +
        " }\n" +
        "}", "cec");
    }
}


class AppInj extends AbstractModule{

    @Override
    protected void configure() {
        bind(BaseService.class);
    }
}

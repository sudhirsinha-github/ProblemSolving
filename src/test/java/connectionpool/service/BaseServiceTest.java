package connectionpool.service;

import com.mongodb.*;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by sudhirkumar on 3/12/17.
 */
public class BaseServiceTest {

    @Mock
    private MongoClient mongoClient;

    private BaseService service;

    @Before
    public void setUp() throws Exception {
        JSONObject object = new JSONObject();
        object.put("test","test");
    BaseService service = new BaseService(object.toJSONString(), "test");
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void insertDocument() throws Exception {
        DB db = mock(DB.class);
        when(mongoClient.getDB("nextgencec")).thenReturn(db);
        //BaseService service = new BaseService(Mockito.anyString(), Mockito.anyString());
        DBCollection collection = mock(DBCollection.class);
        WriteResult testResult = mock(WriteResult.class);
        when(testResult.wasAcknowledged()).thenReturn(true);

        when(db.getCollection("test")).thenReturn(collection);
        when(collection.insert(Mockito.any(BasicDBObject.class))).thenReturn(testResult);

        boolean result = service.insertDocument();
        assertEquals(result, true);
    }

}
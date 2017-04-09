package connectionpool.service;

import com.mongodb.*;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by sudhirkumar on 3/12/17.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({BaseService.class})
public class BaseServiceTest {
    @Mock
    MongoClient mongoClient ;

    private String jsonData;

    @InjectMocks
    private BaseService service;

    @Before
    public void setUp() throws Exception {

        JSONObject object = new JSONObject();
        object.put("name", "test");
        jsonData = object.toString();
    }

    @Test
    public void insertDocument() throws Exception {
        DB db = mock(DB.class);
        when(mongoClient.getDB("nextgencec")).thenReturn(db);
        DBCollection collection = mock(DBCollection.class);
        WriteResult testResult = mock(WriteResult.class);
        when(testResult.wasAcknowledged()).thenReturn(true);

        //when(BasicDBObject.parse(jsonData)).thenReturn(basicDBObject);
        when(db.getCollection("test")).thenReturn(collection);
        when(collection.insert(Mockito.any(BasicDBObject.class))).thenReturn(testResult);

        boolean result = service.insertDocument(jsonData, "test");
        assertEquals(result, true);
    }

}
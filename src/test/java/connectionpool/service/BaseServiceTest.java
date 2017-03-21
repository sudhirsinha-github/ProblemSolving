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
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by sudhirkumar on 3/12/17.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(BaseService.class)
public class BaseServiceTest {

    MongoClient mongoClient ;
    @InjectMocks
    private BaseService service = spy(new BaseService("",""));

    @Before
    public void setUp() throws Exception {
        JSONObject object = new JSONObject();
        BaseService serviceTest  = mock(BaseService.class);
        mongoClient = mock(MongoClient.class);
        PowerMockito.when(service,"getMongoClient").thenReturn(mongoClient);
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
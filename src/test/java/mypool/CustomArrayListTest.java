//package mypool;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//
///**
// * Created by sudhirkumar on 5/9/17.
// */
//@RunWith(PowerMockRunner.class)
//@PrepareForTest(CustomArrayList.class)
//public class CustomArrayListTest {
//
//
//    private CustomArrayList<String> testInstance = PowerMockito.spy(new CustomArrayList<>());
//
//
//    @Test
//    public void testAddUseCase(){
//
//
//        try {
//          PowerMockito.doReturn(5).when(testInstance, "ensureCapacity", Mockito.anyInt());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//       testInstance.add("jhj,k");
//    }
//
//
//
//
//
//
//
//
//}

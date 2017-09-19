package java8;

@FunctionalInterface
public interface Interface2 {

	void method2();
    default void log(String str){
		System.out.println("I2 logging::"+str);
	}
    default void log2(String str){
		System.out.println("I2 logging::"+str);
	}

}
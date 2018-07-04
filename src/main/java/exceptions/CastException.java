package exceptions;

public class CastException<T>{
    T method(T body)
    {
        return body;
    }
}

class Test<T> extends CastException<T>{

}
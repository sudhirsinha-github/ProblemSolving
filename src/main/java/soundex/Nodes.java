package soundex;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Nodes {
    public String Key;
    public String Value;

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}

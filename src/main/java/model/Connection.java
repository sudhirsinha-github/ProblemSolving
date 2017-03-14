package model;

/**
 * Created by sudhirkumar on 3/12/17.
 */
public class Connection {
    public String host;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPortNo(Integer portNo) {
        this.portNo = portNo;
    }

    public String getHost() {
        return host;
    }

    public Integer getPortNo() {
        return portNo;
    }

    public Integer portNo;
}

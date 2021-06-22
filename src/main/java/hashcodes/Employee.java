package hashcodes;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Employee {
    private String name;
    private String email;
    private String code;

    public Employee(String name, String email, String code) {
        this.name = name;
        this.email = email;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Employee employee = (Employee) o;
//
//        return new EqualsBuilder()
//                .append(email, employee.email)
//                .isEquals();
//    }

    @Override
    public int hashCode() {
        int i = new HashCodeBuilder(17, 37)
                .append(email)
                .toHashCode();

        System.out.println("HasCode is: " + i);

        return i;
    }
}

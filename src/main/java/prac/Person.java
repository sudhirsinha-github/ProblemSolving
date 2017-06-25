package prac;

/**
 * Created by sudhirkumar on 4/19/17.
 * Example for builder pattern
 */
public class Person
{
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final String salutation;
    private final String suffix;
    private final String streetAddress;
    private final String city;
    private final String state;
    private final boolean isFemale;
    private final boolean isEmployed;
    private final boolean isHomewOwner;

    public Person(
            final String newLastName,
            final String newFirstName,
            final String newMiddleName,
            final String newSalutation,
            final String newSuffix,
            final String newStreetAddress,
            final String newCity,
            final String newState,
            final boolean newIsFemale,
            final boolean newIsEmployed,
            final boolean newIsHomeOwner)
    {
        this.lastName = newLastName;
        this.firstName = newFirstName;
        this.middleName = newMiddleName;
        this.salutation = newSalutation;
        this.suffix = newSuffix;
        this.streetAddress = newStreetAddress;
        this.city = newCity;
        this.state = newState;
        this.isFemale = newIsFemale;
        this.isEmployed = newIsEmployed;
        this.isHomewOwner = newIsHomeOwner;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", salutation='" + salutation + '\'' +
                ", suffix='" + suffix + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", isFemale=" + isFemale +
                ", isEmployed=" + isEmployed +
                ", isHomewOwner=" + isHomewOwner +
                '}';
    }

    public static class PersonBuilder
    {
        private String nestedLastName="optional";
        private String nestedFirstName;
        private String nestedMiddleName;
        private String nestedSalutation;
        private String nestedSuffix;
        private String nestedStreetAddress;
        private String nestedCity;
        private String nestedState;
        private boolean nestedIsFemale;
        private boolean nestedIsEmployed;
        private boolean nestedIsHomeOwner;

        public PersonBuilder(
                /*final String newFirstName,
                final String newCity,
                final String newState*/)
        {
         /*   this.nestedFirstName = newFirstName;
            this.nestedCity = newCity;
            this.nestedState = newState;*/
        }

        public PersonBuilder lastName(String newLastName)
        {
            this.nestedLastName = newLastName;
            return this;
        }

        public PersonBuilder firstName(String newFirstName)
        {
            this.nestedFirstName = newFirstName;
            return this;
        }

        public PersonBuilder middleName(String newMiddleName)
        {
            this.nestedMiddleName = newMiddleName;
            return this;
        }

        public PersonBuilder salutation(String newSalutation)
        {
            this.nestedSalutation = newSalutation;
            return this;
        }

        public PersonBuilder suffix(String newSuffix)
        {
            this.nestedSuffix = newSuffix;
            return this;
        }

        public PersonBuilder streetAddress(String newStreetAddress)
        {
            this.nestedStreetAddress = newStreetAddress;
            return this;
        }

        public PersonBuilder city(String newCity)
        {
            this.nestedCity = newCity;
            return this;
        }

        public PersonBuilder state(String newState)
        {
            this.nestedState = newState;
            return this;
        }

        public PersonBuilder isFemale(boolean newIsFemale)
        {
            this.nestedIsFemale = newIsFemale;
            return this;
        }

        public PersonBuilder isEmployed(boolean newIsEmployed)
        {
            this.nestedIsEmployed = newIsEmployed;
            return this;
        }

        public PersonBuilder isHomeOwner(boolean newIsHomeOwner)
        {
            this.nestedIsHomeOwner = newIsHomeOwner;
            return this;
        }

        public Person createPerson()
        {
            return new Person(
                    nestedLastName, nestedFirstName, nestedMiddleName,
                    nestedSalutation, nestedSuffix,
                    nestedStreetAddress, nestedCity, nestedState,
                    nestedIsFemale, nestedIsEmployed, nestedIsHomeOwner);
        }
    }
}

class Main
{
    public static void main(String[] args) {

        Person person = (new Person.PersonBuilder())
                .city("EEE").firstName("Tet").isEmployed(true)
                .isFemale(true).isHomeOwner(true).middleName("dddewee")
                .salutation("MRs").streetAddress("ertyjuhgfddhgg")
                .createPerson();

        System.out.println(person);
    }
}

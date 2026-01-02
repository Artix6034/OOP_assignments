public class Property {
    private String name;
    private String address;

    // below is constructor
    public Property(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // getters
    public String getname() {
        return this.name;
    }
    public String getaddress() {
        return this.address;
    }
    // setters
    public void setname(String name) {
        this.name = name;
    }
    public void setaddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return name + " is at "+ address;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property p = (Property) o;
        return address.equals(p.address);
    }
    @Override
    public int hashCode() {
        return address.hashCode();
    }
}



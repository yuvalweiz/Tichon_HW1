public class Address {
    private String _country;
    private String _city;

    public String get_country() {
        return _country;
    }

    public void set_country(String _country) {
        this._country = _country;
    }

    public String get_city() {
        return _city;
    }

    public void set_city(String _city) {
        this._city = _city;
    }

    public String get_street() {
        return _street;
    }

    public void set_street(String _street) {
        this._street = _street;
    }

    public int get_number() {
        return _number;
    }

    public void set_number(int _number) {
        this._number = _number;
    }

    private String _street;

    public Address(String _country, String _city, String _street, int _number) {
        this._country = _country;
        this._city = _city;
        this._street = _street;
        this._number = _number;
    }

    private int _number;

    @Override
    public String toString() {
        return "Address:" +
                "Country = '" + _country + '\'' +
                ", City = '" + _city + '\'' +
                ", Street = '" + _street + '\'' +
                ", Number=" + _number
                ;
    }
}

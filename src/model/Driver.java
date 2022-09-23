package model;

public class Driver {
    private String driverName;
    private String NIC;
    private String driverLNO;
    private String address;
    private String contactNo;

    public Driver() {
    }

    public Driver(String driverName, String NIC, String driverLNO, String address, String contactNo) {
        this.setDriverName(driverName);
        this.setNIC(NIC);
        this.setDriverLNO(driverLNO);
        this.setAddress(address);
        this.setContactNo(contactNo);
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getDriverLNO() {
        return driverLNO;
    }

    public void setDriverLNO(String driverLNO) {
        this.driverLNO = driverLNO;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}

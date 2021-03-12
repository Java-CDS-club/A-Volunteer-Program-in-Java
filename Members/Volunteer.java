package App.Members;

public class Volunteer extends Member{
    private String Code;
    private String fName;
    private String lName;
    private String Address;
    private int Age;
    private String Email;
    private String Action;

    public Volunteer(String code, String fName, String lName, String address, int age, String email, String action) {
        this.Code = code;
        this.fName = fName;
        this.lName = lName;
        this.Address = address;
        this.Age = age;
        this.Email = email;
        this.Action = action;
    }

    @Override
    public String getCode() {
        return Code;
    }

    @Override
    public void setCode(String code) {
        Code = code;
    }

    @Override
    public String getfName() {
        return fName;
    }

    @Override
    public void setfName(String fName) {
        this.fName = fName;
    }

    @Override
    public String getlName() {
        return lName;
    }

    @Override
    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String getAddress() {
        return Address;
    }

    @Override
    public void setAddress(String address) {
        this.Address = address;
    }

    @Override
    public int getAge() {
        return Age;
    }

    @Override
    public void setAge(int age) {
        this.Age = age;
    }

    @Override
    public String getEmail() {
        return Email;
    }

    @Override
    public void setEmail(String email) {
        this.Email = email;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        this.Action = action;
    }
}

/**
 * @author andrew
 * @version 1.1
 */
package all_system;

public class player {
    private String name;
    private String address;
    private String phone;
    private String passWord;
    private boolean inATeam;
    static private int id;
    private int balance;
    Booking []Booking;

    public player(){
        this.name = " ";
        this.address = " ";
        this.phone = " ";
        this.passWord = " ";
        this.balance=0;
        this.inATeam = false;
        id+=1;
    }

    /**
     *
     * @param name
     * @param address
     * @param phone
     * @param passWord
     * @param balance
     */
    public player(String name, String address, String phone, String passWord,int balance) {
        this.name = name;
        this.address = address;
        this.inATeam = false;
        this.phone = phone;
        this.passWord = passWord;
        this.balance=balance;
        id+=1;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public void print(){
        System.out.println("Name: "+this.name +" phone: "+this.phone);
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @param passWord
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /**
     *
     * @return name
     */
    public boolean getInATeam(){ return this.inATeam;}
    public void setInATeam(boolean val){  this.inATeam = val;}
    public String getName() {
        return name;
    }

    /**
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @return password
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     *
     * @param balance
     */
    void addMoney(int balance){
        this.balance+=balance;
    }

    /**
     *
     * @param pay
     */
    void Pay(int pay){
        balance-=pay;
    }
}

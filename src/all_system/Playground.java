/**
 * @author nader
 * @version 1.1
 */

package all_system;

import java.sql.Time;

public class Playground {
    public String name;
    public String[]dateTime;
    public boolean state;
    public int price;
    public owner Owner;

    public Playground(){
        this.name ="";
        this.state = true;
        this.price = 0;
    }

    /**
     *
     * @param name
     * @param dateTime
     * @param state
     * @param price
     * @param owner
     */
    public Playground(String name, String []dateTime, boolean state, int price,owner owner) {
        this.name = name;
        this.dateTime = dateTime;
        this.state = state;
        this.price = price;
        this.Owner=owner;
    }

    void print(){
        System.out.println("NAme->"+name);
        System.out.println("Price->"+price);
        for (int i=0;i<3;i++){
            System.out.println("slot number: "+ Integer.toString(i) + " "+ dateTime[i]);
        }
        System.out.println("-------------------End-------------------");
    }

}

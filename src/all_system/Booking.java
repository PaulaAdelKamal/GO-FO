
/**
 * @author nader
 * @version 1.1
 */

package all_system;


public class Booking {
    public Playground playground;
    public String slot;
    public player Player ;

    /**
     *
      * @param playground
     * @param slot
     * @param p
     */
    Booking(Playground playground,String slot, player p){
        this.playground=playground;
        this.slot = slot;
        this.Player = p;
    }
}

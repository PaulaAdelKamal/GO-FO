/**
 * @author paula
 * @version 1.1
 */
package all_system;

public class owner extends player {

    public owner(String name, String address, String phone, String password, int i) {
        super(name, address,phone,password,0);
    }
    public owner() {
        super(" ", " "," "," ",0);
    }

    /**
     *
     * @param ground
     * @param playgrounds
     */
    public void addPlayGround(Playground ground, Playground [] playgrounds){
        for (int i=0; i<playgrounds.length;i++ ){
            if(playgrounds[i].name.equals("")){
                playgrounds[i]=ground;
                break;
            } else if (i == (playgrounds.length-1)) {
                System.out.println("Sorry System is full");
            }
        }
    }
//    public void editPlayground(Playground []playgrounds){
//
//    }
//    public void removePlayground(Playground[] playgrounds){
//
//    }

}

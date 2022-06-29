/**
 * @author paula
 * @version 1.1
 */

package all_system;



public class Team {
    public final player [] player;
    public int counter;
    public Team(int number){
        player=new player[number];
        counter = 0;
    }

    /**
     *
     * @param player1
     */
    public void addPlayer(player player1){
        if(counter!=player.length){
            player[counter]=player1;
            counter +=1;
        }else
            System.out.println("sorry The team is full");
    }

    /**
     *
     * @param player1
     */
    public void removePlayer(player player1){
        int key=0;
        player Play=new player();
        String name=player1.getName();
        for(int i=0;i< player.length;i++){
            if(player[i].getName().equals(name)){
                for (int j=i;j<10;j++){
                    if(player[j].getName().equals(" ")) {
                        key = j;
                        break;
                    }
                    else {
                    player[j]=player[j+1];
                        key=j;

                    }
                }
                player[key + 1] = Play;
                break;
            }
        }
    }
}

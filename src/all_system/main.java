/**
 * @version 1.1
 * @author andrew
 *
 */


package all_system;


import java.util.Scanner;

public class main {
    static Playground[] grounds;
    static player[] players;
    static owner[] owners;
    static Team[] teams;
    static Booking[] bookings;
    static int groundCounter;
    static int playersCounter;
    static int ownersCounter;
    static  int bookingsCounter;
    static int teamsCounter;

    public static void print() {
        System.out.println("1- Sign-UP");
        System.out.println("2- log-in");
        System.out.println("3- exit");
    }

    /**
     *
     * @param p
     * @param pIndex
     * @param sc
     */
    public static  void AddingTeamMenu(player p,int pIndex,Scanner sc){
        System.out.println("How many players will you add(other than yourself)?");
        int nPlayers = sc.nextInt();
        Team skt1 = new Team(nPlayers+1);
        p.setInATeam(true);
        players[pIndex].setInATeam(true);
        int teamPlayerNumber =0;
        skt1.addPlayer(p);
        System.out.println("these are the available players");
        for (int h=0;h<playersCounter;h++){
            if (!players[h].getInATeam()){
                System.out.print(h+"- ");
                players[h].print();
            }
        }
        for(int j=0; j<nPlayers;j++){
            System.out.println("enter a player number you want to add to the team");
            int pn = sc.nextInt();
            skt1.addPlayer(players[pn]);
            players[pn].setInATeam(true);
        }
        teams[teamsCounter] = skt1;
        teamsCounter++;
        System.out.println("team added successfully");
    }

    /**
     *
     * @param arr
     * @param index
     * @return
     */
    public static String[] removeTheElement(String[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
        String[] anotherArray = new String[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }

    public static void MenuOwner() {
        System.out.println("1-Add playground");
        System.out.println("2-Edit play ground");
        System.out.println("3-Remove my playground");
        System.out.println("4- sign out");
    }

    public static void MenuPlayer() {
        System.out.println("1- Book playground");
        System.out.println("2- Creat Team");
        System.out.println("3- sign out");
    }

    /**
     *
     * @param O
     * @param sc
     */
    public static  void EditPlaygroundMenu(owner O,Scanner sc){
        boolean anyAvailable = false;
        System.out.println("these are the available playgrounds for you");
        for (int j=0;j<groundCounter;j++){
            if(grounds[j].Owner.getName().equals(O.getName())){
                System.out.print(j+"- ");
                grounds[j].print();
                anyAvailable =true;
            }
        }
        if (!anyAvailable){
            System.out.println("---no available playgrounds");
            return;
        }
        String slots[];
        slots = new String[3];
        System.out.println("enter the playground number you need to edit");
        int pgn = sc.nextInt();
        grounds[pgn].print();
        System.out.println("Enter the new values for the playground");

        System.out.println("ADD Name");
        String name = sc.next();

        System.out.print("Add slots");
        System.out.println("  Enter time in Format(From->To \"in hours\")");
        System.out.println("the first:");
        slots[0] = sc.next();
        System.out.println("the second:");
        slots[1] = sc.next();
        System.out.println("the third:");
        slots[2] = sc.next();
        System.out.println("Add your Price");
        int price = sc.nextInt();
        sc.skip("\n");
        grounds[pgn] = new Playground(name, slots, true, price, O);
        System.out.println("playground changed successfully");

    }

    /**
     *
     * @param O
     * @param sc
     */
    public static void RemovePlaygroundMenu(owner O, Scanner sc){
        System.out.println("These are the available playgrounds for you");
        for (int j=0;j<groundCounter;j++){
            if(grounds[j].Owner.getName().equals(O.getName())){
                System.out.print(j+"- ");
                grounds[j].print();
            }
        }
        System.out.println("Enter the number of the playground you want to move(it will be removed immediately)");
        int pgn = sc.nextInt();
        for(int i = pgn ;i<groundCounter-1;i++){
            grounds[i] = grounds[i+1];
        }
        grounds[groundCounter-1] = null;
        groundCounter--;
        System.out.println("Removed");


    }

    /**
     *
     * @param Str
     */
    public static void main(String[] Str) {

        grounds = new Playground[100];

        players = new player[100];
        bookings = new Booking[100];
        owners = new owner[100];
        teams = new Team[100];
        groundCounter = 0;
        ownersCounter = 0;
        playersCounter = 0;
        bookingsCounter = 0;
        teamsCounter=0;
        int  price;
        String x, name, address, phone, password, slots[],time;
        slots = new String[3];
        while(true){
            print();
            Scanner sc = new Scanner(System.in);
            x = sc.next();
            if (x.equals("3")){break;}
//            boolean exit = false;

                if (x.equals("1")) {
                    System.out.println("Enter your name");
                    name = sc.next();
                    System.out.println("Enter password");
                    password = sc.next();
                    System.out.println("Enter phone");
                    phone = sc.next();
                    System.out.println("Enter address");
                    address = sc.next();
                    System.out.println("1-owner");
                    System.out.println("2-player");
                    String signUPownerorPlayer = sc.next();
                    if (signUPownerorPlayer.equals("1")) {
                        owners[ownersCounter] = new owner(name, address, phone, password, 0);
                        ownersCounter++;
                    } else {
                        players[playersCounter] = new player(name, address, phone, password, 0);
                        playersCounter++;
                    }
                } else if (x.equals("2")) {
                    System.out.println("Enter your name");
                    name = sc.next();
                    System.out.println("Enter password");
                    password = sc.next();
                    System.out.println("1-owner");
                    System.out.println("2-player");
                    x = sc.next();
                    boolean check = false;
                    if (x.equals("1")) {
                        owner O = new owner();
                        int ownerIdex;
                        for (int k = 0; k < ownersCounter; k++) {
                            if (owners[k].getName().equals(name) && owners[k].getPassWord().equals(password)) {
                                check = true;
                                O = owners[k];
                                ownerIdex = k;
                            }
                        }

                        if (check) {
                            while(true){
                                System.out.println("Welcome in the System");
                                MenuOwner();
                                x = sc.next();
                                if (x.equals("1")) {
                                    System.out.println("ADD Name");
                                    name = sc.next();
                                    System.out.print("Add slots");
                                    System.out.println("  Enter time in Format(From->To \"in hours\")");
                                    System.out.println("the first:");
                                    sc.skip("\n");
                                    slots[0] = sc.nextLine();
                                    System.out.println("the second:");
                                    slots[1] = sc.next();
                                    System.out.println("the third:");
                                    slots[2] = sc.next();
                                    System.out.println("Add your Price");
                                    price = sc.nextInt();
//                            sc.skip("\n");
                                    grounds[groundCounter] = new Playground(name, slots, true, price, O);
                                    groundCounter++;
                                    System.out.println("playground added");
                                } else if (x.equals("2")) {
                                    EditPlaygroundMenu(O, sc);
                                } else if (x.equals("3")) {
                                    RemovePlaygroundMenu(O, sc);
                                }else{
                                    break;
                                }
                            }

                        } else {
                            System.out.println("invalid credentials");
                        }

                    } else if (x.equals("2")) {
                        check = false;
                        player p = new player();
                        int pIndex = 0;
                        for (int k = 0; k < playersCounter; k++) {
                            if (players[k].getName().equals(name) && players[k].getPassWord().equals(password)) {
                                check = true;
                                p = players[k];
                                pIndex = k;
                            }
                        }
                        if (check) {
                          while(true)  {
                                System.out.println("Welcome in the System");
                                MenuPlayer();
                                x = sc.next();
                                if (x.equals("1")) {
                                    for (int f = 0; f < groundCounter; f++) {
                                        System.out.print(f);
                                        System.out.print("- ");
                                        grounds[f].print();
                                    }
                                    System.out.println("Enter play ground number");
                                    int playgroundNumber = sc.nextInt();
                                    grounds[playgroundNumber].print();
                                    System.out.println("Enter Slot number: ");
                                    int slotNumber = sc.nextInt();
                                    String bookingSlot = grounds[playgroundNumber].dateTime[slotNumber];
                                    grounds[playgroundNumber].dateTime = removeTheElement(grounds[playgroundNumber].dateTime, slotNumber);
                                    bookings[bookingsCounter] = new Booking(grounds[playgroundNumber], bookingSlot, p);
                                    bookingsCounter++;
                                    System.out.println("booked successfully");
                                } else if (x.equals("2")) {
                                    AddingTeamMenu(p, pIndex, sc);
                                }else{
                                    break;
                                }
                            }
                        } else {
                            System.out.println("invalid credentials");
                        }
                    }

                } else {
                    break;
                }
            }
    }
}

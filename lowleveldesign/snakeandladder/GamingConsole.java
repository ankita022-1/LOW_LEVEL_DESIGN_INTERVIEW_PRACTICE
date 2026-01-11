package lowleveldesign.snakeandladder;

import lowleveldesign.snakeandladder.model.Board;
import lowleveldesign.snakeandladder.model.Dice;
import lowleveldesign.snakeandladder.model.Player;
import lowleveldesign.snakeandladder.model.Status;

import java.util.*;

public class GamingConsole {
    private Status status;
    private Deque<Player> players;
    private Dice dice=new Dice(1,6);
    private Board board;
    private Player winner;

    public GamingConsole() {
        init();
    }
    private void init() {
        this.status = Status.START;
        //board
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Board size: ");
        int size = sc.nextInt();

        System.out.println("Enter number of snakes and ladders: ");
        int n = sc.nextInt();
        Map<Integer,Integer> mp=new HashMap<>();

        for(int i=0;i<n;i++){
            System.out.println("enter start position: "+ i);
            int start = sc.nextInt();
            System.out.println("enter end position: "+ i);
            int end = sc.nextInt();
            mp.put(start,end);
        }
        board=new Board(size,mp);

        players = new LinkedList<>();
        //players
        sc.nextLine();
        System.out.println("Enter Player's name: ");
        String name1 = sc.nextLine();
        System.out.println("Enter Player's name: ");
        String name2 = sc.nextLine();
        if(name1==null){
            name1="abx";
        }
        Player p1 = new Player(name1, 0),p2=new Player(name2, 0);

        players.add(p1);
        players.add(p2);
    }

    public void play(){
        if(players.size()<2){
            System.out.println("You have to enter at least 2 players!");
            return;
        }
        this.status=Status.RUNNING;
        while(status==Status.RUNNING){
            //player turn
            Player player=players.getFirst();
            players.pollFirst();
            System.out.println(player.getName() + " turn!");
            //roll dice
            int number = dice.roll();
            int newPosition=player.getPosition()+number;
            //check position
            //lottery snake or ladder
            if(newPosition > board.getSize()){
                players.addLast(player);
                System.out.println(player.getName() + " not valid position"+ newPosition + "skip");
                continue;
            }
            int finalPosition= board.getFinalPosition(newPosition,player);
            if(finalPosition == board.getSize()){
                winner=player;
                status=Status.FINISHED;
                break;
            }
            System.out.println(" + " + newPosition);
            player.setPosition(finalPosition);
            players.addLast(player);
        }
        if(status==Status.FINISHED){
            System.out.println("You have finished the game! Winner + " + winner.getName());
            return;
        }
        System.out.println(status);
        status=Status.FINISHED;
    }
}

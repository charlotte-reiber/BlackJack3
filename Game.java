import java.util.UUID;
import java.util.Scanner;
import java.util.ArrayList;

public class Game{

  private ArrayList<Player> players = new ArrayList<Player>();
  private ArrayList<Player> dealers = new ArrayList<Player>();
  private Deck     deck;   //= new Deck(scan);
  private UUID     id     = UUID.randomUUID();
  private Scanner scan;
  
  public Game(int numPlayers, int numDealers, Scanner scan){
    this.scan = scan;
    this.deck = new Deck(this.scan);
    for (int i = 0; i < numPlayers; i++)
      this.players.add(new Player("bob", 20.00, false, this.scan));
    for (int i = 0; i < numDealers; i++)
      this.dealers.add(new Player("bob", 20.00, true, this.scan));
  }

  public void setup() {
    for (int i = 0; i < this.players.size(); i++)
      this.players.get(i).askBet();
    for (int i = 0; i < this.dealers.size(); i++)
      this.dealers.get(i).show();
    for (int i = 0; i < this.players.size(); i++)
      this.players.get(i).printIntro();
  }
}
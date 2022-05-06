import java.util.UUID;
import java.util.Scanner;
import java.util.ArrayList;

public class Game{

  private ArrayList<Player> players = new ArrayList<Player>();
  private Player dealer;
  private Deck     deck;   //= new Deck(scan);
  private UUID     id     = UUID.randomUUID();
  private Scanner scan;
  
  public Game(int numPlayers, Scanner scan){
    this.scan = scan;
    this.deck = new Deck(this.scan);
    for (int i = 0; i < numPlayers; i++)
      this.players.add(new Player("bob", 20.00, false, this.scan));
    this.dealer = new Player("dealer", 20.00, true, this.scan);
  }

  public void setup() {
    for (int i = 0; i < this.players.size(); i++)
      this.players.get(i).askBet();
    this.dealer.show();
    for (int i = 0; i < this.players.size(); i++)
      this.players.get(i).printIntro();
  }
}
import java.util.ArrayList;
import java.util.Scanner;

public class Player{
  
  private String name;
  private double cash;
  private double bet;
  private int score = 0;

  private boolean dealer;
  private ArrayList<Card> hand = new ArrayList<Card>();
  private Scanner scan;
  
  public Player(String name, double cash, boolean dealer, Scanner scan){
    this.name = name;
    this.cash = cash;
    this.dealer = dealer;
    this.scan = scan;
  }

  //withdraws an amount from player
  public double getBet(){
    return this.bet;
  }

  //returns the name of the player
  public String getName() {
	  return name;
  }

  //returns how much money the player has
  public double getCash() {
	  return cash;
  }

  //adds a card to the hand
  public void drawCard(Card card) {
    this.hand.add(card);
  }

  //gets the hand
  private String getHand() {
    String hand = "";
    for (int i = 0; i < this.hand.size(); i++)
      hand += "[" + this.hand.get(i).toString() + "] ";
    return hand;
  }

  //calculates the total
  private int calcTotal() {
    boolean hasAce = false;
    int total = 0;
    int value;
    for (int i = 0; i < this.hand.size(); i++) {
      value = this.hand.get(i).getValue();
      if (value == 11) {
        hasAce = true;
        total += 1;
      } else {
        total += value;
      }
    }

    if (hasAce && total < 12) total += 10;
    return total;
  }

  //decides if should continue
  public boolean decideHit() {
    int total = calcTotal();
    if (total > 20) return false;
    if (this.dealer) {
      return (total < 17);
    } else {
      System.out.println("  Take a (h)it or (s)tand?");
      char input = this.scan.next().charAt(0);
      return input == 'h';
    }
  }

  //prints the stats of a current hand of blackjack
  //then decides if a turn should be taken
  public boolean takeTurn() {
    String cards = " " + getHand();
    while (cards.length() < 28) cards += " ";
    String total = "total: " + calcTotal();
    System.out.println(cards + total);
    return decideHit();
  }

  //gets the bet ammount from the user
  public void askBet() {
    System.out.println("\n--------------------------------------");
    System.out.println("  Let's play Blackjack!");
    System.out.println("--------------------------------------");
    System.out.print("\n  How much will you bet? ");
    this.bet = this.scan.nextDouble();
    this.cash -= this.bet;
  }

  //determines score
  public int getScore() {
    this.score = calcTotal();
    if (this.score > 21) this.score = 0;
    return this.score;
  }

  //determines if won and adjusts cash
  public boolean checkWon(int rival) {
    int diff = this.score - rival;
    if (diff > 0 || (diff == 0 && this.dealer)) {
      this.cash += this.bet * 2;
      return true;
    }
    return false;
  }

  //prints the hand intro
  public void printIntro() {
    System.out.println();
    System.out.println("--------------------------------------");
    System.out.println(((this.dealer)?"  Dealer" : "  Player") + " plays...");
    System.out.println("--------------------------------------");
    System.out.println();
  }
}
import java.util.Scanner;
import java.util.ArrayList;

public class Deck{

  private int SIZE = 52;
  private ArrayList<Card> cards = new ArrayList<Card>();
  
  private int[] lose = {14, 22, 20, 2, 41, 15, 16, 28, 0, 24, 45, 12, 26, 13, 49, 29, 39, 25, 10, 21, 1, 40, 51, 27, 35, 38, 18, 19, 31, 36, 32, 37, 4, 42, 8, 6, 17, 47, 23, 7, 46, 33, 30, 9, 11, 48, 50, 34, 44, 5, 43, 3};
  
  private int[] win = {49, 13, 39, 22, 46, 4, 15, 14, 38, 3, 25, 26, 5, 21, 45, 17, 9, 27, 1, 28, 40, 48, 19, 30, 35, 10, 32, 6, 24, 29, 0, 2, 8, 44, 31, 50, 12, 11, 34, 42, 37, 41, 47, 23, 16, 36, 33, 20, 18, 51, 7, 43};
  
  private int[] basic= numbers(SIZE);
  private Scanner scan;
  
  public Deck(Scanner scan){
    this.scan = scan;
    int whichDeck = askDeck();
    if (whichDeck == 0) buildDeck(lose);
    else if (whichDeck == 1) buildDeck(win);
    else buildDeck(shuffle(basic));
  }

  //shuffles the deck
  private int[] shuffle(int[] array) {
    int placeholder;
    
    for (int i = 0; i < array.length; i++) {
      int index = (int)(Math.random() * array.length);
      placeholder = array[i];
      array[i] = array[index];
      array[index] = placeholder;
    }

    return array;
  }

  //asks the user what kind of deck to use
  private int askDeck() {
    System.out.println("\nTHE CARDS ARE SHUFFLED!");
    System.out.println("Want to use a test deck?" );
    System.out.print("(0:looser 1:winner or skip): ");
    String input = this.scan.next();
    if (input.equals("0")) return 0;
    if (input.equals("1")) return 1;
    return -1;
  }

  //builds an array of numbers given a size
  private int[] numbers(int size) {
    int[] array = new int[size];
    for (int i = 0; i < size; i++)
      array[i] = i;
    return array;
  }

  //takes an array of seeds and turns it into an array of cards
  private void buildDeck(int[] seeds) {
    for (int i = 0; i < seeds.length; i++)
      cards.add(new Card(seeds[i]));
  }

  //prints the current deck
  public void printDeck() {
    for (int i = 0; i < this.cards.size(); i++) {
      System.out.print(this.cards.get(i).toString() + " ");
    }
    System.out.println();
  }

  //deals a card from the top of the deck and removes it
  public Card dealCard() {
    Card card = this.cards.get(0);
    this.cards.remove(0);
    return card;
  }
}
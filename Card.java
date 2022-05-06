public class Card {

  private String suit;
  private String card;
  private int    value;
  private int    seed; 
  
  static final String[] SUITS    = {"♠","♥","♦","♣"};
  static final String[] SPECIALS  = {"A","J","Q","K"};
  static final int      BASE      = 9;
  
  public Card(int seed){
    this.seed = seed;
    this.value = calcValue();
    this.card  = calcCard();
    this.suit = calcSuit();
    
  }

  public String toString(){
    return this.suit + this.card;
  }

  public int getValue() {
    if (this.card.equals("A")) return 11;
    else if (contains(SPECIALS, this.card)) return 10;
    else return this.value;
  }

  private boolean contains(String[] array, String element) {
    for (int i = 0; i < array.length; i++)
      if (element.equals(array[i])) return true;
    return false;
  }

  //calculates the number/special on the card
  private String calcCard() {
    int n = calcValue();
    String c;
    if (n > BASE + 1) c = SPECIALS[n - BASE - 2];
    else c = "" + n;
    return c;
  }

  //calculates the value of the card
  private int calcValue() {
    return this.seed % (BASE + SPECIALS.length) + 2;
  }

  //calculates the suit
  private String calcSuit() {
    int s = this.seed / (BASE + SUITS.length);
    return SUITS[s];
  }
}
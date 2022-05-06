import java.util.*;
//import java.util.ArrayList;

import java.util.Scanner;

class BlackJackTwo {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    Game game = new Game(1, scan);
    game.setup();
    /*
    Deck deck = new Deck(scan);
    Player player = new Player("bob", 50, false, scan);

    player.askBet();

    player.printIntro();
    player.drawCard(deck.dealCard());
    do {
      player.drawCard(deck.dealCard());
    } while (player.takeTurn());

    System.out.println(player.getScore());
    System.out.println(player.checkWon(20));
    */
  }
}
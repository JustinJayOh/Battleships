/**
* Main program for battleship game.
* 
* @author Justin Oh (jjoh1993@gmail.com)
* @version 10/15/2018
*/
import java.util.Scanner;

public class Game {
 /** 
 * Initializes ship objects and player objects to start game.
 * @param args Command line arguments - not used.
 */
   public static void main(String[] args) {
   
      Scanner input = new Scanner(System.in);
      System.out.println("Game Start");
   
      Player me = new Player();
      Player computer = new Player();
      
      int a;
      int b;
      char c;
      boolean isSet = false;
   	
   	// Set up 5 ship pieces.
      do {
         System.out.println("Where do you want the Carrier? (1)");
         System.out.print("Enter a row from 0-9: ");
         a = input.nextInt();
         System.out.print("Enter a column from 0-9: ");
         b = input.nextInt();
         System.out.print("Enter a character for Up, Down, Left, or Right: ");
         c = input.next().charAt(0);
         if (me.setCarrier(a, b, c) == false) {
            System.out.println("\nCannot fit ship in location\n");
         }
         else {
            me.setCarrier(a, b, c);
            isSet = true;
         }
      } while (isSet == false);
      isSet = false;
      
      do {
         System.out.println("Where do you want the Battleship? (2)");
         System.out.print("Enter a row from 0-9: ");
         a = input.nextInt();
         System.out.print("Enter a column from 0-9: ");
         b = input.nextInt();
         System.out.print("Enter a character for Up, Down, Left, or Right: ");
         c = input.next().charAt(0);
         if ((me.setBattleship(a, b, c)) == false) {
            System.out.println("\nCannot fit ship in location\n");
         }
         else {
            me.setBattleship(a, b, c);
            isSet = true;
         }
      } while (isSet == false);
      isSet = false;
      
      do {
         System.out.println("Where do you want the Cruiser? (3)");
         System.out.print("Enter a row from 0-9: ");
         a = input.nextInt();
         System.out.print("Enter a column from 0-9: ");
         b = input.nextInt();
         System.out.print("Enter a character for Up, Down, Left, or Right: ");
         c = input.next().charAt(0);
         if ((me.setCruiser(a, b, c)) == false) {
            System.out.println("\nCannot fit ship in location\n");
         }
         else {
            me.setCruiser(a, b, c);
            isSet = true;
         }
      } while (isSet == false);
      isSet = false;
      
      do {
         System.out.println("Where do you want the Submarine? (4)");
         System.out.print("Enter a row from 0-9: ");
         a = input.nextInt();
         System.out.print("Enter a column from 0-9: ");
         b = input.nextInt();
         System.out.print("Enter a character for Up, Down, Left, or Right: ");
         c = input.next().charAt(0);
         if ((me.setSubmarine(a, b, c)) == false) {
            System.out.println("\nCannot fit ship in location\n");
         }
         else {
            me.setSubmarine(a, b, c);
            isSet = true;
         }
      } while (isSet == false);
      isSet = false;
      
      do {
         System.out.println("Where do you want the Destroyer? (5)");
         System.out.print("Enter a row from 0-9: ");
         a = input.nextInt();
         System.out.print("Enter a column from 0-9: ");
         b = input.nextInt();
         System.out.print("Enter a character for Up, Down, Left, or Right: ");
         c = input.next().charAt(0);
         if ((me.setDestroyer(a, b, c)) == false) {
            System.out.println("\nCannot fit ship in location\n");
         }
         else {
            me.setDestroyer(a, b, c);
            isSet = true;
         }
      } while (isSet == false);
      isSet = false;
      
      System.out.println("Your ships have been placed");
      
   
   	// Place Computer Ships
      System.out.println("The Computer is placing its ships");
      do {
         a = computer.randomInt();
         b = computer.randomInt();
         c = computer.randomChar();
         computer.setCruiser(a, b, c);
      } while (computer.setCruiser(a, b, c));
      
      do {
         a = computer.randomInt();
         b = computer.randomInt();
         c = computer.randomChar();
         computer.setBattleship(a, b, c);
      } while (computer.setBattleship(a, b, c));
      
      do {
         a = computer.randomInt();
         b = computer.randomInt();
         c = computer.randomChar();
         computer.setBattleship(a, b, c);
      } while (computer.setBattleship(a, b, c));
      
      do {
         a = computer.randomInt();
         b = computer.randomInt();
         c = computer.randomChar();
         computer.setSubmarine(a, b, c);
      } while (computer.setBattleship(a, b, c));
      
      do {
         a = computer.randomInt();
         b = computer.randomInt();
         c = computer.randomChar();
         computer.setDestroyer(a, b, c);
      } while (computer.setDestroyer(a, b, c));
      
      // Game Loop
      do {
         System.out.println("------------------------------------------------");
         System.out.println("                 Your current Map               ");
         System.out.println("------------------------------------------------");
         System.out.println(me.getMap());
         System.out.println("------------------------------------------------");
         System.out.println("                   Your Hit Map                 ");
         System.out.println("------------------------------------------------");
         System.out.println(computer.getHitMap());
         System.out.println();
         System.out.println("Choose a location to hit");
         System.out.print("Enter a row: ");
         int x = input.nextInt();
         System.out.print("Enter a column: ");
         int y = input.nextInt();
         computer.hitMapHit(x, y);
         
         // Hit/Miss for user
         if (computer.isOccupied(x, y)) {
            computer.hit(x, y);
            System.out.println("You hit a ship!");
         }
         else if (!(computer.isOccupied(x, y))) {
            System.out.println("You missed!");
         }
         
         System.out.println();
         System.out.println("The Computer's turn");
         int q = computer.randomInt();
         int r = computer.randomInt();
         
         // Hit/Miss for computer
         if (me.isOccupied(q, r)) {
            me.hit(q, r);
            System.out.println("You were hit!");
            System.out.println();
         }
         else if (!(me.isOccupied(q, r))) {
            System.out.println("The Computer missed!");
            System.out.println();
         }
         
      } while (me.getShipsLeft() > 0 && computer.getShipsLeft() > 0);
      
      // Close scanner
      input.close();
      
      // Game End
      if (me.getShipsLeft() == 0) {
         System.out.println("You lost against the computer!");
      }
      else if (computer.getShipsLeft() == 0) {
         System.out.println("You won against the computer!");
      }
      
      System.out.println("End Game");
         
         
      
      
   }
}

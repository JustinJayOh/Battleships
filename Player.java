 /**
* Represents a Player.
* 
* @author Justin Oh (jjoh1993@gmail.com)
* @version 10/15/2018
*/
public class Player {

   // Instance variables
   
   Ships ship;
   int lives;
   
   
   // Constructor
   
   /** Initializes a player. 
   */
   public Player() {
      ship = new Ships();
      lives = 17;
   }
   
   /** Sets carrier location.
   * @param rowIn for row
   * @param columnIn for column
   * @param orientation for ship orientation
   * @return boolean true if set, false otherwise
   */
   public boolean setCarrier(int rowIn, int columnIn, char orientation) {
      boolean isSet = false;
      
      if (!(isOccupied(rowIn, columnIn))) {
         ship.setCarrier(rowIn, columnIn, orientation);
         if (ship.setCarrier(rowIn, columnIn, orientation) == true) {
            isSet = true;
         }
      }
      return isSet;
   }
   
    /** Sets battleship location.
   * @param rowIn for row
   * @param columnIn for column
   * @param orientation for ship orientation
   * @return boolean true if set, false otherwise
   */
   public boolean setBattleship(int rowIn, int columnIn, char orientation) {
      boolean isSet = false;
      
      if (!(isOccupied(rowIn, columnIn))) {
         ship.setBattleship(rowIn, columnIn, orientation);
         if (ship.setBattleship(rowIn, columnIn, orientation)) {
            isSet = true;
         }
      }
      return isSet;
   }
   
    /** Sets cruiser location.
   * @param rowIn for row
   * @param columnIn for column
   * @param orientation for ship orientation
   * @return boolean true if set, false otherwise
   */
   public boolean setCruiser(int rowIn, int columnIn, char orientation) {
      boolean isSet = false;
      
      if (!(isOccupied(rowIn, columnIn))) {
         ship.setCruiser(rowIn, columnIn, orientation);
         if (ship.setCruiser(rowIn, columnIn, orientation)) {
            isSet = true;
         }
      }
      return isSet;
   }
   
    /** Sets submarine location.
   * @param rowIn for row
   * @param columnIn for column
   * @param orientation for ship orientation
   * @return boolean true if set, false otherwise
   */
   public boolean setSubmarine(int rowIn, int columnIn, char orientation) {
      boolean isSet = false;
      
      if (!(isOccupied(rowIn, columnIn))) {
         ship.setSubmarine(rowIn, columnIn, orientation);
         if (ship.setSubmarine(rowIn, columnIn, orientation)) {
            isSet = true;
         }
      }
      return isSet;
   }
   
    /** Sets destroyer location.
   * @param rowIn for row
   * @param columnIn for column
   * @param orientation for ship orientation
   * @return boolean true if set, false otherwise
   */
   public boolean setDestroyer(int rowIn, int columnIn, char orientation) {
      boolean isSet = false;
      
      if (!(isOccupied(rowIn, columnIn))) {
         ship.setDestroyer(rowIn, columnIn, orientation);
         if (ship.setDestroyer(rowIn, columnIn, orientation)) {
            isSet = true;
         }
      }
      return isSet;
   }
	
   /** Returns String representation of Map.
   * @return String for map
   */
   public String getMap() {
      return ship.getMap();
   }
   
   /** Returns String representation of hitMap.
   * @return String for hitMap
   */
   public String getHitMap() {
      return ship.getHitMap();
   }
   
   
   /** Hits a specific location.
   * @param rowIn for row
   * @param columnIn for column
   */
   public void hit(int rowIn, int columnIn) {
      
      ship.hitMapHit(rowIn, columnIn);
      
      if (isOccupied(rowIn, columnIn)) {
         ship.setZero(rowIn, columnIn);
         lives--;
      } 
   }
   
   /** Returns true if location is occupied.
   * @param rowIn for row
   * @param columnIn for column
   * @return boolean true if hit; false otherwise
   */
   public boolean isOccupied(int rowIn, int columnIn) {
      return ship.isOccupied(rowIn, columnIn);
   } 
	
   /** Returns a random int from 0-9.
   * @return int from 0-9
   */
   public int randomInt() {
      return (int) Math.random() * 9;
   }
   
   /** Returns a random char for ship orientation.
   * @return char U, D, L, or R
   */
   public char randomChar() {
      char result = 'U';
      int random = (int) Math.random() * 3 + 1;
      
      switch (random) {
         case 1: 
            result = 'U';
            break;
         case 2:
            result = 'D';
            break;
         case 3: 
            result = 'L';
            break;
         case 4:
            result = 'R';
            break;
      }
      return result;
   }
   
   /** Returns int representing ships locations left.
   * @return int for lives
   */
   public int getShipsLeft() {
      return lives;
   }
   
   /** Hit on hitMap; X for hit, M for miss.
   * @param rowIn for row
   * @column columnIn for column
   */
   public void hitMapHit(int rowIn, int columnIn) {
      
      ship.hitMapHit(rowIn, columnIn);
   }
        
}

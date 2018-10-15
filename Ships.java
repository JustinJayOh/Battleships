/**
* Represents Ship pieces.
* 
* @author Justin Oh (jjoh1993@gmail.com)
* @version 10/15/2018
*/
public class Ships {

	// instance variables
   private int[][] map;
   private String[][] hitMap;
	
	// Constructor
	
	/** Initializes 5 ships with differing lengths.
	 * 
	 */
   public Ships() {
      map = new int[10][10];
      hitMap = new String[10][10];
      hitMap();
   }
	
	// Methods
	
	/** Initializes map location for Carrier ship. (5)
	 * 
	 * @param rowIn for row
	 * @param columnIn for column
	 * @param input for ship orientation
    * @return boolean true if set; false otherwise
	 */
   public boolean setCarrier(int rowIn, int columnIn, char input) {
      int x = 1;
      boolean set = false;
   	
      if (!(isOccupied(rowIn, columnIn))) {
         map[rowIn][columnIn] = 1;
         x++;
      }
   	
     
      switch (input) {
         case 'U':
            if (rowIn <= 3) {
               map[rowIn][columnIn] = 0;
               break;
            }
            for (int i = 1; i < 5; i++) {
               if (!(isOccupied(rowIn - i, columnIn))) {
                  map[rowIn - i][columnIn] = 1;
                  x++;
               }
               else {
                  for (int z = 1; z < x; z++) {
                     map[rowIn + z][columnIn] = 0;
                     x = 1;
                  }
                  break;	
               }
            }
            set = true;
            break;
         
         	
         case 'D':
            if (rowIn >= 6) {
               break;
            }
            for (int i = 1; i < 5; i++) {
               if (!(isOccupied(rowIn + i, columnIn))) {
                  map[rowIn + i][columnIn] = 1;
                  x++;
               }
               else {
                  for (int z = 1; z < x; z++) {
                     map[rowIn - z][columnIn] = 0;
                     x = 1;
                  }
                  break;	
               }
            }
            set = true;
            break;
         	
         case 'R':
            if (columnIn >= 6) {
               break;
            }
            for (int i = 1; i < 5; i++) {
               if (!(isOccupied(rowIn, columnIn + i))) {
                  map[rowIn][columnIn + i] = 1;
                  x++;
               }
               else {
                  for (int z = 1; z < x; z++) {
                     map[rowIn][columnIn - z] = 0;
                     x = 1;
                  }
                  break;	
               }
            }
            set = true;
            break;
         
         case 'L':
            if (columnIn <= 3) {
               break;
            }
            for (int i = 1; i < 5; i++) {
               if (!(isOccupied(rowIn, columnIn - i))) {
                  map[rowIn][columnIn - i] = 1;
                  x++;
               }
               else {
                  for (int z = 1; z < x; z++) {
                     map[rowIn][columnIn + z] = 0;
                     x = 1;
                  }
                  break;	
               }
            }
            set = true;
            break; 
      }
      
      return set;
   }
	
	
	/** Initializes map location for Battleship ship. (4)
	 * 
	 * @param rowIn for row
	 * @param columnIn for column
	 * @param input for ship orientation
    * @return boolean true if set; false otherwise
	 */
   public boolean setBattleship(int rowIn, int columnIn, char input) {
      int x = 1;
      boolean set = false;
   	
      if (!(isOccupied(rowIn, columnIn))) {
         map[rowIn][columnIn] = 2;
         x++;
      }
   	
      switch (input) {
         
         case 'U':
            if (rowIn <= 2) {
               break;
            }
            for (int i = 1; i < 4; i++) {
               if (!(isOccupied(rowIn - i, columnIn))) {
                  map[rowIn - i][columnIn] = 2;
                  x++;
               }
               else {
                  for (int z = 1; z < x; z++) {
                     map[rowIn + z][columnIn] = 0;
                     x = 1;
                  }
                  break;	
               }
            }
            set = true;
            break;
         
         	
         case 'D':
            if (rowIn >= 7) {
               break;
            }
            for (int i = 1; i < 4; i++) {
               if (!(isOccupied(rowIn + i, columnIn))) {
                  map[rowIn + i][columnIn] = 2;
                  x++;
               }
               else {
                  for (int z = 1; z < x; z++) {
                     map[rowIn - z][columnIn] = 0;
                     x = 1;
                  }
                  break;	
               }
            }
            set = true;
            break;
         	
         case 'R':
            if (columnIn >= 7) {
               break;
            }
            for (int i = 1; i < 4; i++) {
               if (!(isOccupied(rowIn, columnIn + i))) {
                  map[rowIn][columnIn + i] = 2;
                  x++;
               }
               else {
                  for (int z = 1; z < x; z++) {
                     map[rowIn][columnIn - z] = 0;
                     x = 1;
                  }
                  break;	
               }
            }
            set = true;
            break;
         
         case 'L':
            if (columnIn <= 2) {
               break;
            }
            for (int i = 1; i < 4; i++) {
               if (!(isOccupied(rowIn, columnIn - i))) {
                  map[rowIn][columnIn - i] = 2;
                  x++;
               }
               else {
                  for (int z = 1; z < x; z++) {
                     map[rowIn][columnIn + z] = 0;
                     x = 1;
                  }
                  break;	
               }
            }
            set = true;
            break; 
      }
      
      return set;
   }
	
	 /** Initializes map location for Cruiser ship. (3)
	 * 
	 * @param rowIn for row
	 * @param columnIn for column
	 * @param input for ship orientation
    * @return boolean true if set; false otherwise
	 */
   public boolean setCruiser(int rowIn, int columnIn, char input) {
      int x = 1;
      boolean set = false;
   	
      if (!(isOccupied(rowIn, columnIn))) {
         map[rowIn][columnIn] = 3;
         x++;
      }
   	
      switch (input) {
         
         case 'U':
            if (rowIn <= 1) {
               break;
            }
            for (int i = 1; i < 3; i++) {
               if (!(isOccupied(rowIn - i, columnIn))) {
                  map[rowIn - i][columnIn] = 3;
                  x++;
               }
               else {
                  for (int z = 1; z < x; z++) {
                     map[rowIn + z][columnIn] = 0;
                     x = 1;
                  }
                  break;	
               }
            }
            set = true;
            break;
         
         	
         case 'D':
            if (rowIn >= 8) {
               break;
            }
            for (int i = 1; i < 3; i++) {
               if (!(isOccupied(rowIn + i, columnIn))) {
                  map[rowIn + i][columnIn] = 3;
                  x++;
               }
               else {
                  for (int z = 1; z < x; z++) {
                     map[rowIn - z][columnIn] = 0;
                     x = 1;
                  }
                  break;	
               }
            }
            set = true;
            break;
         	
         case 'R':
            if (columnIn >= 8) {
               break;
            }
            for (int i = 1; i < 3; i++) {
               if (!(isOccupied(rowIn, columnIn + i))) {
                  map[rowIn][columnIn + i] = 3;
                  x++;
               }
               else {
                  for (int z = 1; z < x; z++) {
                     map[rowIn][columnIn - z] = 0;
                     x = 1;
                  }
                  break;	
               }
            }
            set = true;
            break;
         
         case 'L':
            if (columnIn <= 1) {
               break;
            }
            for (int i = 1; i < 3; i++) {
               if (!(isOccupied(rowIn, columnIn - i))) {
                  map[rowIn][columnIn - i] = 3;
                  x++;
               }
               else {
                  for (int z = 1; z < x; z++) {
                     map[rowIn][columnIn + z] = 0;
                     x = 1;
                  }
                  break;	
               }
            }
            set = true;
            break; 
      }
      
      return set;
   }
	
	
	/** Initializes map location for Submarine ship. (3)
	 * 
	 * @param rowIn for row
	 * @param columnIn for column
	 * @param input for ship orientation
    * @boolean true if set; false otherwise
	 */
   public boolean setSubmarine(int rowIn, int columnIn, char input) {
      int x = 1;
      boolean set = false;
   	
      if (!(isOccupied(rowIn, columnIn))) {
         map[rowIn][columnIn] = 4;
         x++;
      }
   	
      switch (input) {
         
         case 'U':
            if (rowIn <= 1) {
               break;
            }
            for (int i = 1; i < 3; i++) {
               if (!(isOccupied(rowIn - i, columnIn))) {
                  map[rowIn - i][columnIn] = 4;
                  x++;
               }
               else {
                  for (int z = 1; z < x; z++) {
                     map[rowIn + z][columnIn] = 0;
                     x = 1;
                  }
                  break;	
               }
            }
            set = true;
            break;
         
         	
         case 'D':
            if (rowIn >= 8) {
               break;
            }
            for (int i = 1; i < 3; i++) {
               if (!(isOccupied(rowIn + i, columnIn))) {
                  map[rowIn + i][columnIn] = 4;
                  x++;
               }
               else {
                  for (int z = 1; z < x; z++) {
                     map[rowIn - z][columnIn] = 0;
                     x = 1;
                  }
                  break;	
               }
            }
            set = true;
            break;
         	
         case 'R':
            if (columnIn >= 8) {
               break;
            }
            for (int i = 1; i < 3; i++) {
               if (!(isOccupied(rowIn, columnIn + i))) {
                  map[rowIn][columnIn + i] = 4;
                  x++;
               }
               else {
                  for (int z = 1; z < x; z++) {
                     map[rowIn][columnIn - z] = 0;
                     x = 1;
                  }
                  break;	
               }
            }
            set = true;
            break;
         
         case 'L':
            if (columnIn <= 1) {
               break;
            }
            for (int i = 1; i < 3; i++) {
               if (!(isOccupied(rowIn, columnIn - i))) {
                  map[rowIn][columnIn - i] = 4;
                  x++;
               }
               else {
                  for (int z = 1; z < x; z++) {
                     map[rowIn][columnIn + z] = 0;
                     x = 1;
                  }
                  break;	
               }
            }
            set = true;
            break; 
      }
      return set;
   }
	
	 /** Initializes map location for Destroyer ship. (2)
	 * 
	 * @param rowIn for row
	 * @param columnIn for column
	 * @param input for ship orientation
    * @return boolean true if set; false otherwise
	 */
   public boolean setDestroyer(int rowIn, int columnIn, char input) {
      int x = 1;
      boolean set = false;
   	
      if (!(isOccupied(rowIn, columnIn))) {
         map[rowIn][columnIn] = 5;
         x++;
      }
   	
      switch (input) {
         
         case 'U':
            if (rowIn <= 0) {
               break;
            }
            for (int i = 1; i < 2; i++) {
               if (!(isOccupied(rowIn - i, columnIn))) {
                  map[rowIn - i][columnIn] = 5;
                  x++;
               }
               else {
                  for (int z = 1; z < x; z++) {
                     map[rowIn + z][columnIn] = 0;
                     x = 1;
                  }
                  break;	
               }
            }
            set = true;
            break;
         
         	
         case 'D':
            if (rowIn >= 9) {
               break;
            }
            for (int i = 1; i < 2; i++) {
               if (!(isOccupied(rowIn + i, columnIn))) {
                  map[rowIn + i][columnIn] = 5;
                  x++;
               }
               else {
                  for (int z = 1; z < x; z++) {
                     map[rowIn - z][columnIn] = 0;
                     x = 1;
                  }
                  break;	
               }
            }
            set = true;
            break;
         	
         case 'R':
            if (columnIn >= 9) {
               break;
            }
            for (int i = 1; i < 2; i++) {
               if (!(isOccupied(rowIn, columnIn + i))) {
                  map[rowIn][columnIn + i] = 5;
                  x++;
               }
               else {
                  for (int z = 1; z < x; z++) {
                     map[rowIn][columnIn - z] = 0;
                     x = 1;
                  }
                  break;	
               }
            }
            set = true;
            break;
         
         case 'L':
            if (columnIn <= 0) {
               break;
            }
            for (int i = 1; i < 2; i++) {
               if (!(isOccupied(rowIn, columnIn - i))) {
                  map[rowIn][columnIn - i] = 5;
                  x++;
               }
               else {
                  for (int z = 1; z < x; z++) {
                     map[rowIn][columnIn + z] = 0;
                     x = 1;
                  }
                  break;	
               }
            }
            set = true;
            break; 
      }
      return set;
   }
	
	/** Returns boolean result of space being occupied.
	 * 
	 * @param i for row
	 * @param j for column
	 * @return boolean true if occupied; false otherwise
	 */
   public boolean isOccupied(int i, int j) {
      boolean result = false;
   	
      if (map[i][j] > 0) {
         result = true;
      }
   	
      return result;
   }
   
   /** Returns string representing the map.
   *
   * @return String for output.
   */
   public String getMap() {
      String output = "";
      
      for (int i = 0; i < 10; i++) {
         output += "\n";
         for (int j = 0; j < 10; j++) {
            output += map[i][j] + " ";
         }
      }
      
      return output;
   }
   
   /** Sets map location to 0.
   *
   * @param rowIn for row
   * @param columnIn for column
   */
   public void setZero(int rowIn, int columnIn) {
      map[rowIn][columnIn] = 0;
   }
   
   /** Initialize the hitMap with 0's. 
   */
   public void hitMap() {
      for (int i = 0; i < 10; i++) {
         for (int j = 0; j < 10; j++) {
            hitMap[i][j] = "0";
         }
      }
   }
   
   /** Hit on hitMap; X for hit, M for miss.
   * @param rowIn for row
   * @param columnIn for column
   */
   public void hitMapHit(int rowIn, int columnIn) {
      
      hitMap[rowIn][columnIn] = "M";
      
      if (isOccupied(rowIn, columnIn)) {
         hitMap[rowIn][columnIn] = "X";
      }
      
   }
   
   /** Return String representing the hitMap.
   * @return String for hitmap
   */
   public String getHitMap() {
      String output = "";
      
      for (int i = 0; i < 10; i++) {
         output += "\n";
         for (int j = 0; j < 10; j++) {
            output += hitMap[i][j] + " ";
         }
      }
      return output;
   }
	
}

import java.util.Random;

public class BoardMechanics {

	static int tetroO1[][] = {{1, 1},{1, 1}};
	static int tetroO2[][] = {{1, 1},{1, 1}};
	static int tetroO3[][] = {{1, 1},{1, 1}};
	static int tetroO4[][] = {{1, 1},{1, 1}};

	static int tetroI1[][] = {{9, 9, 9, 9}, {2, 2, 2, 2}, {9, 9, 9, 9}, {9, 9, 9, 9}};
	static int tetroI2[][] = {{9, 9, 2, 9}, {9, 9, 2, 9}, {9, 9, 2, 9}, {9, 9, 2, 9}};
	static int tetroI3[][] = {{9, 9, 9, 9}, {9, 9, 9, 9}, {2, 2, 2, 2}, {9, 9, 9, 9}};
	static int tetroI4[][] = {{9, 2, 9, 9}, {9, 2, 9, 9}, {9, 2, 9, 9}, {9, 2, 9, 9}};

	static int tetroT1[][] = {{9, 3, 9}, {3, 3, 3}, {9, 9, 9}};
	static int tetroT2[][] = {{9, 3, 9}, {9, 3, 3}, {9, 3, 9}};
	static int tetroT3[][] = {{9, 9, 9}, {3, 3, 3}, {9, 3, 9}};
	static int tetroT4[][] = {{9, 3, 9}, {3, 3, 9}, {9, 3, 9}};
	
	static int tetroL1[][] = {{9, 9, 4}, {4, 4, 4}, {9, 9, 9}};
	static int tetroL2[][] = {{9, 4, 9}, {9, 4, 9}, {9, 4, 4}};
	static int tetroL3[][] = {{9, 9, 9}, {4, 4, 4}, {4, 9, 9}};
	static int tetroL4[][] = {{4, 4, 9}, {9, 4, 9}, {9, 4, 9}};
	
	static int tetroRL1[][] = {{5, 9, 9}, {5, 5, 5}, {9, 9, 9}};
	static int tetroRL2[][] = {{9, 5, 5}, {9, 5, 9}, {9, 5, 9}};
	static int tetroRL3[][] = {{9, 9, 9}, {5, 5, 5}, {5, 5, 9}};
	static int tetroRL4[][] = {{9, 5, 9}, {9, 5, 9}, {5, 5, 9}};
	
	static int tetroS1[][] = {{9, 6, 6}, {6, 6, 9}, {9, 9, 9}};
	static int tetroS2[][] = {{9, 6, 9}, {9, 6, 6}, {9, 9, 6}};
	static int tetroS3[][] = {{9, 9, 9}, {9, 6, 6}, {6, 6, 9}};
	static int tetroS4[][] = {{6, 9, 9}, {6, 6, 9}, {9, 6, 9}};
	
	static int tetroZ1[][] = {{7, 7, 9}, {9, 7, 7}, {9, 9, 9}};
	static int tetroZ2[][] = {{9, 9, 7}, {9, 7, 7}, {9, 7, 9}};
	static int tetroZ3[][] = {{9, 9, 9}, {7, 7, 9}, {9, 7, 7}};
	static int tetroZ4[][] = {{9, 7, 9}, {7, 7, 9}, {7, 9, 9}};
	
	
	
	static int shapeNum;
	static int shapeHeight, shapeWidth;
	static int shapeCenterX, shapeCenterY;
	static int board[][];
	boolean hitBottom = false;
	static int boardX = 12;
	static int boardY = 22; 
	static int origX;
	static int origY;
	static int offset = 10;
	static int stateNum = 1;
	static int speed;
	static int currentLevel;
	
	static void initBoard(){
		board = new int[boardX][boardY];
		int i, j;
		for(i = 0; i < boardX; i++){
			for(j = 0; j < boardY; j++){
				board[i][j] = 0;
				System.out.print("" + board[i][j]);
			}
			System.out.println("");
		}
		speed = 700;
		currentLevel = 1;
		
	}
	
	static void increaseSpeed(){
		speed = 50 - (currentLevel * 2) * 700; // The 700 is a factor to simply amplify the time because we're using the sleep command
	}
	
	static void delay(){
		try {
			  Thread.sleep(speed);
			} catch (InterruptedException ie) {
			    //Handle exception
			}		
	}
	
	static int[][] nextPiece(){
		Random rand = new Random();
		int temp = rand.nextInt(7);
		if(temp == 0){
			shapeNum = 1;
			shapeHeight = 2; 
			shapeWidth = 2;
			shapeCenterX = 0;
			shapeCenterY = offset;
			return tetroO1;
		}
		else if(temp == 1){
			shapeNum = 2;
			shapeHeight = 4; 
			shapeWidth = 4;
			shapeCenterX = 2;
			shapeCenterY = offset;
			return tetroI1;			
		}
		else if(temp == 2){
			shapeNum = 3;
			shapeHeight = 3; 
			shapeWidth = 3;
			shapeCenterX = 1;
			shapeCenterY = offset;
			return tetroT1;			
		}
		else if(temp == 3){
			shapeNum = 4;
			shapeHeight = 3; 
			shapeWidth = 3;
			shapeCenterX = 1;
			shapeCenterY = offset;
			return tetroL1;			
		}
		else if(temp == 4){
			shapeNum = 5;
			shapeHeight = 3; 
			shapeWidth = 3;
			shapeCenterX = 1;
			shapeCenterY = offset;
			return tetroRL1;			
		}
		else if(temp == 5){
			shapeNum = 6;
			shapeHeight = 3; 
			shapeWidth = 3;
			shapeCenterX = 1;
			shapeCenterY = offset;
			return tetroS1;			
		}
		else{
			shapeNum = 7;
			shapeHeight = 3; 
			shapeWidth = 3;
			shapeCenterX = 1;
			shapeCenterY = offset;
			return tetroZ1;				
		}
	}
	
	static boolean hitBottom(){

		return false;
	}
	
	/*
	 * this sets the piece falling down to the center of the top of the board
	 */
	static void firstDrop(int [][] shape){
		int i, j;
		System.out.println("shapeHeight: " + shapeHeight + " shapeWidth: " + shapeWidth);
		for(i = 0; i < shapeHeight; i++){
			for(j = 0; j < shapeWidth; j++){
				board[i][j+offset] = shape[i][j];
			}
			System.out.println("");
		}
		System.out.println("PRINTED!");
		printBoard();
	}
	
	/*
	 * method to check if the position below one of the blocks of a shape is a free space or if there is a block already there
	 * we do this to stop the new piece falling from overwriting the pieces already on the ground and stopping right on top of one
	 */
	static boolean isNextNotASpace(){
		int i, j;
		for (i = 0; i < boardX; i++){
			for (j = 0; j < boardY; j++){
				if (board[i][j] == shapeNum){
					if ( (i + 1) != boardX){
						if (board[i+1][j] != 0 && board[i+1][j] != shapeNum && board[i+1][j] != 9){
							return true;
						}
					}
					else
							return false;
				}
			}
		}
		return false;
	}
	
	
	/*
	 * method to keep dropping a shape down at a specific rate 
	 */
	static boolean finishedDropping = false;
	static void movePieceDown(int [][] shape){
		int i, j; int y = 0;
		firstDrop(shape);
		while(!finishedDropping){
			for(i = boardX-1; i>=0 ; i--){
				for(j = boardY-1; j >=0; j--){
					if(i+1 < boardX  && j < boardY && (board[i][j] == shapeNum || board[i][j] == 9)){
						board[i+1][j] = board[i][j];
						board[i][j] = 0;
					}
				}					
			}
//			delay();
//			if(y > 3){
//			  //movePieceLeft();
//			  rotatePiece();
//			}
			shapeCenterX++;
			if (shapeCenterX +1 == boardX || isNextNotASpace()){
				System.out.println("shapeCenterX: " + shapeCenterX + " isNextNotASpace: " + isNextNotASpace() );
				finishedDropping = true;
				System.out.println("shapeNum: " + shapeNum);				
				for(i = 0; i < boardX; i++){
					for(j = 0; j < boardY; j++){
						if(board[i][j] == shapeNum)
							board[i][j] = board[i][j] + 10;
					}
				}
				System.out.println("1ShapeCenterX: " + shapeCenterX + " " + "1ShapeCenterY: " + shapeCenterY);
				return;
			}
			else {
				delay();
				if(y > 3){
				  //movePieceLeft();
				  rotatePiece();
				}
				y++;
				printBoard();					
			}
//			delay();
//			if(y > 3){
//			  //movePieceLeft();
//			  rotatePiece();
//			}
			//y++;
		
		}
	}
	
	/**
	 * Rotate piece to the left of the board
	 */
	static void movePieceLeft(){
		int i, j;
		for(i = 0; i < boardX; i++){
			for(j = 0; j < boardY; j++){
				if(board[i][j] == shapeNum){
					board[i][j-1] = board[i][j];
					board[i][j] = 0;
				}
			}
		}
		shapeCenterY--;		
	}
	
	/**
	 * Rotate piece to the right of the board
	 */
	static void movePieceRight(){
		int i, j;
		for(i = 0; i < boardX; i++){
			for(j = 0; j < boardY; j++){
				if(board[i][j] == shapeNum){
					board[i][j+1] = board[i][j];
					board[i][j] = 0;
				}
			}
		}
		shapeCenterY++;	
	}

	/**
	 * Print board
	 */
	static void printBoard(){
		int i, j;
		System.out.println("");
		for(i = 0; i <boardX; i++){
			for(j = 0; j< boardY; j++){
				System.out.print(board[i][j] + "");
			}
		System.out.println("");
		}
	}
	
	/**
	 * Rotate the current tetromino...
	 * For rotate piece function, it assumes shapeNum and stateNum have been previously set
	 * @param shape
	 */
	// 6 aka the letter s
	static void rotatePiece(){
		int i, j, x, y, cornerX, cornerY; 
		int firstTime = 0; cornerX = 0; cornerY = 0;
		for(i = 0; i < boardX; i++){
			for(j = 0; j < boardY; j++){
				if(board[i][j] == shapeNum || board[i][j] == 9){
					if(firstTime == 0){
						cornerX = i; cornerY = j;
						firstTime = 1;
					}
//					if(i != shapeCenterX && j != shapeCenterY){
					board[i][j] = 0;
//					}
				}
			}
		}
		System.out.println("/*************************/");
		//printBoard();
		int [][] shape;
		
		if (shapeNum == 1){
			if (stateNum == 1 || stateNum == 3){
				stateNum = 2;
				shape = tetroO2;
				shapeHeight = 2;
				shapeWidth = 2;
			} else {
				stateNum = 3;
				shape = tetroO1;
				shapeHeight = 2;
				shapeWidth = 2;
			}
		}
		else if(shapeNum == 2){
			if(stateNum == 1 || stateNum == 3){
				stateNum  = 2;
				shape = tetroI2;
				shapeHeight = 4;
				shapeWidth = 4;
			} else{ /*(stateNum == 2 || stateNum == 4)*/
				stateNum  = 3;
				shape = tetroI1;
				shapeHeight = 4;
				shapeWidth = 4;
			} 
		}
		else if (shapeNum == 3){
			if(stateNum == 1){
				stateNum  = 2;
				shape = tetroT2;
				shapeHeight = 3;
				shapeWidth = 3;
			} else if(stateNum == 2){
				stateNum  = 3;
				shape = tetroT3;
				shapeHeight = 3;
				shapeWidth = 3;
			} else if(stateNum == 3){
				stateNum  = 4;
				shape = tetroT4;
				shapeHeight = 3;
				shapeWidth = 3;
			} else { //stateNum == 4
				stateNum  = 1;
				shape = tetroT1;
				shapeHeight = 3;
				shapeWidth = 3;
			}
		}
		
		else if (shapeNum == 4){
			if(stateNum == 1){
				stateNum  = 2;
				shape = tetroL2;
				shapeHeight = 3;
				shapeWidth = 3;
			} else if(stateNum == 2){
				stateNum  = 3;
				shape = tetroL3;
				shapeHeight = 3;
				shapeWidth = 3;
			} else if(stateNum == 3){
				stateNum  = 4;
				shape = tetroL4;
				shapeHeight = 3;
				shapeWidth = 3;
			} else { //stateNum == 4
				stateNum  = 1;
				shape = tetroL1;
				shapeHeight = 3;
				shapeWidth = 3;
			}
		}
		
		else if (shapeNum == 5){
			if(stateNum == 1){
				stateNum  = 2;
				shape = tetroRL2;
				shapeHeight = 3;
				shapeWidth = 3;
			} else if(stateNum == 2){
				stateNum  = 3;
				shape = tetroRL3;
				shapeHeight = 3;
				shapeWidth = 3;
			} else if(stateNum == 3){
				stateNum  = 4;
				shape = tetroRL4;
				shapeHeight = 3;
				shapeWidth = 3;
			} else { //stateNum == 4
				stateNum  = 1;
				shape = tetroRL1;
				shapeHeight = 3;
				shapeWidth = 3;
			}
		}
		
		else if(shapeNum == 6){
			if(stateNum == 1){
				stateNum  = 2;
				shape = tetroS2;
				shapeHeight = 3;
				shapeWidth = 2;
			} else if(stateNum == 2){
				stateNum  = 3;
				shape = tetroS3;
				shapeHeight = 3;
				shapeWidth = 3;
			} else if(stateNum == 3){
				stateNum  = 4;
				shape = tetroS4;
				shapeHeight = 3;
				shapeWidth = 3;
			} else { //stateNum == 4
				stateNum  = 1;
				shape = tetroS1;
				shapeHeight = 3;
				shapeWidth = 3;
			}
		}	
		else /*shapeNum == 7*/{
				if(stateNum == 1){
					stateNum  = 2;
					shape = tetroZ2;
					shapeHeight = 3;
					shapeWidth = 3;
				} else if(stateNum == 2){
					stateNum  = 3;
					shape = tetroZ3;
					shapeHeight = 3;
					shapeWidth = 3;
				} else if(stateNum == 3){
					stateNum  = 4;
					shape = tetroZ4;
					shapeHeight = 3;
					shapeWidth = 3;
				} else { //stateNum == 4
					stateNum  = 1;
					shape = tetroZ1;
					shapeHeight = 3;
					shapeWidth = 3;
				}
			}
		
		System.out.print("shapeCenterX: " + shapeCenterX + " shapeCenterY: " + shapeCenterY);
		
		for(i = 0; i < boardX; i++){
			for(j = 0; j < boardY; j++){
				if(i == cornerX && j == cornerY){
					if(cornerX + 2 != boardX){
						for(x = 0; x < shapeHeight; x++){
							for(y = 0; y < shapeWidth; y++){
								int t = x + i;
								System.out.println("" + i + " + " + x + " :" + t);
		//		board[shapeCenterX - (shapeHeight - x)][shapeCenterY - (shapeWidth - y)] = shape[x][y];
								board[i + x][j + y] = shape[x][y];
							}
						}	
					}
				}
			}
		}
	}
	
	public static void main(String[] args){
		initBoard();
		shapeHeight = 3;
		shapeWidth = 3;
		shapeCenterX = 1;
		shapeCenterY = offset + 1;
		shapeNum = 3;
//		movePieceDown(nextPiece());
		movePieceDown(tetroT1);
		finishedDropping = false;
		int i = 0;
		while (i < 8){
			movePieceDown(nextPiece());
			finishedDropping = false;
			i++;
		}
//		movePieceDown(nextPiece());
//		finishedDropping = false;
//		
//		movePieceDown(nextPiece());
//		finishedDropping = false;
//		
//		movePieceDown(nextPiece());
//		finishedDropping = false;
//		
//		movePieceDown(nextPiece());
//		finishedDropping = false;
		
		return;
	}	
}
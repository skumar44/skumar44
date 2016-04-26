import java.util.Random;

public class BoardMechanics {

	
	static int tetroO1[][] = {{1, 1},{1, 1}};
	static int tetroO2[][] = {{1, 1},{1, 1}};
	static int tetroO3[][] = {{1, 1},{1, 1}};
	static int tetroO4[][] = {{1, 1},{1, 1}};

	
	static int tetroI1[][] = {{2, 0},{2, 0},{2, 0},{2, 0}};
	static int tetroI2[][] = {{0, 0, 0, 0},{2, 2, 2, 2}};
	static int tetroI3[][] = {{2, 0},{2, 0},{2, 0},{2, 0}};
	static int tetroI4[][] = {{0, 0, 0, 0},{2, 2, 2, 2}};

	static int tetroT1[][] = {{3, 3, 3},{0, 3, 0}};	
	static int tetroT2[][] = {{3, 0},{3, 3}, {3, 0}};
	static int tetroT3[][] = {{0, 3, 0},{3, 3, 3}};
	static int tetroT4[][] = {{0, 3},{3, 3}, {0, 3}};
	
	static int tetroL1[][] = {{4, 0},{4, 0},{4, 4}};
	static int tetroL2[][] = {{0, 0, 4},{4, 4, 4}};
	static int tetroL3[][] = {{4, 4},{0, 4},{0, 4}};
	static int tetroL4[][] = {{4, 4, 4},{4, 0, 0}};

	static int tetroRL1[][] = {{0, 5}, {0, 5}, {5, 5}};
	static int tetroRL2[][] = {{5, 5, 5}, {0, 0, 5}};
	static int tetroRL3[][] = {{5, 5}, {5, 0}, {5, 0}};
	static int tetroRL4[][] = {{5, 0, 0}, {5, 5, 5}};

	static int tetroS1[][] = {{0, 6, 6},{6, 6, 0}};
	static int tetroS2[][] = {{6, 0},{6, 6}, {0, 6}};
	static int tetroS3[][] = {{0, 6, 6},{6, 6, 0}};
	static int tetroS4[][] = {{6, 0},{6, 6}, {0, 6}};

	static int tetroZ1[][] = {{7, 7, 0}, {0, 7, 7}};
	static int tetroZ2[][] = {{0, 7}, {7, 7}, {7, 0}};
	static int tetroZ3[][] = {{7, 7, 0}, {0, 7, 7}};
	static int tetroZ4[][] = {{0, 7}, {7, 7}, {7, 0}};
	
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
	}
	
	static void delay(){
		try {
			  Thread.sleep(1500);
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
			shapeWidth = 2;
			shapeCenterX = 1;
			shapeCenterY = offset;
			return tetroI1;			
		}
		else if(temp == 2){
			shapeNum = 3;
			shapeHeight = 2; 
			shapeWidth = 3;
			shapeCenterX = 0;
			shapeCenterY = offset + 1;
			return tetroT1;			
		}
		else if(temp == 3){
			shapeNum = 4;
			shapeHeight = 3; 
			shapeWidth = 2;
			shapeCenterX = 2;
			shapeCenterY = offset;
			return tetroL1;			
		}
		else if(temp == 4){
			shapeNum = 5;
			shapeHeight = 3; 
			shapeWidth = 2;
			shapeCenterX = 1;
			shapeCenterY = offset+1;
			return tetroRL1;			
		}
		else if(temp == 5){
			shapeNum = 6;
			shapeHeight = 2; 
			shapeWidth = 3;
			shapeCenterX = 0;
			shapeCenterY = offset+1;
			return tetroS1;			
		}
		else{
			shapeNum = 7;
			shapeHeight = 2; 
			shapeWidth = 3;
			shapeCenterX = 0;
			shapeCenterY = offset+1;
			return tetroZ1;				
		}
	}
	
	static boolean hitBottom(){

		return false;
	}
	
	static void firstDrop(int [][] shape){
		int i, j;
		System.out.println("shapeHeight: " + shapeHeight + " shapeWidth: " + shapeWidth);
		for(i = 0; i < shapeHeight; i++){
			for(j = 0; j < shapeWidth; j++){
				board[i][j+offset] = shape[i][j];
			}
			System.out.println("");
		}
		printBoard();
	}
	
	static boolean finishedDropping = false;
	static void movePieceDown(int [][] shape){
		int i, j; int y = 0;
		firstDrop(shape);
		while(!finishedDropping){
		for(i = boardX-1; i>=0 ; i--){
			for(j = boardY-1; j >=0; j--){
				if(board[i][j] != 0 && i < boardY){

					board[i+1][j] = board[i][j];
					board[i][j] = 0;
				}
				}					
			}
		
		shapeCenterX++;
		delay();
		if(y > 3){
			rotatePiece();
		}
		y++;
		printBoard();		
		}
	}
	
	/**
	 * Roate piece to the counter clockwise
	 * @param shape
	 */
	static void movePieceLeft(int [][] shape){
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
	 * Rotate piece clockwise
	 * @param shape
	 */
	static void movePieceRight(int [][] shape){
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
	 * Rotate the curretnt tetromonioeo...
	 * For rotate piece function, it assumes shapeNum and stateNum have been previously set
	 * @param shape
	 */
	// 6 aka the letter s
	static void rotatePiece(){
		int i, j, x, y, x1, y1;
		int newX, newY;
		for(i = 0; i < boardX; i++){
			for(j = 0; j < boardY; j++){
				if(board[i][j] == shapeNum ){// == 6
//					if(i != shapeCenterX && j != shapeCenterY){
						board[i][j] = 0;
//					}
				}
			}
		}
		System.out.println("/*************************/");
		printBoard();
		System.out.println("/*************************/");
		int [][] shape;
		
		if(shapeNum == 2){
			if(stateNum == 1 || stateNum == 3){
				stateNum  = 2;
				shape = tetroI2;
				shapeHeight = 2;
				shapeWidth = 4;
			} else{ /*(stateNum == 2 || stateNum == 4)*/
				stateNum  = 3;
				shape = tetroI1;
				shapeHeight = 4;
				shapeWidth = 2;
			} 
		}
		else/*(shapeNum == 6)*/{
			if(stateNum == 1){
				stateNum  = 2;
				shape = tetroS2;
				shapeHeight = 3;
				shapeWidth = 2;
			} else if(stateNum == 2){
				stateNum  = 3;
				shape = tetroS3;
				shapeHeight = 2;
				shapeWidth = 3;
			} else if(stateNum == 3){
				stateNum  = 4;
				shape = tetroS4;
				shapeHeight = 3;
				shapeWidth = 2;
			} else { //stateNum == 4
				stateNum  = 1;
				shape = tetroS1;
				shapeHeight = 2;
				shapeWidth = 3;
			}
		}
		
		
		System.out.print("shapeCenterX: " + shapeCenterX + " shapeCenterY: " + shapeCenterY);
		for(x = 0; x < shapeHeight; x++){
			for(y = 0; y < shapeWidth; y++){
				board[shapeCenterX - (shapeHeight - x)][shapeCenterY - (shapeWidth - y)] = shape[x][y];
			}
		}
		
		
		
	}
	
	public static void main(String[] args){
		initBoard();
		shapeHeight = 4;
		shapeWidth = 2;
		shapeCenterX = 1;
		shapeCenterY = offset;
		shapeNum = 2;
//		movePieceDown(nextPiece());
		movePieceDown(tetroI1);

		return;
	}
	
	
	
}

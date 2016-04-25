import java.util.Random;

public class BoardMechanics {

	
	static int tetroO[][] = {{1, 1},{1, 1}};
	static int tetroI[][] = {{2, 0},{2, 0},{2, 0},{2, 0}};
	static int tetroT[][] = {{3, 3, 3},{0, 3, 0}};	
	static int tetroL[][] = {{4, 0},{4, 0},{4, 4}};
	static int tetroRL[][] = {{0, 5}, {0, 5}, {5, 5}};
	static int tetroS[][] = {{0, 6, 6},{6, 6, 0}};
	static int tetroZ[][] = {{7, 7, 0}, {0, 7, 7}};
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
			  Thread.sleep(500);
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
			return tetroO;
		}
		else if(temp == 1){
			shapeNum = 2;
			shapeHeight = 4; 
			shapeWidth = 2;
			shapeCenterX = 1;
			shapeCenterY = offset;
			return tetroI;			
		}
		else if(temp == 2){
			shapeNum = 3;
			shapeHeight = 2; 
			shapeWidth = 3;
			shapeCenterX = 0;
			shapeCenterY = offset + 1;
			return tetroT;			
		}
		else if(temp == 3){
			shapeNum = 4;
			shapeHeight = 3; 
			shapeWidth = 2;
			shapeCenterX = 2;
			shapeCenterY = offset;
			return tetroL;			
		}
		else if(temp == 4){
			shapeNum = 5;
			shapeHeight = 3; 
			shapeWidth = 2;
			shapeCenterX = 1;
			shapeCenterY = offset+1;
			return tetroRL;			
		}
		else if(temp == 5){
			shapeNum = 6;
			shapeHeight = 2; 
			shapeWidth = 3;
			shapeCenterX = 0;
			shapeCenterY = offset+1;
			return tetroS;			
		}
		else{
			shapeNum = 7;
			shapeHeight = 2; 
			shapeWidth = 3;
			shapeCenterX = 0;
			shapeCenterY = offset+1;
			return tetroZ;				
		}
	}
	
	static boolean hitBottom(){

		return false;
	}
	
	static void firstDrop(int [][] shape){
		int i, j;
		System.out.println("");
//		System.out.println("Hey");
		for(i = 0; i < shapeHeight; i++){
			for(j = 0; j < shapeWidth; j++){
//				System.out.print(shape[i][j] + " ");
				board[i][j+offset] = shape[i][j];
			}
			System.out.println("");

		}
		printBoard();
	}
	
	static boolean finishedDropping = false;
	static void movePieceDown(int [][] shape){
		int i, j;
		firstDrop(shape);
		while(!finishedDropping){
		for(i = boardX-1; i>=0 ; i--){
			for(j = boardY-1; j >=0; j--){
				if(board[i][j] != 0 && i < boardY){
//					if(i+1 == boardX-1)
//						finishedDropping = true;
					board[i+1][j] = board[i][j];
					board[i][j] = 0;					
				}
				}					
			}
		delay();
//		if(y > 2)
//			roatePiece();
		printBoard();		
		}
		

	}
	
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
	
	static void roatePiece(){
		int i, j, x, y, x1, y1;
		int newX, newY;
		for(i = 0; i < boardX; i++){
			for(j = 0; j < boardY; j++){
				if(board[i][j] != 0){
					newX = i + shapeCenterX - shapeCenterY;
					newY = shapeCenterX + shapeCenterY - i;
					board[newX][newY] = shapeNum;
					board[i][j] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args){
		initBoard();
		shapeHeight = 3;
		shapeWidth = 2;
		movePieceDown(nextPiece());
		return;
	}
	
	
	
}

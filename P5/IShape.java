package tetrisGame;

public class IShape extends Tetromino{

	public int [][] state1;
	public int [][] state2; 
	public int [][] state3; 
	public int [][] state4; 

	public int[][] IShape1(){
		return state1 = Tetromino.tetroI1;
	}
	public int[][] IShape2(){
		return state2 = Tetromino.tetroI2;
	}
	public int[][] IShape3(){
		return state3 = Tetromino.tetroI3;
	}
	public int[][] IShape4(){
		return state4 = Tetromino.tetroI4;
	}

	
}

package tetrisGame;

public class TShape extends Tetromino{

	public int [][] state1;
	public int [][] state2; 
	public int [][] state3; 
	public int [][] state4; 

	public int[][] TShape1(){
		return state1 = Tetromino.tetroT1;
	}
	public int[][] TShape2(){
		return state2 = Tetromino.tetroT2;
	}
	public int[][] TShape3(){
		return state3 = Tetromino.tetroT3;
	}
	public int[][] TShape4(){
		return state4 = Tetromino.tetroT4;
	}

}

package tetrisGame;

public class LShape extends Tetromino{

	public int [][] state1;
	public int [][] state2; 
	public int [][] state3; 
	public int [][] state4; 

	public int[][] LShape1(){
		return state1 = Tetromino.tetroL1;
	}
	public int[][] LShape2(){
		return state2 = Tetromino.tetroL2;
	}
	public int[][] LShape3(){
		return state3 = Tetromino.tetroL3;
	}
	public int[][] LShape4(){
		return state4 = Tetromino.tetroL4;
	}

}

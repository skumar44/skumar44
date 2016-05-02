package tetrisGame;

import java.util.Random;

public class ShapeFactory {

	Tetromino shape;
	/**
	 * Squares
	 * @return
	 */
	public int [][] generateSquare1(){
		return shape.tetroO1;
	}
	public int [][] generateSquare2(){
		return shape.tetroO2;
	}
	public int [][] generateSquare3(){
		return shape.tetroO3;
	}
	public int [][] generateSquare4(){
		return shape.tetroO4;
	}
	
	/**
	 * I's
	 * @return
	 */
	public int [][] generateI1(){
		return shape.tetroI1;
	}
	public int [][] generateI2(){
		return shape.tetroI2;
	}
	public int [][] generateI3(){
		return shape.tetroI3;
	}
	public int [][] generateI4(){
		return shape.tetroI4;
	}
	
	/**
	 * T's
	 * @return
	 */
	public int [][] generateT1(){
		return shape.tetroT1;
	}
	public int [][] generateT2(){
		return shape.tetroT2;
	}
	public int [][] generateT3(){
		return shape.tetroT3;
	}
	public int [][] generateT4(){
		return shape.tetroT4;
	}
	
	/**
	 * L's
	 * @return
	 */
	public int [][] generateL1(){
		return shape.tetroL1;
	}
	public int [][] generateL2(){
		return shape.tetroL2;
	}
	public int [][] generateL3(){
		return shape.tetroL3;
	}
	public int [][] generateL4(){
		return shape.tetroL4;
	}
	
	
	/**
	 * Reverse L's
	 * @return
	 */
	public int [][] generateRL1(){
		return shape.tetroRL1;
	}
	public int [][] generateRL2(){
		return shape.tetroRL2;
	}
	public int [][] generateRL3(){
		return shape.tetroRL3;
	}
	public int [][] generateRL4(){
		return shape.tetroRL4;
	}
	
	/**
	 * S's
	 * @return
	 */
	public int [][] generateS1(){
		return shape.tetroS1;
	}
	public int [][] generateS2(){
		return shape.tetroS2;
	}
	public int [][] generateS3(){
		return shape.tetroS3;
	}
	public int [][] generateS4(){
		return shape.tetroS4;
	}
	
	/**
	 * Z's
	 * @return
	 */
	public int [][] generateZ1(){
		return shape.tetroZ1;			
	}
	public int [][] generateZ2(){
		return shape.tetroZ2;			
	}
	public int [][] generateZ3(){
		return shape.tetroZ3;			
	}
	public int [][] generateZ4(){
		return shape.tetroZ4;			
	}
	
	

}

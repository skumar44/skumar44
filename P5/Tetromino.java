package tetrisGame;

public abstract class Tetromino {
	
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
	
	
}

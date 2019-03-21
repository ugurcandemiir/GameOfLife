package lab09;

public class CellGrid
{
	private boolean[][] cells;
	private int maxRows;
	private int maxCols;
	private int a;
	public CellGrid(int mRows, int mCols)
	{
		maxRows = mRows;
		maxCols = mCols;
		cells = new boolean[mRows][mCols];
		for(int i = 0; i < mRows; i++)
			for(int j = 0; j < mCols; j++)
				cells[i][j] = false;
	}

	public boolean[][] getCells() {
		return cells;
	}

	public void randomStart()
	{
		java.util.Random random = new java.util.Random();
		for(int i = 0; i < maxRows; i++)
			for(int j = 0; j < maxCols; j++)
				cells[i][j] = random.nextBoolean();
	}

	public void applyUpdate()
	{
		int[][] living = new int[maxRows][maxCols];
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxCols; j++) {
                int top = (j > 0 ? j - 1 : maxCols - 1);
                int bottom = (j < maxCols - 1 ? j + 1 : 0);
                int left = (i > 0 ? i - 1 : maxRows - 1);
                int right = (i < maxRows - 1 ? i + 1 : 0);
                int neighbors = 0;

                if (cells[i][top]== true) {
                    neighbors++;
                }
                if (cells[i][bottom]== true) {
                    neighbors++;
                }
                if (cells[left][top]== true) {
                    neighbors++;
                }
                if (cells[left][bottom]== true) {
                    neighbors++;
                }
                if (cells[left][j]== true) {
                    neighbors++;
                }
                if (cells[right][j]== true) {
                    neighbors++;
                }
                if (cells[right][top]== true) {
                    neighbors++;
                }
                if (cells[right][bottom]== true) {
                    neighbors++;
                }
                living[i][j] = neighbors ;
            }
        }
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j  < maxCols; j++) {
            	if (living[i][j] == 3) cells[i][j] = true; 
            	
            	if (living[i][j] < 2  ) cells[i][j] = false ;
            	
            	if (living[i][j] > 3 )  cells[i][j] = false ;
            	
           
            }
          
        }
	}
	public void gosperStart() {
		for(int i = 0; i < maxRows; i++)
			for(int j = 0; j < maxCols; j++)
				cells[i][j] = false;
		cells[5][1] = true;
		cells[5][2] = true;
		cells[6][1] = true;
		cells[6][2] = true;
		cells[1][25] = true;
		cells[2][23] = true;
		cells[2][25] = true;
		cells[3][13] = true;
		cells[3][14] = true;
		cells[3][21] = true;
		cells[3][22] = true;
		cells[3][35] = true;
		cells[3][36] = true;
		cells[4][12] = true;
		cells[4][16] = true;
		cells[4][21] = true;
		cells[4][22] = true;
		cells[4][35] = true;
		cells[4][36] = true;
		cells[5][11] = true;
		cells[5][17] = true;
		cells[5][21] = true;
		cells[5][22] = true;
		cells[6][11] = true;
		cells[6][15] = true;
		cells[6][17] = true;
		cells[6][18] = true;
		cells[6][23] = true;
		cells[6][25] = true;
		cells[7][11] = true;
		cells[7][17] = true;
		cells[7][25] = true;
		cells[8][12] = true;
		cells[8][16] = true;
		cells[9][13] = true;
		cells[9][14] = true;
	}

	public void gliderStart() {
		for(int i = 0; i < maxRows; i++)
			for(int j = 0; j < maxCols; j++)
				cells[i][j] = false;
		cells[1][3] = true;
		cells[2][4] = true;
		cells[3][2] = true;
		cells[3][3] = true;
		cells[3][4] = true;
	}
}

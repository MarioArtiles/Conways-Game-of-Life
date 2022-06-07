package TheGame;

import java.util.Random;

import javax.swing.JOptionPane;

public class Game {
	
	private static boolean[][] Cells;
	// private static String rowlen = JOptionPane.showInputDialog("what will be the size of your square grid (input will be both row and column length)");
	public static int row; // Integer.parseInt(rowlen);
	public static int col = row;
	// public static String liveChance;  // JOptionPane.showInputDialog("What percent chance will each cell have to start alive(from 1 to 80 only)?");
	public static int chance; // Integer.parseInt(liveChance);
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		try
		{
			int rows = 0;
			int cols = 0;
			boolean runRows = true;
			while (runRows)
			{
				rows = Integer.parseInt(JOptionPane.showInputDialog(null, "enter grid dimensions (input will be both row and column length, minimun 10 and maximum 34)"));
				if (rows > 34 || rows < 10)
				{
					JOptionPane.showMessageDialog(null, "input out of bounds");
				}
				else
				{
					runRows = false;
				}
			}
				cols = rows;
			
			boolean[][] array = new boolean[rows-1][cols-1];
			
			Random rand = new Random();
			int ran1 = 0;
			boolean runRan = true;
			while (runRan)
			{
				ran1 = Integer.parseInt(JOptionPane.showInputDialog(null, "What percent chance will each cell have to start alive(from 1 to 80 only)?"));
				if (ran1 > 80 || ran1 < 1)
				{
					JOptionPane.showInputDialog(null, "input out of bounds");
				}
				else
				{
					runRan = false;
				}
			}
			for (int i = 0; i < array.length; i++)
			{
				for (int j = 0; j < array[i].length; j++)
				{
					int ran2 = rand.nextInt(101);
					
					if (ran2 <= ran1)
					{
						array[i][j] = true;
					}
					else
					{
						array[i][j] = false;
					}	
				}
			}
			
			boolean run = true;
			
			while (run)
			{
				String display = "";
				
				for (int i = 0; i < array.length; i++)
				{
					for (int j = 0; j < array[i].length; j++)
					{
						if (array [i][j])
						{
							display += " @ ";
						}
						else
						{
							display += "  o  ";
						}
					}
					display += "\n";
				}
				
				String[] options = new String[] {"next gen", "exit"};
				Object answer = JOptionPane.showInputDialog(null, display + "\n" + "@'s  are  alive  cells  and  o's  are  dead  cells", null, 1, null, options, null);
				if (answer.equals("next gen"))
				{	
					for (int i = 0; i < array.length; i++)
					{
						for (int j = 0; j < array[i].length; j++)
						{
							int neighbors = 0;
							
							try
							{
								if (array[i-1][j-1])
								{
									neighbors++;
								}
								if (array[i-1][j])
								{
									neighbors++;
								}
								if (array[i-1][j+1])
								{
									neighbors++;
								}
								if (array[i][j-1])
								{
									neighbors++;
								}
								if (array[i][j+1])
								{
									neighbors++;
								}
								if (array[i+1][j-1])
								{
									neighbors++;
								}
								if (array[i+1][j])
								{
									neighbors++;
								}
								if (array[i+1][j+1])
								{
									neighbors++;
								}
							}
							catch (Exception e){}
							
							if (array[i][j])
							{
								if (neighbors < 2)
								{
									array[i][j] = false;
								}
								else if (neighbors > 3)
								{
									array[i][j] = false;
								}
							}
							else if (!array[i][j])
							{
								if (neighbors == 3)
								{
									array[i][j] = true;
								}
							}
						}
					}					
				}
				else if (answer.equals("exit"))
				{
					run = false;
				}
				else if (answer.equals(0))
				{
					run = false;
				}
			}			
		}
		catch (Exception e){}
	}

	
	

		
	
	public static void GiveLife() {
		int cnt = 0;
		Cells = new boolean[row][col];
		//System.out.println(Cells.length);
		//System.out.println(Cells[0].length);
		for(int r = 0; r < Cells.length; r++) {
			for(int c = 0; c < Cells.length; c++) {	
				Cells[r][c] = Math.random() <= (double)chance/100; 
			}
		}
		for(int r = 0; r < Cells.length; r++) {
			for(int c = 0; c < Cells.length; c++) {				
				if(Cells[r][c] == true) {
					cnt++;
				}	
			}
		}
		//System.out.println((double)cnt/(row*col));
	}
	
	private static String drawMap(boolean[][] Map) {
		Cells = Map;
		String map = "";
		for(int r = 0; r < Cells.length; r++) {
			for(int c = 0; c < Cells[0].length; c++) {
				if(Cells[r][c]) {
					map+= " @ ";
					map+= "";
				}
				else if(!Cells[r][c]) {
					map+= "  0  ";
					map+= "";
				}
			}
			map += "\n";
		}
		return map;
	}
	
	public static void NextGen(boolean[][] lastGen){
		//JOptionPane.showMessageDialog(null, drawMap(Cells));
		Cells = lastGen;
		boolean[][] nextGen = new boolean[row][col];
		for (int i = 0; i < Cells.length; i++)
		{
			for (int j = 0; j < Cells[i].length; j++)
			{
				int neighbors = 0;
				
				try
				{
					if (Cells[i-1][j-1])
					{
						neighbors++;
					}
					if (Cells[i-1][j])
					{
						neighbors++;
					}
					if (Cells[i-1][j+1])
					{
						neighbors++;
					}
					if (Cells[i][j-1])
					{
						neighbors++;
					}
					if (Cells[i][j+1])
					{
						neighbors++;
					}
					if (Cells[i+1][j-1])
					{
						neighbors++;
					}
					if (Cells[i+1][j])
					{
						neighbors++;
					}
					if (Cells[i+1][j+1])
					{
						neighbors++;
					}
				}
				catch (Exception e){}
				
				if (Cells[i][j])
				{
					if (neighbors < 2)
					{
						Cells[i][j] = false;
					}
					else if (neighbors > 3)
					{
						Cells[i][j] = false;
					}
				}
				else if (!Cells[i][j])
				{
					if (neighbors == 3)
					{
						Cells[i][j] = true;
					}
				}
			}
		}
		nextGen = Cells;
		Cells = nextGen;
    }
}

package midterm;

import java.util.ArrayList;

	class Cell{
		int x,y;
		Cell(int x, int y){
			this.x = x;
			this.y = y;
		}
		public String toString(){
			return "["+ this.x +","+ this.y + "]";
		}
	}

	public class Extra {
		ArrayList<Cell> result = new ArrayList<Cell>();
		
		public ArrayList<Cell> findPath(int[][] maze){
			move( maze,0 ,0 ,maze.length -1, maze[0].length -1);
			return result;
			}
		
		public void move(int maze[][], int x, int y, int xtail, int ytail){
			if(x == maze.length - 1 && y == maze.length - 1){
				result.add(new Cell(x,y));
			}
			if(x >= 0 && y >= 0 && x <= maze.length-1 && y <= maze.length-1 && maze[x][y] == 1){
				result.add(new Cell(x,y));
				
				move(maze, x+1, y, xtail, ytail);
				
				move(maze, x, y+1, xtail, ytail);
			}
	    }
	
	public static void main(String[] args) {
		Extra e = new Extra();
		int maze[][] = {
				{1,0,0,0,0},
				{1,1,0,0,0},
				{0,1,1,1,1},
				{0,0,1,0,1},
				{1,0,0,1,1},
		};
		for(Cell c: e.findPath(maze)){
			System.out.print(c.toString()+",");
		}
	}

}

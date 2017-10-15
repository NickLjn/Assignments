package assignment5;

import java.util.ArrayList;
import java.util.List;

public class Extra {
	public static void main(String args[]){
		int[][] mx = {{1,2,3},{4,5,6},{7,8,9}};
		Extra e = new Extra();
		System.out.print(e.spiralOrder(mx));
	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if (matrix == null||matrix.length==0){
			return res;
		}
		int left = 0, right = matrix.length - 1, top = 0, bottom = matrix[0].length - 1;
		while(left < right && top < bottom){
			for(int i = left; i < right; i++){
				res.add(matrix[top][i]);
			}
			for(int i = top; i < bottom; i++){
				res.add(matrix[i][right]);
			}
			for(int i = right; i > left; i--){
				res.add(matrix[bottom][i]);
			}
			for(int i = bottom; i > top; i--){
				res.add(matrix[i][left]);
			}
			top++;
			bottom--;
			left++;
			right--;
		}
		return res;
    }
}

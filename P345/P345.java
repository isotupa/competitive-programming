package aop.P345;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class P345 {
	
	static int nums[] = {0,0,0,0,0,0,0,0,0};
	
	public static void main(String[] args) {
		
		int sudoku[][] = {
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0}
		};
		
		try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 1*1024))) {
			int casos = sc.nextInt();
			while(casos != 0) {
				
				// Load the matrix
				for(int i = 0; i < 9; i++) {
					for(int j = 0; j < 9; j++) {
						sudoku[j][i] = sc.nextInt();
//						System.out.format("%d ", sudoku[j][i]);
					}
//					System.out.println();
				}
				
				System.out.format("%s\n", checkAll(sudoku) ? "SI" : "NO");
				
				casos--;
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
	}
	
	static boolean checkAll(int sudoku[][]) {
		
		// Check cols
		for(int x = 0; x < 9; x++) {
			for(int y = 0; y < 9; y++) {
				nums[sudoku[x][y]-1] = 1;
			}
			if(!checkAndResetNums()) return false;
		}
//		System.out.println("cols");
		
		// Check rows
		for(int x = 0; x < 9; x++) {
			for(int y = 0; y < 9; y++) {
				nums[sudoku[y][x]-1] = 1;
			}
			if(!checkAndResetNums()) return false;
		}
//		System.out.println("rows");
		
		
		for(int x = 3; x < 6; x++) {
			for(int y = 0; y < 3; y++) {
				nums[sudoku[y][x]-1] = 1;
			}
		}
		if(!checkAndResetNums()) return false;
		
		for(int x = 6; x < 9; x++) {
			for(int y = 0; y < 3; y++) {
				nums[sudoku[y][x]-1] = 1;
			}
		}
		if(!checkAndResetNums()) return false;
		
		for(int x = 0; x < 3; x++) {
			for(int y = 3; y < 6; y++) {
				nums[sudoku[y][x]-1] = 1;
			}
		}
		if(!checkAndResetNums()) return false;
		
		for(int x = 0; x < 3; x++) {
			for(int y = 6; y < 9; y++) {
				nums[sudoku[y][x]-1] = 1;
			}
		}
		if(!checkAndResetNums()) return false;
		
		for(int x = 3; x < 6; x++) {
			for(int y = 3; y < 6; y++) {
				nums[sudoku[y][x]-1] = 1;
			}
		}
		if(!checkAndResetNums()) return false;
		
		for(int x = 6; x < 9; x++) {
			for(int y = 6; y < 9; y++) {
				nums[sudoku[y][x]-1] = 1;
			}
		}
		if(!checkAndResetNums()) return false;
		
		for(int x = 3; x < 6; x++) {
			for(int y = 6; y < 9; y++) {
				nums[sudoku[y][x]-1] = 1;
			}
		}
		if(!checkAndResetNums()) return false;
		
		for(int x = 6; x < 9; x++) {
			for(int y = 0; y < 3; y++) {
				nums[sudoku[y][x]-1] = 1;
			}
		}
		if(!checkAndResetNums()) return false;
		
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 3; y++) {
				nums[sudoku[y][x]-1] = 1;
			}
		}
		if(!checkAndResetNums()) return false;
		
		return true;
	}
	
	static boolean checkAndResetNums() {
		
		for(int a = 0; a < nums.length; a++) {
			if(nums[a] == 0) return false;
			nums[a] = 0;
		}
		
		return true;
	}
	
}
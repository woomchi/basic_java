package Section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//보류
public class Code21 {
	static int n;
	static int [][] grid;
	public static void main(String[] args) {
		
		try {
			Scanner inFile = new Scanner(new File("data.txt"));
			n = inFile.nextInt();	//grid 길이
			grid = new int[n][n];	//nXn 크기의 grid 객체 생성
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					grid[i][j] = inFile.nextInt();
					//System.out.println(grid[i][j]);
				}
			}
			inFile.close();
			
			// 모든 가능한 수열에 대하여 정수값으로 환산하라
			//만약 그것이 소수라면 출력하라
			for(int x=0;x<n;x++) {
				for(int y=0;y<n;y++) {
					for(int dir=0;dir<8;dir++) {
						for(int length = 1; length<n;length++) {
							int value = computeValue(x,y,dir,length);
							if(value!=-1 && isPrime(value)) {
								System.out.println(value);
							}
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static int [] offsetX = {0,1,1,1,0,-1,-1,-1};
	static int [] offsetY = {-1,-1,0,1,1,1,0,-1};
	public static int getDigit(int x, int y, int dir, int i) {
		int newX = x+i*offsetX[dir];
		int newY = y+i*offsetY[dir];
		if(newX <0 || newX >=grid.length || newY <0 || newY >=grid.length) {
			return -1;
		}
		return grid[newX][newY];	
	}
	
	public static int computeValue(int x, int y, int dir, int length) {
		int value = 0;
		for(int i=0;i<length;i++) {
			int digit = getDigit(x,y,dir,i);
			if(digit==-1) {
				return -1;
			}
			value = value * 10;
		}
		return value;
	}
		
	static boolean isPrime(int value) {
		for(int i=2;i*i<=value;i++) {
			if(value%i==0) {
				return false;
			}
		}
		return true;
	}

}

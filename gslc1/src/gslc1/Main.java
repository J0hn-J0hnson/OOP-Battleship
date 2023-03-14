package gslc1;

import java.util.*;
public class Main {
	
	static boolean check_valid(String s, int len, char[][] table, char bn, ArrayList<Integer> arr) {
		String[] coords = s.split(" ", 2);
		// col = letters - row = alphabet
		int col_1 = (coords[0].charAt(0) - 'A');
		int col_2 = (coords[1].charAt(0) - 'A');
		int row_1 = (coords[0].charAt(1) - '0');
		int row_2 = (coords[1].charAt(1) - '0');
		if(row_1 < 0 || row_1 >= 10 || row_2 < 0 || row_2 >= 10) return false;
		if(col_1 < 0 || col_1 >= 10 || col_2 < 0 || col_2 >= 10) return false;
		if(row_1 != row_2 && col_1 != col_2) {
			return false;
		}else if(row_1 != row_2) {
			if(Math.abs(row_2-row_1)+1 != len) return false;
			else {
				if(row_1 > row_2) {
					for(int i = row_2; i <= row_1; i++) {
						if(table[i][col_1] != '~') return false;
					}
					for(int i = row_2; i <= row_1; i++) {
						System.out.println(i);
						table[i][col_1] = bn;
						arr.add(i*10 + col_1);
					}
					return true;
				}else {
					for(int i = row_1; i <= row_2; i++) {
						if(table[i][col_1] != '~') return false;
					}
					for(int i = row_1; i <= row_2; i++) {
						table[i][col_1] = bn;
						arr.add(i*10 + col_1);
					}
					return true;
				}
			}
		}else if(col_1 != col_2) {
			if(Math.abs(col_2-col_1)+1 != len) return false;
			else {
				// check form a[row_2][col_1] -> a[row_1][col_1]
				if(col_1 > col_2) {
					System.out.println("c1");
					for(int i = col_2; i <= col_1; i++) {
						if(table[row_1][i] != '~') return false;
					}
					for(int i = col_2; i <= col_1; i++) {
						System.out.println(i);
						table[row_1][i] = bn;
						arr.add(row_1*10 + i);
					}
					return true;
				}else {
					for(int i = col_1; i <= col_2; i++) {
						if(table[row_1][i] != '~') return false;
					}
					for(int i = col_1; i <= col_2; i++) {
						table[row_1][i] = bn;
						arr.add(row_1*10 + i);
					}
					
					return true;
				}
			}
			
		}else {
			return false;
		}
	}
	
	static int find_e(char[] table, char tc) {
		int i = 0;
		for(char c: table) {
				if(c == tc) return i;
				i++;
		}
		return i;
	}
		
	static boolean attack(String s, char[][] table, char[][] table_e, boolean[][] bool_table, Map<Character, ArrayList<Integer>>ships) {
		// col = letters - row = alphabet
		char[] cari = {'C', 'B', 'D', 'S', 'P'};
		String[] sari = {"Carrier", "Battleship", "Destroyer", "Submarine", "Patrol Boat"};
		int col =(s.charAt(0) - 'A');
		int row = (s.charAt(1) - '0');
		// 10 =board size
//		System.out.println(col + " " + row);
		if(row < 0 || row >= 10) return false;
		if(col < 0 || col >= 10) return false;
		
		if(bool_table[row][col]) return false;
		bool_table[row][col] = true;
		table[row][col] = table_e[row][col];
		
		if(table_e[row][col] != '~') {
			ships.get(table_e[row][col]).remove(Integer.valueOf(row*10 + col));
			int temp = find_e(cari, table_e[row][col]);
			System.out.println(sari[temp] + " has been hit!");
			if(ships.get(table_e[row][col]).isEmpty()){
				System.out.println(sari[temp] + " has been sunk!");
				ships.remove(table_e[row][col]);
			}
		}else System.out.println("Miss!");
		table_e[row][col] = 'X';
		return true;
	}
	
	
	public static void main(String[] args) {
		// generate initial board
		System.out.println(" ____    ____  ______  ______  _        ___  _____ __ __  ____  ____  \r\n"
				+ "|    \\  /    ||      ||      || |      /  _]/ ___/|  |  ||    ||    \\ \r\n"
				+ "|  o  )|  o  ||      ||      || |     /  [_(   \\_ |  |  | |  | |  o  )\r\n"
				+ "|     ||     ||_|  |_||_|  |_|| |___ |    _]\\__  ||  _  | |  | |   _/ \r\n"
				+ "|  O  ||  _  |  |  |    |  |  |     ||   [_ /  \\ ||  |  | |  | |  |   \r\n"
				+ "|     ||  |  |  |  |    |  |  |     ||     |\\    ||  |  | |  | |  |   \r\n"
				+ "|_____||__|__|  |__|    |__|  |_____||_____| \\___||__|__||____||__|   \r\n"
				+ "                                                                      ");
		System.out.println("Board Size = 10 X 10 ");
		
		boolean[][] bool_table_p1 = new boolean[10][10];
		boolean[][] bool_table_p2 = new boolean[10][10];
		
		char[][] table_p1 = new char[10][10];
		char[][] table_p2 = new char[10][10];
		
		char[][] table_e_p1 = new char[10][10];
		char[][] table_e_p2 = new char[10][10];
		
		Map<Character, ArrayList<Integer>>p1_ships = new HashMap<Character, ArrayList<Integer>>(5, 0.5f);
		Map<Character, ArrayList<Integer>>p2_ships = new HashMap<Character, ArrayList<Integer>>(5, 0.5f);
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				table_p1[i][j] = '~';
				table_p2[i][j] = '~';
				table_e_p1[i][j] = '.';
				table_e_p2[i][j] = '.';
				bool_table_p1[i][j] = false;
				bool_table_p2[i][j] = false;
			}
		}
		
		String si;
		Scanner sc = new Scanner(System.in);
		int[] iari = {5, 4, 3, 3, 2};
		char[] cari = {'C', 'B', 'D', 'S', 'P'};
		String[] sari = {"Carrier", "Battleship", "Destroyer", "Submarine", "Patrol Boat"};
		// start the game
		// get ship location
		System.out.println("Player 1: Insert Ships(collumn, row) [A-J][0-9] -> [A-j][0-9] ");
		for(int i = 0; i < 5; i++) {
			
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k < 10; k++) {
					System.out.print(table_p1[j][k] + " ");
				}
				System.out.println("\n");
			}
			
			System.out.println(sari[i] + " | Size = " + iari[i] + " | Location [A-J][0-9] -> [A-j][0-9]:");
			
			p1_ships.put(cari[i], new ArrayList<Integer>());
			
			do{
				si = sc.nextLine();
			}while(check_valid(si, iari[i], table_p1, cari[i], p1_ships.get(cari[i])) == false);
			
		}
		for(int j = 0; j < 10; j++) {
			for(int k = 0; k < 10; k++) {
				System.out.print(table_p1[j][k] + " ");
			}
			System.out.println("\n");
		}
		for(int i = 0; i < 30; i++) {
			System.out.println("\n");
		}		
		////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("Player 2: Insert Ships(collumn, row) [A-J][0-9] -> [A-j][0-9] ");
		for(int i = 0; i < 5; i++) {
			
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k < 10; k++) {
					System.out.print(table_p2[j][k] + " ");
				}
				System.out.println("\n");
			}
			
			System.out.println(sari[i] + " | Size = " + iari[i] + " | Location (coord1 coord2):");
			
			p2_ships.put(cari[i], new ArrayList<Integer>());
			
			do{
				si = sc.nextLine();
			}while(check_valid(si, iari[i], table_p2, cari[i], p2_ships.get(cari[i])) == false);			
		}
		for(int j = 0; j < 10; j++) {
			for(int k = 0; k < 10; k++) {
				System.out.print(table_p1[j][k] + " ");
			}
			System.out.println("\n");
		}
		for(int i = 0; i < 30; i++) {
			System.out.println("\n");
		}	

		/////////////////////////////////////////////////////////////////////////////////////
		int turn = 1;
		while(p1_ships.isEmpty() == false && p2_ships.isEmpty() == false){
			if(turn % 2 != 0) {
				do {
					System.out.println("Player 1 Input Target [A-J 0-9]:");
					si = sc.nextLine();
					// input , 
				}while(attack(si, table_e_p1, table_p2, bool_table_p1, p1_ships) == false);
				// print board
				for(int j = 0; j < 10; j++) {
					for(int k = 0; k < 10; k++) {
						System.out.print(table_e_p1[j][k] + " ");
					}
					System.out.println("\n");
				}
			}else {
				do{
					System.out.println("Player 2 Input Target [A-J 0-9]:");
					si = sc.nextLine();
				}while(attack(si, table_e_p2, table_p1, bool_table_p2, p2_ships) == false);
				// print board
				for(int j = 0; j < 10; j++) {
					for(int k = 0; k < 10; k++) {
						System.out.print(table_e_p2[j][k] + " ");
					}
					System.out.println("\n");
				}
			}
			turn++;			
		}
		if(p1_ships.isEmpty() == false) {
			System.out.println("Player 2 Wins!");
		}else {
			System.out.println("Player 1 Wins!");
		}
	}

}

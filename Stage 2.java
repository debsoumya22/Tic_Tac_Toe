package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String input = scanner.next();
        
        System.out.println("---------");
        int counter = 0;
        for (int i = 1; i <= 3; i++) {
            System.out.print("| ");
            for(int j = 1; j <= 3; j++) {
                System.out.printf("%c ", input.charAt(counter++));
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }
}

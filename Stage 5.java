package tictactoe;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean XsTurn = true;

        //creating the board and displaying it
        char[][] board = new char[3][3];
        createBoard(board);
        printBoard(board);

        while (true){
            char marker = XsTurn ? 'X' : 'O';

            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if(isValid(board,x,y) != null) {
                System.out.println(isValid(board,x,y));
                continue;
            }

            System.out.println("Enter the coordinates: " + x + " " + y);
            board[x-1][y-1] = marker;
            printBoard(board);

            if (gameResults(board) != null){
                System.out.println(gameResults(board));
                break;
            }

            //changes the turn found
            XsTurn = !XsTurn;
        }
    }

    public static char[][] createBoard(char[][]arr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                arr[i][j] = ' ';

            }
            System.out.println();
        }
        return arr;
    }

    // checks for exceptions
    public static String isValid(char[][]gameBoard, int x, int y) {

        if ( x < 1 || y < 1 || x > 3 || y > 3) {
            return "Coordinates should be from 1 to 3!";
        }

        if (gameBoard[x-1][y-1] == 'X' || gameBoard[x-1][y-1] == 'O'){
            return "This cell is occupied! Choose another one!";

        }
        return null;
    }

    // prints the board
    public static void printBoard (char[][] arr) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++){
                System.out.print(arr[i][j] + " ");

            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    // check to see if X wins
    public static boolean didXWin(char[][]gameBoard){
        // BOOLEANS TO CHECK X WIN
        boolean rowWin = false;
        boolean columnWin = false;
        boolean rightDiagonal = false;
        boolean leftDiagonal = false;

        int checkRightDia = 0;


        for (int i = 0; i < 3; i++) {
            // COUNT X WINS
            int checkRowWin = 0;
            int checkColWin = 0;
            int checkLeftDia = 0;

            //RIGHT DIAGONAL
            if(gameBoard[i][2-i]== 'X'){
                checkRightDia += 1;
            }

            for(int j = 0; j < 3; j++) {
                //ROW
                if (gameBoard[i][j] == 'X') {
                    checkRowWin += 1;
                }
                //COLUMN
                if (gameBoard[j][i] == 'X') {
                    checkColWin += 1;
                }

                //LEFT DIAGONAL
                if (gameBoard[j][j] == 'X') {
                    checkLeftDia += 1;
                }
            }
            if (checkColWin == 3) {
                columnWin = true;
            }
            if (checkRowWin == 3) {
                rowWin = true;
            }

            if (checkLeftDia == 3) {
                leftDiagonal = true;
            }
        }

        if (checkRightDia == 3) {
            rightDiagonal = true;
        }

        return columnWin || rowWin || leftDiagonal || rightDiagonal;
    }

    // check to see if O wins
    public static boolean didOWin(char[][]gameBoard){
        boolean rowWin = false;
        boolean columnWin = false;
        boolean rightDiagonal = false;
        boolean leftDiagonal = false;
        int checkRightDia = 0;


        for (int i = 0; i < 3; i++) {
            int checkRowWin = 0;
            int checkColWin = 0;
            int checkLeftDia = 0;

            //RIGHT DIAGONAL
            if(gameBoard[i][2-i]== 'O'){
                checkRightDia += 1;
            }
            //LEFT DIAGONAL
            if (gameBoard[i][i] == 'O') {
                checkLeftDia += 1;
            }

            for(int j = 0; j < 3; j++) {
                //ROW
                if (gameBoard[i][j] == 'O') {
                    checkRowWin += 1;
                }
                //COLUMN
                if (gameBoard[j][i] == 'O') {
                    checkColWin += 1;
                }

            }
            if (checkColWin == 3) {
                columnWin = true;
            }
            if (checkRowWin == 3) {
                rowWin = true;
            }
            if (checkLeftDia == 3) {
                leftDiagonal = true;
            }
        }

        if (checkRightDia == 3) {
            rightDiagonal = true;
        }

        return columnWin || rowWin || leftDiagonal || rightDiagonal;
    }

    // finds number of empty spots
    public static boolean areThereSpaces(char[][]gameBoard){
        boolean emptySpace = false;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++){
                if (gameBoard[i][j] == ' ') {
                    emptySpace = true;
                    break;
                }
            }
        }
        return emptySpace;
    }

    // gets the result of the game
    public static String gameResults(char[][]gameBoard){
        if (didOWin(gameBoard)) {
            return "O wins";
        }
        if (didXWin(gameBoard)) {
            return "X wins";
        }
        if(!areThereSpaces(gameBoard)){
            return "Draw";
        }
        return null;
    }




}

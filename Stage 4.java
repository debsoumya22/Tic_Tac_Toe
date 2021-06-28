package tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String playerChoices = scanner.nextLine();

        System.out.println("Enter cells: " + playerChoices);
        char[][] board = createBoard(playerChoices);
        printBoard(board);

        while (true) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            boolean isAnInt = scanner.hasNextInt();
            //make it work with the both inputs

            if (!isAnInt){
                System.out.println("You should enter number!");
                continue;
            }

            if ( x < 1 || y < 1 || x > 3 || y > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (board[x-1][y-1] != '_'){
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            System.out.println("Enter the coordinates : " + x + " " + y);
            board[x-1][y-1] = 'X';
            break;
        }

        printBoard(board);


    }

// creates the board
    public static char[][] createBoard (String choices) {
        char[][] board = new char[3][3];
        int choiceIndex = 0;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++){
                board[i][j] = choices.charAt(choiceIndex);
                choiceIndex += 1;
            }
        }
        return board;
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


// check to see if the game is possible
    public static boolean isImpossible(char[][]gameBoard){
        return (didOWin(gameBoard) && didXWin(gameBoard) || countDiff(gameBoard) >= 2);
    }
// check to see if X wins
    public static boolean didXWin(char[][]gameBoard){
        // BOOLEANS TO CHECK X WIN
        boolean rowWin = false;
        boolean columnWin = false;
        boolean rightDiagonal = false;
        boolean leftDiagonal = false;

        int checkRightDia = 0;
        int checkRightODia = 0;


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

// finds number of O
    public static int countDiff(char[][]gameBoard){
        int countO = 0;
        int countX = 0;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++){
                if (gameBoard[i][j] == 'O') {
                    countO += 1;
                    countX += 1;
                }
            }
        }

        return Math.abs(countO - countX);
    }

// finds number of _
    public static boolean areThereSpaces(char[][]gameBoard){
        boolean emptySpace = false;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++){
                if (gameBoard[i][j] == '_') {
                    emptySpace = true;
                    break;
                }
            }
        }
        return emptySpace;
    }

// gets the result of the game
    public static String gameResults(char[][]gameBoard){
        if (isImpossible(gameBoard)){
            return "Impossible";
        }
        if (didOWin(gameBoard)) {
            return "O wins";
        }
        if (didXWin(gameBoard)) {
            return "X wins";
        }
        if(areThereSpaces(gameBoard)){
            return "Game not finished";
        }
        return "Draw";
    }




}

package tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.next();

        System.out.println("---------");
        System.out.println("| " + name.charAt(0) + " " + name.charAt(1) + " " + name.charAt(2) + " |");
        System.out.println("| " + name.charAt(3) + " " + name.charAt(4) + " " + name.charAt(5) + " |");
        System.out.println("| " + name.charAt(6) + " " + name.charAt(7) + " " + name.charAt(8) + " |");
        System.out.println("---------");

        String[][] list = new String[3][3];
        int length = 0;
        boolean finished = true;
        boolean xwinner = false;
        boolean owinner = false;
        boolean draw = false;
        boolean impossible = false;
        boolean notfinished = false;
        int count = 0;
        int numberX = 0;
        int numberO = 0;

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                list[i][j] = "" + name.charAt(length);
                length++;
                if (list[i][j].contains("_")) {
                    finished = false;
                }
            }
        }
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (list[i][j].equals("X")) {
                    numberX++;
                } else if (list[i][j].equals("O")) {
                    numberO++;
                }
            }
        }

        for (int i = 0; i < list.length; i++) {
            count++;

            if (list[i][0].equals("X") && list[i][1].equals("X") && list[i][2].equals("X")) {
                xwinner = true;
            }
            if (list[i][0].equals("O") && list[i][1].equals("O") && list[i][2].equals("O")) {
                owinner = true;
            }
            if (list[0][i].equals("X") && list[1][i].equals("X") && list[2][i].equals("X")) {
                xwinner = true;
            }
            if (list[0][i].equals("O") && list[1][i].equals("O") && list[2][i].equals("O")) {
                owinner = true;
            }
            if (list[0][0].equals("X") && list[1][1].equals("X") && list[2][2].equals("X")) {
                xwinner = true;
            }
            if (list[0][0].equals("O") && list[1][1].equals("O") && list[2][2].equals("O")) {
                owinner = true;
            }
            if (list[2][0].equals("X") && list[1][1].equals("X") && list[0][2].equals("X")) {
                xwinner = true;
            }
            if (list[2][0].equals("O") && list[1][1].equals("O") && list[0][2].equals("O")) {
                owinner = true;
            }
            if (!xwinner && !owinner && count == 3) {
                draw = true;
            }
            if (!finished && !xwinner && !owinner && count == 3) {
                notfinished = true;
            }
            if ((xwinner && owinner && count == 3) || (numberX - numberO > 1 || numberO - numberX > 1)) {
                impossible = true;
            }

            if (count == 3) {
                if (impossible) {
                    System.out.println("Impossible");
                } else if (notfinished) {
                    System.out.println("Game not finished");
                } else if (xwinner) {
                    System.out.println("X wins");
                } else if (owinner) {
                    System.out.println("O wins");
                } else if (draw) {
                    System.out.println("Draw");
                }
            }
        }
    }
}
package task1.TicTacToeGame;
import java.util.Scanner;

public class TicTacToeGame {
    private static char[][] board = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
    private static char currentPlayer = 'M';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain;

        do {
            resetBoard();
            boolean gameEnded = false;
            
            while (!gameEnded) {
                printBoard();
                System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
                int move = sc.nextInt();

                if (isValidMove(move)) {
                    placeMove(move);
                    if (checkWin()) {
                        printBoard();
                        System.out.println("Player " + currentPlayer + " wins!");
                        gameEnded = true;
                    } else if (isBoardFull()) {
                        printBoard();
                        System.out.println("It's a draw!");
                        gameEnded = true;
                    } else {
                        switchPlayer();
                    }
                } else {
                    System.out.println("Invalid move.Try again.");
                }
            }

            System.out.println("Do you want to play again? (Yes/no): ");
            playAgain = sc.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thanks for playing!");
        sc.close();
    }

    
    private static void resetBoard() {
        char num = '1';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = num++;
            }
        }
        currentPlayer = 'M';
    }

    
    private static void printBoard() {
        System.out.println("-------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char cell : row) {
                System.out.print(cell + " | ");
            }
            System.out.println("\n--------");
        }
    }

    
    private static boolean isValidMove(int move) {
        if (move < 1 || move > 9) return false;
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;
        return board[row][col] >= '1' && board[row][col] <= '9';
    }

 
    private static void placeMove(int move) {
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;
        board[row][col] = currentPlayer;
    }

    
    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'M') ? 'O' : 'X';
    }

    
    private static boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell >= '1' && cell <= '9') return false;
            }
        }
        return true;
    }

    
    private static boolean checkWin() {
     
        return (checkRowWin() || checkColumnWin() || checkDiagonalWin());
    }

    private static boolean checkRowWin() {
        for (char[] row : board) {
            if (row[0] == row[1] && row[1] == row[2]) return true;
        }
        return false;
    }

    private static boolean checkColumnWin() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) return true;
        }
        return false;
    }

    private static boolean checkDiagonalWin() {
        return (board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
               (board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }
}
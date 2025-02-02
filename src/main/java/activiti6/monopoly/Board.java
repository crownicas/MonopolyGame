package activiti6.monopoly;
/**
 *
 * @author Fredy
 */
import java.util.ArrayList;
import java.util.Random;
import java.io.Serializable;

public class Board implements Serializable {
    private final Player playerOne;
    private final Player playerTwo;
    private Player turn;

    private ArrayList<Square> squares = new ArrayList<>(16);
    
    // Constructor initializes a game board with two players and various types of squares
    // Each square is named and assigned an index, then added to the board
    // Both players start at the Start square
    public Board(Player player_one, Player player_two){
        playerOne = player_one;
        playerTwo = player_two;
        squares = new ArrayList<>();

        //add squares
        squares.add(new StartSquare("Inicio", 0));
        squares.add(new PropertySquare("Calle Gran Via", 1));
        squares.add(new ChanceSquare("Suerte",  2));
        squares.add(new PropertySquare("Mansion", 3));
        squares.add(new JailSquare("Translado a la carcel", 4));
        squares.add(new PropertySquare("Hospital PTS", 5));
        squares.add(new SpecialSquare("Impuesto a la banca", 6));
        squares.add(new PropertySquare("Calle Real de la Alhambra", 7));
        squares.add(new EmptySquare("Vacia",8));
        squares.add(new PropertySquare("Calle Elvira", 9));
        squares.add(new ChanceSquare("Suerte", 10));
        squares.add(new PropertySquare("Hotel Luna", 11));
        squares.add(new JailSquare("Carcel", 12));
        squares.add(new PropertySquare("CC Nevada", 13));
        squares.add(new SpecialSquare("Impuesto a la banca", 14));
        squares.add(new PropertySquare("Calle Blas Infante", 15));
        
        playerOne.setCurrentPosition(0);
        playerTwo.setCurrentPosition(0);
    }
    
    public int rollDie(){
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
    
    public Player getPlayerTurn() {
        return this.turn;
    }

    public void whoStarts(){
        int resultPlayerOne = rollDie();
        int resultPlayerTwo = rollDie();
        
        while (resultPlayerOne == resultPlayerTwo) {
            resultPlayerOne = rollDie();
            resultPlayerTwo = rollDie();
        }
        
        if (resultPlayerOne > resultPlayerTwo) {
            this.turn = playerOne;
        } else {
            this.turn = playerTwo;
        }
    }

    public boolean isGameActive() {
        return playerOne.getMegaMoney() > 0 && playerTwo.getMegaMoney() > 0;
    }

    public int movePlayer(int dieResult) {
        int newPosition = (turn.getCurrentPosition() + dieResult) % squares.size();
        turn.setCurrentPosition(newPosition);
       
        return newPosition;
    }

    public Player getWinner() {
        return (playerOne.getMegaMoney() > 0) ? playerOne : playerTwo;
    }

    public void changeTurn() {
        if (turn != null && playerOne != null && playerTwo != null) {
            if(turn == playerOne){
                turn = playerTwo;
            } else {
                turn = playerOne;
            }
        }
    }

    public ArrayList<Square> getSquares(){
        return this.squares;
    }
    
    public Square getSquare(int position) {
        return this.squares.get(position);
    }
    
    public Player getPlayerOne() {
        return this.playerOne;
    }
    
    public Player getPlayerTwo() {
        return this.playerTwo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("playerOne").append(playerOne).append("\n");
        sb.append("playerTwo").append(playerTwo).append("\n");
        sb.append("turn").append(turn != null ? turn.getName() : "Ninguno").append("\n");
        sb.append("squares").append(squares).append("\n");
        return sb.toString();
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package activiti6.monopoly;

/**
 *
 * @author Fredy
 */
import java.util.ArrayList;
import java.util.Random;
import java.io.Serializable; //serializable

public class Board implements Serializable{ //serializable
    private final Player playerOne;
    private final Player playerTwo;
    private Player turn;

    private ArrayList<Square> squares = new ArrayList<>(16);

    public Board(Player player_one, Player player_two){
        playerOne = player_one;
        playerTwo = player_two;
        squares = new ArrayList<>();

        //add squares
        squares.add(new StartSquare("Start", 0));
        squares.add(new PropertySquare("Street", 1));
        squares.add(new ChanceSquare("Chance",  2));
        squares.add(new PropertySquare("House", 3));
        squares.add(new JailSquare("Jail", 4));
        squares.add(new PropertySquare("Hospital", 5));
        squares.add(new SpecialSquare("Special", 6));
        squares.add(new PropertySquare("Street", 7));
        squares.add(new EmptySquare("Empty",8));
        squares.add(new PropertySquare("Street", 9));
        squares.add(new ChanceSquare("Chance", 10));
        squares.add(new PropertySquare("Hotel", 11));
        squares.add(new JailSquare("Jail", 12));
        squares.add(new PropertySquare("Street", 13));
        squares.add(new SpecialSquare("Special", 14));
        squares.add(new PropertySquare("Street", 15));
    }
    
    public int rollDie(){
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
    
    public Player getPlayerTurn() {
        return this.turn;
    }

    public void newPlay(){
        //initialize the game
        initPlay();
        //determine who starts
        whoStarts();
    }

    public void initPlay(){
        //set initial position
        playerOne.setCurrentPosition(0);
        playerTwo.setCurrentPosition(0);
    }

    private void whoStarts(){
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

    public void finishPlay(){

    }

    public void savePlay(){

    }

    public void loadPlay(){

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

    public void displayOptions(){

    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jugador 1: ").append(playerOne).append("\n");
        sb.append("Jugador 2: ").append(playerTwo).append("\n");
        sb.append("Jugador en turno: ").append(turn != null ? turn.getName() : "Ninguno").append("\n");
        sb.append("Squares: ").append(squares).append("\n");
        return sb.toString();
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package activiti6.monopoly;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.*; //borra si no funciona serializable
import javax.swing.JFileChooser; //borra si no funciona serializable

/**
 *
 * @author Cristina
 */
public class MonopolyGuiBoard extends javax.swing.JFrame implements Serializable {  //Serializable. Se han convertido todas las clases a serializable
    private Board board;
    /**
     * Creates new form MonopolyBoardGui
     * @param board
     */
    public MonopolyGuiBoard(Board board) {
        this.board = board;
        initComponents();
        
        this.setComponentsName();
        this.drawSquares();
        this.drawInformationSquares();
        
        this.board.newPlay();
        this.playTurn(); 
    }
    
    private void updateGameAfterLoad() {
    //actualizarPosicionesJugadores();
    //actualizarPropiedadesJugadores();
        updatedMMInfo();
        this.setLabelTurnName();
        drawInformationSquares();
    
        // Mostrar información del tablero
        System.out.println("Información del tablero después de cargar:");
        System.out.println(this.board.toString()); 

        // Mostrar información de los jugadores
        System.out.println("Información de los jugadores después de cargar:");
        System.out.println("Jugador 1: " + this.board.getPlayerOne().toString());
        System.out.println("Jugador 2: " + this.board.getPlayerTwo().toString());
    }

    private void showWinner() {
        Player winner = this.board.getWinner();
        
        Object[] options = {"Jugar de nuevo", "Cerrar"};
        int response = JOptionPane.showOptionDialog(null,
            "El ganador es " + winner.getName() + ". ¿Qué te gustaría hacer?",
            "Información de la partida",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);
        
        if (response == JOptionPane.YES_OPTION) {
            this.dispose();
            new MonopolyGui().setVisible(true);
        } else if (response == JOptionPane.NO_OPTION) {
            this.dispose();
        }
    }
       
    private void playTurn() {
        this.updatedMMInfo();
        this.setLabelTurnName();
    }

    private void setComponentsName() {
        this.bDie.setName("bDie");
        this.jMenu.setName("jMenu");
        this.jMenuBar1.setName("jMenuBar1");
        this.jMenuLoadItem.setName("jMenuLoadItem");
        this.jMenuSaveItem.setName("jMenuSaveItem");
        this.jPanel0.setName("jPanel0");
        this.jPanel1.setName("jPanel1");
        this.jPanel10.setName("jPanel10");
        this.jPanel11.setName("jPanel11");
        this.jPanel12.setName("jPanel12");
        this.jPanel13.setName("jPanel13");
        this.jPanel14.setName("jPanel14");
        this.jPanel15.setName("jPanel15");
        this.jPanel2.setName("jPanel2");
        this.jPanel3.setName("jPanel3");
        this.jPanel4.setName("jPanel4");
        this.jPanel5.setName("jPanel5");
        this.jPanel6.setName("jPanel6");
        this.jPanel7.setName("jPanel7");
        this.jPanel8.setName("jPanel8");
        this.jPanel9.setName("jPanel9");
        this.jPanelBoard.setName("jPanelBoard");
        this.jSeparator1.setName("jSeparator1");
        this.lPanelName0.setName("lPanelName0");
        this.lPanelName1.setName("lPanelName1");
        this.lPanelName10.setName("lPanelName10");
        this.lPanelName11.setName("lPanelName11");
        this.lPanelName12.setName("lPanelName12");
        this.lPanelName13.setName("lPanelName13");
        this.lPanelName14.setName("lPanelName14");
        this.lPanelName15.setName("lPanelName15");
        this.lPanelName2.setName("lPanelName2");
        this.lPanelName3.setName("lPanelName3");
        this.lPanelName4.setName("lPanelName4");
        this.lPanelName5.setName("lPanelName5");
        this.lPanelName6.setName("lPanelName6");
        this.lPanelName7.setName("lPanelName7");
        this.lPanelName8.setName("lPanelName8");
        this.lPanelName9.setName("lPanelName9");
        this.lPanelOwner0.setName("lPanelOwner0");
        this.lPanelOwner1.setName("lPanelOwner1");
        this.lPanelOwner10.setName("lPanelOwner10");
        this.lPanelOwner11.setName("lPanelOwner11");
        this.lPanelOwner12.setName("lPanelOwner12");
        this.lPanelOwner13.setName("lPanelOwner13");
        this.lPanelOwner14.setName("lPanelOwner14");
        this.lPanelOwner15.setName("lPanelOwner15");
        this.lPanelOwner2.setName("lPanelOwner2");
        this.lPanelOwner3.setName("lPanelOwner3");
        this.lPanelOwner4.setName("lPanelOwner4");
        this.lPanelOwner5.setName("lPanelOwner5");
        this.lPanelOwner6.setName("lPanelOwner6");
        this.lPanelOwner7.setName("lPanelOwner7");
        this.lPanelOwner8.setName("lPanelOwner8");
        this.lPanelOwner9.setName("lPanelOwner9");
        this.lPanelPrice0.setName("lPanelPrice0");
        this.lPanelPrice1.setName("lPanelPrice1");
        this.lPanelPrice10.setName("lPanelPrice10");
        this.lPanelPrice11.setName("lPanelPrice11");
        this.lPanelPrice12.setName("lPanelPrice12");
        this.lPanelPrice13.setName("lPanelPrice13");
        this.lPanelPrice14.setName("lPanelPrice14");
        this.lPanelPrice15.setName("lPanelPrice15");
        this.lPanelPrice2.setName("lPanelPrice2");
        this.lPanelPrice3.setName("lPanelPrice3");
        this.lPanelPrice4.setName("lPanelPrice4");
        this.lPanelPrice5.setName("lPanelPrice5");
        this.lPanelPrice6.setName("lPanelPrice6");
        this.lPanelPrice7.setName("lPanelPrice7");
        this.lPanelPrice8.setName("lPanelPrice8");
        this.lPanelPrice9.setName("lPanelPrice9");
        this.lPlayerOneMM.setName("lPlayerOneMM");
        this.lPlayerOneName.setName("lPlayerOneName");
        this.lPlayerTwoMM.setName("lPlayerTwoMM");
        this.lPlayerTwoName.setName("lPlayerTwoName");
        this.tPiecePanelPlayerOne0.setName("tPiecePanelPlayerOne0");
        this.tPiecePanelPlayerOne1.setName("tPiecePanelPlayerOne1");
        this.tPiecePanelPlayerOne10.setName("tPiecePanelPlayerOne10");
        this.tPiecePanelPlayerOne11.setName("tPiecePanelPlayerOne11");
        this.tPiecePanelPlayerOne12.setName("tPiecePanelPlayerOne12");
        this.tPiecePanelPlayerOne13.setName("tPiecePanelPlayerOne13");
        this.tPiecePanelPlayerOne14.setName("tPiecePanelPlayerOne14");
        this.tPiecePanelPlayerOne15.setName("tPiecePanelPlayerOne15");
        this.tPiecePanelPlayerOne2.setName("tPiecePanelPlayerOne2");
        this.tPiecePanelPlayerOne3.setName("tPiecePanelPlayerOne3");
        this.tPiecePanelPlayerOne4.setName("tPiecePanelPlayerOne4");
        this.tPiecePanelPlayerOne5.setName("tPiecePanelPlayerOne5");
        this.tPiecePanelPlayerOne6.setName("tPiecePanelPlayerOne6");
        this.tPiecePanelPlayerOne7.setName("tPiecePanelPlayerOne7");
        this.tPiecePanelPlayerOne8.setName("tPiecePanelPlayerOne8");
        this.tPiecePanelPlayerOne9.setName("tPiecePanelPlayerOne9");
        this.tPiecePanelPlayerTwo0.setName("tPiecePanelPlayerTwo0");
        this.tPiecePanelPlayerTwo1.setName("tPiecePanelPlayerTwo1");
        this.tPiecePanelPlayerTwo10.setName("tPiecePanelPlayerTwo10");
        this.tPiecePanelPlayerTwo11.setName("tPiecePanelPlayerTwo11");
        this.tPiecePanelPlayerTwo12.setName("tPiecePanelPlayerTwo12");
        this.tPiecePanelPlayerTwo13.setName("tPiecePanelPlayerTwo13");
        this.tPiecePanelPlayerTwo14.setName("tPiecePanelPlayerTwo14");
        this.tPiecePanelPlayerTwo15.setName("tPiecePanelPlayerTwo15");
        this.tPiecePanelPlayerTwo2.setName("tPiecePanelPlayerTwo2");
        this.tPiecePanelPlayerTwo3.setName("tPiecePanelPlayerTwo3");
        this.tPiecePanelPlayerTwo4.setName("tPiecePanelPlayerTwo4");
        this.tPiecePanelPlayerTwo5.setName("tPiecePanelPlayerTwo5");
        this.tPiecePanelPlayerTwo6.setName("tPiecePanelPlayerTwo6");
        this.tPiecePanelPlayerTwo7.setName("tPiecePanelPlayerTwo7");
        this.tPiecePanelPlayerTwo8.setName("tPiecePanelPlayerTwo8");
        this.tPiecePanelPlayerTwo9.setName("tPiecePanelPlayerTwo9");
        this.tPlayerOneMM.setName("tPlayerOneMM");
        this.tPlayerOneName.setName("tPlayerOneName");
        this.tPlayerTwoMM.setName("tPlayerTwoMM");
        this.tPlayerTwoName.setName("tPlayerTwoName");
        this.lPlayerTurnInfo.setName("lPlayerTurnInfo");
        this.lPlayerTurnName.setName("lPlayerTurnName");
    }
    
    private void drawSquares() {
        ArrayList<Square> squares = this.board.getSquares();
        HashMap<Object, Object> squareMap = new HashMap<>();
        
        squareMap.put("jSquare0", this.jPanel0);
        squareMap.put("jSquare1", this.jPanel1);
        squareMap.put("jSquare2", this.jPanel2);                    
        squareMap.put("jSquare3", this.jPanel3);                    
        squareMap.put("jSquare4", this.jPanel4);                    
        squareMap.put("jSquare5", this.jPanel5);                    
        squareMap.put("jSquare6", this.jPanel6);                    
        squareMap.put("jSquare7", this.jPanel7);                    
        squareMap.put("jSquare8", this.jPanel8);                    
        squareMap.put("jSquare9", this.jPanel9);                    
        squareMap.put("jSquare10", this.jPanel10);                    
        squareMap.put("jSquare11", this.jPanel11);                    
        squareMap.put("jSquare12", this.jPanel12);                    
        squareMap.put("jSquare13", this.jPanel13);                    
        squareMap.put("jSquare14", this.jPanel14);                    
        squareMap.put("jSquare15", this.jPanel15);                    
                       
        for (int i = 0; i < squares.size(); i++) {
            String name = "jSquare" + i;    
            JPanel square_panel = (JPanel) squareMap.get(name);
         
            this.drawInformationSquare(square_panel, squares.get(i), i);
        }
    }
    
    public void drawInformationSquares() {
        Player player_one = this.board.getPlayerOne();
        Player player_two = this.board.getPlayerTwo();
        
        this.tPlayerOneName.setText(player_one.getName());
        this.tPlayerTwoName.setText(player_two.getName());
        
        this.updatedMMInfo();
    }
    
    public void updatedMMInfo() {
        Player player_one = this.board.getPlayerOne();
        Player player_two = this.board.getPlayerTwo();
        
        this.tPlayerOneMM.setText(String.valueOf(player_one.getMegaMoney()));
        this.tPlayerTwoMM.setText(String.valueOf(player_two.getMegaMoney()));
    }
    
    private void drawInformationSquare(JPanel square_panel, Square square, int value) {
        square_panel.setBackground(new Color(204, 255, 204));
        Player playerOne = this.board.getPlayerOne();
        Player playerTwo = this.board.getPlayerTwo();
        
        
        
        Component[] components = square_panel.getComponents();
        for (Component component : components) {
            
            if (component instanceof JTextField textField) {
                if (textField.getName().equals("tPiecePanelPlayerTwo" + value)) {
                    textField.setText(playerTwo.getName());
                    textField.setBackground(playerTwo.getPieceColor());
                    
                    if (value == 0) {
                        textField.setVisible(true);
                    } else {
                        textField.setVisible(false);
                    }
                    
                }
                
                if (textField.getName().equals("tPiecePanelPlayerOne" + value)) {
                    textField.setText(playerOne.getName());
                    textField.setBackground(playerOne.getPieceColor());
                    
                    if (value == 0) {
                        textField.setVisible(true);
                    } else {
                        textField.setVisible(false);
                    }
                } 
            }  
            
            if (component instanceof JLabel label) {
                
                if (label.getName().equals("lPanelName" + value)) {
                   label.setText(square.getName());
                   label.setBackground(square.getColor());
                }
                
                if (square instanceof PropertySquare) {
                    if (label.getName().equals("lPanelOwner" + value)) {
                        
                        if (((PropertySquare) square).isBought()) {
                            String ownerName = ((PropertySquare) square).getOwner().getName();
                            label.setText("Propietario: " + ownerName);
                        }
                      
                    }
                    
                    if (label.getName().equals("lPanelPrice" + value)) {
                        int price = ((PropertySquare) square).getPrice();
                        label.setText(String.valueOf(price) + " MM");
                        label.setVisible(true);
                    }
                }

            }
        }    
    }
    
    private String checkWhoIsPlaying() {
        String playerName = this.board.getPlayerTurn().getName();
        Player playerOne = this.board.getPlayerOne();
        
        if (playerOne.getName().equals(playerName)) {
            return "PlayerOne";
        } else {
            return "PlayerTwo";
        }
    }
    
    private Component findComponentByName(Container container, String name) {
        Component[] components = container.getComponents();
        
        for (Component component : components) {
            if (component.getName() != null && component.getName().equals(name)) {
                return component;
            }
            
            if (component instanceof Container) {
                Container nestedContainer = (Container) component;
                Component foundComponent = findComponentByName(nestedContainer, name);
                if (foundComponent != null) {
                    return foundComponent;
                }
            }
        }
        
        return null;    
    }
    
    private void setLabelTurnInfo(String text) {
        this.lPlayerTurnInfo.setText(text);
    }
    
    private void setLabelTurnName() {
        this.lPlayerTurnName.setText("Turno del jugador: " + this.board.getPlayerTurn().getName());
    }
    
    private void showPiece(String pieceName) {
        Component piece = this.findComponentByName(this.jPanelBoard, pieceName);
        ((JTextField)piece).setVisible(true);
    }
    
    private void hiddenPiece(String pieceName) {
        Component piece = this.findComponentByName(this.jPanelBoard, pieceName);
        ((JTextField)piece).setVisible(false);
    }
    
    public void showSquareOwner(int position, Square square) {
        String labelName = "lPanelOwner" + String.valueOf(position);
        Component labelOwner = this.findComponentByName(this.jPanelBoard, labelName);
        ((JLabel) labelOwner).setText("Propiedad de: " + ((PropertySquare)square).getOwner().getName());
    }
    
    private void drawPiecePlayer(int position, int newPosition) {
        String playerTurn = this.checkWhoIsPlaying();
        
        //ocultamos la ficha actual
        String playerPiece = "tPiecePanel" + playerTurn + String.valueOf(position);
        this.hiddenPiece(playerPiece);
        
        //mostramos la ficha en la casilla actual
        playerPiece = "tPiecePanel" + playerTurn + String.valueOf(newPosition);
        this.showPiece(playerPiece);
    }
    
    private String executeSquareAction(int position) {
        Square square = this.board.getSquare(position);
        Player current = this.board.getPlayerTurn();
        String message = square.executeAction(current);
        
        if (message.equals("bough_action")) {
            message = this.showPropertyOptionDialog(square);
        }
        
        if (message.contains("Hoy es tu cumpleaños.")) {
            Player playerOne = this.board.getPlayerOne();
            Player playerTwo = this.board.getPlayerTwo();
            
            if (playerOne.getName().equals(current.getName())) {
                playerTwo.setMegaMoney(playerTwo.getMegaMoney() - 10);
            } else {
                playerOne.setMegaMoney(playerOne.getMegaMoney() - 10);
            }
        }
        
        if (position != current.getCurrentPosition()) {
            this.drawPiecePlayer(position, current.getCurrentPosition());
        }
        
        this.updatedMMInfo();
        return message;
    }
    
    private String showPropertyOptionDialog(Square square) {
        String message = "";
        Player currentPlayer = this.board.getPlayerTurn();
        int option = JOptionPane.showConfirmDialog(null, "¿Quieres comprar la propiedad?", "Comprar", JOptionPane.YES_NO_OPTION);
        
        if (option == JOptionPane.YES_OPTION) {
            message = ((PropertySquare)square).buyProperty(currentPlayer);
            this.showSquareOwner(currentPlayer.getCurrentPosition(), square);
        }
        
        return message;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lPlayerOneName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanelBoard = new javax.swing.JPanel();
        jPanel0 = new javax.swing.JPanel();
        lPanelName0 = new javax.swing.JLabel();
        lPanelPrice0 = new javax.swing.JLabel();
        lPanelOwner0 = new javax.swing.JLabel();
        tPiecePanelPlayerOne0 = new javax.swing.JTextField();
        tPiecePanelPlayerTwo0 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lPanelName1 = new javax.swing.JLabel();
        lPanelPrice1 = new javax.swing.JLabel();
        lPanelOwner1 = new javax.swing.JLabel();
        tPiecePanelPlayerOne1 = new javax.swing.JTextField();
        tPiecePanelPlayerTwo1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lPanelName2 = new javax.swing.JLabel();
        lPanelPrice2 = new javax.swing.JLabel();
        lPanelOwner2 = new javax.swing.JLabel();
        tPiecePanelPlayerOne2 = new javax.swing.JTextField();
        tPiecePanelPlayerTwo2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lPanelName3 = new javax.swing.JLabel();
        lPanelPrice3 = new javax.swing.JLabel();
        lPanelOwner3 = new javax.swing.JLabel();
        tPiecePanelPlayerOne3 = new javax.swing.JTextField();
        tPiecePanelPlayerTwo3 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lPanelName4 = new javax.swing.JLabel();
        lPanelPrice4 = new javax.swing.JLabel();
        lPanelOwner4 = new javax.swing.JLabel();
        tPiecePanelPlayerOne4 = new javax.swing.JTextField();
        tPiecePanelPlayerTwo4 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        lPanelName5 = new javax.swing.JLabel();
        lPanelPrice5 = new javax.swing.JLabel();
        lPanelOwner5 = new javax.swing.JLabel();
        tPiecePanelPlayerOne5 = new javax.swing.JTextField();
        tPiecePanelPlayerTwo5 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        lPanelName6 = new javax.swing.JLabel();
        lPanelPrice6 = new javax.swing.JLabel();
        lPanelOwner6 = new javax.swing.JLabel();
        tPiecePanelPlayerOne6 = new javax.swing.JTextField();
        tPiecePanelPlayerTwo6 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        lPanelName7 = new javax.swing.JLabel();
        lPanelPrice7 = new javax.swing.JLabel();
        lPanelOwner7 = new javax.swing.JLabel();
        tPiecePanelPlayerOne7 = new javax.swing.JTextField();
        tPiecePanelPlayerTwo7 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        lPanelName8 = new javax.swing.JLabel();
        lPanelPrice8 = new javax.swing.JLabel();
        tPiecePanelPlayerOne8 = new javax.swing.JTextField();
        tPiecePanelPlayerTwo8 = new javax.swing.JTextField();
        lPanelOwner8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lPanelName9 = new javax.swing.JLabel();
        lPanelPrice9 = new javax.swing.JLabel();
        lPanelOwner9 = new javax.swing.JLabel();
        tPiecePanelPlayerOne9 = new javax.swing.JTextField();
        tPiecePanelPlayerTwo9 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        lPanelName10 = new javax.swing.JLabel();
        lPanelPrice10 = new javax.swing.JLabel();
        lPanelOwner10 = new javax.swing.JLabel();
        tPiecePanelPlayerOne10 = new javax.swing.JTextField();
        tPiecePanelPlayerTwo10 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        lPanelName12 = new javax.swing.JLabel();
        lPanelPrice12 = new javax.swing.JLabel();
        lPanelOwner12 = new javax.swing.JLabel();
        tPiecePanelPlayerOne12 = new javax.swing.JTextField();
        tPiecePanelPlayerTwo12 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        lPanelName13 = new javax.swing.JLabel();
        lPanelPrice13 = new javax.swing.JLabel();
        lPanelOwner13 = new javax.swing.JLabel();
        tPiecePanelPlayerOne13 = new javax.swing.JTextField();
        tPiecePanelPlayerTwo13 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        lPanelName11 = new javax.swing.JLabel();
        lPanelPrice11 = new javax.swing.JLabel();
        lPanelOwner11 = new javax.swing.JLabel();
        tPiecePanelPlayerOne11 = new javax.swing.JTextField();
        tPiecePanelPlayerTwo11 = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        lPanelName14 = new javax.swing.JLabel();
        lPanelPrice14 = new javax.swing.JLabel();
        lPanelOwner14 = new javax.swing.JLabel();
        tPiecePanelPlayerOne14 = new javax.swing.JTextField();
        tPiecePanelPlayerTwo14 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        lPanelName15 = new javax.swing.JLabel();
        lPanelPrice15 = new javax.swing.JLabel();
        lPanelOwner15 = new javax.swing.JLabel();
        tPiecePanelPlayerOne15 = new javax.swing.JTextField();
        tPiecePanelPlayerTwo15 = new javax.swing.JTextField();
        lPlayerTurnInfo = new javax.swing.JLabel();
        bDie = new javax.swing.JButton();
        lPlayerTurnName = new javax.swing.JLabel();
        tPlayerOneName = new javax.swing.JTextField();
        lPlayerOneMM = new javax.swing.JLabel();
        tPlayerOneMM = new javax.swing.JTextField();
        lPlayerTwoName = new javax.swing.JLabel();
        tPlayerTwoName = new javax.swing.JTextField();
        lPlayerTwoMM = new javax.swing.JLabel();
        tPlayerTwoMM = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMenuSaveItem = new javax.swing.JMenuItem();
        jMenuLoadItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lPlayerOneName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lPlayerOneName.setText("Jugador 1:");

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));

        jPanelBoard.setBackground(new java.awt.Color(204, 255, 204));

        jPanel0.setBackground(new java.awt.Color(204, 255, 204));
        jPanel0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lPanelName0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lPanelName0.setOpaque(true);

        lPanelPrice0.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lPanelPrice0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        tPiecePanelPlayerOne0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tPiecePanelPlayerOne0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tPiecePanelPlayerOne0ActionPerformed(evt);
            }
        });

        tPiecePanelPlayerTwo0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel0Layout = new javax.swing.GroupLayout(jPanel0);
        jPanel0.setLayout(jPanel0Layout);
        jPanel0Layout.setHorizontalGroup(
            jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel0Layout.createSequentialGroup()
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(tPiecePanelPlayerOne0, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tPiecePanelPlayerTwo0, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel0Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lPanelOwner0, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lPanelPrice0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
            .addComponent(lPanelName0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel0Layout.setVerticalGroup(
            jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel0Layout.createSequentialGroup()
                .addComponent(lPanelName0, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tPiecePanelPlayerOne0, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(tPiecePanelPlayerTwo0))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPanelOwner0, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(lPanelPrice0, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lPanelName1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lPanelName1.setOpaque(true);

        lPanelPrice1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lPanelPrice1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(tPiecePanelPlayerOne1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tPiecePanelPlayerTwo1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lPanelOwner1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lPanelPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lPanelName1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lPanelName1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tPiecePanelPlayerOne1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(tPiecePanelPlayerTwo1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPanelOwner1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lPanelPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lPanelName2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lPanelName2.setOpaque(true);

        lPanelPrice2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lPanelPrice2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(tPiecePanelPlayerOne2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tPiecePanelPlayerTwo2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lPanelOwner2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lPanelPrice2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(lPanelName2, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lPanelName2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tPiecePanelPlayerOne2, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(tPiecePanelPlayerTwo2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPanelOwner2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lPanelPrice2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lPanelName3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lPanelName3.setOpaque(true);

        lPanelPrice3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lPanelPrice3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(tPiecePanelPlayerOne3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tPiecePanelPlayerTwo3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lPanelOwner3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lPanelPrice3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(lPanelName3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lPanelName3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tPiecePanelPlayerOne3, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(tPiecePanelPlayerTwo3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPanelOwner3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lPanelPrice3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lPanelName4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lPanelName4.setOpaque(true);

        lPanelPrice4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lPanelPrice4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(tPiecePanelPlayerOne4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tPiecePanelPlayerTwo4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lPanelOwner4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lPanelPrice4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
            .addComponent(lPanelName4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lPanelName4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tPiecePanelPlayerOne4, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(tPiecePanelPlayerTwo4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPanelOwner4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lPanelPrice4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lPanelName5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lPanelName5.setOpaque(true);

        lPanelPrice5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lPanelPrice5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(tPiecePanelPlayerOne5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tPiecePanelPlayerTwo5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lPanelOwner5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lPanelPrice5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
            .addComponent(lPanelName5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lPanelName5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tPiecePanelPlayerOne5, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(tPiecePanelPlayerTwo5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPanelOwner5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(lPanelPrice5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lPanelName6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lPanelName6.setOpaque(true);

        lPanelPrice6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lPanelPrice6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lPanelOwner6.setPreferredSize(new java.awt.Dimension(146, 30));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lPanelName6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lPanelOwner6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lPanelPrice6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(tPiecePanelPlayerOne6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tPiecePanelPlayerTwo6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(lPanelName6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tPiecePanelPlayerOne6, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(tPiecePanelPlayerTwo6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lPanelOwner6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPanelPrice6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel7.setPreferredSize(new java.awt.Dimension(176, 195));

        lPanelName7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lPanelName7.setOpaque(true);

        lPanelOwner7.setPreferredSize(new java.awt.Dimension(146, 30));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lPanelName7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(tPiecePanelPlayerOne7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tPiecePanelPlayerTwo7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(lPanelPrice7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lPanelOwner7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(lPanelName7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tPiecePanelPlayerOne7, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(tPiecePanelPlayerTwo7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lPanelOwner7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPanelPrice7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        jPanel8.setBackground(new java.awt.Color(204, 255, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lPanelName8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lPanelName8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lPanelName8.setOpaque(true);

        lPanelPrice8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lPanelPrice8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        tPiecePanelPlayerOne8.setBackground(new java.awt.Color(153, 0, 0));
        tPiecePanelPlayerOne8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 0, 0), 5, true));

        lPanelOwner8.setPreferredSize(new java.awt.Dimension(146, 30));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lPanelName8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lPanelOwner8, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(lPanelPrice8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tPiecePanelPlayerOne8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tPiecePanelPlayerTwo8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(lPanelName8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tPiecePanelPlayerOne8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tPiecePanelPlayerTwo8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lPanelOwner8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPanelPrice8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        jPanel9.setBackground(new java.awt.Color(204, 255, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lPanelName9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lPanelName9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lPanelName9.setOpaque(true);

        lPanelPrice9.setPreferredSize(new java.awt.Dimension(60, 26));
        lPanelPrice9.setVerifyInputWhenFocusTarget(false);

        lPanelOwner9.setPreferredSize(new java.awt.Dimension(146, 30));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(tPiecePanelPlayerOne9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tPiecePanelPlayerTwo9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lPanelName9, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lPanelPrice9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lPanelOwner9, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(lPanelName9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tPiecePanelPlayerOne9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(tPiecePanelPlayerTwo9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lPanelOwner9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lPanelPrice9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        jPanel10.setBackground(new java.awt.Color(204, 255, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lPanelName10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lPanelName10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lPanelName10.setOpaque(true);

        lPanelPrice10.setPreferredSize(new java.awt.Dimension(60, 26));
        lPanelPrice10.setVerifyInputWhenFocusTarget(false);

        lPanelOwner10.setPreferredSize(new java.awt.Dimension(146, 30));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lPanelOwner10, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lPanelPrice10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(tPiecePanelPlayerOne10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tPiecePanelPlayerTwo10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lPanelName10, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(lPanelName10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tPiecePanelPlayerOne10, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(tPiecePanelPlayerTwo10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lPanelOwner10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lPanelPrice10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        jPanel12.setBackground(new java.awt.Color(204, 255, 204));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lPanelName12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lPanelName12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lPanelName12.setOpaque(true);

        lPanelPrice12.setPreferredSize(new java.awt.Dimension(60, 26));
        lPanelPrice12.setVerifyInputWhenFocusTarget(false);

        lPanelOwner12.setPreferredSize(new java.awt.Dimension(146, 30));

        tPiecePanelPlayerOne12.setBackground(new java.awt.Color(0, 0, 0));
        tPiecePanelPlayerOne12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tPiecePanelPlayerOne12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lPanelName12, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lPanelOwner12, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(tPiecePanelPlayerOne12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tPiecePanelPlayerTwo12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lPanelPrice12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(lPanelName12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tPiecePanelPlayerOne12, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(tPiecePanelPlayerTwo12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lPanelOwner12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lPanelPrice12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        jPanel13.setBackground(new java.awt.Color(204, 255, 204));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lPanelName13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lPanelName13.setOpaque(true);

        lPanelOwner13.setPreferredSize(new java.awt.Dimension(146, 30));

        tPiecePanelPlayerOne13.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lPanelName13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(tPiecePanelPlayerOne13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tPiecePanelPlayerTwo13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 36, Short.MAX_VALUE))
                    .addComponent(lPanelOwner13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lPanelPrice13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(lPanelName13, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tPiecePanelPlayerOne13, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(tPiecePanelPlayerTwo13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lPanelOwner13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lPanelPrice13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        jPanel11.setBackground(new java.awt.Color(204, 255, 204));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lPanelName11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lPanelName11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lPanelName11.setOpaque(true);

        lPanelPrice11.setPreferredSize(new java.awt.Dimension(60, 26));
        lPanelPrice11.setVerifyInputWhenFocusTarget(false);

        lPanelOwner11.setPreferredSize(new java.awt.Dimension(146, 30));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(tPiecePanelPlayerOne11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(tPiecePanelPlayerTwo11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lPanelName11, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lPanelPrice11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lPanelOwner11, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(lPanelName11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tPiecePanelPlayerTwo11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tPiecePanelPlayerOne11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lPanelOwner11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(lPanelPrice11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel14.setBackground(new java.awt.Color(204, 255, 204));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lPanelName14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lPanelName14.setOpaque(true);

        lPanelPrice14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lPanelPrice14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lPanelOwner14.setPreferredSize(new java.awt.Dimension(146, 30));

        tPiecePanelPlayerOne14.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lPanelName14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lPanelPrice14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lPanelOwner14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(tPiecePanelPlayerOne14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tPiecePanelPlayerTwo14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(lPanelName14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tPiecePanelPlayerOne14, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(tPiecePanelPlayerTwo14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lPanelOwner14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPanelPrice14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        jPanel15.setBackground(new java.awt.Color(204, 255, 204));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        lPanelName15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lPanelName15.setOpaque(true);

        lPanelPrice15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lPanelPrice15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(tPiecePanelPlayerOne15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tPiecePanelPlayerTwo15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lPanelOwner15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lPanelPrice15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lPanelName15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(lPanelName15, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tPiecePanelPlayerOne15, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(tPiecePanelPlayerTwo15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lPanelOwner15, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lPanelPrice15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lPlayerTurnInfo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        bDie.setIcon(new javax.swing.ImageIcon("C:\\Users\\Cristina\\Downloads\\dado.png")); // NOI18N
        bDie.setText("Dado");
        bDie.setBorder(null);
        bDie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDieActionPerformed(evt);
            }
        });

        lPlayerTurnName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lPlayerTurnName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelBoardLayout = new javax.swing.GroupLayout(jPanelBoard);
        jPanelBoard.setLayout(jPanelBoardLayout);
        jPanelBoardLayout.setHorizontalGroup(
            jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelBoardLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBoardLayout.createSequentialGroup()
                            .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBoardLayout.createSequentialGroup()
                        .addComponent(bDie, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lPlayerTurnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelBoardLayout.createSequentialGroup()
                        .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelBoardLayout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelBoardLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBoardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lPlayerTurnName, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(192, 192, 192))
        );
        jPanelBoardLayout.setVerticalGroup(
            jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBoardLayout.createSequentialGroup()
                .addComponent(lPlayerTurnName, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBoardLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBoardLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bDie, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelBoardLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lPlayerTurnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBoardLayout.createSequentialGroup()
                        .addComponent(jPanel0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelBoardLayout.createSequentialGroup()
                        .addGroup(jPanelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        tPlayerOneName.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tPlayerOneName.setEnabled(false);
        tPlayerOneName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                none(evt);
            }
        });

        lPlayerOneMM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lPlayerOneMM.setText("MM:");

        tPlayerOneMM.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tPlayerOneMM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tPlayerOneMMActionPerformed(evt);
            }
        });

        lPlayerTwoName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lPlayerTwoName.setText("Jugador 2:");

        tPlayerTwoName.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tPlayerTwoName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tPlayerTwoNameActionPerformed(evt);
            }
        });

        lPlayerTwoMM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lPlayerTwoMM.setText("MM:");

        tPlayerTwoMM.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tPlayerTwoMM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tPlayerTwoMMActionPerformed(evt);
            }
        });

        jMenu.setText("Menú");

        jMenuSaveItem.setText("Guardar");
        jMenuSaveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSaveItemActionPerformed(evt);
            }
        });
        jMenu.add(jMenuSaveItem);

        jMenuLoadItem.setText("Cargar");
        jMenuLoadItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuLoadItemActionPerformed(evt);
            }
        });
        jMenu.add(jMenuLoadItem);

        jMenuBar1.add(jMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lPlayerOneName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tPlayerOneName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(lPlayerOneMM, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tPlayerOneMM, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(lPlayerTwoName, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tPlayerTwoName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(lPlayerTwoMM, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tPlayerTwoMM, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanelBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lPlayerOneName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lPlayerOneMM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lPlayerTwoName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lPlayerTwoMM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tPlayerOneName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tPlayerOneMM, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tPlayerTwoName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tPlayerTwoMM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuLoadItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuLoadItemActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                this.board = (Board) in.readObject();

                // Operaciones adicionales después de cargar
                updateGameAfterLoad();
             
                JOptionPane.showMessageDialog(this, "Partida cargada correctamente.");
            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(this, "Error al cargar la partida: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenuLoadItemActionPerformed

    private void jMenuSaveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSaveItemActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                out.writeObject(this.board);
                JOptionPane.showMessageDialog(this, "Partida guardada correctamente.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar la partida: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenuSaveItemActionPerformed

    private void none(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_none
        // TODO add your handling code here:
    }//GEN-LAST:event_none

    private void tPlayerOneMMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tPlayerOneMMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tPlayerOneMMActionPerformed

    private void tPlayerTwoNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tPlayerTwoNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tPlayerTwoNameActionPerformed

    private void tPlayerTwoMMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tPlayerTwoMMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tPlayerTwoMMActionPerformed

    private void tPiecePanelPlayerOne0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tPiecePanelPlayerOne0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tPiecePanelPlayerOne0ActionPerformed

    private void bDieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDieActionPerformed
        int die = this.board.rollDie();
        this.setLabelTurnInfo("Has sacado: " + String.valueOf(die));
        Player current = this.board.getPlayerTurn();

        System.out.println("Jugador " + current.getName()+ " , ha sacado: " + die);

        int currentPosition = current.getCurrentPosition();
        int newPosition = currentPosition;

        if (!current.isBlocked() || current.isBlocked() && die == 5) {
            System.out.println("Jugador no bloqueado");
            current.setBlocked(false);
            newPosition = this.board.movePlayer(die);
            this.drawPiecePlayer(currentPosition, newPosition);
            System.out.println("Nueva posición: "+ newPosition);
        }

        if (newPosition < currentPosition) {
            this.hasPassedStartSquare(current);
        }

        String message = this.executeSquareAction(newPosition);
        System.out.println("Jugador " +current.getName()+ " ,current_position: " + currentPosition + ", new Position: " + newPosition);

        if (!this.board.isGameActive()) {
            this.showWinner();
        } else {
            this.changeTurn(message);
        }
    }//GEN-LAST:event_bDieActionPerformed

    private void tPiecePanelPlayerOne12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tPiecePanelPlayerOne12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tPiecePanelPlayerOne12ActionPerformed

    private void hasPassedStartSquare(Player currentPlayer) {
        currentPlayer.setMegaMoney(currentPlayer.getMegaMoney() + StartSquare.PASS_BY_START_SQUARE);
    }
    
    private void changeTurn(String message) {
        this.board.changeTurn();
        this.setLabelTurnName();
        this.setLabelTurnInfo(message);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDie;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuLoadItem;
    private javax.swing.JMenuItem jMenuSaveItem;
    private javax.swing.JPanel jPanel0;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelBoard;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lPanelName0;
    private javax.swing.JLabel lPanelName1;
    private javax.swing.JLabel lPanelName10;
    private javax.swing.JLabel lPanelName11;
    private javax.swing.JLabel lPanelName12;
    private javax.swing.JLabel lPanelName13;
    private javax.swing.JLabel lPanelName14;
    private javax.swing.JLabel lPanelName15;
    private javax.swing.JLabel lPanelName2;
    private javax.swing.JLabel lPanelName3;
    private javax.swing.JLabel lPanelName4;
    private javax.swing.JLabel lPanelName5;
    private javax.swing.JLabel lPanelName6;
    private javax.swing.JLabel lPanelName7;
    private javax.swing.JLabel lPanelName8;
    private javax.swing.JLabel lPanelName9;
    private javax.swing.JLabel lPanelOwner0;
    private javax.swing.JLabel lPanelOwner1;
    private javax.swing.JLabel lPanelOwner10;
    private javax.swing.JLabel lPanelOwner11;
    private javax.swing.JLabel lPanelOwner12;
    private javax.swing.JLabel lPanelOwner13;
    private javax.swing.JLabel lPanelOwner14;
    private javax.swing.JLabel lPanelOwner15;
    private javax.swing.JLabel lPanelOwner2;
    private javax.swing.JLabel lPanelOwner3;
    private javax.swing.JLabel lPanelOwner4;
    private javax.swing.JLabel lPanelOwner5;
    private javax.swing.JLabel lPanelOwner6;
    private javax.swing.JLabel lPanelOwner7;
    private javax.swing.JLabel lPanelOwner8;
    private javax.swing.JLabel lPanelOwner9;
    private javax.swing.JLabel lPanelPrice0;
    private javax.swing.JLabel lPanelPrice1;
    private javax.swing.JLabel lPanelPrice10;
    private javax.swing.JLabel lPanelPrice11;
    private javax.swing.JLabel lPanelPrice12;
    private javax.swing.JLabel lPanelPrice13;
    private javax.swing.JLabel lPanelPrice14;
    private javax.swing.JLabel lPanelPrice15;
    private javax.swing.JLabel lPanelPrice2;
    private javax.swing.JLabel lPanelPrice3;
    private javax.swing.JLabel lPanelPrice4;
    private javax.swing.JLabel lPanelPrice5;
    private javax.swing.JLabel lPanelPrice6;
    private javax.swing.JLabel lPanelPrice7;
    private javax.swing.JLabel lPanelPrice8;
    private javax.swing.JLabel lPanelPrice9;
    private javax.swing.JLabel lPlayerOneMM;
    private javax.swing.JLabel lPlayerOneName;
    private javax.swing.JLabel lPlayerTurnInfo;
    private javax.swing.JLabel lPlayerTurnName;
    private javax.swing.JLabel lPlayerTwoMM;
    private javax.swing.JLabel lPlayerTwoName;
    private javax.swing.JTextField tPiecePanelPlayerOne0;
    private javax.swing.JTextField tPiecePanelPlayerOne1;
    private javax.swing.JTextField tPiecePanelPlayerOne10;
    private javax.swing.JTextField tPiecePanelPlayerOne11;
    private javax.swing.JTextField tPiecePanelPlayerOne12;
    private javax.swing.JTextField tPiecePanelPlayerOne13;
    private javax.swing.JTextField tPiecePanelPlayerOne14;
    private javax.swing.JTextField tPiecePanelPlayerOne15;
    private javax.swing.JTextField tPiecePanelPlayerOne2;
    private javax.swing.JTextField tPiecePanelPlayerOne3;
    private javax.swing.JTextField tPiecePanelPlayerOne4;
    private javax.swing.JTextField tPiecePanelPlayerOne5;
    private javax.swing.JTextField tPiecePanelPlayerOne6;
    private javax.swing.JTextField tPiecePanelPlayerOne7;
    private javax.swing.JTextField tPiecePanelPlayerOne8;
    private javax.swing.JTextField tPiecePanelPlayerOne9;
    private javax.swing.JTextField tPiecePanelPlayerTwo0;
    private javax.swing.JTextField tPiecePanelPlayerTwo1;
    private javax.swing.JTextField tPiecePanelPlayerTwo10;
    private javax.swing.JTextField tPiecePanelPlayerTwo11;
    private javax.swing.JTextField tPiecePanelPlayerTwo12;
    private javax.swing.JTextField tPiecePanelPlayerTwo13;
    private javax.swing.JTextField tPiecePanelPlayerTwo14;
    private javax.swing.JTextField tPiecePanelPlayerTwo15;
    private javax.swing.JTextField tPiecePanelPlayerTwo2;
    private javax.swing.JTextField tPiecePanelPlayerTwo3;
    private javax.swing.JTextField tPiecePanelPlayerTwo4;
    private javax.swing.JTextField tPiecePanelPlayerTwo5;
    private javax.swing.JTextField tPiecePanelPlayerTwo6;
    private javax.swing.JTextField tPiecePanelPlayerTwo7;
    private javax.swing.JTextField tPiecePanelPlayerTwo8;
    private javax.swing.JTextField tPiecePanelPlayerTwo9;
    private javax.swing.JTextField tPlayerOneMM;
    private javax.swing.JTextField tPlayerOneName;
    private javax.swing.JTextField tPlayerTwoMM;
    private javax.swing.JTextField tPlayerTwoName;
    // End of variables declaration//GEN-END:variables
}

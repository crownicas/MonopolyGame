package activiti6.monopoly;
/**
 *
 * @author Fredy
 */
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;


public class MonopolyGuiBoard extends javax.swing.JFrame implements Serializable {
    private Board board;
    private int rows = 5;
    private int cols = 5;
    private JPanel[][] panelBoard;
    private HashMap<Object, Object> squareMap = new HashMap<>();
    /**
     * Creates new form MonopolyBoardGui
     * @param board
     */
    public MonopolyGuiBoard(Board board) {
        this.board = board;
        initComponents();
                
        this.drawPanelSquare();
        this.updatePanelInfo();
        
        this.board.whoStarts();
        this.playTurn(); 
    }
    
    // This method initializes and draws the panel squares on the game board.
    // It creates a 2D array of JPanels representing the board squares and styles them.
    // Then, it fills in the squares starting from the bottom border, moving clockwise.
    // Each square is associated with its panel and added to the squareMap.
    // Finally, player pieces are moved to their starting positions on the board.
    private void drawPanelSquare() {
        ArrayList<Square> squares = this.board.getSquares();
        panelBoard = new JPanel[this.rows][this.cols];
        
        for (int i = 0; i < panelBoard.length; i++) {
            for (int j = 0; j < panelBoard.length; j++) {
                panelBoard[i][j] = new JPanel();
                //panelBoard[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, WIDTH));
                panelBoard[i][j].setBackground(new Color(169,223,191));
                pBoard.add(panelBoard[i][j]);
            }
        }
        add(pBoard);
        setVisible(true);
        
        int row = 4;
        int col = 4;
        int indice = 0;
        // Fills the bottom border of the game board.
        for (int i = col; i >= 0; i--) {
            this.createSquarePanel(panelBoard[row][i], squares.get(indice));
            this.squareMap.put(indice, panelBoard[row][i]);
            indice++;
        }
        
        col = 0;
        row = 3;
        // Fills the left border of the game board
        for (int i = row; i >= 0; i--) {
            this.createSquarePanel(panelBoard[i][col], squares.get(indice));
            this.squareMap.put(indice, panelBoard[i][col]);
            indice++;
        }
        
        col = 1;
        row = 0;
        // Fills the top border of the game board
        for (int i = col; i < this.cols; i++) {
            this.createSquarePanel(panelBoard[row][i], squares.get(indice));
            this.squareMap.put(indice, panelBoard[row][i]);
            indice++;
        }
        
        col = this.cols - 1;
        row = 1;
        // Fills the right border of the game board
        for (int i = row; i < this.rows - 1; i++) {
            this.createSquarePanel(panelBoard[i][col], squares.get(indice));
            this.squareMap.put(indice, panelBoard[i][col]);
            indice++;
        }
        
        this.movePieceToStart(this.board.getPlayerOne(), this.board.getPlayerTwo());
    }
    
    // Method to create and configure a panel representing a square on the game board.
    // It sets the layout to null for custom positioning, sets the panel size, and adds a border.
    // Components are added to display the square's color, name, owner (if applicable), and price (if it's a property square).
    private void createSquarePanel(JPanel squarePanel, Square square) {
        squarePanel.setLayout(null);
        squarePanel.setSize(new Dimension(200, 200)); 
        squarePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, WIDTH)); // Set border of the panel
        squarePanel.setVisible(true);
        
        int maxWith = squarePanel.getWidth(); // Get the maximum width of the panel
        
        JLabel colorRow = new JLabel();
        colorRow.setName("colorRow");
        colorRow.setVisible(true);
        colorRow.setOpaque(true);
        colorRow.setBounds(0, 0, maxWith, 40);
        colorRow.setBackground(square.getColor());
        colorRow.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        squarePanel.add(colorRow);
       
        JLabel nameSquareRow = new JLabel();
        nameSquareRow.setName("nameSquareRow");
        nameSquareRow.setBounds(0, 50, maxWith, 20);
        nameSquareRow.setFont(new Font("Arial", Font.BOLD, 14));
        nameSquareRow.setHorizontalAlignment(SwingConstants.CENTER);
        nameSquareRow.setText(square.getName());
        nameSquareRow.setVisible(true);
        squarePanel.add(nameSquareRow);
        
        JPanel emptyRow = new JPanel();
        emptyRow.setName("emptyRow");
        emptyRow.setLayout(null);
        emptyRow.setBounds(1, 70, maxWith-1, 40);
        emptyRow.setVisible(true);
        emptyRow.setBackground(new Color(169,223,191));
        squarePanel.add(emptyRow);
              
        JLabel ownerRow = new JLabel();
        ownerRow.setName("ownerRow");
        ownerRow.setBounds(0, 110, maxWith, 20);
        ownerRow.setFont(new Font("Arial", 0, 12));
        ownerRow.setHorizontalAlignment(SwingConstants.CENTER);
        ownerRow.setVisible(true);
        squarePanel.add(ownerRow);

        JLabel priceRow = new JLabel();
        priceRow.setName("priceRow");
        priceRow.setBounds(0, 150, maxWith, 20);
        priceRow.setFont(new Font("Arial", Font.BOLD, 14));
        priceRow.setHorizontalAlignment(SwingConstants.CENTER);
        priceRow.setVisible(true);
        squarePanel.add(priceRow);
        
        if (square instanceof PropertySquare propSquare) {
            if (propSquare.getOwner() != null) {
                ownerRow.setText("Propiedad de: " + propSquare.getOwner().getName());
            }
            
            priceRow.setText(propSquare.getPrice() + "MM");
        }
    }
    // Method to move player pieces to their starting positions on the game board.
    // It retrieves the current positions of both players and places their colored JLabel pieces on the corresponding empty rows.
    private void movePieceToStart(Player playerOne, Player playerTwo) {
        int playerOnePosition = playerOne.getCurrentPosition();
        int playerTwoPosition = playerTwo.getCurrentPosition();
        
        JPanel currentPanelOnePlayer = (JPanel) squareMap.get(playerOnePosition);
        JPanel currentPanelTwoPlayer = (JPanel) squareMap.get(playerTwoPosition);
        
        Component emptyRowOnePlayer = this.findComponentByName(currentPanelOnePlayer, "emptyRow");
        Component emptyRowTwoPlayer = this.findComponentByName(currentPanelTwoPlayer, "emptyRow");

        JLabel piecePlayerOne = new JLabel();
        piecePlayerOne.setBackground(playerOne.getPieceColor());
        piecePlayerOne.setName(playerOne.getPieceColorName());
        piecePlayerOne.setBounds(60, 10, 30, 30);
        piecePlayerOne.setVisible(true);
        piecePlayerOne.setOpaque(true);
        ((JPanel)emptyRowOnePlayer).add(piecePlayerOne);

        JLabel piecePlayerTwo = new JLabel();
        piecePlayerTwo.setBackground(playerTwo.getPieceColor());
        piecePlayerTwo.setName(playerTwo.getPieceColorName());
        piecePlayerTwo.setBounds(100, 10, 30, 30);
        piecePlayerTwo.setVisible(true);
        piecePlayerTwo.setOpaque(true);
        ((JPanel)emptyRowTwoPlayer).add(piecePlayerTwo);
    }
    
    private void movePiece(int currentPosition, int newPosition) {
        if (newPosition != currentPosition) {
            JPanel current_panel = (JPanel) squareMap.get(currentPosition);
            JPanel next_panel = (JPanel) squareMap.get(newPosition);
            Player currentPlayer = this.board.getPlayerTurn();

            String pieceName = currentPlayer.getPieceColorName();

            // Removes the player piece from the current square
            Component emptyRow = this.findComponentByName(current_panel, "emptyRow");
            Component removePiece = this.findComponentByName(((JPanel)emptyRow), pieceName);
            ((JPanel)emptyRow).remove(removePiece);
            
            ((JPanel)emptyRow).revalidate();
            ((JPanel)emptyRow).repaint();
            
            Player otherPlayer = this.getPlayerNotTurn();
            
            // Paints the player piece on the new square
            emptyRow = this.findComponentByName(next_panel, "emptyRow");
            JLabel piece = new JLabel();
            piece.setName(currentPlayer.getPieceColorName());
            piece.setBackground(currentPlayer.getPieceColor());
            
            if(otherPlayer.getCurrentPosition() == newPosition) {
                piece.setBounds(100, 10, 30, 30);
            } else {
                piece.setBounds(60, 10, 30, 30);
            }
            
            piece.setVisible(true);
            piece.setOpaque(true);
            ((JPanel)emptyRow).add(piece);
            
            // Actualizamos la interfaz gráfica
            ((JPanel)emptyRow).revalidate();
            ((JPanel)emptyRow).repaint();
        }   
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
        this.updatePAction("");
    }
        
    public void updatePanelInfo() {
        Player player_one = this.board.getPlayerOne();
        Player player_two = this.board.getPlayerTwo();
        
        this.tPlayerOneName.setText(player_one.getName());
        this.tPlayerTwoName.setText(player_two.getName()); 
        this.updatedMMInfo();
    }
    
    private void updatePAction(String message) {
        this.lTurnName.setText("Turno: " + this.board.getPlayerTurn().getName());
        this.lTurnInfo.setText(message);
    }
    
    public void updatedMMInfo() {
        Player player_one = this.board.getPlayerOne();
        Player player_two = this.board.getPlayerTwo();
        
        this.tPlayerOneMM.setText(String.valueOf(player_one.getMegaMoney()));
        this.tPlayerTwoMM.setText(String.valueOf(player_two.getMegaMoney()));
    }
        
    private Player getPlayerNotTurn() {
        if (this.board.getPlayerTurn().equals(this.board.getPlayerOne())) {
            return this.board.getPlayerTwo();
        } else {
            return this.board.getPlayerOne();
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
    
    private void showSquareOwner(int position) {
        JPanel current_panel = (JPanel) squareMap.get(position);
        Square square = this.board.getSquare(position);
           
        Component ownerRow = this.findComponentByName(current_panel, "ownerRow");
        ((JLabel) ownerRow).setText("Propiedad de: " + ((PropertySquare)square).getOwner().getName());
    }
    
    // Executes actions related to a square on the game board
    // Handles purchases, deducts money on birthdays, and updates player positions and money
    // Returns the action message
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
            this.movePiece(position, current.getCurrentPosition());
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
            this.showSquareOwner(currentPlayer.getCurrentPosition());
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

        pInfo = new javax.swing.JPanel();
        lPlayerOneName = new javax.swing.JLabel();
        tPlayerOneName = new javax.swing.JTextField();
        lPlayerOneMM = new javax.swing.JLabel();
        tPlayerOneMM = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lPlayerTwoName = new javax.swing.JLabel();
        tPlayerTwoName = new javax.swing.JTextField();
        lPlayerTwoMM = new javax.swing.JLabel();
        tPlayerTwoMM = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pAction = new javax.swing.JPanel();
        lTurnInfo = new javax.swing.JLabel();
        lTurnName = new javax.swing.JLabel();
        bDie = new javax.swing.JButton();
        pBoard = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMenuSaveItem = new javax.swing.JMenuItem();
        jMenuLoadItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pInfo.setMaximumSize(null);
        pInfo.setPreferredSize(new java.awt.Dimension(950, 100));
        pInfo.setLayout(null);

        lPlayerOneName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lPlayerOneName.setText("Jugador 1:");
        lPlayerOneName.setPreferredSize(new java.awt.Dimension(65, 20));
        pInfo.add(lPlayerOneName);
        lPlayerOneName.setBounds(70, 10, 65, 20);

        tPlayerOneName.setEditable(false);
        tPlayerOneName.setBackground(new java.awt.Color(255, 255, 255));
        tPlayerOneName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tPlayerOneName.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tPlayerOneName.setPreferredSize(new java.awt.Dimension(150, 25));
        tPlayerOneName.setRequestFocusEnabled(false);
        pInfo.add(tPlayerOneName);
        tPlayerOneName.setBounds(140, 10, 150, 25);

        lPlayerOneMM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lPlayerOneMM.setText("MM:");
        lPlayerOneMM.setPreferredSize(new java.awt.Dimension(30, 20));
        pInfo.add(lPlayerOneMM);
        lPlayerOneMM.setBounds(300, 10, 30, 20);

        tPlayerOneMM.setEditable(false);
        tPlayerOneMM.setBackground(new java.awt.Color(255, 255, 255));
        tPlayerOneMM.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tPlayerOneMM.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tPlayerOneMM.setPreferredSize(new java.awt.Dimension(50, 25));
        pInfo.add(tPlayerOneMM);
        tPlayerOneMM.setBounds(340, 10, 50, 25);

        jSeparator1.setBackground(new java.awt.Color(102, 102, 102));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setFocusCycleRoot(true);
        jSeparator1.setPreferredSize(new java.awt.Dimension(20, 20));
        pInfo.add(jSeparator1);
        jSeparator1.setBounds(510, 10, 20, 20);

        lPlayerTwoName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lPlayerTwoName.setText("Jugador 2:");
        lPlayerTwoName.setPreferredSize(new java.awt.Dimension(65, 20));
        pInfo.add(lPlayerTwoName);
        lPlayerTwoName.setBounds(650, 10, 65, 20);

        tPlayerTwoName.setEditable(false);
        tPlayerTwoName.setBackground(new java.awt.Color(255, 255, 255));
        tPlayerTwoName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tPlayerTwoName.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tPlayerTwoName.setPreferredSize(new java.awt.Dimension(150, 25));
        tPlayerTwoName.setRequestFocusEnabled(false);
        pInfo.add(tPlayerTwoName);
        tPlayerTwoName.setBounds(720, 10, 150, 25);

        lPlayerTwoMM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lPlayerTwoMM.setText("MM:");
        lPlayerTwoMM.setPreferredSize(new java.awt.Dimension(30, 20));
        pInfo.add(lPlayerTwoMM);
        lPlayerTwoMM.setBounds(890, 10, 30, 20);

        tPlayerTwoMM.setEditable(false);
        tPlayerTwoMM.setBackground(new java.awt.Color(255, 255, 255));
        tPlayerTwoMM.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tPlayerTwoMM.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tPlayerTwoMM.setPreferredSize(new java.awt.Dimension(50, 25));
        pInfo.add(tPlayerTwoMM);
        tPlayerTwoMM.setBounds(930, 10, 50, 25);

        jLabel1.setBackground(new java.awt.Color(0, 204, 0));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(20, 20));
        pInfo.add(jLabel1);
        jLabel1.setBounds(610, 10, 30, 20);

        jLabel2.setBackground(new java.awt.Color(255, 0, 0));
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new java.awt.Dimension(20, 20));
        pInfo.add(jLabel2);
        jLabel2.setBounds(30, 10, 30, 20);

        pAction.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lTurnInfo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        lTurnName.setBackground(new java.awt.Color(204, 204, 204));
        lTurnName.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        bDie.setBackground(new java.awt.Color(102, 102, 102));
        bDie.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bDie.setForeground(new java.awt.Color(255, 255, 255));
        bDie.setText("Lanzar dado");
        bDie.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bDie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pActionLayout = new javax.swing.GroupLayout(pAction);
        pAction.setLayout(pActionLayout);
        pActionLayout.setHorizontalGroup(
            pActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pActionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lTurnName, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lTurnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(bDie, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        pActionLayout.setVerticalGroup(
            pActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pActionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bDie, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addGroup(pActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lTurnInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(lTurnName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pBoard.setLayout(new java.awt.GridLayout(5, 5));

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
            .addComponent(pAction, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 1006, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 1008, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pInfo.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Handles loading a game from a file when the "Load" menu item is clicked
    // Opens a file chooser dialog for selecting the game file
    // Reads the serialized board object from the file and displays it
    // Closes the current window after loading
    private void jMenuLoadItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuLoadItemActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                Board load_board = (Board) in.readObject();
                MonopolyGuiBoard guiBoard = new MonopolyGuiBoard(load_board);
                guiBoard.setSize(1060,1050);
                guiBoard.setVisible(true);
                guiBoard.setLocationRelativeTo(null);
        
                this.dispose();

            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(this, "Error al cargar la partida: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenuLoadItemActionPerformed
    
    // Handles saving the game when "Save" is clicked in the menu.
    // Allows the user to choose the save location using a file chooser.
    // Serializes and writes the current game board to the selected file.
    // Displays a success message upon successful save, or an error message if saving fails.
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
    
    // Handles rolling the die and player movement
    private void bDieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDieActionPerformed
        int die = this.board.rollDie();
        this.updatePAction("Has sacado: " + String.valueOf(die));
        Player current = this.board.getPlayerTurn();

        System.out.println("Jugador " + current.getName()+ " , ha sacado: " + die);

        int currentPosition = current.getCurrentPosition();
        int newPosition = currentPosition;
        
        if (!current.isBlocked() || current.isBlocked() && die == 5) {
            System.out.println("Jugador no bloqueado");
            current.setBlocked(false);
            newPosition = this.board.movePlayer(die);

            this.movePiece(currentPosition, newPosition);
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
    
    // Increases the player's money when passing the start square
    private void hasPassedStartSquare(Player currentPlayer) {
        currentPlayer.setMegaMoney(currentPlayer.getMegaMoney() + StartSquare.PASS_BY_START_SQUARE);
    }
    // Changes the turn to the next player and updates the player action message.
    private void changeTurn(String message) {
        this.board.changeTurn();
        this.updatePAction(message);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuLoadItem;
    private javax.swing.JMenuItem jMenuSaveItem;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lPlayerOneMM;
    private javax.swing.JLabel lPlayerOneName;
    private javax.swing.JLabel lPlayerTwoMM;
    private javax.swing.JLabel lPlayerTwoName;
    private javax.swing.JLabel lTurnInfo;
    private javax.swing.JLabel lTurnName;
    private javax.swing.JPanel pAction;
    private javax.swing.JPanel pBoard;
    private javax.swing.JPanel pInfo;
    private javax.swing.JTextField tPlayerOneMM;
    private javax.swing.JTextField tPlayerOneName;
    private javax.swing.JTextField tPlayerTwoMM;
    private javax.swing.JTextField tPlayerTwoName;
    // End of variables declaration//GEN-END:variables
}

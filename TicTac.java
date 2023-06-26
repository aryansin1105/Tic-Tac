import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
public class TicTac implements ActionListener{

    Random random = new Random();
    JFrame frame;
    JButton[] buttons;
    JPanel panel = new JPanel();
    JPanel btnPanel = new JPanel();
    JLabel label = new JLabel();
    boolean player1Turn;

    TicTac(){
        frame = new JFrame("TIc Tac");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(new BorderLayout());

        buttons = new JButton[9];
        btnPanel.setLayout(new GridLayout(3,3));
        label.setBackground(Color.BLACK);
        label.setText("Tic Tac Toe");
        label.setFont(new Font("Ink Free",Font.BOLD,55));
        label.setHorizontalAlignment(JLabel.CENTER);

        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.BLUE);
        panel.add(label);

        btnPanel.setLayout(new GridLayout(3,3));

        for(int i=0;i<9;i++){
            buttons[i] = new JButton();
            btnPanel.add(buttons[i]);
            buttons[i].addActionListener(this);
        }


        frame.add(panel,BorderLayout.NORTH);
        frame.add(btnPanel,BorderLayout.CENTER);
        frame.setVisible(true);

        firstTurn();
    }
    public void firstTurn(){
        if(random.nextInt(2) == 0){
            player1Turn = true;
            label.setText("X Turn");
        }else{
            player1Turn = false;
            label.setText("O Turn");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        for(int i=0;i<9;i++){
            if(e.getSource() == buttons[i]){
                if(player1Turn){
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        buttons[i].setFont(new Font("Ink Free",Font.BOLD,55));
                        player1Turn = false;
                        label.setText("O Turn");
                        checkWin();
                    }
                }else{
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        buttons[i].setFont(new Font("Ink Free",Font.BOLD,55));
                        player1Turn = true;
                        label.setText("X Turn");
                        checkWin();
                    }
                }
            }
        }
    }
    public void checkWin(){
        if((buttons[0].getText() == "X") && 
            (buttons[1].getText() == "X") && 
            (buttons[2].getText() == "X")){
                xWin(0,1,2);
        }
        if((buttons[3].getText() == "X") && 
            (buttons[4].getText() == "X") && 
            (buttons[5].getText() == "X")){
                xWin(3,4,5);
        }
        if((buttons[6].getText() == "X") && 
            (buttons[7].getText() == "X") && 
            (buttons[8].getText() == "X")){
                xWin(6,7,8);
        }
        if((buttons[0].getText() == "X") && 
            (buttons[3].getText() == "X") && 
            (buttons[6].getText() == "X")){
                xWin(0,3,6);
        }
        if((buttons[1].getText() == "X") && 
            (buttons[4].getText() == "X") && 
            (buttons[7].getText() == "X")){
                xWin(1,4,7);
        }
        if((buttons[2].getText() == "X") && 
            (buttons[5].getText() == "X") && 
            (buttons[8].getText() == "X")){
                xWin(2,5,8);
        }
        if((buttons[0].getText() == "X") && 
            (buttons[4].getText() == "X") && 
            (buttons[8].getText() == "X")){
                xWin(0,4,8);
        }
        if((buttons[2].getText() == "X") && 
            (buttons[4].getText() == "X") && 
            (buttons[6].getText() == "X")){
                xWin(2,4,6);
        }
        if((buttons[0].getText() == "O") && 
            (buttons[1].getText() == "O") && 
            (buttons[2].getText() == "O")){
                oWin(0,1,2);
            }
        if((buttons[3].getText() == "O") && 
            (buttons[4].getText() == "O") && 
            (buttons[5].getText() == "O")){
                oWin(3,4,5);
        }
        if((buttons[6].getText() == "O") && 
            (buttons[7].getText() == "O") && 
            (buttons[8].getText() == "O")){
                oWin(6,7,8);
        }
        if((buttons[0].getText() == "O") && 
            (buttons[3].getText() == "O") && 
            (buttons[6].getText() == "O")){
                oWin(0,3,6);
            }
        if((buttons[1].getText() == "O") && 
            (buttons[4].getText() == "O") && 
            (buttons[7].getText() == "O")){
                oWin(1,4,7);
        }
        if((buttons[2].getText() == "O") && 
            (buttons[5].getText() == "O") && 
            (buttons[8].getText() == "O")){
                oWin(2,5,8);
        }
        if((buttons[0].getText() == "O") &&
            (buttons[4].getText() == "O") && 
            (buttons[8].getText() == "O")){
                oWin(0,4,8);
        }
        if((buttons[2].getText() == "O") && 
            (buttons[4].getText() == "O") && 
            (buttons[6].getText() == "O")){
                oWin(2,4,6);
        }
    }
    public void xWin(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        label.setText("X Wins");
    }
    public void oWin(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        label.setText("O Wins");
    }
    public static void main(String[] args) {
        new TicTac();
    }
}

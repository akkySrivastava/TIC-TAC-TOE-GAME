/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author akky
 */
public final class game implements ActionListener{
    JLabel l,X,Y;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    JButton replay,clear;
    JPanel p1,p2,p3;
    JFrame f;
    int count=0;
    int ctr=0;
   
    public game(){
                //initComponents();
                
                f=new JFrame();
                f.setBackground(Color.WHITE);
                
                f.setLayout(null);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(400,600);
                
                f.setTitle("TIC TAC TOE GAME");
                               
                p1=new JPanel(new GridLayout(2,2,5,5));
                l=new JLabel("PLAY");
                X=new JLabel("X's Stat: 0");
                X.setFont(new Font("tahoma",Font.BOLD,17));
                Y=new JLabel("Y's Stat: 0");
                Y.setFont(new Font("tahoma",Font.BOLD,17));
                p1.setBackground(Color.red);
                l.setForeground(Color.white);
                p1.setBounds(50,20,280,50);
                l.setFont(new Font("tahoma",Font.BOLD,15));
                clear=new JButton("Clear");
                clear.setBackground(Color.red);
                clear.setForeground(Color.BLACK);
                clear.setSize(50,50);
                p1.add(clear);
                p1.add(l);
                p1.add(X);
                p1.add(Y);
                f.add(p1);
                clear.addActionListener(this);
                
                p2=new JPanel(new GridLayout(3,3,15,15));
                p2.setBounds(65,90,250,300);
                b1=new JButton("");
                b1.setBounds(80,100,50,50);
                b1.setPreferredSize(new Dimension(50,50));
                
                b2=new JButton("");
                
                b2.setBounds(180,100,50,50);
                
                b3=new JButton("");
                b3.setBounds(280,100,50,50);
                
                b4=new JButton("");
                b4.setBounds(80,200,50,50);
                
                b5=new JButton("");
                b5.setBounds(180,200,50,50);
                
                b6=new JButton("");
                b6.setBounds(280,200,50,50);
                
                b7=new JButton("");
                b7.setBounds(80,300,50,50);
                
                
                b8=new JButton("");
                b7.setBounds(180,80,50,50);
                
                b9=new JButton("");
                b9.setBounds(280,80,50,50);
               
                
                p2.add(b1);
                p2.add(b2);
                p2.add(b3);
                p2.add(b4);
                p2.add(b5);
                p2.add(b6);
                p2.add(b7);
                p2.add(b8);
                p2.add(b9);
                f.add(p2);
                
                
                replay=new JButton("REPLAY");
                replay.setBounds(50,400,280,50);
                replay.setBackground(Color.green);
                replay.setForeground(Color.black);
                replay.setFont(new Font("tahoma",Font.BOLD,32));
                f.add(replay);
                replay.addActionListener(this);
                addAction();
                f.setVisible(true);
                
    }
    
   public int allMoves(){
    String txt="";
    Component[] comps=p2.getComponents();
        for(Component comp: comps)
        {
            if(comp instanceof JButton) {
                JButton button=(JButton)comp;
                txt=txt+button.getText();
            }
        }
        return txt.length();
    
}
    public void winEffect(JButton b1,JButton b2,JButton b3)
    {
        String msg;
        
        b1.setBackground(Color.black);
        b2.setBackground(Color.black);
        b3.setBackground(Color.BLACK);
        
        b1.setForeground(Color.white);
        b2.setForeground(Color.white);
        b3.setForeground(Color.white);
        
        
        if(b1.getText().equals("X")){
        
        msg=b1.getText() + " Is the Winner";
        ctr++;
       // ctr=ctr+count;
        //count=ctr;
        l.setText(msg);
        X.setText("X's Stat: "+ctr);
        }
        else {
            msg=b1.getText() + " Is the Winner";
            count++;
            //ctr=ctr+count;
            //count=ctr;
            l.setText(msg);
           Y.setText("Y's Stat: "+count);
            
        }
        
        
        
        
    }
    boolean win=false;
    public void getTheWinner(){
        if(!b1.getText().equals("") && b1.getText().equals(b2.getText()) && b1.getText().equals(b3.getText()))
        {
            winEffect(b1,b2,b3);
            win=true;
        }
        else if(!b4.getText().equals("") && b4.getText().equals(b5.getText()) && b4.getText().equals(b6.getText())){
            winEffect(b4,b5,b6);
            win=true;
        }
        else if(!b7.getText().equals("") && b7.getText().equals(b8.getText()) && b7.getText().equals(b9.getText())){
            winEffect(b7,b8,b9);;
            win=true;
        }
        else if(!b1.getText().equals("") && b1.getText().equals(b4.getText()) && b1.getText().equals(b7.getText())){
            winEffect(b1,b4,b7);
            win=true;
        }
        else if(!b2.getText().equals("") && b2.getText().equals(b5.getText()) && b2.getText().equals(b8.getText())){
            winEffect(b2,b5,b8);
            win=true;
        }
        else if(!b3.getText().equals("") && b3.getText().equals(b6.getText()) && b3.getText().equals(b9.getText())){
            winEffect(b3,b6,b9);
            win=true;
            
        }
        else if(!b1.getText().equals("") && b1.getText().equals(b5.getText()) && b1.getText().equals(b9.getText())){
            winEffect(b1,b5,b9);
            win=true;
        }
        else if(!b3.getText().equals("") && b3.getText().equals(b5.getText()) && b3.getText().equals(b7.getText())){
            winEffect(b3,b5,b7);
            win=true;
        }
        else if(allMoves() == 9 && win==false) {
            l.setText("NO ONE WINS IT'S TIE");
        }
    }
    int x_or_O = 0;
    public  ActionListener createAction(JButton button) 
    {
        ActionListener al=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(button.getText().equals("")){
                if((x_or_O % 2) ==0)
                {
                    button.setText("X");
                    button.setForeground(Color.green);
                    l.setText("O turn Now");
                    getTheWinner();
                }
                else{
                    button.setText("O");
                    button.setForeground(Color.blue);
                    l.setText("X turn now");
                    getTheWinner();
                }
                x_or_O ++;
            }
            }
        };
        return al;
    }
    
    public void addAction(){
        Component[] comps=p2.getComponents();
        for(Component comp: comps)
        {
            if(comp instanceof JButton) {
                JButton button=(JButton)comp;
                button.addActionListener(createAction(button));
                button.setBackground(Color.white);
                button.setBorderPainted(true);
                button.setFont(new Font("tahoma",Font.BOLD,25));
            }
        }
    }
    
    public static void main(String[] args)
    {
        try{
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        new game();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==replay){
        win=false;
        Component[] comps=p2.getComponents();
        for(Component comp: comps)
        {
            if(comp instanceof JButton) {
                JButton button=(JButton)comp;
                button.addActionListener(createAction(button));
                button.setText("");
                button.setBackground(Color.white);
                button.setBorderPainted(true);
                button.setFont(new Font("tahoma",Font.BOLD,25));
                l.setBackground(Color.green);
                l.setText("PLAY");
               // X.setText("X's Stat: 0");
               // Y.setText("Y's Stat: 0");
                
            }
           if(ae.getSource()==clear)
        {
            X.setText("X's Stat: 0");
            Y.setText("Y's Stat: 0");
        }
        }
        }
    }

   
}

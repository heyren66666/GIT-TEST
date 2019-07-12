import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Calculator {
    public static void main(String[] args){
        CalFrame calFrame=new CalFrame();
        calFrame.show();
    }

}
class CalFrame implements ActionListener{

    private JFrame mainFrame;
    private JTextField text;
    private JButton[] buttons;
    private char modifier='\0';
    private double result;
    private boolean flag=false;
    public CalFrame(){
        mainFrame = new JFrame("计算器 v1.0");
        text=new JTextField();
        buttons=new JButton[16];
        init();
        setFontAndColor();
        addEventHandle();
    }
    private void init(){
        JPanel north=new JPanel();
        JPanel center=new JPanel();
        north.setLayout(new FlowLayout());
        center.setLayout(new GridLayout(4,4,2,2));
        text=new JTextField(25);
        north.add(text);
        String str="123+456-789*0.=/";
        for (int i=0;i<16;i++){
            JButton jb=new JButton(String.valueOf(str.charAt(i)));
            buttons[i]=jb;
            center.add(jb);
        }
        mainFrame.add(north,BorderLayout.NORTH);
        mainFrame.add(center,BorderLayout.CENTER);
    }
    public void show(){
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setFontAndColor(){
        Font f=new Font("黑体",Font.BOLD,20);
        text.setFont(f);
        for (int i=0;i<buttons.length;i++){
            buttons[i].setFont(f);
            buttons[i].setForeground(Color.RED);
        }
    }
    public void addEventHandle(){
        for (int i=0;i<buttons.length;i++){
            buttons[i].addActionListener(this);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String str=e.getActionCommand();
        if ("0123456789.".indexOf(str)!=-1){
            if (flag){
                text.setText("");
                flag=false;
            }
            text.setText(text.getText()+str);
        }else if ("+-*/".indexOf(str) !=-1){
            modifier = str.charAt(0);
            double num=Double.valueOf(text.getText());
            result = num;
            flag = true;
        }else if (str.charAt(0)=='='){
            if (modifier=='+'){
                double num=Double.valueOf(text.getText());
                result +=num;
            }
            if (modifier=='-'){
                double num=Double.valueOf(text.getText());
                result -=num;
            }
            if (modifier=='*'){
                double num=Double.valueOf(text.getText());
                result *=num;
            }
            if (modifier=='/'){
                double num=Double.valueOf(text.getText());
                result /=num;
            }
            text.setText(result+"");
            modifier='\0';
            result=0;
        }
    }
}

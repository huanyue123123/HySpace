import javax.swing.*;
import java.awt.*;

public class SwingTest {

    public static void main(String[] args) {
        jf8();
    }

    public static void jf1(){
        JFrame jf = new JFrame("java第一个GUI程序");
        jf.setBounds(300,100,1320,900);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jl = new JLabel("这是使用JFrame创建的窗口");
        JPanel jp=new JPanel();
        jp.setBackground(Color.white);
        jp.add(jl);
        jf.add(jp);
        jf.setVisible(true);
    }

    public static void jf2(){
        JFrame jf=new JFrame("Java第二个GUI程序");    //创建一个JFrame对象
        jf.setBounds(300, 100, 1000, 200);    //设置窗口大小和位置
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jp=new JPanel();    //创建一个JPanel对象
        JLabel jl=new JLabel("这是放在JPanel上的标签");    //创建一个标签
        jp.setBackground(Color.white);    //设置背景色
        jp.add(jl);    //将标签添加到面板
        jf.add(jp);    //将面板添加到窗口
        jf.setVisible(true);    //设置窗口可见
    }

    public static void jf3(){
        JFrame jf=new JFrame("Java第三个GUI程序");
        JButton jButtonTop = new JButton("上");
        JButton jButtonDown = new JButton("下");
        JButton jButtonLeft = new JButton("左");
        JButton jButtonRight = new JButton("右");
        JButton jButtonCenter = new JButton("中");
        jf.add(jButtonTop,BorderLayout.NORTH);
        jf.add(jButtonDown,BorderLayout.SOUTH);
        jf.add(jButtonLeft,BorderLayout.WEST);
        jf.add(jButtonRight,BorderLayout.EAST);
        jf.add(jButtonCenter,BorderLayout.CENTER);
        jf.setBounds(460,100,1000,900);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }

    public static void jf4(){
        JFrame jf = new JFrame("java第四个GUI程序");
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JPanel jp = new JPanel();
        jp.add(b1);
        jp.add(b2);
        jp.add(b3);
        jp.add(b4);
        jp.add(b5);
        jp.add(b6);
        jp.add(b7);
        jp.add(b8);
        jp.add(b9);
        jp.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
        jp.setBackground(Color.gray);

        jf.add(jp);
        jf.setBounds(300, 100, 300, 200);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void jf5(){
        JFrame frame=new JFrame("Java第五个程序");    //创建Frame窗口
        JPanel p1=new JPanel();    //面板1
        JPanel p2=new JPanel();    //面板2
        JPanel cards=new JPanel(new CardLayout());    //卡片式布局的面板
        p1.add(new JButton("登录按钮"));
        p1.add(new JButton("注册按钮"));
        p1.add(new JButton("找回密码按钮"));
        p2.setBounds(0,0,400,200);
        p2.add(new JTextField("用户名文本框",20));
        p2.add(new JTextField("密码文本框",20));
        p2.add(new JTextField("验证码文本框",20));
        cards.add(p1,"card1");    //向卡片式布局面板中添加面板1
        cards.add(p2,"card2");    //向卡片式布局面板中添加面板2
        CardLayout cl=(CardLayout)(cards.getLayout());
        cl.show(cards,"card1");    //调用show()方法显示面板2
        cl.show(cards,"card2");    //调用show()方法显示面板2
        frame.add(cards);
        frame.setBounds(300,200,1000,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void jf6(){
        JFrame frame=new JFrame("GridLayou布局计算器");
        JPanel panel=new JPanel();    //创建面板
        //指定面板的布局为GridLayout，4行4列，间隙为5
        panel.setLayout(new GridLayout(4,4,5,5));
        panel.add(new JButton("7"));    //添加按钮
        panel.add(new JButton("8"));
        panel.add(new JButton("9"));
        panel.add(new JButton("/"));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("*"));
        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("-"));
        panel.add(new JButton("0"));
        panel.add(new JButton("."));
        panel.add(new JButton("="));
        panel.add(new JButton("+"));
        frame.add(panel);    //添加面板到容器
        frame.setBounds(660,300,600,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void makeButton(String title,JFrame jFrame,GridBagLayout gridBagLayout,GridBagConstraints constraints){
        JButton button = new JButton(title);
        gridBagLayout.setConstraints(button,constraints);
        jFrame.add(button);
    }

    public static void jf7(){
        JFrame jFrame = new JFrame("拨号盘");
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        jFrame.setLayout(gridBagLayout);
        constraints.fill=GridBagConstraints.BOTH;
        constraints.weightx=0.0;    //恢复默认值
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        JTextField textField = new JTextField("12312345678");
        textField.setBounds(0,0,200,200);
        textField.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,30));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        gridBagLayout.setConstraints(textField,constraints);
        jFrame.add(textField);
        constraints.weightx=0.5;    // 指定组件的分配区域
        constraints.weighty=0.2;
        constraints.gridwidth = 1;
        makeButton("7",jFrame,gridBagLayout,constraints);
        makeButton("8",jFrame,gridBagLayout,constraints);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        makeButton("9",jFrame,gridBagLayout,constraints);
        constraints.gridwidth = 1;
        makeButton("4",jFrame,gridBagLayout,constraints);
        makeButton("5",jFrame,gridBagLayout,constraints);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        makeButton("6",jFrame,gridBagLayout,constraints);
        constraints.gridwidth = 1;
        makeButton("1",jFrame,gridBagLayout,constraints);
        makeButton("2",jFrame,gridBagLayout,constraints);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        makeButton("3",jFrame,gridBagLayout,constraints);
        constraints.gridwidth = 1;
        makeButton("返回",jFrame,gridBagLayout,constraints);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        makeButton("拨号",jFrame,gridBagLayout,constraints);
        constraints.gridwidth = 1;
        jFrame.setBounds(660,350,600,400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public static void jf8(){
        JFrame frame=new JFrame("Java示例程序");
        //左侧
        Box b1 = Box.createVerticalBox();
       // b1.setMaximumSize(new Dimension(200,400));
       // b1.setMinimumSize(new Dimension(200,400));
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(5,1,0,0));
        for(int i = 0;i < 5;i++){
            JButton button = new JButton(i+"");
            button.setPreferredSize(new Dimension(200,80));
            p1.add(button);
        }
        b1.add(p1);

        Box right = Box.createVerticalBox();
        //右上
        Box rt = Box.createHorizontalBox();
        rt.setMaximumSize(new Dimension(360,80));
        JTextField jTextField = new JTextField("HelloWorld");
        jTextField.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,40));
        rt.add(jTextField);
        right.add(rt);
        Box rb = Box.createHorizontalBox();
        Panel bluePanel = new Panel();
        bluePanel.setBackground(Color.cyan);
        rb.add(bluePanel);
        right.add(rb);
        Box all = Box.createHorizontalBox();
        all.add(b1);
        all.add(right);
        frame.add(all);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(460,100,1000,400);
        frame.setVisible(true);

    }


}

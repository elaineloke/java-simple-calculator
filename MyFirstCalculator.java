import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

import static java.lang.Integer.parseInt;

public class MyFirstCalculator extends JFrame
{
    public static void main(String[] args) {
        new MyFirstCalculator();
    }

    private JTextField tfNumber1, tfNumber2;
    private JLabel lbResult;
    private int num1; int num2;

    /**
     * Constructor for objects of class MyFirstCalculator
     */
    public MyFirstCalculator()
    {
        super("A simple calculator");

        makeFrame();
    }

    private void makeFrame()
    {
        setSize(300,200);

        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        JLabel lbNumber1 = new JLabel("First number");
        tfNumber1 = new JTextField(20);

        JLabel lbNumber2 = new JLabel("Second number");
        tfNumber2 = new JTextField(20);

        JButton btnAdd = new JButton("Add");
        JButton btnDivide = new JButton("Divide");
        lbResult = new JLabel("Result?");

        // v1: using a class
//        btnAdd.addActionListener(new MyActionListener());

        // v2: using anonymous class
//        btnAdd.addActionListener(new ActionListener() {
//                                     @Override
//                                     public void actionPerformed(ActionEvent e) {
//                                           doAddition();
//                                     }
//                                 });

         //v3: using lambda
        btnAdd.addActionListener( e -> doAddition() );
        btnDivide.addActionListener(e -> doDivision());


        container.add(lbNumber1);
        container.add(tfNumber1);
        container.add(lbNumber2);
        container.add(tfNumber2);
        container.add(btnAdd);
        container.add(btnDivide);
        container.add(lbResult);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void doAddition()
    {
        try {
            getInputs();
            int result = num1 + num2;
            lbResult.setText("" + result);

        } catch (NumberFormatException ne) {
            lbResult.setText("Error: " + ne.getMessage());
            }
        }

        private void doDivision(){
        try {
            getInputs();
            int result = num1 / num2;
            lbResult.setText("" + result);
        } catch (ArithmeticException ae){
            lbResult.setText("Error: " + ae.getMessage());
            }
        }


      private void getInputs() throws ArithmeticException {
          num1 = Integer.parseInt(tfNumber1.getText());
          num2 = Integer.parseInt(tfNumber2.getText());
      }
    }

//    private class MyActionListener implements ActionListener
//    {
//
//        /**
//         * Invoked when an action occurs.
//         *
//         * @param e the event to be processed
//         */
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            doAddition();
//        }
//    }

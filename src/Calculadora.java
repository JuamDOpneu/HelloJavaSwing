import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    private JTextField txtResultado;
    private JButton btn7;
    private JButton btnMultiplicar;
    private JButton btndDividir;
    private JButton btn8;
    private JButton btn4;
    private JButton btn5;
    private JButton btnLimpar;
    private JButton btn9;
    private JButton btn6;
    private JButton btnsoma;
    private JButton btnResultado;
    private JButton btn0;
    private JButton btn3;
    private JButton btn2;
    private JButton btn1;
    private JButton btnSubtrair;
    private JPanel painelCalculadora;

    private double num1, num2, resultado;
    private String operador;


    //.settext pega o numero do botão clicado e mostra no resultado

    public Calculadora() {

        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultado.setText(txtResultado.getText() + "0");
            }
        });
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultado.setText(txtResultado.getText() + "1");
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultado.setText(txtResultado.getText() + "2");
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultado.setText(txtResultado.getText() + "3");
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultado.setText(txtResultado.getText() + "4");
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultado.setText(txtResultado.getText() + "5");
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultado.setText(txtResultado.getText() + "6");
            }
        });

        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultado.setText(txtResultado.getText() + "7");
            }
        });

        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultado.setText(txtResultado.getText() + "8");
            }
        });

        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultado.setText(txtResultado.getText() + "9");
            }
        });


        btnsoma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(txtResultado.getText());
                operador = "+";
                txtResultado.setText("");
            }
        });
        btnSubtrair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(txtResultado.getText());
                operador = "-";
                txtResultado.setText("");
            }
        });

        btnMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(txtResultado.getText());
                operador = "*";
                txtResultado.setText("");
            }
        });
        btndDividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(txtResultado.getText());
                operador = "/";
                txtResultado.setText("");
            }
        });

        btnResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num2 = Double.parseDouble(txtResultado.getText());
                switch (operador) {
                    case "+":
                        resultado = num1 + num2;
                        break;
                    case "-":
                        resultado = num1 - num2;
                        break;
                    case "*":
                        resultado = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            resultado = num1 / num2;
                        } else {
                            txtResultado.setText("ERRO");
                            return;
                        }
                        break;
                }
                txtResultado.setText(String.valueOf(resultado));
            }
        });

        //  num1 = num2 = resultado = 0; zera as variavel da direita pra esquerda
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultado.setText("");
                num1 = num2 = resultado = 0;
                operador = "";
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Minha Calculadora");
        frame.setContentPane(new Calculadora().painelCalculadora);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }
}
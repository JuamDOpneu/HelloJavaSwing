import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraIMC {
    private JPanel CalculadoradeIMC;
    private JTextField txtPeso;
    private JTextField txtAltura;
    private JButton btnCalcular;
    private JLabel lblPeso;
    private JLabel lblAltura;
    private JLabel lblResultadoIMC;
    private JButton btnLimpar;
    private JLabel lblStatus;

    private double peso = 0.0;
    private double altura = 0.0;
    private double imc = 0.0;
    private String categoria = "";

    public CalculadoraIMC() {
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtPeso.getText().trim().isEmpty() || txtAltura.getText().trim().isEmpty()) {
                    lblStatus.setText("Por favor, preencha todos os campos.");
                    lblResultadoIMC.setText("");
                    return;
                }
                try {
                    peso = Double.parseDouble(txtPeso.getText().replace(",", "."));
                    altura = Double.parseDouble(txtAltura.getText().replace(",", "."));

                    if (peso <= 0.0 || altura <= 0.0) {
                        lblStatus.setText("Erro! Os campos precisam ter números maiores que zero!");
                        lblResultadoIMC.setText("");
                        return;
                    }

                    imc = peso / (altura * altura);

                    if (imc < 18.5) {
                        categoria = "Baixo peso";
                    } else if (imc >= 18.5 && imc < 24.99) {
                        categoria = "Normal";
                    } else if (imc >= 25 && imc < 29.99) {
                        categoria = "Sobrepeso";
                    } else {
                        categoria = "Obesidade";
                    }
                    lblStatus.setText("");
                    lblResultadoIMC.setText(String.valueOf("IMC: " + String.format("%.2f", imc) + "kg/m²" + " | Categoria: " + categoria));
                } catch (NumberFormatException ex) {
                    lblStatus.setText("Erro! Insira somente números nos campos.");
                    lblResultadoIMC.setText("");
                }
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                txtPeso.setText("");
                txtAltura.setText("");
                lblResultadoIMC.setText("");
                lblStatus.setText("");
                peso = 0.0;
                altura = 0.0;
                imc = 0.0;
            }
        });
    }

    public static void main (String[]args){
        JFrame frame = new JFrame("Calculadora_de_IMC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new CalculadoraIMC().CalculadoradeIMC);
        frame.pack();
        frame.setVisible(true);
    }

}
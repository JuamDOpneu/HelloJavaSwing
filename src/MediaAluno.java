import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediaAluno {
    private JTextArea txtAreaNotas;
    private JTextField txtNota;
    private JButton btnAdicionar;
    private JButton btnCalcularMedia;
    private JPanel AplicativodeNotas;
    private JTextArea txtAreaAvaliacao;
    private JButton btnLimpar;
    private JLabel lblAvaliacao;


    private Double notasSomadas = 0.0;
    private int i = 0;
    private Double media = 0.0;
    private Double notaRecebida = 0.0;
    public MediaAluno() {
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    notaRecebida = Double.valueOf(txtNota.getText());
                    if (notaRecebida >= 0) {
                        notasSomadas = notaRecebida + notasSomadas;
                        i++;
                        txtAreaNotas.append(i + "ª nota: " + notaRecebida + "\n");
                    } else {
                        txtAreaAvaliacao.setText("Erro");
                    }
                } catch (NumberFormatException ex) {
                    txtAreaAvaliacao.setText("Erro: Caractere inválido!");
                }
            }
        });
        btnCalcularMedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i > 0) {
                    media = notasSomadas / i;
                    if (media >= 7) {
                        txtAreaAvaliacao.setText("Aprovado\n" + "Média: " + media);
                    } else {
                        txtAreaAvaliacao.setText("Reprovado\n" + "Média: " + media);
                    }
                } else {
                    txtAreaAvaliacao.setText("Nenhuma nota adicionada.");
                }
            }
        });
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i = 0;
                media = 0.0;
                notasSomadas = 0.0;
                txtAreaAvaliacao.setText("");
                txtAreaNotas.setText("");
                txtNota.setText("");
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Notas_e_Media");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane((new MediaAluno()).AplicativodeNotas);
        frame.setVisible(true);
        frame.pack();
    }

}
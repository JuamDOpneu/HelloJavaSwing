import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AgendaDiaria {
    private JTextField txtCompromisso;
    private JSpinner spnData;
    private JTable tblResultado;
    private JButton btnRemover;
    private JButton btnAdicionar;
    private JPanel jpAgenda;
    private JLabel lblSelecioneData;
    private JLabel lblQualseuCompromisso;
    private JSpinner spnHora;

    private String Compromisso;
    private String data;
    private String hora;

    public AgendaDiaria() {

        // default é o modelo para criar e gerenciar as colunas
        // modelo.addColum  cria uma coluna para cada dado
        // .setModel(modelo) liga o modelo a tabela tblResultado

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Compromisso");
        modelo.addColumn("Data");
        modelo.addColumn("Hora");
        tblResultado.setModel(modelo);

        //Definir o modelo (data e hora)
        // defini o formato primeiro pra data e dps pra hora

        spnData.setModel(new SpinnerDateModel());
        JSpinner.DateEditor editorData = new JSpinner.DateEditor(spnData, "dd/MM/yyyy");
        spnData.setEditor(editorData);

        spnHora.setModel(new SpinnerDateModel());
        JSpinner.DateEditor editorTemporal = new JSpinner.DateEditor(spnHora, "HH:mm");
        spnHora.setEditor(editorTemporal);

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // JOptionPane.showMessageDialog Mostra uma mensagem de erro no meu da tela muito melhor que criar um label pra isso

                Compromisso = txtCompromisso.getText();
                if (Compromisso.equals("")) {
                    JOptionPane.showMessageDialog(null, "Adicione um compromisso.");
                } else {

                    // pega a data e hora

                    String data = new SimpleDateFormat("dd/MM/yyyy").format(spnData.getValue());
                    String hora = new SimpleDateFormat("HH:mm").format(spnHora.getValue());

                    // Adiciona os dados pegados a tabela
                    modelo.addRow(new Object[]{Compromisso, data, hora});

                    // Limpando o campo de texto
                    txtCompromisso.setText("");
                }
            }
        });

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tblResultado.getSelectedRow();

                if (linhaSelecionada != -1) {
                    modelo.removeRow(linhaSelecionada);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um compromisso para remover.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Agenda Diária");
        frame.setContentPane(new AgendaDiaria().jpAgenda);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class AgendaDiaria {
    private JPanel Agenda_Diaria;
    private JSpinner spnData;
    private JTextField txtCompromisso;
    private JLabel lblComp;
    private JLabel lblHorario;
    private JTable tblCompromissos;
    private JButton btnAdicionar;
    private JButton btnRemover;
    private JSpinner spnHorario;
    private JLabel lblStatus;
    private JLabel lblDta;
    private JLabel lblDesc;
    private JLabel lblCompromissos;
    private JLabel lblHra;
    private JLabel lblData;

    private DefaultTableModel modeloDaTabela;

    private String compromisso = "";
    private String dataCompromisso = "";
    private String horarioCompromisso = "";

    private int linhaSelecionada = 0;

    public AgendaDiaria() {// Certifique-se de que os componentes personalizados são inicializados

        modeloDaTabela = new DefaultTableModel(new Object[]{"Data", "Horário", "Compromisso"}, 0);
        tblCompromissos.setModel(modeloDaTabela);

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compromisso = txtCompromisso.getText();
                dataCompromisso = new SimpleDateFormat("dd/MM/yyyy").format(spnData.getValue());
                horarioCompromisso = new SimpleDateFormat("HH:mm").format(spnHorario.getValue());

                if (!compromisso.equals("")) {
                    modeloDaTabela.addRow(new Object[]{dataCompromisso, horarioCompromisso, compromisso});
                    txtCompromisso.setText("");
                    lblStatus.setText("Compromisso adicionado!");
                } else {
                    lblStatus.setText("Preencha o campo compromisso!");
                }
            }
        });

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                linhaSelecionada = tblCompromissos.getSelectedRow();
                if (linhaSelecionada != -1) {
                    modeloDaTabela.removeRow(linhaSelecionada);
                    lblStatus.setText("Compromisso removido!");
                } else {
                    lblStatus.setText("Selecione um compromisso para remover!");
                }
            }
        });
    }

    // Adicionando o método createUIComponents()
    private void createUIComponents() {
        // Initialize custom components here
        spnData = new JSpinner(new SpinnerDateModel());
        spnData.setEditor(new JSpinner.DateEditor(spnData, "dd/MM/yyyy"));

        spnHorario = new JSpinner(new SpinnerDateModel());
        spnHorario.setEditor(new JSpinner.DateEditor(spnHorario, "HH:mm"));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Agenda Diaria");
        frame.setContentPane(new AgendaDiaria().Agenda_Diaria);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
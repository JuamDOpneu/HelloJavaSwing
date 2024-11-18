import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


//a parte do swing nao quis funcionar ent utilizei uma forma mais arcaica
//o link da onde eu peguei o exemplo
//https://youtu.be/rKGupS2tFIA
//utilizei um pouco de IA para deixar os botoes bunitinhos

// USA EM TELA CHEIA!!!!!!


public class AgendaDiaria extends JFrame {
    private JTextField compromissoField;
    private JSpinner dataHoraSpinner;
    private JTable tabelaCompromissos;
    private DefaultTableModel modeloTabela;

    public AgendaDiaria() {
        setTitle("Agenda Diária");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        compromissoField = new JTextField(20);
        dataHoraSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(dataHoraSpinner, "dd/MM/yyyy HH:mm");
        dataHoraSpinner.setEditor(timeEditor);

        JButton adicionarButton = new JButton("Adicionar Compromisso");
        JButton removerButton = new JButton("Remover Compromisso");

        String[] colunas = {"Data/Hora", "Descrição"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaCompromissos = new JTable(modeloTabela);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Compromisso:"));
        panel.add(compromissoField);
        panel.add(new JLabel("Data e Hora:"));
        panel.add(dataHoraSpinner);
        panel.add(adicionarButton);
        panel.add(removerButton);

        add(panel, "North");
        add(new JScrollPane(tabelaCompromissos), "Center");

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String compromisso = compromissoField.getText();
                if (!compromisso.isEmpty()) {
                    Date dataHora = (Date) dataHoraSpinner.getValue();
                    modeloTabela.addRow(new Object[]{dataHora, compromisso});
                    compromissoField.setText("");
                } else {
                    JOptionPane.showMessageDialog(AgendaDiaria.this, "O campo de compromisso não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabelaCompromissos.getSelectedRow();
                if (linhaSelecionada >= 0) {
                    modeloTabela.removeRow(linhaSelecionada);
                } else {
                    JOptionPane.showMessageDialog(AgendaDiaria.this, "Nenhum compromisso selecionado.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AgendaDiaria().setVisible(true);
            }
        });
    }
}
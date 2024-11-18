
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AgendadeContatos {
    private JPanel CadastrodeContatos;
    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JButton btnAdicionarContato;
    private JList<String> listContatos;
    private JLabel lblnome;
    private JLabel lblemail;
    private JLabel lblTelefone;
    private JLabel lblListaContatos;
    private JLabel lblStatus;
    private JButton btnDeletarContato;
    private JTextArea txtAreaStatus;

    //Variável contadora
    private int i = 0;
    //Variável para armazenar a String dentro de txtNome
    private String nome = "";
    //Variável para armazenar a String dentro de txtEmail
    private String email = "";
    //Variável para armazenar a String dentro de txtTelefone
    private String telefone = "";

    //Variável para armazenar as Strings "nome", "email" e "telefone"
    private String contato = "";

    //Variável que armazena o número de qual elemento da lista está selecionado
    private int indexSelecionado = 0;


    //Cria uma instância da "DefaultListModel", com o nome "modeloContatos", que será utilizada como o modelo de dados para a JList
    //Ela é o modelo padrão de lista, como o próprio nome já diz
    //Aparentemente ela é melhor de manipular dados que são exibidos na JList. Ela consegue exibir, remover ou editar os dados de forma dinâmica.
    DefaultListModel<String> modeloContatos = new DefaultListModel<>();

    public AgendadeContatos() {
        //Setando o modelo que será utilizado na "listContatos" como sendo o "modeloContatos", ou seja, a DefaultListModel
        listContatos.setModel(modeloContatos);

        btnAdicionarContato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Pegando que foi escrito em cada campo e colocando em sua rescectica variável
                nome = txtNome.getText();
                telefone = txtTelefone.getText();
                email = txtEmail.getText();

                //Verificação dos dados adquiridos e exibição de erros
                //
                //Verificações:
                //Se há um campo vazio
                //Se o campo "Telefone" tem 11 caracteres
                //Se o campo "Telefone" tem somente números
                //Se o campo "Email" possui uma das strings (domínios) declaradas na verificalção
                if (nome.isEmpty() || email.isEmpty() || telefone.isEmpty()) {
                    txtAreaStatus.setText("Preencha todos os campos!");
                } else if (!nome.matches("[a-zA-Z]+")){
                    txtAreaStatus.setText("O nome só pode conter letras!");
                } else if (!telefone.matches("[0-9]+")) {
                    txtAreaStatus.setText("O telefone deve conter apenas números!");
                } else if (telefone.length() < 11 || telefone.length() > 12) {
                    txtAreaStatus.setText("O número de telefone deve ter 11 números!" + "\nExemplo: " + "\n46987539732");
                } else if (!(email.contains("@gmail.com") || email.contains("@hotmail.com") || email.contains("@outlook.com") || email.contains("@yahoo.com"))) {
                    txtAreaStatus.setText("Email inválido.");
                } else {
                    //Adiciona +1 à variável contadora
                    i++;

                    //Coloca as Strings "nome", "email" e "telefone na String "contato"
                    contato = ("Contato " + i + " | Nome: " + nome + " | Telefone: " + telefone + " | Email: " + email);

                    //Adiciona a String "contato" na ListModel "modeloContatos"
                    modeloContatos.addElement(contato);

                    //Limpa os campos de cadastro
                    txtNome.setText("");
                    txtTelefone.setText("");
                    txtEmail.setText("");

                    //Escreve a mensagem de sucesso no "txtAreaStatus"
                    txtAreaStatus.setText("Cadastrado com sucesso!");
                }
            }
        });
        btnDeletarContato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Define que o valor da variável int "indexSelecionado" será aquele do qual o campo na JList "listContatos" estiver selecionado
                //Resumindo, se o campo 0 estiver selecionado, esse será o valor do indexSelecionado
                indexSelecionado = listContatos.getSelectedIndex();


                if (indexSelecionado != -1) {
                    modeloContatos.removeElementAt(indexSelecionado);

                    txtAreaStatus.setText("Contato removido com sucesso!");
                } else {
                    txtAreaStatus.setText("Selecione um contato para deletar.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Contatos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new AgendadeContatos().CadastrodeContatos);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}

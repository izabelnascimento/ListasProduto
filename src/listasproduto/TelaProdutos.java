package listasproduto;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TelaProdutos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel lbDescricao;
    private JLabel lbPreco;
    private JTextField tfDescricao;
    private JTextField tfPreco;
    private JButton btCadastrar;
    private JButton btRemover;
    private JScrollPane barraRolagem;
    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();
    private JLabel lbConsultas;
    private JLabel lbConsultaExcluirCodigo;
    private JTextField tfConsultaExcluirCodigo;
    private JButton btConsultaCodigo;
    private JButton btExcluirCodigo;
    private JLabel lbConsultaDescricao;
    private JTextField tfConsultaDescricao;
    private JButton btConsultaDescricao;

    public TelaProdutos() {
	this.setTitle("Tela Produtos");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setResizable(false);
	this.setSize(650, 600);
	this.setLocationRelativeTo(null);
	this.setLayout(null);

	this.lbDescricao = new JLabel("Nome");
	this.lbDescricao.setBounds(20, 20, 150, 20);
	this.lbPreco = new JLabel("Preço");
	this.lbPreco.setBounds(400, 20, 150, 20);
	this.tfDescricao = new JTextField("");
	this.tfDescricao.setBounds(20, 50, 350, 25);
	this.tfPreco = new JTextField();
	this.tfPreco.setBounds(400, 50, 200, 25);
	this.btCadastrar = new JButton("Cadastrar");
	this.btCadastrar.setBounds(20, 85, 200, 25);
	this.btRemover = new JButton("Remover Selecionado");
	this.btRemover.setBounds(250, 85, 200, 25);
	criarTabela();
	barraRolagem = new JScrollPane(tabela);
	barraRolagem.setBounds(20, 270, 580, 280);

	this.lbConsultas = new JLabel(":: Consultas ::");
	this.lbConsultas.setBounds(20, 120, 150, 20);

	this.lbConsultaExcluirCodigo = new JLabel("Consultar por Código:");
	this.lbConsultaExcluirCodigo.setBounds(20, 140, 150, 20);
	this.tfConsultaExcluirCodigo = new JTextField("");
	this.tfConsultaExcluirCodigo.setBounds(20, 165, 350, 25);
	this.btConsultaCodigo = new JButton("Consultar");
	this.btConsultaCodigo.setBounds(400, 165, 100, 25);
        this.btExcluirCodigo = new JButton("Excluir");
        this.btExcluirCodigo.setBounds(500, 165, 100, 25);

	this.lbConsultaDescricao = new JLabel("Consultar por Descrição:");
	this.lbConsultaDescricao.setBounds(20, 200, 150, 20);
	this.tfConsultaDescricao = new JTextField("");
	this.tfConsultaDescricao.setBounds(20, 225, 350, 25);
	this.btConsultaDescricao = new JButton("Consultar");
	this.btConsultaDescricao.setBounds(400, 225, 200, 25);

	this.add(lbDescricao);
	this.add(lbPreco);
	this.add(tfDescricao);
	this.add(tfPreco);
	this.add(btCadastrar);
	this.add(btRemover);
	this.add(barraRolagem);
	this.add(lbConsultas);
	this.add(lbConsultaExcluirCodigo);
	this.add(tfConsultaExcluirCodigo);
        this.add(btConsultaCodigo);
        this.add(btExcluirCodigo);
	this.add(lbConsultaDescricao);
	this.add(tfConsultaDescricao);
	this.add(btConsultaDescricao);

	setVisible(true);
    }

    public void limparCampos() {
	tfDescricao.setText("");
	tfPreco.setText("");
    }

    public void exibirAlerta(String mensagem) {
	JOptionPane.showMessageDialog(this, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    private void criarTabela() {
	tabela = new JTable(modelo);
	modelo.addColumn("Código");
	modelo.addColumn("Nome");
	modelo.addColumn("Preço");
	tabela.getColumnModel().getColumn(0).setPreferredWidth(140);
	tabela.getColumnModel().getColumn(1).setPreferredWidth(300);
	tabela.getColumnModel().getColumn(2).setPreferredWidth(140);
    }

    public void adicionarProdutoTabela(Produto produto) {
	modelo.addRow(new Object[] { produto.getCodigo(), produto.getDescricao(), produto.getPreco() });
    }

    public void atualizarTabela(ILista produtos) {
	modelo.setRowCount(0);
    	for (int i = 0; i < produtos.getQuantidadeProdutos(); i++) {
            modelo.addRow(new Object[] { produtos.get(i).getCodigo(), produtos.get(i).getDescricao(),
            produtos.get(i).getPreco() });
	}
    }

    public JLabel getLbDescricao() {
	return lbDescricao;
    }

    public void setLbDescricao(JLabel lbDescricao) {
	this.lbDescricao = lbDescricao;
    }

    public JLabel getLbPreco() {
	return lbPreco;
    }

    public void setLbPreco(JLabel lbPreco) {
	this.lbPreco = lbPreco;
    }

    public JTextField getTfDescricao() {
	return tfDescricao;
    }

    public void setTfDescricao(JTextField tfDescricao) {
	this.tfDescricao = tfDescricao;
    }

    public JTextField getTfPreco() {
	return tfPreco;
    }

    public void setTfPreco(JTextField tfPreco) {
	this.tfPreco = tfPreco;
    }

    public JButton getBtCadastrar() {
	return btCadastrar;
    }

    public void setBtCadastrar(JButton btCadastrar) {
	this.btCadastrar = btCadastrar;
    }

    public JButton getBtRemover() {
    	return btRemover;
    }

    public void setBtRemover(JButton btRemover) {
	this.btRemover = btRemover;
    }

    public JScrollPane getBarraRolagem() {
	return barraRolagem;
    }

    public void setBarraRolagem(JScrollPane barraRolagem) {
	this.barraRolagem = barraRolagem;
    }

    public JTable getTabela() {
    	return tabela;
    }

    public void setTabela(JTable tabela) {
	this.tabela = tabela;
    }

    public DefaultTableModel getModelo() {
	return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
	this.modelo = modelo;
    }

    public JLabel getLbConsultas() {
	return lbConsultas;
    }

    public void setLbConsultas(JLabel lbConsultas) {
	this.lbConsultas = lbConsultas;
    }

    public JLabel getLbConsultaExcluirCodigo() {
	return lbConsultaExcluirCodigo;
    }

    public void setLbConsultaExcluirCodigo(JLabel lbConsultaExcluirCodigo) {
	this.lbConsultaExcluirCodigo = lbConsultaExcluirCodigo;
    }

    public JTextField getTfConsultaExcluirCodigo() {
	return tfConsultaExcluirCodigo;
    }

    public void setTfConsultaExcluirCodigo(JTextField tfConsultaExcluirCodigo) {
	this.tfConsultaExcluirCodigo = tfConsultaExcluirCodigo;
    }

    public JButton getBtConsultaCodigo() {
	return btConsultaCodigo;
    }

    public void setBtConsultaCodigo(JButton btConsultaCodigo) {
	this.btConsultaCodigo = btConsultaCodigo;
    }

    public JButton getBtExcluirCodigo() {
        return btExcluirCodigo;
    }

    public void setBtExcluirCodigo(JButton btExcluirCodigo) {
        this.btExcluirCodigo = btExcluirCodigo;
    }

    public JLabel getLbConsultaDescricao() {
	return lbConsultaDescricao;
    }

    public void setLbConsultaDescricao(JLabel lbConsultaDescricao) {
	this.lbConsultaDescricao = lbConsultaDescricao;
    }

    public JTextField getTfConsultaDescricao() {
	return tfConsultaDescricao;
    }

    public void setTfConsultaDescricao(JTextField tfConsultaDescricao) {
	this.tfConsultaDescricao = tfConsultaDescricao;
    }

    public JButton getBtConsultaDescricao() {
	return btConsultaDescricao;
    }

    public void setBtConsultaDescricao(JButton btConsultaDescricao) {
	this.btConsultaDescricao = btConsultaDescricao;
    }

    public static long getSerialversionuid() {
	return serialVersionUID;
    }
}
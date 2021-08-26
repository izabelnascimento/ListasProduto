package listasproduto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class TelaProdutosControlador {
	
    private TelaProdutos telaProdutos;
    private int codigoProduto = 1;
    private ILista listaProdutos = new ListaProdutoDinamica();

	
    public TelaProdutosControlador(TelaProdutos tela) {
	this.telaProdutos = tela;
		
	this.telaProdutos.getBtCadastrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descricao = telaProdutos.getTfDescricao().getText();
                String precoString = telaProdutos.getTfPreco().getText();
		if(descricao.trim().equals("")) {
                    telaProdutos.exibirAlerta("Informe a descrição do produto.");
		}else{
                    float preco = 0;
                    try {
			preco = Float.parseFloat(precoString);
			Produto produto = new Produto();
			produto.setCodigo(codigoProduto);
			produto.setDescricao(descricao);
			produto.setPreco(preco);
			listaProdutos.adicionar(produto);
                        telaProdutos.atualizarTabela(listaProdutos);
			codigoProduto++;
			telaProdutos.limparCampos();
                    }catch(NumberFormatException err) {
			telaProdutos.exibirAlerta("Informe um preço válido.");
                    }
		}
            }
	});
	this.telaProdutos.getBtRemover().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		int linhaSelecionada = telaProdutos.getTabela().getSelectedRow();
		if(linhaSelecionada < 0) {
                    telaProdutos.exibirAlerta("Selecione um produto para ser removido.");
		}else {
                    Produto produto = listaProdutos.get(linhaSelecionada);
                    int confirm = JOptionPane.showConfirmDialog(null, "Você deseja remover o produto " + produto + "?");
                    if(confirm == 0) {
			listaProdutos.remover(produto.getCodigo());
			telaProdutos.atualizarTabela(listaProdutos);
                    }
		}
            }
	});
	this.telaProdutos.getBtConsultaCodigo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		String codigoString = telaProdutos.getTfConsultaExcluirCodigo().getText();
                try {
                    int codigo = Integer.parseInt(codigoString);
                    Produto produto = listaProdutos.getCodigo(codigo);
                    if(produto == null) {
			JOptionPane.showMessageDialog(null, "Produto não encontrado.");
                    }else{
			JOptionPane.showMessageDialog(null, produto);
                    }
		}catch(NumberFormatException err) {
                    telaProdutos.exibirAlerta("Código inválido");
		}
            }
	});
	this.telaProdutos.getBtConsultaDescricao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		String descricao = telaProdutos.getTfConsultaDescricao().getText();
                if(descricao.trim().equalsIgnoreCase("")){
                    telaProdutos.exibirAlerta("Informe uma descrição");
                }else{
                    try{
                    Produto produto = listaProdutos.get(descricao);
                        if(produto == null) {
                            JOptionPane.showMessageDialog(null, "Produto não encontrado.");
                        }else{
                            JOptionPane.showMessageDialog(null, produto);
                        }
                    }catch(NumberFormatException err){
                        telaProdutos.exibirAlerta("Descrição inválida");
                    }
                }
            }
	});
        this.telaProdutos.getBtExcluirCodigo().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String codigoString = telaProdutos.getTfConsultaExcluirCodigo().getText();
                try{
                    int codigo = Integer.parseInt(codigoString);
                    Produto produto = listaProdutos.getCodigo(codigo);
                    if(produto == null){
                        JOptionPane.showMessageDialog(null, "Produto não encontrado.");
                    }else{
                        int confirm = JOptionPane.showConfirmDialog(null, "Você deseja remover o produto " + produto + "?");
                        if(confirm == 0) {
                            listaProdutos.remover(produto.getCodigo());
                            telaProdutos.atualizarTabela(listaProdutos);
                        }
                    }
                }catch(NumberFormatException err){
                    telaProdutos.exibirAlerta("Código inválido");
                }
            }
        });
    }
}
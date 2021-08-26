package listasproduto;

public interface ILista {	
    
    public int getQuantidadeProdutos();
    public int getTamanho();
    public boolean isVazia();	
    public boolean isCheia();
    public boolean adicionar(Produto produto);
    public boolean remover(int codigoProduto);
    public Produto get(int i);
    public Produto get(String descricaoProduto);
    public Produto getCodigo(int codigo);
}
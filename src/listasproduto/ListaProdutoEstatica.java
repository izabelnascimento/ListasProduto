package listasproduto;

public class ListaProdutoEstatica implements ILista {
	
    private int tamanho;
    private int quantidadeProdutos = 0;
    private Produto dados[];
	
    public ListaProdutoEstatica(int tamanho) {
	this.tamanho = tamanho;
	dados = new Produto[tamanho];
    }
	
    @Override
    public int getQuantidadeProdutos() {
    	return quantidadeProdutos;
    }
	
    @Override
    public int getTamanho() {
	return tamanho;
    }
	
    @Override
    public boolean isVazia() {
    	return quantidadeProdutos == 0;
    }
	
    @Override
    public boolean isCheia() {
	return quantidadeProdutos == tamanho;
    }
	
    @Override
    public boolean adicionar(Produto produto) {
	if(isCheia()) {
            return false;
        }
        if(isVazia()){
            dados[quantidadeProdutos] = produto;
        }else{
            int x = 0, y;
            while(x < quantidadeProdutos && dados[x].getPreco() < produto.getPreco()){
                x++;
            }
            if(x == quantidadeProdutos){
                dados[quantidadeProdutos] = produto;
            }else{
                for(y = quantidadeProdutos-1; y > x; y--){
                    dados[y+1] = dados[y];
                }
                dados[x+1] = dados[x];
                dados[x] = produto;
            }
        }
        quantidadeProdutos++;
        return true;
    }
	
    @Override
    public boolean remover(int codigoProduto) {
	if(isVazia()) {
            return false;
	}
	int x = 0, y;
	while(x < quantidadeProdutos && dados[x].getCodigo() != codigoProduto) {
            x++;
	}
	if(x == quantidadeProdutos) {
            return false;
	}
	for(y = x; y < quantidadeProdutos - 1; y++) {
            dados[y] = dados[y + 1];
	}
	quantidadeProdutos--;
	return true;
    }
	
    @Override
    public Produto get(int i) {
        return dados[i];
    }

    @Override
    public Produto get(String descricaoProduto) {
        int x = 0;
        if(isVazia()){
            return null;
        }
        while(x<quantidadeProdutos){
            if(dados[x].getDescricao().equalsIgnoreCase(descricaoProduto)){
                break;
            }
            x++;
        }
        if(x == quantidadeProdutos){
            return null;
        }else{
            return dados[x];
        }
    }

    @Override
    public Produto getCodigo(int codigo) {
        if(isVazia()){
            return null;
        }
        int x = 0;
        while(x<quantidadeProdutos && dados[x].getCodigo()!=codigo){
            x++;
        }
        if(x == quantidadeProdutos){
            return null;
        }
	return dados[x];
    }    
}

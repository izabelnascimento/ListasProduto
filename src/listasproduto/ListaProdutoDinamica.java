package listasproduto;

    public class ListaProdutoDinamica implements ILista {
	
    private No primeiro = null;

    @Override
    public int getQuantidadeProdutos() {
	int quantidadeProdutos = 0;
	No aux = primeiro;
	while(aux != null) {
            quantidadeProdutos++;
            aux = aux.proximo;
	}
	return quantidadeProdutos;
    }

    @Override
    public int getTamanho() {
	return getQuantidadeProdutos();
    }

    @Override
    public boolean isVazia() {
	return primeiro == null;
    }

    @Override
    public boolean isCheia() {
	return false;
    }

    @Override
    public boolean adicionar(Produto produto) {
	No no = new No();
	no.produto = produto;
	no.proximo = null;
	if(isVazia()) {
            primeiro = no;
	}else {
            No aux = primeiro;
            No auxAnterior = null;
            int compareTo;
            while(aux.proximo != null) {
                compareTo = aux.produto.getDescricao().compareTo(produto.getDescricao());
                if(compareTo >= 0){
                    break;
                }
                auxAnterior = aux;
		aux = aux.proximo;
            }
            if(aux == primeiro){
                compareTo = aux.produto.getDescricao().compareTo(produto.getDescricao());
                if(compareTo >= 0){
                    primeiro = no;
                    no.proximo = aux;
                }else{
                    no.proximo = aux.proximo;
                    primeiro.proximo = no;
                }
                return true;
            }
            if(aux.proximo == null){
                compareTo = aux.produto.getDescricao().compareTo(produto.getDescricao());
                if(compareTo >= 0){
                    auxAnterior.proximo = no;
                    no.proximo = aux;
                }else{
                    aux.proximo = no;
                }
            }else{
                auxAnterior.proximo = no;
                no.proximo = aux;
            }
        }
	return true;
    }

    @Override
    public boolean remover(int codigoProduto) {
        No aux = primeiro;
	No auxAnterior = null;
	while(aux != null && aux.produto.getCodigo() != codigoProduto) {
            auxAnterior = aux;
            aux = aux.proximo;
	}
	if(aux == null) {
            return false;
	}
	if(aux == primeiro) {
            primeiro = aux.proximo;
        }else {			
            auxAnterior.proximo = aux.proximo;
	}
	return true;
    }

    @Override
    public Produto get(int i) {
	if(i < 0 || i >= getQuantidadeProdutos()) {
            return null;
	}
	No aux = primeiro;
	int indice = 0;
	while(aux != null && indice < i ) {
            aux = aux.proximo;
            indice++;
	}
	if(aux == null) {
            return null;
	}
	return aux.produto;
    }
	
    private class No {
	Produto produto;
	No proximo;
    }

    @Override
    public Produto get(String descricaoProduto) {
        if(isVazia()){
            return null;
        }
        No aux = primeiro;
        while(aux != null){
            if(aux.produto.getDescricao().equalsIgnoreCase(descricaoProduto)){
                break;
            }
            aux = aux.proximo;
        }
        if(aux == null){
            return null;
        }
	return aux.produto;
    }

    @Override
    public Produto getCodigo(int codigo) {
        if(isVazia()){
            return null;
        }
        No aux = primeiro;
	while(aux != null && aux.produto.getCodigo() != codigo) {
            aux = aux.proximo;
	}
        if(aux == null){
            return null;
        }
        return aux.produto;
    }
}

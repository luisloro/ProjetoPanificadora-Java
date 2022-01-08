package panificadora.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Grupo Pan
 */
public class CartaoVenda implements Serializable{
    
    private int CodCartao;
    private double Total;
    private Produto Produto;
    private ArrayList<Produto> listaProduto;
    private Funcionario funcionario;
    
    public CartaoVenda(){ //Método construtor para inicializar as variáveis
        
        this.CodCartao=0;
        this.Total=0;
        this.Produto = new Produto();
        this.funcionario = new Funcionario();
        
    }

    public int getCodCartao() {  //chamada para retornar a variavel CodCartao
        return CodCartao;
    }
    public void setCodCartao(int CodCartao) { //grava no CodCartao um código recebido pela chamada do método
        this.CodCartao = CodCartao;
    }

    public double getTotal() { //chamada para retornar a variavel Total
        return Total;
    }
    public void setTotal(double Total) { //grava no Total um valor recebido pela chamada do método
        this.Total = Total;
    }

    public ArrayList<Produto> getProduto() { //chamada para retornar a array do tipo Produto chamada ListaProduto
        return listaProduto;
    }
    public void setProdutos(ArrayList<Produto> produtos) { //grava no array do tipo Produto um Produto recebido pela chamada do método
        this.listaProduto = produtos;
    }
    
    public void setFuncionario(Funcionario funcionario) throws Exception{ //grava informação do funcionário através da chamada do método
        if((funcionario == null) && (funcionario.getCodigo() == 0))
            throw new Exception("Funcionario não informado!");
        this.funcionario = funcionario;
    }
    
    public Funcionario getFuncionario() { //Retorna a informação sobre o funcionario gravado neste cartão
        return funcionario;
    }
    
    public void CalculaVenda (Produto produto){ //Calcula o valor dos produtos adicionados ao cartão
        this.Total = getTotal() + produto.getValor();
    }
    
    public int excluirProduto (int codProd){ //Método para excluir um produto adicionado ao cartão
        
        if (this.listaProduto.isEmpty()){ //se a lista estiver vazia retorna zero para o view apresentar a mensagem de produto não encontrado
            return 0;
        }
        
        for (int i=0; i<this.listaProduto.size();i++){ //apaga o produto e retorna um para o view apresentar a mensagem de produto excluido
            
            if (this.listaProduto.get(i).getCodProd()==codProd){
                this.Total = getTotal() - this.listaProduto.get(i).getValor();
                this.listaProduto.remove(i);
                return 1;
            }
        }
        return 0; //se a lista não estiver vazia e não encontrar o produto retorna zero para o view apresentar a mensagem de produto não encontrado
    }
    
}

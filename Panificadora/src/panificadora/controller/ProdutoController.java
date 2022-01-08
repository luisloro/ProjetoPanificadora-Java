package panificadora.controller;

import java.util.ArrayList;
import panificadora.dao.ProdutoDAO;
import panificadora.dao.FornecedorDAO;
import panificadora.dao.FuncionarioDAO;
import panificadora.model.Fornecedor;
import panificadora.model.Funcionario;
import panificadora.model.Produto;
/**
 *
 * @author Grupo Pan
 */
public class ProdutoController {
    
    
    private Produto produto;
    private ProdutoDAO bd;
    private FornecedorDAO bdFor;
    private FuncionarioDAO bdFunc;
    private ArrayList<Produto> listaProduto;
    
    private Fornecedor fornecedor;
    private Funcionario funcionario;
    
    public ProdutoController(){ //construtor para inicializar as variaveis
        
        this.produto = new Produto();
        this.bd = new ProdutoDAO();
        this.bdFor = new FornecedorDAO();
        this.bdFunc = new FuncionarioDAO();
        
    }

    public Produto getProduto() { // retorna nformações contidas na variavel produto
        return this.produto;
    }

    public ArrayList<Produto> getListaProduto() { // retorna um array de produto ListaProduto recebido do banco de dados
        return this.listaProduto;
    }

    public Fornecedor getFornecedor() { // retorna a informação salva do fornecedor
        return this.fornecedor;
    }

    public Funcionario getFuncionario() { // retorna a informação salva do funcionario
        return this.funcionario;
    }
    
    //metodo para cadastrar o produto e salvar no banco de dados
    public void cadastrarProduto (String Descricao, double Valor, 
            String Tipo, int fornecedor, int funcionario)throws Exception{
        
        Produto prod = new Produto();
        
        prod.setCodProd(1);
        prod.setDescricao(Descricao);
        prod.setValor(Valor);
        prod.setTipo(Tipo);
        prod.setFornecedor(fornecedor);
        prod.setFuncionario(funcionario);
        
        this.bd.cadastrar(prod);
        
    }
    
    public void buscaNomes (int CodProd){ //salva nas variaveis os codigos de produto, fornecedor e funcionario
        this.produto=this.bd.recuperaProduto(CodProd);
        this.fornecedor=this.bdFor.recuperaCodigo(produto.getFornecedor().getCodigo());
        this.funcionario=this.bdFunc.recuperaCodigo(produto.getFuncionario().getCodigo());
    }
    
    //recebe as informações do view que precisam serem alteradas, pesquisa no banco qual o codigo e altera o produto do codigo a ser alterado
    public void alterarProduto (int CodProd, String Descricao, double Valor, 
            String Tipo, int fornecedor, int funcionario)throws Exception{
        
        Produto prod = new Produto();
        
        prod.setCodProd(CodProd);
        prod.setDescricao(Descricao);
        prod.setValor(Valor);
        prod.setTipo(Tipo);
        prod.setFornecedor(fornecedor);
        prod.setFuncionario(funcionario);
        
        this.bd.alterar(prod);
        
    }
    
    public void retornaFornecedor(int CodProd){ //salva no produto o que foi recuperado do banco de dados sobre fornecedor
        this.produto = this.bd.recuperaProduto(CodProd);
        this.produto.getFornecedor();
    }
    
    public int excluirProduto (int codigo){ //exclui um produto específico do banco de dados
        
        return this.bd.excluir(codigo);
        
    }
    
    public void buscaProduto (int CodProd){ //salva no produto com o código informado sobre o Produto a ser pesquisado no banco de dados
        
        this.produto = this.bd.recuperaProduto(CodProd);
        
    }
    
    public void todosProdutos (){ //vai buscar a tabela do banco de dados, adicionando produto por produto q esta em retorno na listaProduto
        
        ArrayList<Object> retorno = this.bd.retornaTudo();
        this.listaProduto = new ArrayList<Produto>();
        
        for (Object o : retorno){
            
            //transforma o "o" object em produto e adiciona em "p"
            Produto p = ((Produto)o);
            
            //adicionando "p" na listaProduto
            this.listaProduto.add(p);
            
        }
        
    }
    
}

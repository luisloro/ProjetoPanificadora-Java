package panificadora.controller;

import java.util.ArrayList;
import panificadora.dao.CartaoVendaDAO;
import panificadora.dao.ProdutoDAO;
import panificadora.model.CartaoVenda;
import panificadora.model.Produto;
import panificadora.model.Funcionario;
import panificadora.dao.BancoDadosGeral;
import panificadora.dao.FuncionarioDAO;
import panificadora.model.ItemVenda;

/**
 *
 * @author Grupo Pan
 */
public class CartaoVendaController {
    
    private CartaoVenda cartao;
    private ArrayList<CartaoVenda> listaCartao;
    private CartaoVendaDAO bd;
    private Produto produto;
    private ProdutoDAO bdp;
    private Funcionario funcionario;
    private FuncionarioDAO funcDAO;
    private static double total;
    private ArrayList<Produto> listaProdutos;
    
    
    public CartaoVendaController(){ //Método construtor para inicializar as variáveis
        this.cartao = new CartaoVenda();
        this.bd = new CartaoVendaDAO();
        this.produto = new Produto();
        this.bdp = new ProdutoDAO();
        this.funcDAO = new FuncionarioDAO();
        this.total = 0;
        this.listaProdutos = new ArrayList();
    }

    public CartaoVenda getCartao() { //retorna as informações do cartão
        return cartao;
    }

    public ArrayList<CartaoVenda> getListaCartao() { //retorna uma array do tipo cartao venda chamado lista cartão
        return listaCartao;
    }
    
    public int excluiProdCartao (int codCartao, int codProd){ //metodo para chamar excluir do banco de dados, para excluir um produto selecionado de um cartao específico do banco de dados geral
        
        int verifica=0;
        CartaoVenda car = new CartaoVenda();
        
        car=bd.recuperaCartao(codCartao);
        verifica=car.excluirProduto(codProd);
        
        //retorna o valor de verifica(int) para o view afim de emitir uma mensagem ao usuario
        return verifica;
        
    }
    
    public int excluirCartao (int codCartao){ //metodo chamar o excluir do banco de dados e exluir um cartao do banco de dados geral
        
        return this.bd.excluir(codCartao);
        
    }
    
    public void buscaCartao (int CodCartao){ //metodo q busca informação de um cartão do banco de dados
        
        this.cartao = this.bd.recuperaCartao(CodCartao);
        
    }
    
    public void buscaFuncionario(int CodFuncionario){ //busca funcionário do banco de dados do funcionário um funcionario especifico
        this.funcionario = this.funcDAO.recuperaCodigo(CodFuncionario );
    }
    
    public Funcionario getFuncionario(){ //retorna informação de um funcionario contido no cartao
        return this.funcionario;
    }
    
    public void buscaProdutoCodigo(int CodProduto){ //recupera informação de um produto no banco de dados do produto
        this.produto=this.bdp.recuperaProduto(CodProduto);
    }
    
    public Produto getProduto(){ //resupera informação de um produto do cartao
        return this.produto;
    }
    
    
    public void adicionarProdutoCartao() throws Exception{ //metodo para adicionar um produto no array de produto do cartao
        
        this.listaProdutos.add(produto);
        this.total=this.total+produto.getValor();
        
        //this.produto = null;
        
    }
    
    public void confirmaVenda() throws Exception{ //adiciona o cartao no banco de dados
        
        CartaoVenda cart = new CartaoVenda();
        cart.setTotal(total);
        cart.setFuncionario(this.funcionario);
        
        
        cart.setProdutos(this.listaProdutos);
        
        this.bd.cadastrar(cart);
        
        this.listaProdutos=null;
    }
    
    public void todosCartoes (){ //adiciona no array ListaCartao todos os cartoes contidos no banco de dados, para o view apresentar
        
        this.listaCartao = new ArrayList<CartaoVenda>();
        
        for (Object o : this.bd.retornaTudo()){
            
            CartaoVenda c = ((CartaoVenda)o);
            
            this.listaCartao.add(c);
        }
    }
    
    public void gerarListaProdutos(){ //adiciona no array ListaProdutos todos os produtos do cartao
        
        this.listaProdutos = new ArrayList<Produto>();
        
        for (Object o : this.cartao.getProduto()){
            
            Produto p = ((Produto)o);
            
            this.listaProdutos.add(p);
        }
    }
     
    public ArrayList<Produto> getListaProdutos() { //retorna a lista de produtos para o view
        return listaProdutos;
    }

}

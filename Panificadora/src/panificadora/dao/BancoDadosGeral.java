/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panificadora.dao;

import java.util.ArrayList;
import panificadora.model.Fornecedor;
import panificadora.model.Funcionario;
import panificadora.model.Produto;
import panificadora.model.CartaoVenda;

public class BancoDadosGeral {
    
    private static ArrayList<Fornecedor> tabelaFornecedor = null; //Cria um array do tipo Fornecedor(model) chamado tabela
    private static ArrayList<Funcionario> tabelaFuncionario = null; //Cria um array do tipo Funcionario(model) chamado tabela
    private static ArrayList<Produto> tabelaProduto = null; //Cria um array do tipo Produto(model) chamado tabela
    private static ArrayList<CartaoVenda> tabelaCartao = null; //Cria um array do tipo CartaoVenda(model) chamado tabela
    
   
    
    private static int proximoCodigoFornecedor = 1; //Cria uma variavel que grava o próximo codigo
    private static int proximoCodigoFuncionario = 1; //Cria uma variavel que grava o próximo codigo
    private static int proximoCodigoProduto = 1; //Cria uma variavel que grava o próximo codigo
    private static int proximoCodigoCartao = 1; //Cria uma variavel que grava o próximo codigo
    
    public static void carregaProximoCodigo(){
        int forn = 0;
        for(int i=0;i<BancoDadosGeral.getTabelaFornecedor().size();i++){ //percorre a Tabela Fornecedor até a ultima posição para pegar o ultimo código para a variavel proximoCodigo
            forn = getTabelaFornecedor().get(i).getCodigo();
        }
        
        
       int func = 0;
       for(int j=0; j<BancoDadosGeral.getTabelaFuncionario().size();j++){ //percorre a Tabela Funcionário até a ultima posição para pegar o ultimo código para a variavel proximoCodigo
           func = getTabelaFuncionario().get(j).getCodigo();
       }
       
       int prod = 0;
       for(int h=0; h<BancoDadosGeral.getTabelaProduto().size();h++){ //percorre a Tabela Produto até a ultima posição para pegar o ultimo código para a variavel proximoCodigo
           prod = getTabelaProduto().get(h).getCodProd();
       }
       
       int cart = 0;
       for(int k=0; k<BancoDadosGeral.getTabelaCartao().size();k++){ //percorre a Tabela Cartão até a ultima posição para pegar o ultimo código para a variavel proximoCodigo
           cart = getTabelaCartao().get(k).getCodCartao();
       }
       
       proximoCodigoFornecedor = forn+1; //recebe o valor do ultimo codigo e adiciona um
       proximoCodigoFuncionario = func+1; //recebe o valor do ultimo codigo e adiciona um
       proximoCodigoProduto = prod+1; //recebe o valor do ultimo codigo e adiciona um
       proximoCodigoCartao  = cart+1; //recebe o valor do ultimo codigo e adiciona um
       
    }
    
    public static int getProximocodigoFornecedor(){ //Retorna o Código do fornecedor
        return proximoCodigoFornecedor;
    }
    
    public static void atualizaProximoCodigoFornecedor(){ //Atualiza o Código do Fornecedor para o próximo cadastro
        proximoCodigoFornecedor = proximoCodigoFornecedor + 1;
    }
    
    public static int getProximocodigoFuncionario(){ //Retorna o Código do Funcionário
        return proximoCodigoFuncionario;
    }
    
     public static void atualizaProximoCodigoFuncionario(){ //Atualiza o Código do Funcionario para o próximo cadastro
        proximoCodigoFuncionario = proximoCodigoFuncionario + 1;
    }
    
    public static int getProximocodigoProduto(){ //Retorna o Código do Produto
        return proximoCodigoProduto;
    }
    
    public static void atualizaProximoCodigoProduto(){ //Atualiza o Código do Produto para o próximo cadastro
        proximoCodigoProduto = proximoCodigoProduto + 1;
    }
    
    public static int getProximocodigoCartao(){ //Retorna o Código do Cartão
        return proximoCodigoCartao;
    }
    public static void atualizaProximoCodigoCartao(){ //Atualiza o Código do Cartão para o próximo cadastro
        proximoCodigoCartao = proximoCodigoCartao + 1;
    }
    
    
    public static ArrayList<Fornecedor> getTabelaFornecedor() { //Retorna a tabela Forncedor inteira
        
        if ( tabelaFornecedor == null)
            tabelaFornecedor = new ArrayList<Fornecedor>();
        
        return tabelaFornecedor;
    }
    
    public static ArrayList<Funcionario> getTabelaFuncionario() { //Retorna a tabela Funcionário inteira
        
        if ( tabelaFuncionario == null)
            tabelaFuncionario = new ArrayList<Funcionario>();
        
        return tabelaFuncionario;
    }
    public static ArrayList<Produto> getTabelaProduto() { //Retorna a tabela Produto inteira
        
        if ( tabelaProduto == null)
            tabelaProduto = new ArrayList<Produto>();
        
        return tabelaProduto;
    }
    
    public static ArrayList<CartaoVenda> getTabelaCartao() { //Retorna a tabela Cartão inteira
        
        if ( tabelaCartao == null)
            tabelaCartao = new ArrayList<CartaoVenda>();
        
        return tabelaCartao;
    }
    
    
    public static void setTabelaFornecedor(ArrayList<Fornecedor> tabfor){ //Grava na tabela Fornecedor informação vindas do FornecedorDAO
        tabelaFornecedor = tabfor;
    }
    
    public static void setTabelaFuncionario(ArrayList<Funcionario> tabfun){ //Grava na tabela Funcionário informação vindas do FornecedorDAO
        tabelaFuncionario = tabfun;
    }
    
    public static void setTabelaProduto(ArrayList<Produto> tabprod){ //Grava na tabela Produto informação vindas do FornecedorDAO
        tabelaProduto = tabprod;
    }
    
    public static void setTabelaCartao(ArrayList<CartaoVenda> tabcartao){ //Grava na tabela Cartão informação vindas do FornecedorDAO
        tabelaCartao = tabcartao;
    }
    
}

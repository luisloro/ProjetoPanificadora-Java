package panificadora;

import java.io.IOException;
import java.util.Scanner;
import panificadora.view.CartaoVendaView;
import panificadora.view.FornecedorView;
import panificadora.view.FuncionarioView;
import panificadora.view.ProdutoView;
import java.util.ArrayList;
import panificadora.dao.BancoDadosGeral;
import panificadora.model.CartaoVenda;
import panificadora.model.Fornecedor;
import panificadora.model.Funcionario;
import panificadora.model.Produto;
import panificadora.uteis.ManipulaBD;


/**
 *
 * @author NoteC
 */
public class Panificadora {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        recuperaTabelas(); //chama o metodo pra recuperar as informações salvas em dat e gravando na tabela do banco geral
        BancoDadosGeral.carregaProximoCodigo(); //carrega as informações dos proximos códigos de todos os models(menos pessoa q é herdado pr outras classes)
        Scanner s = new Scanner(System.in); //Objeto do tipo scanner para receber informações digitados pelo usuario e gravar em uma variavel do programa
        int op; //variavel do tipo inteira para o menu
        
        do{ //laço de repetição do menu que força pelo menos uma passagem pelo menu antes de fechar caso digitado zero de primeira
            
            System.out.println("|----------------------------------------------|");
            System.out.println("|          PANIFICADORA FARINHA D'BOA          |");
            System.out.println("|----------------------------------------------|");
            System.out.println("|                                              |");
            System.out.println("| 0 - Sair                                     |");
            System.out.println("| 1 - Menu Cartão                              |");
            System.out.println("| 2 - Menu Fonecedor                           |");
            System.out.println("| 3 - Menu Funcionario                         |");
            System.out.println("| 4 - Menu Produto                             |");
            System.out.println("|                                              |");
            System.out.println("|----------------------------------------------|");
            System.out.println(" Selection sua opção:");           

            op = Integer.parseInt(s.nextLine()); //gravando o que foi digitado na variavel
            
            //estrutura de desição para selecionar a opção desejada pelo usuario
            switch(op){
                case 0:{ //opção para encerrar o programa
                    System.out.println("Deseja realmente sair? 0 - Sim | 1 - Não");
                    op = Integer.parseInt( s.nextLine() );
                    
                    if ( op == 0){
                        //salvar as tabelas em arquivos no disco (tipo dat), antes de fechar o programa
                        salvarTabelas();
                    }
                    break;
                }
                case 1:{ //cria o objeto cartaovendaView e instancia ele chamando o seu metodo construtor
                    CartaoVendaView cav = new CartaoVendaView();
                    break;
                }
                case 2:{ //cria o objeto fornecedorView e instancia ele chamando o seu metodo construtor
                    FornecedorView fov = new FornecedorView();
                    break;
                }
                case 3:{ //cria o objeto funcionarioView e instancia ele chamando o seu metodo construtor
                    FuncionarioView fuv = new FuncionarioView();
                    break;
                }
                case 4:{ //cria o objeto produtoView e instancia ele chamando o seu metodo construtor
                    ProdutoView prv = new ProdutoView();
                    break;
                }
            }
            
        }while ( op != 0); //caso a opção foi zero encerra o programa saindo do laço de repetição
    }
    
    private static void salvarTabelas(){
        
        
        // converter ArrayList<Fornecedor> em um ArrayList<Object> (generico)
        ArrayList<Object> tabelaFornecedor = new ArrayList();
        for (Object fornecedor : BancoDadosGeral.getTabelaFornecedor()) {
            tabelaFornecedor.add(fornecedor);
        }
        
        //Convertendo ArrayList<Funcionario> em um ArrayList<Object> (generico)
        ArrayList<Object> tabelaFuncionario = new ArrayList();
        for (Object objFunc : BancoDadosGeral.getTabelaFuncionario()) {
            tabelaFuncionario.add(objFunc);
        }
        
        //Converter Tabela ArrayList<Produtos> em uma tabelaFor ArrayList<Objet> (generico)
        ArrayList<Object> tabelaProduto = new ArrayList();
        for ( Object objProd : BancoDadosGeral.getTabelaProduto()){
            tabelaProduto.add(objProd);
        }
        
        //Converter Tabela ArrayList<CartaoVenda> em uma tabelaFor ArrayList<Objet> (generico)
         ArrayList<Object> tabelaCartao = new ArrayList();
        for (Object cartao : BancoDadosGeral.getTabelaCartao()) {
            tabelaCartao.add(cartao);
        }
        
        try {
            
            // salvando o objeto tabelaFornecedor com os dados do fornecedor dentro do arquivo fornecedor.dat no diretorio data
            ManipulaBD.gravaTabelasEmArquivos(tabelaFornecedor, "data\\fornecedor.dat");
            
            // salvando o objeto tabelaFuncionario com os dados do Funcionario dentro do arquivo funcionario.dat no diretorio data
            ManipulaBD.gravaTabelasEmArquivos(tabelaFuncionario, "data\\funcionario.dat");
            
            // salvando o objeto tabelaProduto com os dados do Produto dentro do arquivo produto.dat no diretorio data
            ManipulaBD.gravaTabelasEmArquivos(tabelaProduto, "data\\produto.dat");
            
            // salvando o objeto tabelaCartao com os dados do Produto dentro do arquivo cartao.dat no diretorio data
            ManipulaBD.gravaTabelasEmArquivos(tabelaCartao, "data\\cartao.dat");
            
        //caso de erro a variavel ex recebera o erro no qual depois o ex sera mostrado em tela, ou seja a informação do erro   
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("ERRO: " + ex.getMessage());
        }
        
    }
    
    
    
    private static void recuperaTabelas(){
        
        System.out.println("  |------------------------------------------|");
        System.out.println("  |                                          |");        
        System.out.println("  |      CONECTANDO AO BANCO DE DADOS...     |");
        System.out.println("  |                                          |");
        System.out.println("  |------------------------------------------|");
        
        try{
            
            // recuperando a tabela fornecedor armazenada em arquivo no disco----------------------------------------------
            ArrayList tabelaFor = ManipulaBD.recuperaTabelaEmArquivo("data\\fornecedor.dat");
            
            if ( tabelaFor != null ){
                
                // converter a tabela recuperada (ArrayList<Object>) em um ArrayList<Fornecedor>
                ArrayList<Fornecedor> tabFornecedor = new ArrayList();
                for (Object obj : tabelaFor) {                    
                    Fornecedor f = (Fornecedor)obj;                    
                    tabFornecedor.add(f);
                }

                //Definir a tabela fornecedor no meu banco de dados
                BancoDadosGeral.setTabelaFornecedor(tabFornecedor);
                
               
            }
            
            // recuperando a tabela Funcionario armazenada em arquivo no disco----------------------------------------------
            ArrayList<Object> tabFunc = ManipulaBD.recuperaTabelaEmArquivo("data\\funcionario.dat");
            
            if ( tabFunc != null){
                
                // converter ArrayList<Object> (Generico) em um ArrayList<Cliente>
                ArrayList<Funcionario> tabFuncionario = new ArrayList();
                
                for (Object funcionario : tabFunc) {
                    Funcionario f = (Funcionario)funcionario;
                    tabFuncionario.add(f);
                }
                
                BancoDadosGeral.setTabelaFuncionario(tabFuncionario);
                
            }
            
            // recuperando a tabela Produto armazenada em arquivo no disco----------------------------------------------
            ArrayList<Object> tabProd = ManipulaBD.recuperaTabelaEmArquivo("data\\produto.dat");
            
            if (tabProd != null ){
                
                ArrayList<Produto> tabProduto = new ArrayList();

                for( Object produto : tabProd){
                    Produto p = (Produto)produto;
                    tabProduto.add(p);
                }
                
                BancoDadosGeral.setTabelaProduto(tabProduto);
            }
            
            // recuperando a tabela fornecedor armazenada em arquivo no disco----------------------------------------------
            ArrayList tabelaCar = ManipulaBD.recuperaTabelaEmArquivo("data\\cartao.dat");
            
            if ( tabelaCar != null ){
                
                // converter a tabela recuperada (ArrayList<Object>) em um ArrayList<Fornecedor>
                ArrayList<CartaoVenda> tabCartao = new ArrayList();
                for (Object obj : tabelaCar) {                    
                    CartaoVenda c = (CartaoVenda)obj;                    
                    tabCartao.add(c);
                }

                //Definir a tabela fornecedor no meu banco de dados
                BancoDadosGeral.setTabelaCartao(tabCartao);
            }
            
           
            System.out.println(" |--------------------------------------------|");
            System.out.println(" |                                            |");        
            System.out.println(" |       BANCO CONECTADO COM SUCESSO!!!       |");
            System.out.println(" |                                            |");
            System.out.println(" |--------------------------------------------|");
            
            
            
        }catch(IOException | ClassNotFoundException erro){
            
            System.out.println("|********************************************|");
            System.out.println("|                                            |");        
            System.out.println("|    ERRO AO CONECTAR NO BANCO DE DADOS      |");
            System.out.println("|                                            |");
            System.out.println("|********************************************|");
            System.out.println("                                              ");
            System.out.println("ERRO: "+erro.getMessage()                      );
            
        }
        
    }
}

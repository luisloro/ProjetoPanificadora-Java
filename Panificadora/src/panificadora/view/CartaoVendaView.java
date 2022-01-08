package panificadora.view;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import panificadora.controller.CartaoVendaController;

/**
 *
 * @author Grupo Pan
 */
public class CartaoVendaView {
    
    private CartaoVendaController controle;
    
    public CartaoVendaView() throws IOException{ //Método construtor para inicializar as variáveis e chamar o Menu
        this.controle = new CartaoVendaController();
        this.menuCartao();
    }

    private void menuCartao() throws IOException { //menu do cartão para chamar as funções
        
        Scanner s = new Scanner(System.in);
        int op;
        
        do{
            
            System.out.println("|---------------------------------------------|");
            System.out.println("|                MENU CARTAO                  |");
            System.out.println("|---------------------------------------------|");
            System.out.println("|                                             |");
            System.out.println("| 0 - Sair                                    |");
            System.out.println("| 1 - Cadastrar Cartao                        |");
            System.out.println("| 2 - Excluir Produto no Cartao               |");
            System.out.println("| 3 - Excluir Cartao                          |");
            System.out.println("| 4 - Listagem de Cartao por Codigo           |");
            System.out.println("| 5 - Listagem de Cartoes Cadastrados         |");
            System.out.println("|---------------------------------------------|");
            System.out.println(" Selecione sua opção:                          ");           

            op = Integer.parseInt(s.nextLine());
            
            switch (op){
                case 0:{ //sai do menu do cartao
                    System.out.println("Saindo do Cartao!");
                    break;
                }
                case 1:{ //chama o metodo de cadastrar o cartao
                    this.cadastrarCartao();
                    break;
                }
                case 2:{ //chama o metodo de excluir o produto de cartao
                    this.excluiProdCartao();
                    break;
                }
                case 3:{ //chama o metodo de excluir o cartao
                    this.excluirCartao();
                    break;
                }
                case 4:{ //chama o metodo de buscar o cartao especifico
                    this.buscaCartao();
                    break;
                }
                case 5:{ //chama o metodo de listar todos os cartões
                    this.todosCartoes();
                    break;
                }
            }
        
        }while (op>0);
    
    }

    private void cadastrarCartao() { //método para chamar do Controller a criação do cartão e adicionar todos os produtos no cartão
        
        int CodProduto=0;
        int CodFuncionario=0;
        int verifica=0;
        
        
        
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        Calendar dataDoDia = Calendar.getInstance();
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|               NOVO CARTAO VENDA                |");
        System.out.println("|------------------------------------------------|");
        
        System.out.println("Data Venda: " + formatador.format(dataDoDia.getTime()));
        
        System.out.println("Digite o Código do Funcionário: ");
        CodFuncionario = Integer.parseInt(s.nextLine());
        
        
        this.controle.buscaFuncionario(CodFuncionario);
        
        if ( this.controle.getFuncionario() == null){
            
            System.out.println("Funcionario não encontrado! Digite o código do funcionario corretamente.");
            System.out.println("-------------------------------------------");
            System.out.println("Pressione qualquer tecla para continuar....");            
            s.nextLine();
            
        }else{
            System.out.println("Funcionario que efetuol a venda:" + this.controle.getFuncionario().getNome());
             
            int op = 0;
            do{
                System.out.println("DIGITE O CODIGO DO PRODUTO: ");
                 
                CodProduto = Integer.parseInt(s.nextLine());
                 
                try{
                    this.controle.buscaProdutoCodigo(CodProduto);
                    if ( this.controle.getProduto() == null){
                        System.out.println("Esse produto não foi encontrado");
                        System.out.println("-------------------------------------------");
                        System.out.println("Pressione qualquer tecla para continuar....");            
                        s.nextLine();
                         
                    }else{
                        System.out.println(" Produto :" + this.controle.getProduto().getDescricao());
                        System.out.println(" Valor :" + this.controle.getProduto().getValor());
                        try{
                            this.controle.adicionarProdutoCartao();
                        }catch(Exception ex){
                            System.out.println( ex.getMessage());
                        }
                    }
                    System.out.println("Deseja incluir mais algum produto? 1 - SIM | 0 - NÃO");

                    op = Integer.parseInt(s.nextLine());
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                    System.out.println("-------------------------------------------");
                    System.out.println("Pressione qualquer tecla para continuar....");     
                    s.nextLine();
                }
            }while(op != 0);
            
            System.out.println("-------------------------------------------");
            System.out.println("Confirma a venda? 1 - SIM | 0 - NÃO");
            op = Integer.parseInt(s.nextLine());
             
            if ( op == 1){
                
                try{
                    this.controle.confirmaVenda();
                }catch(Exception ex){
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            
        }
     
    }

    

    private void excluiProdCartao() { //método para chamar a exclusao do Controller para excluir o produto do cartao
        
        int CodCartao=0;
        int CodProduto=0;
        int verifica=0;
        int op=0;
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("Digite o Código do Cartão: ");
        CodCartao = Integer.parseInt(s.nextLine());
        
        do{
            
            System.out.println("|------------------------------------------------|");
            System.out.println("|           EXCLUIR PRODUTO CARTAO               |");
            System.out.println("|------------------------------------------------|");

            
            System.out.println("Digite o Código do Produto a ser Excluido no Cartão: ");
            CodProduto = Integer.parseInt(s.nextLine());
            
            verifica=this.controle.excluiProdCartao(CodCartao, CodProduto);
            
            if(verifica==0){
                System.out.println("Produto a ser Excluido Não Encontrado!");
            }
            else{
                System.out.println("Produto Excluido no Cartão com Sucesso!");
            }
            
            System.out.println("Deseja Excluir outro Produto no Cartão: 0-Não | 1-Sim");
            op = Integer.parseInt(s.nextLine());
            
        }while(op==1);
        
    }

    private void excluirCartao() { //metodo para chamar o controller para excluir o cartão
        
        int codCartao=0;
        int verifica=0;
        Scanner s = new Scanner(System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|                EXCLUIR CARTAO                  |");
        System.out.println("|------------------------------------------------|");
        
        System.out.println("Digite o Código do Cartão a ser Excluido: ");
        codCartao = Integer.parseInt(s.nextLine());
        
        verifica=this.controle.excluirCartao(codCartao);
        
        if (verifica==0){
            System.out.println("Não existe este Cartão no Cadastro!");
        }
        else{
            System.out.println("Cartão Excluido com Sucesso!");
        }
        
    }

    private void buscaCartao() { //metodo para chamar o controller e buscar um cartão específico
        
        int codCartao=0;
        Scanner s = new Scanner (System.in);
        
        System.out.println("|-------------------------------------------------|");
        System.out.println("|                 BUSCAR CARTAO                   |");
        System.out.println("|-------------------------------------------------|");
        
        System.out.println("Digite o Código do Cartão a ser Pesquisado: ");
        codCartao=Integer.parseInt(s.nextLine());
        
        this.controle.buscaCartao(codCartao);
        
        if (this.controle.getCartao()== null){
            System.out.println("Código do Cartão não foi encontrado!");
        }
        else{
            System.out.println("|-------------------------------------------------|");
            System.out.println("Cartão: "+this.controle.getCartao().getCodCartao());
            System.out.println("Produtos: ");
            System.out.println("-------");
            for(int i=0; i<this.controle.getCartao().getProduto().size(); i++){
                System.out.println("Código: "+this.controle.getCartao().getProduto().get(i).getCodProd());
                System.out.println("Descrição: "+this.controle.getCartao().getProduto().get(i).getDescricao());
                System.out.println("Tipo: "+this.controle.getCartao().getProduto().get(i).getTipo());
                System.out.println("Valor: "+this.controle.getCartao().getProduto().get(i).getValor());
                System.out.println("-------");
            }
            System.out.println("Funcionario cód: "+this.controle.getCartao().getFuncionario().getNome());
            System.out.println("VALOR TOTAL: "+this.controle.getCartao().getTotal());
            System.out.println("|-------------------------------------------------|");
        }
        
    }

    private void todosCartoes() throws IOException { //metodo para listar todos os cartões e seus respectivos produtos
        
        System.out.println("|-------------------------------------------------|");
        System.out.println("|                 LISTAR CARTÕES                  |");
        System.out.println("|-------------------------------------------------|");
        
        this.controle.todosCartoes();
        
        if (this.controle.getListaCartao()==null){
            System.out.println("A Lista de Cartões está Vazia!");
        }
        else{
            
            for (int i=0; i<this.controle.getListaCartao().size();i++){
                
                System.out.println("|-------------------------------------------------|");
                System.out.println("Cartão: "+this.controle.getListaCartao().get(i).getCodCartao());
                
                System.out.println("Funcionario Vendedor: "+this.controle.getListaCartao().get(i).getFuncionario().getNome());
                System.out.println("VALOR TOTAL: "+this.controle.getListaCartao().get(i).getTotal());
                
                //this.controle.buscaCartao(i+1);
                for(int j=0; j<this.controle.getCartao().getProduto().size(); j++){
                
                    System.out.println("Descrição: "+this.controle.getCartao().getProduto().get(j).getDescricao());
                    System.out.println("Tipo: "+this.controle.getCartao().getProduto().get(j).getTipo());
                    System.out.println("Valor: "+this.controle.getCartao().getProduto().get(j).getValor());
                    System.out.println("-------");
                        
                }
            }
        }
        System.out.println("|-------------------------------------------------|");
        System.out.println("|            TECLE ENTER PARA CONTINUAR           |");
        System.out.println("|-------------------------------------------------|");
        System.in.read();
    }
    
}


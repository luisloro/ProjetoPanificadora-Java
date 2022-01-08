 package panificadora.view;
//Importação de bibliotecas e outras classes que serão nescessarias
import java.io.IOException;
import java.util.Scanner;
import panificadora.controller.ProdutoController;
import panificadora.controller.FornecedorController;

public class ProdutoView {
    
    private ProdutoController controle;
    private FornecedorController controleFornecedor;
    
    public ProdutoView() throws IOException{
        this.controle = new ProdutoController();
        //Inicializa a tela com o menu de Produtos, com as opções.
        this.menuProduto();
    }
    
    public void menuProduto () throws IOException{
        
        Scanner s = new Scanner(System.in);
        int op;
        
        do{
            
            System.out.println("|---------------------------------------------|");
            System.out.println("|                MENU PRODUTO                 |");
            System.out.println("|---------------------------------------------|");
            System.out.println("|                                             |");
            System.out.println("| 0 - Sair                                    |");
            System.out.println("| 1 - Cadastrar Produto                       |");
            System.out.println("| 2 - Alterar Produto                         |");
            System.out.println("| 3 - Excluir Produto                         |");
            System.out.println("| 4 - Listagem de Produto por Codigo          |");
            System.out.println("| 5 - Listagem de Produtos cadastrados        |");
            System.out.println("|---------------------------------------------|");
            System.out.println(" Selection sua opção:                          ");           

            op = Integer.parseInt(s.nextLine());
            
            switch (op){
                //Escolhe uma das opções para relizar algum procedimento disponivel no menu 
                case 0:{
                    System.out.println("Saindo do Produto!");
                    break;
                }
                case 1:{
                    //Ativa o metodo para cadastrar um novo produto
                    this.cadastrarProduto();
                    break;
                }
                case 2:{
                    //Ativa o metodo para alterar os dados de um produto
                    this.alterarProduto();
                    break;
                }
                case 3:{
                    //Ativa o metodo para excluir algum produto
                    this.excluirProduto();
                    break;
                }
                case 4:{
                    //Ativa o metodo para realizar a busca de algum produto
                    this.buscarProduto();
                    break;
                }
                case 5:{
                    //Ativa um metodo para exibir uma lista com todos o produtos ja cadastrados
                    this.todosProdutos();
                    break;
                }
            }
            
        }while (op>0);
        
    }
    //Metodo para cadastrar um novo produto
    private void cadastrarProduto() {
        //Definição de atributos que serão usandos durante o cadastro de um produto
        String Descricao="";
        double Valor=0.0;
        String Tipo="";
        int CodForn=0;
        int CodFun=0;
                
        Scanner s = new Scanner (System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|               CADASTRAR PRODUTO                |");
        System.out.println("|------------------------------------------------|");
        
        do{
            //Inserção dos cados do novo produto a ser cadastrados
            if(Descricao.equals("")){
                System.out.println("Digite a Descrição do Produto: ");
                Descricao=s.nextLine();
            }
            if(Valor==0){
                System.out.println("Digite o Valor do Produto: ");
                Valor=Double.parseDouble(s.nextLine());
            }
            if(Tipo.equals("")){
                System.out.println("Digite o Tipo do Produto: ");
                Tipo=s.nextLine();
            }
            if(CodForn==0){
                System.out.println("Digite o Código do Fornecedor: ");
                CodForn=Integer.parseInt(s.nextLine());
            }
            if(CodFun==0){
                System.out.println("Digite o Código do Funcionário: ");
                CodFun=Integer.parseInt(s.nextLine());
            }
            try{
                //Com os dados coletados é chamado o metodo paara realizar o cadastro, e caso ocorra algum erro sera exibida uma menssagem
                this.controle.cadastrarProduto(Descricao, Valor, Tipo, CodForn, CodFun);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                System.out.println("");
            }
            //É criado um loop para que enquando algumas informações não sejam inseridas ele fica repetindo
        }while((Descricao.equals("")) || (Valor==0) || (CodForn==0) || (CodFun==0) || (Tipo.equals("")));
    }
    //Metodos para alterar as informações de um produto
    private void alterarProduto() {
        
        int Codigo=0;
        String Descricao="";
        double Valor=0.0;
        String Tipo="";
        int CodForn=0;
        int CodFun=0;
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|                ALTERAR PRODUTO                 |");
        System.out.println("|------------------------------------------------|");
        
        //Coleta o código do produto a ser alterado
        System.out.println("Digite o Código do Produto a ser Alterado: ");
        Codigo = Integer.parseInt(s.nextLine());
        //É realizado a busca desse produto no banco de dados usando o código do produto
        this.controle.buscaProduto(Codigo);
        //Caso não encontre o produto é exibida uma menssagem de erro
        if (this.controle.getProduto()==null){ //não encontrou o Codigo do Produro
            System.out.println("Código do Produto não foi encontrado!");
        }
        else{ //encontrou o Codigo do Produto
            
            int op=0;
            System.out.println("Produto: "+this.controle.getProduto().getDescricao()+", Código: "+this.controle.getProduto().getCodProd());
            
            System.out.println("Deseja alterar esse produto? (0 - Não | 1 - Sim)");
            op = Integer.parseInt(s.nextLine());
            
            if (op==1){
                
                do{
                    //Agora são coletadas as novas informações do produto
                    if(Descricao.equals("")){
                        System.out.println("Digite a Descrição do Produto: ");
                        Descricao=s.nextLine();
                    }
                    if(Valor==0){
                        System.out.println("Digite o Valor do Produto: ");
                        Valor=Double.parseDouble(s.nextLine());
                    }
                    if(Tipo.equals("")){
                        System.out.println("Digite o Tipo do Produto: ");
                        Tipo=s.nextLine();
                    }
                    if(CodForn==0){
                        System.out.println("Digite o Código do Fornecedor: ");
                        CodForn=Integer.parseInt(s.nextLine());
                    }
                    if(CodFun==0){
                        System.out.println("Digite o Código do Funcionário: ");
                        CodFun=Integer.parseInt(s.nextLine());
                    }
                    try{
                        //altera os dados do produto com os dados coletados
                        this.controle.alterarProduto(Codigo, Descricao, Valor, Tipo, CodForn, CodFun);
                    }catch(Exception ex){
                        System.out.println(ex.getMessage());
                        System.out.println("");
                    }
                }while((Descricao.equals("")) || (Valor==0) || (CodForn==0) || (CodFun==0) || (Tipo.equals("")));
            
            }
            System.out.println("Produto alterado com Sucesso!");
        }
        
    }
    //Metodo para excluir um produto
    private void excluirProduto() {
        
        int codigo=0;
        int verifica=0;
        Scanner s = new Scanner(System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|                EXCLUIR PRODUTO                 |");
        System.out.println("|------------------------------------------------|");
        //É pedido o codigo do produto a ser excluido
        System.out.println("Digite o Código do Produto a ser Excluido: ");
        codigo = Integer.parseInt(s.nextLine());
        //Procura o produto no banco de dados usando o codigo para exclui-lo
        verifica=this.controle.excluirProduto(codigo);
        
        //Caso a exclusão não seja bem sucedida é exibida a menssagem
        if (verifica==0){
            System.out.println("Não existe este Produto no Cadastro!");
        }
        else{
            System.out.println("Produto Excluido com Sucesso!");
        }
        
    }
    //Metodo para busca de um produto
    private void buscarProduto() {
        
        int codigo=0;
        Scanner s = new Scanner (System.in);
        
        System.out.println("|-------------------------------------------------|");
        System.out.println("|                 BUSCAR PRODUTO                  |");
        System.out.println("|-------------------------------------------------|");
        
        //É pedido o codigo do produto a ser procurado no banco de dados
        System.out.println("Digite o Código do Produto a ser Pesquisado: ");
        codigo=Integer.parseInt(s.nextLine());
        
        //Esse metodo são usados para pesquisar o funcionario que efetuo o cadastro do produto
        this.controle.buscaNomes(codigo);
        //Metodo para buscar o produto no banco de dados usando o codigo
        this.controle.buscaProduto(codigo);
        //Caso o produto não seja encontrado é exibida a menssagem
        if (this.controle.getProduto()== null){
            System.out.println("Código do Produto não foi encontrado!");
        }
        else{
            //Caso o produto seja encontrado é informado seus dados
            System.out.println("|-------------------------------------------------|");
            System.out.println("Produto: "+this.controle.getProduto().getCodProd()+"---"+
                this.controle.getProduto().getDescricao()+"---"+
                this.controle.getProduto().getValor()+"---"+
                this.controle.getProduto().getTipo()+"---"+
                this.controle.getFornecedor().getNome()+"---"+
                this.controle.getFuncionario().getNome()
            );
            System.out.println("|-------------------------------------------------|");
        }
        
    }
    //Metodo para exibir uma lista com todos os produtos cadastrados
    private void todosProdutos() throws IOException {
        
        System.out.println("|-------------------------------------------------|");
        System.out.println("|                 LISTAR PRODUTO                  |");
        System.out.println("|-------------------------------------------------|");
        
        //É pedido para a classe controller de produto realizar a busca
        this.controle.todosProdutos();
        //Ja com a lista de todos os produtos estabelecida, agora é realizado um for para exibi-los
        for (int i=0; i<this.controle.getListaProduto().size();i++){
            
            System.out.println("|-------------------------------------------------|");
            System.out.println("Produto: "+
                    this.controle.getListaProduto().get(i).getCodProd()+"---"+
                    this.controle.getListaProduto().get(i).getDescricao()+"---"+
                    this.controle.getListaProduto().get(i).getValor()+"---"+
                    this.controle.getListaProduto().get(i).getTipo()
            );
            System.out.println("|-------------------------------------------------|");
            
        }
        System.out.println("|-------------------------------------------------|");
        System.out.println("|           TECLE ENTER PARA CONTINUAR            |");
        System.out.println("|-------------------------------------------------|");
        System.in.read();
    }
    
}

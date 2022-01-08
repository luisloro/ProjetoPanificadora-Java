package panificadora.view;
//Importação de bibliotecas e outras classes que serão nescessarias
import java.io.IOException;
import java.util.Scanner;
import panificadora.controller.FornecedorController;

public class FornecedorView {
    //Definição de atributos que serão utilizados
    private FornecedorController controle;
    
    public FornecedorView() throws IOException{
        this.controle = new FornecedorController();
        this.menuFornecedor();
    }
    
    public void menuFornecedor () throws IOException{
        
        Scanner s = new Scanner(System.in);
        int op;
        
        do{
            //Menu inicial para manutenção de dados de fornecedores
            System.out.println("|---------------------------------------------|");
            System.out.println("|             MENU FORNECEDORES               |");
            System.out.println("|---------------------------------------------|");
            System.out.println("|                                             |");
            System.out.println("| 0 - Sair                                    |");
            System.out.println("| 1 - Cadastrar Fonecedor                     |");
            System.out.println("| 2 - Alterar Fornecedor                      |");
            System.out.println("| 3 - Excluir Fornecedor                      |");
            System.out.println("| 4 - Listagem de Fornecedor por CNPJ         |");
            System.out.println("| 5 - Listagem de Fornecedores cadastrados    |");
            System.out.println("|---------------------------------------------|");
            System.out.println(" Selection sua opção:                          ");           

            op = Integer.parseInt(s.nextLine());
            
            switch (op){
                //Escolhe uma das opções para relizar algum procedimento disponivel no menu
                case 0:{
                    System.out.println("Saindo do Fornecedor!");
                    break;
                }
                case 1:{
                    //Aciona metodo para cadastrar um novo fornecedor
                    this.cadastrarFornecedor();
                    break;
                }
                case 2:{
                    //Aciona metodo para alterar os dados de algum fornecedor
                    this.alterarFornecedor();
                    break;
                }
                case 3:{
                    //Aciona metodo para excluir algum fornecedor cadastrado no banco de dados
                    this.excluirFornecedor();
                    break;
                }
                case 4:{
                    //Aciona metodo para buscar um fornecedor cadastrado no banco de dados
                    this.buscarFornecedor();
                    break;
                }
                case 5:{
                    //Aciona metodo para exibir os fornecedores cadastrados no banco de dados
                    this.todosFornecedores();
                    break;
                }
            }
            
        }while (op>0);
    }
    //Metodo para cadastrar um novo fornecedor
    private void cadastrarFornecedor() {
        //Defini atributos que serão utilizados para o cadastro de um novo fornecedor
        String Nome="";
        String Telefone="";
        String Endereco="";
        int Numero=0;
        String Bairro="";
        String CEP="";
        String Cidade="";
        String UF="";
        String CNPJ="";
        String NomeContato="";
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|              CADASTRAR FORNECEDOR              |");
        System.out.println("|------------------------------------------------|");
        
        do{
            //Coleta os dados para que serão utilizados para cadastrar um novo fornecedor
            if (Nome.equals("")){
                System.out.println("Digite o Nome: ");
                Nome = s.nextLine();
            }
            if (Telefone.equals("")){
                System.out.println("Digite o Telefone: ");
                Telefone = s.nextLine();
            }
            if (Endereco.equals("")){
                System.out.println("Digite o Endereço: ");
                Endereco = s.nextLine();
            }
            if (Numero==0){
                System.out.println("Digite o Número: ");
                Numero = Integer.parseInt(s.nextLine());
            }
            if (Bairro.equals("")){
                System.out.println("Digite o Bairro: ");
                Bairro = s.nextLine();
            }
            if (CEP.equals("")){
                System.out.println("Digite o CEP: ");
                CEP = s.nextLine();
            }
            if (Cidade.equals("")){
                System.out.println("Digite a Cidade: ");
                Cidade = s.nextLine();
            }
            if (UF.equals("")){
                System.out.println("Digite o Estado: ");
                UF = s.nextLine();
            }
            if (CNPJ.equals("")){
                System.out.println("Digite o CNPJ: ");
                CNPJ = s.nextLine();
            }
            if (NomeContato.equals("")){
                System.out.println("Digite o Nome de Contato do Fornecedor: ");
                NomeContato = s.nextLine();
            }
            try{
                //Com os dados coletados é chamado um metodo do contoller funcionarios para cadastrar um novo fornecedor
            controle.cadastrarFornecedor(Nome, Telefone, Endereco, Numero, Bairro, CEP, Cidade, UF, CNPJ, NomeContato);
            
            }catch(Exception ex){
                //Caso de algum erro durante o cadastro sera exibida uma menssagem
                System.out.println(ex.getMessage());
                System.out.println("");
            }
            //Caso seja encontrado o funcionario, sera pedido uma confirmação e assim alterar os dados a serem alterados
        }while(( (Nome.equals("")) || (CNPJ.equals(""))|| (Telefone.equals(""))));
    }
    
    private void alterarFornecedor() {
        //Defini atributos que serão utilizados para alterar os dados de um fornecedor
        int Codigo=0;
        String Nome="";
        String Telefone="";
        String Endereco="";
        int Numero=0;
        String Bairro="";
        String CEP="";
        String Cidade="";
        String UF="";
        String CNPJ="";
        String NomeContato="";
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|               ALTERAR FORNECEDOR               |");
        System.out.println("|------------------------------------------------|");
        
        //É pedido o CNPJ do fornecedir que deseja alterar os dados
        System.out.println("Digite o CNPJ do Fornecedor a ser Alterado: ");
        CNPJ = s.nextLine();
        
        this.controle.buscaFornecedor(CNPJ);
        //Caso não seja encontrado o forncedor é exibida a seguinte menssagem
        if (this.controle.getFornecedor()==null){ //não encontrou o CNPJ
            System.out.println("CNPJ do Fornecedor não foi encontrado!");
        }
        else{ //encontrou o CNPJ
            //Caso seja encontrado o fornecedor, sera pedido uma confirmação e assim alterar os dados a serem alterados
            int op=0;
            System.out.println("Fornecedor: "+this.controle.getFornecedor().getCNPJ()+"---"+this.controle.getFornecedor().getNome()+", Código: "+this.controle.getFornecedor().getCodigo());
            
            System.out.println("Deseja alterar esse fornecedor? (0 - Não | 1 - Sim)");
            op = Integer.parseInt(s.nextLine());
                
            if (op==1){
                
                Codigo = this.controle.getFornecedor().getCodigo();
                
                do{
                    if (Nome.equals("")){
                        System.out.println("Digite o Nome: ");
                        Nome = s.nextLine();
                    } 
                    if (Telefone.equals("")){
                        System.out.println("Digite o Telefone: ");
                        Telefone = s.nextLine();
                    }   
                    if (Endereco.equals("")){
                        System.out.println("Digite o Endereço: ");
                        Endereco = s.nextLine();
                    }
                    if (Numero==0){
                        System.out.println("Digite o Número: ");
                        Numero = Integer.parseInt(s.nextLine());
                    }
                    if (Bairro.equals("")){
                        System.out.println("Digite o Bairro: ");
                        Bairro = s.nextLine();
                    }
                    if (CEP.equals("")){
                        System.out.println("Digite o CEP: ");
                        CEP = s.nextLine();
                    }
                    if (Cidade.equals("")){
                        System.out.println("Digite a Cidade: ");
                        Cidade = s.nextLine();
                    }
                    if (UF.equals("")){
                        System.out.println("Digite o Estado: ");
                        UF = s.nextLine();
                    }
                    if (CNPJ.equals("")){
                        System.out.println("Digite o CNPJ: ");
                        CNPJ = s.nextLine();
                    }
                    if (NomeContato.equals("")){
                        System.out.println("Digite o Nome de Contato do Fornecedor: ");
                        NomeContato = s.nextLine();
                    }
                    try{
                        //Caso seja encontrado o funcionario, sera pedido uma confirmação e assim alterar os dados a serem alterados
                        this.controle.alterarFornecedor(Codigo, Nome, Telefone, Endereco, Numero, Bairro, CEP, Cidade, UF, CNPJ, NomeContato);
                    }catch(Exception ex){
                        System.out.println(ex.getMessage());
                        System.out.println("");
                    } 
                }while(( (Nome.equals("")) || (CNPJ.equals("")) ));
                System.out.println("Fornecedor alterado com Sucesso!");
            }
            
        }
        
    }
    //Metodo para excluir um fornecedor cadastrado no banco de dados
    private void excluirFornecedor() {
        
        int codigo=0;
        int verifica;
        Scanner s = new Scanner(System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|               EXCLUIR FORNECEDOR               |");
        System.out.println("|------------------------------------------------|");
        //É pedido o codigo do fornecedor a ser excluido
        System.out.println("Digite o Código do Fornecedor a ser Excluido: ");
        codigo = Integer.parseInt(s.nextLine());
        //Ja com o codigo do fornecedor o controller realiza o metodo de exclusão
        verifica=this.controle.excluirFornecedor(codigo);
        //Caso a exclusão não seja efetivada é exibida a menssagem e caso seja tambem é avisado
        if (verifica==0){
            System.out.println("Não existe este Fornecedor no Cadastro!");
        }
        else{
            System.out.println("Fornecedor Excluido com Sucesso!");
        }
        
    }
    //Metodo para realizar a busca de un fornecedor cadastrado no banco de dados
    private void buscarFornecedor() {
        
        String CNPJ="";
        Scanner s = new Scanner (System.in);
        
        System.out.println("|-------------------------------------------------|");
        System.out.println("|                BUSCAR FORNECEDOR                |");
        System.out.println("|-------------------------------------------------|");
        //É pedido o CNPJ do fornecedor que deseja buscar no banco de dados
        System.out.println("Digite o CNPJ do Fornecedor a ser Pesquisado: ");
        CNPJ = s.nextLine();
        //Ja com o CNPJ do fornecedor a classe controller manda o comando para pesquisar o fornecedir no banco de dados
        this.controle.buscaFornecedor(CNPJ);
        
        if (this.controle.getFornecedor() == null){
            System.out.println("CNPJ do Fornecedor não foi encontrado!");
        }
        else{
            //Dando tudo certo para encontrar o fornecedor são exibidas suas informações
            System.out.println("|-------------------------------------------------|");
            System.out.println("Fornecedor: "+this.controle.getFornecedor().getCodigo()+"---"+
                this.controle.getFornecedor().getNome()+"---"+
                this.controle.getFornecedor().getTelefone()+"---"+
                this.controle.getFornecedor().getEndereco()+"---"+
                this.controle.getFornecedor().getNumero()+"---"+
                this.controle.getFornecedor().getBairro()+"---"+
                this.controle.getFornecedor().getCep()+"---"+
                this.controle.getFornecedor().getCidade()+"---"+
                this.controle.getFornecedor().getUF()+"---"+
                this.controle.getFornecedor().getCNPJ()+"---"+
                this.controle.getFornecedor().getNomeContato()
            );
            System.out.println("|-------------------------------------------------|");
        }
        
    }
    //Metodo para exibir uma lista de todos os fornecedores cadastrados no banco de dados
    private void todosFornecedores() throws IOException {
        
        System.out.println("|-------------------------------------------------|");
        System.out.println("|                LISTAR FORNECEDOR                |");
        System.out.println("|-------------------------------------------------|");
        //A classe view pede a classe controler para comessar o processo para buscar os fornecedores no bando de dados
        this.controle.todosFornecedores();
         //Com a lista pronta os fornecedores e seus dados são exibidos
        for (int i=0; i<this.controle.getListaFornecedor().size();i++){
            
            System.out.println("|-------------------------------------------------|");
            System.out.println("Fornecedor: "+
                    this.controle.getListaFornecedor().get(i).getCodigo()+"---"+
                    this.controle.getListaFornecedor().get(i).getNome()+"---"+
                    this.controle.getListaFornecedor().get(i).getCNPJ()
            );
            System.out.println("|-------------------------------------------------|");
            
        }
        System.out.println("|-------------------------------------------------|");
        System.out.println("|           TECLE ENTER PARA CONTINUAR            |");
        System.out.println("|-------------------------------------------------|");
        System.in.read();
        
    }
    
}

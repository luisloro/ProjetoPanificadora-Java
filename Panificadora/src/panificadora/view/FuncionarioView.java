package panificadora.view;
//Importação de bibliotecas e outras classes que serão nescessarias
import java.io.IOException;
import static java.text.DateFormat.Field.YEAR;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import panificadora.controller.FuncionarioController;
import java.util.Date;
import java.util.Calendar;

public class FuncionarioView {
    //Definição de atributos que serão utilizados
    private FuncionarioController controle;
    
    public FuncionarioView() throws IOException{
        this.controle = new FuncionarioController();
        this.menuFuncionario();
    }
    
    public void menuFuncionario() throws IOException{
        
        Scanner s = new Scanner(System.in);
        int op;
        
        do{
            //Menu inicial para manutenção de dados de funcionarios
            System.out.println("|---------------------------------------------|");
            System.out.println("|             MENU FUNCIONARIOS               |");
            System.out.println("|---------------------------------------------|");
            System.out.println("|                                             |");
            System.out.println("| 0 - Sair                                    |");
            System.out.println("| 1 - Cadastrar Funcionario                   |");
            System.out.println("| 2 - Alterar Funcionario                     |");
            System.out.println("| 3 - Excluir Funcionario                     |");
            System.out.println("| 4 - Listagem de Funcionario por CPF         |");
            System.out.println("| 5 - Listagem de Funcionarios cadastrados    |");
            System.out.println("|---------------------------------------------|");
            System.out.println(" Selection sua opção:                          ");           

            op = Integer.parseInt(s.nextLine());
            
            switch (op){
                //Escolhe uma das opções para relizar algum procedimento disponivel no menu
                case 0:{
                    System.out.println("Saindo do Funcionario!");
                    break;
                }
                case 1:{
                    //Aciona metodo para cadastrar um novo funcionario
                    this.cadastrarFuncionario();
                    break;
                }
                case 2:{
                    //Aciona metodo para alterar os dados de algum funcionario
                    this.alterarFuncionario();
                    break;
                }
                case 3:{
                    //Aciona metodo para excluir algum funcionario cadastrado no banco de dados
                    this.excluirFuncionario();
                    break;
                }
                case 4:{
                    //Aciona metodo para buscar um funcionario cadastrado no banco de dados
                    this.buscarFuncionario();
                    break;
                }
                case 5:{
                    //Aciona metodo para exibir os funcionarios cadastrados no banco de dados
                    this.todosFuncionario();
                    break;
                }
            }
            
        }while (op>0);
    }
    //Metodo para cadastrar um novo funcionario
    public void cadastrarFuncionario(){
        
        SimpleDateFormat sdf = new SimpleDateFormat ("dd/mm/yyyy");
        //Defini atributos que serão utilizados para o cadastro de um novo funcionario
        String Nome="";
        String Telefone="";
        String Endereco="";
        int Numero=0;
        String Bairro="";
        String CEP="";
        String Cidade="";
        String UF="";
        String CPF="";
        String RG="";
        String dataNascimento="";
        String Cargo="";
        double Salario=0.0;
        String Admissao="";
        String Demissao="";
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|              CADASTRAR FUNCIONARIO             |");
        System.out.println("|------------------------------------------------|");
        
        do{
            //Coleta os dados para que serão utilizados para cadastrar um novo funcionario
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
            if (CPF.equals("")){
                System.out.println("Digite o CEP: ");
                CEP = s.nextLine();
            }
            if(Cidade.equals("")){
                System.out.println("Digite a Cidade: ");
                Cidade = s.nextLine();
            }
            if (UF.equals("")){
                System.out.println("Digite o Estado: ");
                UF = s.nextLine();
            }
            if (CPF.equals("")){
                System.out.println("Digite o cpf: ");
                CPF = s.nextLine();
            }
            if (RG.equals("")){
                System.out.println("Digite o RG: ");
                RG = s.nextLine();
            }
            if (dataNascimento.equals("")){
                System.out.println("Digite o Data de Nascimento: ");
                dataNascimento = s.nextLine();
            }
            if (Cargo.equals("")){
                System.out.println("Digite o Cargo: ");
                Cargo = s.nextLine();
            }
            if (Salario==0){
                System.out.println("Digite o Salario: ");
                Salario = Double.parseDouble(s.nextLine());
            }
            if (Admissao.equals("")){
                System.out.println("Digite o Data de Admissão: ");
                Admissao = s.nextLine();
            }

            try{
                //Com os dados coletados é chamado um metodo do contoller funcionarios para cadastrar um novo funcionario
                this.controle.cadastrarFuncionario(Nome, Telefone, Endereco, Numero, Bairro, CEP, Cidade, UF, CPF, RG, dataNascimento, Cargo, Salario, Admissao);
            }catch(Exception ex){
                //Caso de algum erro durante o cadastro sera exibida uma menssagem
                System.out.println(ex.getMessage());
                System.out.println("");
            }
            //É criado um loop para que enquando algumas informações não sejam inseridas ele fica repetindo
        }while(( (Nome.equals("")) || (CPF.equals("")) || (RG.equals("")) || (dataNascimento.equals("")) ));
    }
    //Metodo para alterar os dados de um funcionario cadastrado no banco de dados
    private void alterarFuncionario() {
        
        SimpleDateFormat sdf = new SimpleDateFormat ("dd/mm/yyyy");
        //Defini atributos que serão utilizados para alterar os dados de um funcionario
        int Codigo=0;
        String Nome="";
        String Telefone="";
        String Endereco="";
        int Numero=0;
        String Bairro="";
        String CEP="";
        String Cidade="";
        String UF="";
        String CPF="";
        String RG="";
        String dataNascimento="";
        String Cargo="";
        double Salario=0.0;
        String Admissao="";
        String Demissao="";
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|              ALTERAR FUNCIONARIO               |");
        System.out.println("|------------------------------------------------|");
        //É pedido o cpf do funcionario que deseja alterar os dados
        System.out.println("Digite o CPF do Funcionario a ser Alterado: ");
        CPF = s.nextLine();
        
        this.controle.buscaFuncionario(CPF);
        //Caso não seja encontrado o funcionaro é exibida a seguinte menssagem
        if (this.controle.getFuncionario()==null){ //não encontrou o CPF
            System.out.println("CPF do Funcionario não foi encontrado!");
        }
        else{ 
            //Caso seja encontrado o funcionario, sera pedido uma confirmação e assim alterar os dados a serem alterados
            int op=0;
            System.out.println("Funcionario: "+this.controle.getFuncionario().getCPF()+"---"+this.controle.getFuncionario().getNome()+", Código: "+this.controle.getFuncionario().getCodigo());
            
            System.out.println("Deseja alterar esse funcionario? (0 - Não | 1 - Sim)");
            op = Integer.parseInt(s.nextLine());
                
            if (op==1){
                
                Codigo=this.controle.getFuncionario().getCodigo();
                
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
                if (CPF.equals("")){
                    System.out.println("Digite o CEP: ");
                    CEP = s.nextLine();
                }
                if(Cidade.equals("")){
                    System.out.println("Digite a Cidade: ");
                    Cidade = s.nextLine();
                }
                if (UF.equals("")){
                    System.out.println("Digite o Estado: ");
                    UF = s.nextLine();
                }
                if (CPF.equals("")){
                    System.out.println("Digite o CPF: ");
                    CPF = s.nextLine();
                }
                if (RG.equals("")){
                    System.out.println("Digite o RG: ");
                    RG = s.nextLine();
                }
                if (dataNascimento.equals("")){
                    System.out.println("Digite o Data de Nascimento: ");
                    dataNascimento = s.nextLine();
                }
                if (Cargo.equals("")){
                    System.out.println("Digite o Cargo: ");
                    Cargo = s.nextLine();
                }
                if (Salario==0){
                    System.out.println("Digite o Salario: ");
                    Salario = Double.parseDouble(s.nextLine());
                }
                if (Admissao.equals("")){
                    System.out.println("Digite o Data de Admissão: ");
                    Admissao = s.nextLine();
                }
                
                try{
                    //Caso seja encontrado o funcionario, sera pedido uma confirmação e assim alterar os dados a serem alterados
                    this.controle.alterarFuncionario(Codigo, Nome, Telefone, Endereco, Numero, Bairro, CEP, Cidade, UF, CPF, RG, dataNascimento, Cargo, Salario, Admissao, Demissao);
                
                }catch(Exception ex){
                    System.out.println(ex.getMessage());
                    System.out.println("");
                }
                
                System.out.println("Funcionário Alterado com Sucesso!");
            }
            
        }
        
    }
    //Metodo para excluir um funcionario cadastrado no banco de dados
    private void excluirFuncionario() {
        
        int codigo=0;
        int verifica;
        Scanner s = new Scanner(System.in);
        
        System.out.println("|------------------------------------------------|");
        System.out.println("|               EXCLUIR FUNCIONARIO              |");
        System.out.println("|------------------------------------------------|");
        //É pedido o codigo do funcionario a ser excluido
        System.out.println("Digite o Código do Funcionario a ser Excluido: ");
        codigo = Integer.parseInt(s.nextLine());
        //Ja com o codigo do funconario o controller realiza o metodo de exclusão
        verifica=this.controle.excluirFuncionario(codigo);
        //Caso a exclusão não seja efetivada é exibida a menssagem e caso seja tambem é avisado
        if (verifica==0){
            System.out.println("Não existe este Fornecedor no Cadastro!");
        }
        else{
            System.out.println("Fornecedor Excluido com Sucesso!");
        }
        
    }
    //Metodo para realizar a busca de un funcionario cadastrado no banco de dados
    private void buscarFuncionario() {
        
        String CPF = "";
        Scanner s = new Scanner(System.in);
        
        System.out.println("|-------------------------------------------------|");
        System.out.println("|                BUSCAR FUNCIONARIO               |");
        System.out.println("|-------------------------------------------------|");
        //É pedido o cpf do funcionario que deseja buscar no banco de dados
        System.out.println("Digite o CPF do Funcionario a ser Pesquisado: ");
        CPF = s.nextLine();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c=null;
        //Ja com o cpf do funconario a classe controller manda o comando para pesquisar o funcionario no banco de dados
        this.controle.buscaFuncionario(CPF);
        //Caso o funcionario não seja encontrado é exibida a menssagem de alerta
        if(this.controle.getFuncionario()==null){
            System.out.println("CPF do Funcionario não foi encontrado!");
        }
        else{
            //Dando tudo certo para encontrar o funcionario são exibidas suas informações
            System.out.println("|-------------------------------------------------|");
            
            System.out.println("Funcionario: "+this.controle.getFuncionario().getCodigo()+"---"+
                this.controle.getFuncionario().getNome()+"---"+
                this.controle.getFuncionario().getTelefone()+"---"+
                this.controle.getFuncionario().getEndereco()+"---"+
                this.controle.getFuncionario().getNumero()+"---"+
                this.controle.getFuncionario().getBairro()+"---"+
                this.controle.getFuncionario().getCep()+"---"+
                this.controle.getFuncionario().getCidade()+"---"+
                this.controle.getFuncionario().getUF()+"---"+
                this.controle.getFuncionario().getCPF()+"---"+
                this.controle.getFuncionario().getRG()+"---"+
                
                this.controle.getFuncionario().getDataNascimento().get(Calendar.DAY_OF_MONTH)+"---"+
                this.controle.getFuncionario().getDataNascimento().get(Calendar.MONTH)+"---"+
                this.controle.getFuncionario().getDataNascimento().get(Calendar.YEAR)+"---"+
                this.controle.getFuncionario().getCargo()+"--"+
                this.controle.getFuncionario().getSalario()+
                this.controle.getFuncionario().getAdmissao().get(Calendar.DAY_OF_MONTH)+"---"+
                this.controle.getFuncionario().getAdmissao().get(Calendar.MONTH)+"---"+
                this.controle.getFuncionario().getAdmissao().get(Calendar.YEAR)+"---"
               
            );
            System.out.println("|-------------------------------------------------|");
        }
        
    }
    //Metodo para exibir uma lista de todos os funcionarios cadastrados no banco de dados
    private void todosFuncionario() throws IOException {
        
        System.out.println("|-------------------------------------------------|");
        System.out.println("|                LISTAR FUNCIONARIO               |");
        System.out.println("|-------------------------------------------------|");
        //A classe view pede a classe controler para comessar o processo para buscar os funcionarios no bando de dados
        this.controle.todosFuncionarios();
        //Com a lista pronta os funcionarios e seus dados são exibidos
        for (int i=0; i<this.controle.getListaFuncionario().size();i++){
            
            System.out.println("|-------------------------------------------------|");
            System.out.println("Fornecedor: "+
                this.controle.getListaFuncionario().get(i).getCodigo()+"---"+
                this.controle.getListaFuncionario().get(i).getNome()+"---"+
                this.controle.getListaFuncionario().get(i).getCPF()
            );
            System.out.println("|-------------------------------------------------|");
            
        }
        System.out.println("|-------------------------------------------------|");
        System.out.println("|           TECLE ENTER PARA CONTINUAR            |");
        System.out.println("|-------------------------------------------------|");
        System.in.read();
    }
    
}

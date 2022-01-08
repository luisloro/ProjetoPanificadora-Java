package panificadora.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import panificadora.dao.FuncionarioDAO;
import panificadora.model.Funcionario;

/**
 *
 * @author Grupo Pan
 */
public class FuncionarioController {
    
    private Funcionario funcionario;
    private FuncionarioDAO bd;
    private ArrayList<Funcionario> listaFuncionario;
    private Object sdf;
    
    public FuncionarioController(){ //construtor para inicializar as variaveis
        this.funcionario = new Funcionario();
        this.bd = new FuncionarioDAO();
    }
    
    public Funcionario getFuncionario(){ //retorna o funcionario
        return this.funcionario;
    }
    
    public ArrayList<Funcionario> getListaFuncionario(){ //retorna a lista de funionario para o view
        return this.listaFuncionario;
    }
    
    //metodo para cadastrar um funcionario no banco de dados
    public void cadastrarFuncionario (String nome, String telefone, String endereco, int numero, String bairro, 
            String CEP, String cidade,String UF, String CPF, String RG, String dataNasc, String Cargo,
            double Salario, String Admissao) throws Exception{
        
        Funcionario fun = new Funcionario();
        
        fun.setCodigo(1);
        fun.setNome(nome);
        fun.setTelefone(telefone);
        fun.setEndereco(endereco);
        fun.setNumero(numero);
        fun.setBairro(bairro);
        fun.setCep(CEP);
        fun.setCidade(cidade);
        fun.setUF(UF);
        fun.setCPF(CPF);
        fun.setRG(RG);
        //fun.setNascimento(dataNasc);
        fun.setCargo(Cargo);
        fun.setSalario(Salario);
        //fun.setDataAdmissao(Admissao);
        
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        // Criando um objetco calendar e pegando a data atual
        
        Calendar nascimento = Calendar.getInstance();        
        nascimento.setTime(formatoData.parse(dataNasc));   
        fun.setDataNascimento( nascimento );
        /*
        Calendar nascimento = Calendar.getInstance();        
        Date d = new Date( dataNasc );        
        nascimento.setTime( d );
        
        fun.setDataNascimento( nascimento );
        
        Calendar admissao = Calendar.getInstance();        
        Date a = new Date( Admissao );        
        nascimento.setTime( a );
        */
        Calendar admissao = Calendar.getInstance();        
        admissao.setTime(formatoData.parse(Admissao));   
        fun.setAdmissao( admissao );
        
        this.bd.cadastrar(fun);
        
    }
    
    //metodo para alterar um informação de um funcionario especifico no banco de dados
    public void alterarFuncionario(int codigo, String nome, String telefone, String endereco, int numero, String bairro, 
            String CEP, String cidade,String UF, String CPF, String RG, String dataNasc, String Cargo,
            double Salario, String Admissao, String Demissao) throws Exception{
        
        Funcionario fun = new Funcionario();
        
        fun.setCodigo(codigo);
        fun.setNome(nome);
        fun.setTelefone(telefone);
        fun.setEndereco(endereco);
        fun.setNumero(numero);
        fun.setBairro(bairro);
        fun.setCep(CEP);
        fun.setCidade(cidade);
        fun.setUF(UF);
        fun.setCPF(CPF);
        fun.setRG(RG);
        fun.setCargo(Cargo);
        fun.setSalario(Salario);
        
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
       
        // Criando um objetco calendar e pegando a data atual
       
        Calendar nascimento = Calendar.getInstance();        
        nascimento.setTime(formatoData.parse(dataNasc));   
        fun.setDataNascimento( nascimento );
         /*
        Calendar nascimento = Calendar.getInstance();        
        Date n = new Date( dataNasc );        
        nascimento.setTime( n );
        fun.setDataNascimento( nascimento );
        */
        /*
        Calendar admissao = Calendar.getInstance();        
        Date a = new Date( Admissao );        
        nascimento.setTime( a );
        
        Calendar demissao = Calendar.getInstance();        
        Date de = new Date( Demissao );        
        nascimento.setTime( de );
        
        
        */
        Calendar admissao = Calendar.getInstance();        
        admissao.setTime(formatoData.parse(Admissao));   
        fun.setAdmissao( admissao );
        this.bd.alterar(fun);
    }
    
    public int excluirFuncionario (int codigo){ //metodo para buscar um funcionario no banco e excluir
        
        return this.bd.excluir(codigo);
        
    }
    
    public void buscaFuncionario (String CPF){ //metodo para buscar um funcionario no banco de dados e salvar na variavel funcionario para o uso do getFuncionario
        
        this.funcionario = this.bd.recuperaCPF(CPF);
        
    }
    
    public void todosFuncionarios (){ //metodo que busca no banco de dados todos os funcionarios e salva no array listaFuncionario todos os funcionarios contidos no banco de dados
        
        ArrayList<Object> retorno = this.bd.retornaTudo();
         
        this.listaFuncionario = new ArrayList<Funcionario>();
        
        for (Object o : retorno){
            
            Funcionario f = ((Funcionario)o);
            
            this.listaFuncionario.add(f);
            
        }
        
    }
    
}

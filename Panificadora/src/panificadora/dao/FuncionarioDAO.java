package panificadora.dao;
//Importação de bibliotecas e outras classes que serão nescessarias
import java.util.ArrayList;
import panificadora.model.Funcionario;


public class FuncionarioDAO implements BD {
    
    private ArrayList<Funcionario> tabelaFuncionario;
    //Definição de atributos que serão utilizados
    public FuncionarioDAO (){
        this.tabelaFuncionario = new ArrayList<Funcionario>();
    }
    //Metodo para cadastrar um novo Funcionario 
    @Override
    public void cadastrar (Object objeto){
        //O Objeto enviado pelo controller é recebido e convertido para a classe Funcionario
        Funcionario f = ((Funcionario)objeto);
        //É setado o codigo no novo Funcionario, recebendo o proximo codigo disponivel do Banco de Dados
        f.setCodigo(BancoDadosGeral.getProximocodigoFuncionario());
        //O novo funcionario é adicionado a tabela de funcionario no banco de dados
        BancoDadosGeral.getTabelaFuncionario().add(f);
        //O codigo é atualizado para proximo código que sera atribuido ao proximo funcionario
        BancoDadosGeral.atualizaProximoCodigoFuncionario();
    }
    //Metodo para alterar os dados de um funcioario
    @Override
    public void alterar (Object objeto){
        //O funcionario com as novas infomações alteradas é enviado como Classe Objeto
        //E então convertido para classe Funcionario
        Funcionario f = ((Funcionario)objeto);
        //Sera coletado os funcionarios cadastrados do bando de dados
        for(int i=0; i<BancoDadosGeral.getTabelaFuncionario().size();i++){
            
            Funcionario forn = BancoDadosGeral.getTabelaFuncionario().get(i);
            //Sera comparado o codigo e encontrara o funcionario com dados antigos, e então sera substituido
            if (forn.getCodigo() == f.getCodigo()){
                BancoDadosGeral.getTabelaFuncionario().set(i, f);
                break;
            }
        }
    }
    //Metodo para excluir um produto do banco de dados
    @Override
    public int excluir(int codigo){
        
        if (BancoDadosGeral.getTabelaFuncionario().isEmpty()){
            return 0;
        }
        //O metodo recebe o codigo do funcionario que sera excluido
        //E então é usado o codigo para pesquisar o funcionario no banco de dados
        for (int i=0; i<BancoDadosGeral.getTabelaFuncionario().size();i++){
            Funcionario f = BancoDadosGeral.getTabelaFuncionario().get(i);
            // E quando é encontrado, o Funcionario é removido do banco de dados.
            if (f.getCodigo()==codigo){
                BancoDadosGeral.getTabelaFuncionario().remove(i);
                return 1;
            }
        }
        return 0;
    }
    // Metodo para encontrar um funcionario no banco de dados
    public Funcionario recuperaCPF (String cpf){
        //O metodo recebe o cpf do funcionario a ser encontrado
        //É feita uma pesquisa na tabela de funcionarios
        
        for (int i=0; i<BancoDadosGeral.getTabelaFuncionario().size(); i++){
            Funcionario f = BancoDadosGeral.getTabelaFuncionario().get(i);
            //E quando encontrado atraves do cpf,o metodo retorna o objeto para a classe controller que solicitou
            if (f.getCPF().equals(cpf)){
                return f;
            }
        }
        return null;
    }
    //Mesmo processo do recuperaCPF, mas usando o codigo do funcionario ao inves de CPF
    public Funcionario recuperaCodigo (int codigo){
        
        
        for (int i=0; i<BancoDadosGeral.getTabelaFuncionario().size(); i++){
            Funcionario f = BancoDadosGeral.getTabelaFuncionario().get(i);
            
            if (f.getCodigo()==codigo){
                return f;
            }
        }
        return null;
    }
    //Metodo para retornar a lista de todos os funcionarios cadastrados no banco de dados
    @Override
    public ArrayList<Object> retornaTudo (){
        
        ArrayList<Object> lista = new ArrayList<Object>();
        //A tabela com os funcionarios no banco de dados é percorrida 
        //Enquanto percorrida um objeto recebe os dados 
        
        for (Funcionario f : BancoDadosGeral.getTabelaFuncionario()){
            //Que então é adicionado a uma lista, que sera retornada para a classe controller que solicitou
            lista.add(f);
        }
        
        return lista;
        
    }
}

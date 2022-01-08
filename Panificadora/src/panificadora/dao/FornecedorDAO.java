package panificadora.dao;
//Importação de bibliotecas e outras classes que serão nescessarias
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import panificadora.model.Fornecedor;

/**
 *
 * @author Grupo Pan
 */
public class FornecedorDAO implements BD {
    //Definição de atributos que serão utilizados
    private ArrayList <Fornecedor> tabelaFornecedor;
    private int proximoCodigo;
    
    public FornecedorDAO (){
        this.tabelaFornecedor = new ArrayList <Fornecedor>();
        this.proximoCodigo = 1;
    }
    //Metodo para cadastrar um novo Forncedor
    @Override
    public void cadastrar (Object objeto){
        //O Objeto enviado pelo controller é recebido e convertido para a classe Fornecedir
        Fornecedor f = ((Fornecedor)objeto);
        //É setado o codigo no novo Fornecedor, recebendo o proximo codigo disponivel do Banco de Dados
        
        f.setCodigo(BancoDadosGeral.getProximocodigoFornecedor());
         //O novo fornecedor é adicionado a tabela de fornecedores no banco de dados
        BancoDadosGeral.getTabelaFornecedor().add(f);
        //O codigo é atualizado para proximo código que sera atribuido ao proximo fornecedor
        BancoDadosGeral.atualizaProximoCodigoFornecedor();
    }
    //Metodo para alterar os dados de um fornecedor
    @Override
    public void alterar (Object objeto){
        //O fornecedor com as novas infomações alteradas é enviado como Classe Objeto
        //E então convertido para classe Fornecedor
        Fornecedor f = ((Fornecedor)objeto);
        //Sera coletado os fornecedores cadastrados do bando de dados
        for(int i=0; i<BancoDadosGeral.getTabelaFornecedor().size();i++){
            
            Fornecedor forn = BancoDadosGeral.getTabelaFornecedor().get(i);
            //Sera comparado o codigo e encontrara o fornecedor com dados antigos, e então sera substituido
            if (forn.getCodigo() == f.getCodigo()){
                BancoDadosGeral.getTabelaFornecedor().set(i, f);
                break;
            }
        }
    }
    
    //Metodo para excluir um fornecedor do banco de dados
    @Override
    public int excluir (int codigo){
        
        if (BancoDadosGeral.getTabelaFornecedor().isEmpty()){
            return 0;
        }
        //O metodo recebe o codigo do fornecedor que sera excluido
        //E então é usado o codigo para pesquisar o fornecedor no banco de dados
        for (int i=0; i<BancoDadosGeral.getTabelaFornecedor().size();i++){
            Fornecedor f = BancoDadosGeral.getTabelaFornecedor().get(i);
            // E quando é encontrado, o Fornecedor é removido do banco de dados.
            if (f.getCodigo()==codigo){
                BancoDadosGeral.getTabelaFornecedor().remove(i);
                return 1;
            }
        }
        return 0;
    }
    // Metodo para encontrar um fornecedor no banco de dados
    public Fornecedor recuperaCNPJ (String cnpj){
        //O metodo recebe o CNPJ do fornecedor a ser encontrado
        //É feita uma pesquisa na tabela de fornecedores
        
        for (int i=0; i<BancoDadosGeral.getTabelaFornecedor().size(); i++){
            Fornecedor f = BancoDadosGeral.getTabelaFornecedor().get(i);
            //E quando encontrado atraves do CNPJ,o metodo retorna o objeto para a classe controller que solicitou
            if (f.getCNPJ().equals(cnpj)){
                return f;
            }
        }
        return null;
    }
     //Mesmo processo do recuperaCNPJ, mas usando o codigo do fornecedor ao inves de CNPJ
     public Fornecedor recuperaCodigo (int codigo){
        
        
        for (int i=0; i<BancoDadosGeral.getTabelaFornecedor().size(); i++){
            Fornecedor f = BancoDadosGeral.getTabelaFornecedor().get(i);
            
            if (f.getCodigo()==codigo){
                return f;
            }
        }
        return null;
    }
     //Metodo para retornar a lista de todos os fornecedores cadastrados no banco de dados
    @Override
    public ArrayList<Object> retornaTudo(){
        
        ArrayList<Object> lista = new ArrayList<Object>();
        //A tabela com os fornecedores no banco de dados é percorrida 
        //Enquanto percorrida um objeto recebe os dados 
        for (Object fornecedor : BancoDadosGeral.getTabelaFornecedor()) {
            //Que então é adicionado a uma lista, que sera retornada para a classe controller que solicitou
            lista.add(fornecedor);
        }
        
        return lista;
    }
    
}

package panificadora.dao;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import panificadora.model.Produto;

/**
 *
 * @author Grupo Pan
 */
public class ProdutoDAO implements BD{
    
    private ArrayList<Produto> tabelaProduto;
    private int proximoCodigo;
    
    
    public ProdutoDAO (){ //construtor para inicializar as variaveis
        this.tabelaProduto = new ArrayList<Produto>();
        this.proximoCodigo = 1;
    }
    
    @Override
    public void cadastrar (Object objeto){ //Método para cadastrar o produto e adicionar no banco geral
        Produto p = ((Produto)objeto);
        
        try {
            p.setCodProd(BancoDadosGeral.getProximocodigoProduto());
        } catch (Exception ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        BancoDadosGeral.getTabelaProduto().add(p);
        BancoDadosGeral.atualizaProximoCodigoProduto();
    }
    
    @Override
    public void alterar (Object objeto){ //Método para alterar informações de um produto no banco geral
        Produto p = ((Produto)objeto);
        
        
        for(int i=0; i<BancoDadosGeral.getTabelaProduto().size();i++){
            
            Produto prod = BancoDadosGeral.getTabelaProduto().get(i);
            
            if (prod.getCodProd()== p.getCodProd()){
                BancoDadosGeral.getTabelaProduto().set(i, p);
                break;
            }
        }
    }
    
    @Override
    public int excluir (int codigo){ //Método para excluir um produto do banco geral
        
        if (BancoDadosGeral.getTabelaProduto().isEmpty()){
            return 0;
        }
        
        for (int i=0; i<BancoDadosGeral.getTabelaProduto().size();i++){
            Produto p = BancoDadosGeral.getTabelaProduto().get(i);
            
            if (p.getCodProd()==codigo){
                BancoDadosGeral.getTabelaProduto().remove(i);
                return 1;
            }
        }
        return 0;
    }
    
    public Produto recuperaProduto (int codigo){ //Método para fornecer informação sobre um produto específico
        
        
        for (int i=0; i<BancoDadosGeral.getTabelaProduto().size(); i++){
            Produto p = BancoDadosGeral.getTabelaProduto().get(i);
            
            if (p.getCodProd()==codigo){
                return p;
            }
        }
        return null;
    }
    
    @Override
    public ArrayList<Object> retornaTudo(){ //Método para retornar todos os produtos do banco geral para o controller
        
        ArrayList<Object> lista = new ArrayList<Object>();
        
        for (Produto p : BancoDadosGeral.getTabelaProduto()){
            lista.add(p);
        }
        
        return lista;
        
    }
    
}

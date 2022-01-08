package panificadora.dao;

import java.util.ArrayList;

/**
 *
 * @author Grupo Pan
 */
public interface BD { //classe de modelo para os outros bancos de dados, fazendo com que todos a implementem tenham que utilizar todos os metodos que ela possui
    
    public abstract void cadastrar (Object objeto);
    
    public abstract void alterar (Object objeto);
    
    public abstract int excluir (int codigo);
    
    //public abstract void consultar ();
    
    public abstract ArrayList<Object> retornaTudo();
    
}

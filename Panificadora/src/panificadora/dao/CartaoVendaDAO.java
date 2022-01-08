package panificadora.dao;

import java.util.ArrayList;
import panificadora.model.CartaoVenda;

/**
 *
 * @author Grupo Pan
 */
public class CartaoVendaDAO implements BD {
    
    
    
    
    
    @Override
    public void cadastrar (Object objeto){ //Método para cadastrar o cartão e adicionar no banco geral
        
        //cria um objeto cartaovenda chamado c q recebe um objetoo do tipo objeto e transforma em tipo cartaovenda
        CartaoVenda c = ((CartaoVenda)objeto);
      
        //adiciona no objeto c o valor do próximo codigo de cartão
        c.setCodCartao(BancoDadosGeral.getProximocodigoCartao());
        
        //adiciona no banco geral na tabela o cartao
        BancoDadosGeral.getTabelaCartao().add(c);
        
        //chama o método para atualizar o próximo codigo para a hora que chamar o cadastro de cartao ele receber o proximo codigo
        BancoDadosGeral.atualizaProximoCodigoCartao();
    }
    
    @Override
    public void alterar (Object objeto){ //Método para alterar informações de um cartão no banco geral
        
        //cria um objeto cartaovenda chamado c q recebe um objetoo do tipo objeto e transforma em tipo cartaovenda
        CartaoVenda c = ((CartaoVenda)objeto);
        
        //laço para percorrer a tabela cartao em busca do cartão a ser alterado
        for(int i=0; i<BancoDadosGeral.getTabelaCartao().size();i++){
            
            //cart recebe o cartao da posição i
            CartaoVenda cart = BancoDadosGeral.getTabelaCartao().get(i);
            
            //vai comparar os codigos do cart e do c para ver se são iguais
            if (cart.getCodCartao()== c.getCodCartao()){
                //vai salvar o valor do objeto c na tabela do banco geral na posição i
                BancoDadosGeral.getTabelaCartao().set(i, c);
                break;
            }
        }
    }
    
    @Override
    public int excluir (int codigo){ //Método para excluir um cartão do banco geral
        
        //se a tabela estiver vazia retorna zero pro controller
        if (BancoDadosGeral.getTabelaCartao().isEmpty()){
            return 0;
        }
        
        //havendo dado dentro da tabela ele vai percorrer pela tabela
        for (int i=0; i<BancoDadosGeral.getTabelaCartao().size();i++){
            
            //c recebe o cartao da posição i
            CartaoVenda c = BancoDadosGeral.getTabelaCartao().get(i);
            
            ////vai comparar os codigos do c e do codigo recebido pelo metodo para ver se são iguais
            if (c.getCodCartao()==codigo){
                //encontrando ele remove a tabela na posição i e retorna 1 pro controller
                BancoDadosGeral.getTabelaCartao().remove(i);
                return 1;
            }
        }
        
        //não estando vazia a tabela e não encontrando o cartao com o codigo informado, retorna zero para o controller
        return 0;
    }
    
    public CartaoVenda recuperaCartao (int codigo){ //Método para fornecer informação sobre um cartao específico
        
        //laço para pesquisar no banco geral o cartao com o codigo informado
        for (int i=0; i<BancoDadosGeral.getTabelaCartao().size(); i++){
            
            //objeto c recebe o cartao q consta na posição i da tabela geral
            CartaoVenda c = BancoDadosGeral.getTabelaCartao().get(i);
            
            //compara se o objeto c é igual o codigo informado a ser pesquisado, se sim ele retorna para o controller o cartão do objeto c
            if (c.getCodCartao()==codigo){
                return c;
            }
        }
        
        //caso não encontre o cartão com o código informado ele retorna null para o controller
        return null;
    }
    
    @Override
    public ArrayList<Object> retornaTudo(){ //Método para retornar todos os cartões do banco geral para o controller
        
        ArrayList<Object> lista = new ArrayList<Object>();
        
        //vai percorrer a tabela do banco de geral e adicionando cada cartao no objeto cartao e adicionando na array lista
        for (Object cartao : BancoDadosGeral.getTabelaCartao()) {
            lista.add(cartao);
        }
        
        //retornando lista para o controller
        return lista;
    }
    
}

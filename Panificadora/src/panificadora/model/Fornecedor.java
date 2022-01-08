package panificadora.model;

import java.io.Serializable;

//Essa classe é filha da classe Pessoa, assim erdando alguns metodos e atributos
public class Fornecedor extends Pessoa implements Serializable{
    //Definir os atributos da classe fornecedor
    private String CNPJ;
    private String NomeContato;
    
    public Fornecedor (){
        //Incializando os metodos definidos
        super();
        this.CNPJ="";
        this.NomeContato="";
        
    }
    //Metodo que retornar o CNPJ do fornecedor
    public String getCNPJ() {
        return this.CNPJ;
    }
    //Metodo que define o CNPJ do fornecedor
    public void setCNPJ(String CNPJ)throws Exception {
         if (CNPJ.equals(""))
            throw new Exception("O CNPJ não foi informado! Digite o CNPJ.");
        this.CNPJ = CNPJ;
    }
    //Metodo que retorna o Nome de contato no fornecedor
    public String getNomeContato() {
        return this.NomeContato;
    }
    //Metodo para definir o Nome de contato do fornecedor.
    public void setNomeContato(String NomeContato) {
        this.NomeContato = NomeContato;
    }
    
}

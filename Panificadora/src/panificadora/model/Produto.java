package panificadora.model;

import java.io.Serializable;


public class Produto implements Serializable{
    //Definindo os atributos da classe Produto.
    private int CodProd;
    private String Descricao;
    private double Valor;
    private String Tipo;
    private Fornecedor Fornecedor;
    private Funcionario Funcionario;
    
    public Produto(){
        //Inicialização dos atributos.
        this.CodProd=0;
        this.Descricao="";
        this.Valor=0;
        this.Tipo="";
        this.Fornecedor = new Fornecedor();
        this.Funcionario = new Funcionario();
        
    }
    //Metodo para retornar codigo do produto
    public int getCodProd() {
        return CodProd;
    }
    //Metodo para definir o codigo do produto.
    public void setCodProd(int CodProd) throws Exception {
        if (CodProd==0)
            throw new Exception("O Codigo do Produto não foi informado! Digite o Codigo.");
        this.CodProd = CodProd;
    }

    //Metodo para retornar a descricão do produto.
    public String getDescricao() {
        return Descricao;
    }
    //Metodo para inserir a descricao do item.
    public void setDescricao(String Descricao)throws Exception {
        if (Descricao.equals(""))
            throw new Exception("A descricao do Produto não foi informado! Digite a Descrição.");
        this.Descricao = Descricao;
    }
    //Metodo para retornar o valor do produto.
    public double getValor() {
        return Valor;
    }
    //Metodo para inserir o valor do produto.
    public void setValor(double Valor) throws Exception {
        if (Valor==0)
            throw new Exception("O Valor do Produto não foi informado! Digite o Valor.");
        this.Valor = Valor;
    }
    //Metodo para retornar o tipo do produto.
    public String getTipo() {
        return Tipo;
    }
    //Metodo para definir o tipo do produto.
    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    //Metodo para retornar o fornecedor do produto.
    public Fornecedor getFornecedor() {
        return Fornecedor;
    }
    //Metodo para definir o fornecedor do produto.
    public void setFornecedor(int Fornecedor) throws Exception { //recebe o codigo do fornecedor
        if (Fornecedor==0)
            throw new Exception("O Fordecedor do Produto não foi informado! Digite o Forcedor.");
        this.Fornecedor.setCodigo(Fornecedor);
    }
    //Metodo para retornar o funcionario que fezo cadastro do produto.
    public Funcionario getFuncionario() {
        return Funcionario;
    }
    //Metodo para definir o funcionario que fez o cadastro do produto.
    public void setFuncionario(int Funcionario) throws Exception{ //recebe o código do funcionario
        this.Funcionario.setCodigo(Funcionario);
    }
    
}

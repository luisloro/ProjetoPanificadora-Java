package panificadora.model;

import java.io.Serializable;
import java.util.Calendar;


public abstract class Pessoa implements Serializable{
    //Definindo atributos da classe pessoa.
    private int Codigo;
    private String Nome;
    private String Telefone;
    private String Endereco;
    private int Numero;
    private String Bairro;
    private String CEP;
    private String Cidade;
    private String UF;
    private Calendar Nascimento;
    
    public Pessoa(){
        //Inicialização dos atributos.
        this.Codigo=0;
        this.Nome="";
        this.Telefone="";
        this.Endereco="";
        this.Numero=0;
        this.Bairro="";
        this.CEP="";
        this.Cidade="";
        this.UF="";
        this.Nascimento=Calendar.getInstance();
        
    }
    //Metodo para definir data de nascimento.
    public void setNascimento(Calendar Nascimento){
        this.Nascimento=Nascimento;
    }
    //Metodo para retornar a data de nascimento.
    public Calendar getNascimento(){
        return this.Nascimento;
    }
    //Metodo para definir o codigo.
    public void setCodigo (int Codigo){
        this.Codigo=Codigo;
    }
    //Metodo para retornar o codigo da pessoa.
    public int getCodigo (){
        return this.Codigo;
    }
    //Metodo para definir o nome do objeto.
    public void setNome (String Nome) throws Exception{
        //Caso no cadastro o nome não seja defenido é enviado um aviso.
        if (Nome.equals(""))
            throw new Exception("O Nome não foi informado! Digite o nome.");
        this.Nome=Nome;
    }
    //Metodo para retornar o nome do objeto.
    public String getNome (){
        return this.Nome;
    }
    //Metodo para definir o telefone.
    public void setTelefone (String Telefone)throws Exception {
        //Caso no cadastro o telefone não seja defenido é enviado um aviso.
        if (Telefone.equals(""))
            throw new Exception("O Telefone não foi informado! Digite o Telefone.");
        
        this.Telefone=Telefone;
    }
    //Metodo para retornar o teledone ja armazenado.
    public String getTelefone (){
        return this.Telefone;
    }
    //Metodo para definir endereco.
    public void setEndereco (String Endereco) throws Exception {
        //Caso no cadastro o endereço não seja defenido é enviado um aviso.
        if (Endereco.equals(""))
           throw new Exception("O Enderço não foi informado! Digite o Enderço.");
        this.Endereco=Endereco;
    }
    //Metodo para retornar endereço.
    public String getEndereco (){
        return this.Endereco;
    }
    //Metodo para definir o numero da casa.
    public void setNumero (int Numero)throws Exception {
        //Caso no cadastro o numero da casa não seja defenido é enviado um aviso.
        if (Numero==0)
            throw new Exception("O Numero não foi informado! Digite o Numero.");
        this.Numero=Numero;
    }
    //Metodo para retornar numero da casa .
    public int getNumero (){
        return this.Numero;
    }
    //Metodo para definir o bairro do endereço informado.
    public void setBairro (String Bairro)throws Exception{
        //Caso no cadastro o bairro não seja defenido é enviado um aviso.
        if (Bairro.equals(""))
            throw new Exception("O Bairro não foi informado! Digite o nome.");
        this.Bairro=Bairro;
    }
    //Metodo para retornar o bairro.
    public String getBairro (){
        return this.Bairro;
    }
    //Metodo para definir o CEP do endereço.
    public void setCep (String CEP)throws Exception{
        //Caso no cadastro o CEP não seja defenido é enviado um aviso.
        if (CEP.equals(""))
           throw new Exception("O CEP não foi informado! Digite o CEP.");
        this.CEP=CEP;
    }
    //Metodo para retornar o CEP.
    public String getCep (){
        return this.CEP;
    }
    //Metodo para definir a cidade.
    public void setCidade (String Cidade){
       
        this.Cidade=Cidade;
    }
    //Metodo para retornar a cidade.
    public String getCidade (){
        return this.Cidade;
    }
    //Metodo para definir o estado do endenreço.
    public void setUF (String Uf){
       
        this.UF=Uf;
    }
    //Metodo para para retornar o estado.
    public String getUF (){
        return this.UF;
    }
    
}

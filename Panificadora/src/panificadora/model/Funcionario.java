package panificadora.model;

import java.io.Serializable;
import java.util.Calendar;

//Essa classe é filha da classe Pessoa, assim erdando alguns metodos e atributos
public class Funcionario extends Pessoa implements Serializable{
    //Definindo atributos da classe Funcionario.
    private String CPF;
    private String RG;
    private Calendar dataNascimento;
    private String Cargo;
    private double Salario;
    private Calendar Admissao;
    private Calendar Demissao;
    
    public Funcionario (){
        //Inicializando atributos definidos.
        super();
        this.CPF="";
        this.RG="";
        this.dataNascimento=null;
        this.Cargo="";
        this.Salario=0;
        this.Admissao=Calendar.getInstance();
        this.Demissao=null;
        
    }
    //Metodo para retornar o CPF desse objeto
    public String getCPF() {
        return this.CPF;
    }
    //Metodo para definir CPF
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    //Metodo para retornar o RG
    public String getRG() {
        return this.RG;
    }
    //Metodo para definir RG
    public void setRG(String RG) {
        this.RG = RG;
    }
    //Metodo para definir a data de nascimento
    public Calendar getDataNascimento() {
        return this.dataNascimento;
    }
    //Metodo para defirnir data de nascimento
    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    //Metodo para retornar para retornar o cargo do funcionario
    public String getCargo() {
        return this.Cargo;
    }
    //Metodo para definir o cardo do funcionario
    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }
    //Metodo para retornar o salario do funcionario
    public double getSalario() {
        return this.Salario;
    }
    //Metodo para definir o salario do funcionario
    public void setSalario(double Salario) {
        this.Salario = Salario;
    }
    //metodo para retornar a data de Admissão do funcionario
    public Calendar getAdmissao() {
        return this.Admissao;
    }
    //Metodo para definir a data de Admissão
    public void setAdmissao(Calendar Admissao) {
        this.Admissao = Admissao;
    }
    //Metodo para retornar a data de Demissão do funcionario
    public Calendar getDemissao() {
        return Demissao;
    }
    //Metodo para defirnir a data de demissão do funcionario
    public void setDemissao(Calendar Demissao) {
        this.Demissao = Demissao;
    }
    
}

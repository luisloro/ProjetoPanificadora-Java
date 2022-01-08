
package panificadora.model;

import java.util.Calendar;


public class ItemVenda {
    
    
    private double valor;
    private Produto produto;
    private CartaoVenda cartao;
    
    public ItemVenda(){
        
    }


    public double getValor() {
        return valor;
    }

    public void setValor(double valor) throws Exception{        
        if (valor <= 0)
            throw new Exception("valor da locação inválido! Informe o valor correto.");
        this.valor = valor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto Produto) throws Exception{
        if ((produto == null) && (produto.getCodProd() == 0))
            throw new Exception("Produto não informado!");
        this.produto = produto;
    }

    public CartaoVenda getCartaoVenda() {
        return cartao;
    }

    public void setCartaoVenda(CartaoVenda cartao) {
        this.cartao = cartao;
    }
    
}

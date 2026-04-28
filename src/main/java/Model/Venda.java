package Model;
import jakarta.persistence.*;
@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantidade;
    private Double precoTotal;

    @ManyToOne
    private Produto produto;

    public Venda(){

    }
    public Venda(Integer quantidade, Produto produto){
        this.quantidade = quantidade;
        this.produto = produto;
        this.precoTotal = quantidade * produto.getPrecoUnitario();

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}

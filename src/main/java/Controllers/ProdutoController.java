package Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Model.Produto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class ProdutoController {

    public List<Produto> produtos = new ArrayList<>();

    @PostMapping("/produtos")
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        produtos.add(produto);
        return ResponseEntity.ok(produto);
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> getProdutos() {
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable String id) {
        for (Produto produto : produtos) {
            if (produto.getId().equals(id)) {
                return ResponseEntity.ok(produto);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable String id, @RequestBody Produto produtoAtualizado) {
        for (Produto produto : produtos) {
            if (produto.getId().equals(id)) {
                produto.setNome(produtoAtualizado.getNome());
                produto.setPrecoUnitario(produtoAtualizado.getPrecoUnitario());
                produto.setQtdEstoque(produtoAtualizado.getQtdEstoque());
                produto.setCategoria(produtoAtualizado.getCategoria());

                return ResponseEntity.ok(produto);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable String id) {
        for (Produto produto : produtos) {
            if (produto.getId().equals(id)) {
                produtos.remove(produto);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}

package Controllers;

import Model.Categoria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Produto;

import java.util.List;

@RestController
@RequestMapping("api")
public class ProdutoController {

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> getProdutos() {
        List<Produto> produtos = List.of(
                new Produto("Produto A", 10.0, 10, new Categoria(1L, "Categoria 1")),
                new Produto("Produto B", 20.0, 5, new Categoria(2L, "Categoria 2")),
                new Produto("Produto C", 15.0, 8, new Categoria(1L, "Categoria 1"))
        );
        return ResponseEntity.ok(produtos);
    }
}

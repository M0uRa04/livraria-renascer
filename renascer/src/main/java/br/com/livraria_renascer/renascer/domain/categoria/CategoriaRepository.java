package br.com.livraria_renascer.renascer.domain.livro;

import br.com.livraria_renascer.renascer.domain.autor.Autor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LivroRepository extends JpaRepository <Autor, Long> {
}

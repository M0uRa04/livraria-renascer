package br.com.livraria_renascer.renascer.domain.livro;

import org.springframework.data.jpa.repository.JpaRepository;


public interface LivroRepository extends JpaRepository <Livro, Long> {
}

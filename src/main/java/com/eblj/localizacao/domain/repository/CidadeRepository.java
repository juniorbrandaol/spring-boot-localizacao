package com.eblj.localizacao.domain.repository;

import com.eblj.localizacao.domain.entity.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade,Long> {

    //busca pelo nome correto
    @Query(" select c from Cidade c where upper(c.nome) like upper(?1)")
    List<Cidade> findByNome(String nome);

    //busca pelas cidades com nomes começadas com o parametro
    List<Cidade> findByNomeStartingWith(String nome);

    //busca pelas cidades com nomes terminados com o parametro
    List<Cidade> findByNomeEndingWith(String nome);

    //busca pelas cidades que contem o parametro no nome
    List<Cidade> findByNomeContaining(String nome);

    /* faz a mesma coisa da busca por nomes (with,end e containe), em uma só função. Coloca o % na
     * passagem de parametros.
     * Sort serve para ordernar
     */
    @Query(" select c from Cidade c where upper(c.nome) like upper(?1)")
    List<Cidade> findByNomeLike(String nome, Sort sort);

    /* faz a mesma coisa da busca por nomes (with,end e containe), em uma só função. Coloca o % na
     * passagem de parametros.
     * PAGINADO
     */
    @Query(" select c from Cidade c where upper(c.nome) like upper(?1)")
    Page<Cidade> findByNomeLikePage(String nome, Pageable pageable);


    //busca pelo nome correto ignorando case
    List<Cidade> findByNomeIgnoreCase(String nome);


    //busca pelas cidades cujo parametro habitantes
    List<Cidade> findByHabitantes(Long habitantes);

    //busca cidades com habitantes menor que o parametro passado
    List<Cidade> findByHabitantesLessThan(Long habitantes);

    //busca cidade habitantes maior que o parametro passado
    List<Cidade> findByHabitantesGreaterThan(Long habitantes);

    //busca cidades com habitantes maior ou igual ao parametro passado
    List<Cidade> findByHabitantesGreaterThanEqual(Long habitantes);


    /*
     * podemos fazer concatenação de quaries caso necessário
     */

    //busca cidades com habitantes maior ou igual ao parametro passado e cujo nome
    //conincide com o parametro
    List<Cidade> findByHabitantesGreaterThanEqualAndNomeLike(Long habitantes,String nome);

}

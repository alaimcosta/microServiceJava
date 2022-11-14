package br.com.alaim.shoppingapi.repository;

import br.com.alaim.shoppingapi.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    //recupera todas as compras de um usuário específico
    public List<Shop> findAllByUserIdentifier(String userIdentifier);

    //busca as compras que tenham valor total > valor passado como parâmetro
    public List<Shop> findAllByTotalGreaterThan(Float total);

    //retorna todas as compras a partir de uma data específica
    List<Shop> findAllByDateGreaterThanEquals(Date date);


}

package br.com.alaim.shoppingapi.service;

import br.com.alaim.shoppingapi.dto.ShopDTO;
import br.com.alaim.shoppingapi.model.Shop;
import br.com.alaim.shoppingapi.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Permitir que o usuário faça compras
@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository; //chamo a interface Repository

    //método que retorna todas as compras
    public List<ShopDTO> getAll() {
        List<Shop> shops = shopRepository.findAll();
        return shops
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    //método que busca todas as compras de um determinado usuário
    public List<ShopDTO> getByUser(String userIdentifier) {
        List<Shop> shops = shopRepository.findAllByUserIdentifier(userIdentifier);
        return shops
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    //Método que busca todas as compras por data
    public List<ShopDTO> getByDate(ShopDTO shopDTO) {
        List<Shop> shops = shopRepository.findAllByDateGreaterThanEquals(shopDTO.getDate());
        return shops
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    //método que retorna uma compra pelo Id
    public ShopDTO findById(long ProductId) {
        Optional<Shop> shop = shopRepository.findById(ProductId);
        if(shop.isPresent()) {
            return ShopDTO.convert(shop.get());
        }
        return null;
    }

    //salvar uma compra
    public ShopDTO save(ShopDTO shopDTO) {

        shopDTO.setTotal(shopDTO.getItems()
                .stream()
                .map(x -> x.getPrice())
                .reduce((float) 0, Float::sum));

        Shop shop = Shop.convert(shopDTO);
        shop.setDate(new Date());

        shop = shopRepository.save(shop);
        return ShopDTO.convert(shop);
    }

}

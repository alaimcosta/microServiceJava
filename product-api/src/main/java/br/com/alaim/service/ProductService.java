package br.com.alaim.service;

import br.com.alaim.dto.ProductDTO;
import br.com.alaim.model.Product;
import br.com.alaim.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import br.com.alaim.exception.ProductNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//classe que implementará os serviço disponíveis
@Service
public class ProductService {

    @Autowired // permite a injeção automática de dependência
    private ProductRepository productRepository;

    //Retorna todos os produtos cadastrados
    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .map(ProductDTO::convert)
                .collect(Collectors.toList());
    }

    //Retorna todos os produtos de uma determinada categoria
    public List<ProductDTO> getProductByCategoryId(Long categoryId) {

        List<Product> products = productRepository.getProductByCategory(categoryId);
        return products
                .stream()
                .map(ProductDTO::convert)
                .collect(Collectors.toList());
    }

    //Retorno um produto pelo passando o Id
    public ProductDTO findByProductIdentifier(String productIdentifier) {

        Product product = productRepository.findByProductIdentifier(productIdentifier);
        if (product != null) {
            return ProductDTO.convert(product);
        }
        return null;
    }

    //Salvar um produto no banco de dados
    public ProductDTO save(ProductDTO productDTO) {
        Product product =
                productRepository.save(Product.convert(productDTO));
        return ProductDTO.convert(product);
    }

    //deletar um produto do banco de dados
    public void delete(long productId) {
        Optional<Product> product =
                productRepository.findById(productId);
        if(product.isPresent()){
            productRepository.delete(product.get());
        }
    }


}

package br.com.alaim.shoppingapi.dto;

import br.com.alaim.shoppingapi.model.Item;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ItemDTO {

    @NotBlank //@NotBlank não deve ser nulo e o comprimento aparado deve ser maior que zero.
    private String productIdentifier;
    @NotNull // Não permitirá valores nulos para os campos restritos. No entanto, os campos podem estar vazios.
    private Float price;

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public static ItemDTO convert(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setProductIdentifier(item.getProductIdentifier());
        itemDTO.setPrice(item.getPrice());
        return itemDTO;
    }
}

package br.com.alaim.shoppingapi.model;

import br.com.alaim.shoppingapi.dto.ItemDTO;

import javax.persistence.Embeddable;

            //indica que a classe poder ser embutida em uma entidade.
@Embeddable// A classe depende de uma outra que tenha anotação @Entity
public class Item {
    private String productIdentifier;
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

    public static Item convert(ItemDTO itemDTO) {
        Item item = new Item();
        item.setProductIdentifier(
                itemDTO.getProductIdentifier());
        item.setPrice(itemDTO.getPrice());
        return item;
    }

}

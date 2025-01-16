package dev.study.exam;

import java.util.ArrayList;
import java.util.List;

public record Order(
        int orderId,
        String customerName,
        List<Product> productList,
        double totalAmount
) {
    // "주문" 객체에 "상품"을 추가하는 메서드, 새롭게 만들어 줘
    public Order addProduct(Product product){
        List<Product> newProductList = new ArrayList<>(productList);
        newProductList.add(product);

        return new Order(orderId, customerName, newProductList, product.price() + totalAmount);
    }

}



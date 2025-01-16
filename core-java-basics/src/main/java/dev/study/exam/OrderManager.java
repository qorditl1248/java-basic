package dev.study.exam;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {

    private final List<Order> orderList = new ArrayList<>();
    private final List<Product> productList = new ArrayList<>();

    // 주문 추가
    public void addOrder(Order order) {
        orderList.add(order);
    }

    // 상품 추가
    public void addProduct(Product product) {
        productList.add(product);
    }

    // 주문 목록 (모든 주문 목록 출력)
    public void printAllOrders() {
        for (Order order : orderList) {
            System.out.println(
                    "주문번호" + order.orderId() +
                            ", 고객: " + order.customerName() +
                            ", 총 가격: " + order.totalAmount()
            );
            System.out.println("상품 목록: " + order.productList());
        }
    }

    // 형태 맞춰서 반환

    // 주문 검색 ("주문 번호를 기준"으로 특정 주문을 검색하는 메서드)
    public Order searchOrder(int orderId){
        for (Order order : orderList) {
            if(order.orderId() == orderId) {
                return order;
            }
        }
        System.out.println(orderId + "번 주문은 존재하지 않습니다.");
        return null;
    }

    // 상품 검색
    // 상품 이름으로 검색 - searchProduct(String name)
    public Product searchProduct(String name) {
        for(Product product : productList) {
            if(product.productName().equals(name)) { // product가 레코드 형식이여서 equals 오류가 날 수도 있음
                return product;
            }
        }
        System.out.println(name + "의 상품은 찾을 수 없습니다.");
        return null;
    }


    // 상품 이름과 가격으로 검색 - searchProdcut(String name, double price)
    public Product searchProduct(String name, double price) {
        for(Product product : productList) {
            if(product.productName().equals(name) && product.price() == price) {
               return product;
            }
        }
        System.out.println(name + "의 상품은 찾을 수 없습니다.");
        return null;
    }

}

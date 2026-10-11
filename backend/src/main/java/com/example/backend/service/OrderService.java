package com.example.backend.service;

import com.example.backend.dto.order.ItemRequest;
import com.example.backend.entity.Book;
import com.example.backend.entity.Order;
import com.example.backend.entity.OrderItem;
import com.example.backend.repository.BookRepository;
import com.example.backend.repository.OrderItemRepository;
import com.example.backend.repository.OrderRepository;
import com.example.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    private final BookRepository bookRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderService(BookRepository bookRepository, OrderRepository orderRepository, UserRepository userRepository, OrderItemRepository orderItemRepository) {
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Transactional
    public void order(String username, List<ItemRequest> items) {

        // Lấy userId
        final int userId = userRepository.findByUsername(username).getId();
        System.out.println(3);


        // tạo trong bảng orders
        final Order order = new Order(
                0,
                userId,
                0,
                "PENDING",
                "Hanoi",
                "0987654321"
        );
        orderRepository.createOrder(order);
        System.out.println(4);

        // tạo trong bảng order_items
        // for items: repo.createItem(orderId, bookId)
        // tính tổng giá đơn hàng
        int currentTotalAmount = 0;
        for (final ItemRequest item: items) {

            final Book book = bookRepository.getBookById(item.getBookId());
            System.out.println(5);

            // Giảm stock bảng books
            final int newStock = book.getStock() - item.getQuantity();
            book.setStock(newStock);

            bookRepository.saveBook(book);
            System.out.println(6);

            final OrderItem orderItem = new OrderItem(
                    order.getId(),
                    item.getBookId(),
                    item.getQuantity(),
                    book.getPrice()
            );

            orderItemRepository.createOrderItem(orderItem);
            System.out.println(7);

            // cap nhat amount
            currentTotalAmount += orderItem.getUnitPrice() * orderItem.getQuantity();
        }

        // cap nhat total amount
        order.setTotalAmount(currentTotalAmount);
        orderRepository.saveOrder(order);
        System.out.println(8);
    }
}

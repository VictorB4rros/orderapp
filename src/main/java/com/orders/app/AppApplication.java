package com.orders.app;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.orders.app.entities.Order;
import com.orders.app.services.OrderService;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {
	
	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insira o código do pedido:");
		Integer code = sc.nextInt();
		System.out.println("Insira o valor básico:");
		Double basic = sc.nextDouble();
		System.out.println("Insira a porcentagem de desconto:");
		Double discount = sc.nextDouble();
		
		Order order = new Order(code, basic, discount);
		
		System.out.println();
		System.out.println("Pedido código " + order.getCode());
		System.out.println("Valor total: R$ " + String.format("%.2f", orderService.total(order)));
		sc.close();
	}
}

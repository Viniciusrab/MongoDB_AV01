package com.iftm.edu.br.system_tests;

import com.iftm.edu.br.product_api.models.dto.ProductDTO;
import com.iftm.edu.br.shopping_api.models.dto.ShoppingDTO;
import com.iftm.edu.br.user_api.models.dto.UserDTO;

import java.util.Arrays;
import java.util.List;

public class SystemIntegrationTest {
    public static void main(String[] args) {
        System.out.println("==== Início dos Testes de Integração ====");

        // Teste de CRUD - Produto
        ProductDTO product = new ProductDTO("1", "Smartphone", "Smartphone Samsung Galaxy", 1500.00);
        System.out.println("Produto Criado: " + product);
        product.setPrice(1400.00);
        System.out.println("Produto Atualizado: " + product);

        // Teste de CRUD - Usuário
        UserDTO user = new UserDTO();
        user.setId("u101");
        user.setName("João Silva");
        user.setCpf("123.456.789-10");
        user.setEmail("joao.silva@example.com");
        System.out.println("Usuário Criado: " + user);

        user.setName("João Souza");
        user.setCpf("987.654.321-00");
        System.out.println("Usuário Atualizado: " + user);

        // Teste de CRUD - Compra
        List<String> productIds = Arrays.asList("1", "2", "3");
        ShoppingDTO shopping = new ShoppingDTO("s202", user.getId(), productIds, 4500.00);
        System.out.println("Compra Criada: " + shopping);

        shopping.setTotal(4300.00);
        System.out.println("Compra Atualizada: " + shopping);

        // Simulação de integração entre APIs
        if (shopping.getUserId().equals(user.getId()) && shopping.getProductIds().contains(product.getId())) {
            System.out.println("Integração entre APIs válida.");
        } else {
            System.out.println("Falha na integração entre APIs.");
        }

        System.out.println("==== Testes de Integração Finalizados ====");
    }
}

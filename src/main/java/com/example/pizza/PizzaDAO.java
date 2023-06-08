package com.example.pizza;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class PizzaDAO {
    public List<Pizza> getListePizzas() {
        List<Pizza> pizzas = new ArrayList<>();

        try {
            Class.forName(" com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/aloui7u_Pizza", "aloui7u_appli", "31825951");
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM pizza");

             while (rs.next()) {
                String recette = rs.getString("recette");
                double prix = rs.getDouble("prix");
                int nbIngredients = rs.getInt("nombre_ingredients");

                Pizza pizza = new Pizza(recette, prix, nbIngredients);
                pizzas.add(pizza);
            }
             con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return pizzas;
    }

    public void ajouterPizza(Pizza pizza) {
        try {

            Class.forName(" com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/aloui7u_Pizza", "aloui7u_appli", "31825951");
            PreparedStatement stmt = con.prepareStatement("INSERT INTO pizza (nom, prix, nombre_ingredients) VALUES (?, ?, ?)");

            stmt.setString(1, pizza.getRecette());
            stmt.setDouble(2, pizza.getPrix());
            stmt.setInt(3, pizza.getNbIngredients());

            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void viderPizzas(Integer id) {
        try {

            Class.forName(" com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/aloui7u_Pizza", "aloui7u_appli", "31825951");
             PreparedStatement Stmt = con.prepareStatement("DELETE FROM pizza");
             Stmt.setInt(1,id);
             Stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

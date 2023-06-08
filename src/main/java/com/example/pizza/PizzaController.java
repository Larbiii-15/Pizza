package com.example.pizza;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class PizzaController {
    @FXML
    private TableView<Pizza> tablePizzas;
    @FXML
    private TableColumn<Pizza, String> recetteColumn;
    @FXML
    private TableColumn<Pizza, Double> prixColumn;
    @FXML
    private TableColumn<Pizza, Integer> nbIngredientsColumn;
    @FXML
    private TextField recetteField;
    @FXML
    private TextField prixField;
    @FXML
    private TextField nbIngredientsField;
    @FXML
    private Button ajouterButton;
    @FXML
    private Button viderButton;

    private List<Pizza> listePizzas;

    @FXML
    public void initialize() {
        // Initialise la liste des pizzas
        listePizzas = getListePizzas();
        PizzaDAO pizza = new PizzaDAO();
        pizza.ajouterPizza(new Pizza("Margritta", 13.0, 3));

        // Lie les colonnes de la table aux propriétés de la classe Pizza
        recetteColumn.setCellValueFactory(cellData -> cellData.getValue().recetteProperty());
        prixColumn.setCellValueFactory(cellData -> cellData.getValue().prixProperty().asObject());
        nbIngredientsColumn.setCellValueFactory(cellData -> cellData.getValue().nbIngredientsProperty().asObject());

        // Ajoute les pizzas à la table
        tablePizzas.getItems().addAll(listePizzas);

    }

    private List<Pizza> getListePizzas() {
        // À remplacer avec votre logique de récupération des pizzas depuis la base de données
        List<Pizza> pizzas = new ArrayList<>();
        // Exemple de création de pizzas pour les tests
        pizzas.add(new Pizza("Pizza Margherita", 9.99, 5));
        pizzas.add(new Pizza("Pizza Pepperoni", 10.99, 7));
        pizzas.add(new Pizza("Pizza Hawaii", 11.99, 8));
        return pizzas;
    }
@FXML
    private void ajouterPizza() {
        String recette = recetteField.getText();
        double prix = Double.parseDouble(prixField.getText());
        int nbIngredients = Integer.parseInt(nbIngredientsField.getText());

        Pizza pizza = new Pizza(recette, prix, nbIngredients);
        tablePizzas.getItems().add(pizza);

        // À remplacer avec votre logique d'ajout de la pizza dans la base de données

        // Efface les champs de saisie
        recetteField.clear();
        prixField.clear();
        nbIngredientsField.clear();
    }
@FXML
    private void viderPizzas() {
        tablePizzas.getItems().clear();

        // À remplacer avec votre logique de suppression de toutes les pizzas dans la base de données
    }
}

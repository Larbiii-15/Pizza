package com.example.pizza;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pizza {
    private StringProperty recette;
    private DoubleProperty prix;
    private IntegerProperty nbIngredients;

    public Pizza(String recette, double prix, int nbIngredients) {
        this.recette = new SimpleStringProperty(recette);
        this.prix = new SimpleDoubleProperty(prix);
        this.nbIngredients = new SimpleIntegerProperty(nbIngredients);
    }

    public String getRecette() {
        return recette.get();
    }

    public void setRecette(String recette) {
        this.recette.set(recette);
    }

    public StringProperty recetteProperty() {
        return recette;
    }

    public double getPrix() {
        return prix.get();
    }

    public void setPrix(double prix) {
        this.prix.set(prix);
    }

    public DoubleProperty prixProperty() {
        return prix;
    }

    public int getNbIngredients() {
        return nbIngredients.get();
    }

    public void setNbIngredients(int nbIngredients) {
        this.nbIngredients.set(nbIngredients);
    }

    public IntegerProperty nbIngredientsProperty() {
        return nbIngredients;
    }
}

package com.udemy.Teste.Book.Category;



public class Category {

    private String label;



    public Category(String label) {
        this.label = label;
	}


	/**
     * @return String return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

}
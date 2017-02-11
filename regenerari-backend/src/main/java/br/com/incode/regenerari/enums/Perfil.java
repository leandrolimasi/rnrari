package br.com.incode.regenerari.enums;

/**
 * Created by marcelolimabh on 10/01/17.
 */
public enum Perfil {

    ADMIN("Admin"), GERENTE("Gerente"), VENDEDOR("Vendedor");

    private String label;


    Perfil(String label){
        this.label = label;
    }

    /**
     * @return the label
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

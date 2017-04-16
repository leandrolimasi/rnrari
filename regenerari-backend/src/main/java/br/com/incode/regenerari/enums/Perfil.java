package br.com.incode.regenerari.enums;

/**
 * Created by leandrolima on 10/01/17.
 */
public enum Perfil {

    ADMIN("Admin"),
    USUARIO("Usuário");

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

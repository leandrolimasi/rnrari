package br.com.incode.regenerari.enums;

/**
 * Created by leandrolima on 20/02/17.
 */
public enum UnidadeMedidaProduto {

    GRAMA("Grama"),
    ML("Mililitro"),
    UNIDADE("Unidade");


    private String label;


    UnidadeMedidaProduto(String label){
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

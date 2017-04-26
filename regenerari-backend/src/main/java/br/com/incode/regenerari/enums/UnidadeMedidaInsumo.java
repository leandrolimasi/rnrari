package br.com.incode.regenerari.enums;

/**
 * Created by leandrolima on 10/01/17.
 */
public enum UnidadeMedidaInsumo {

    GR("Grama"),
    MEIO("Meio"),
    ML("Mililitro"),
    QUARTO("Quarto"),
    TERCO("Terço"),
    UN("Unidade");


    private String label;


    UnidadeMedidaInsumo(String label){
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

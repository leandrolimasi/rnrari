package br.com.incode.regenerari.enums;

/**
 * Created by leandrolima on 10/01/17.
 */
public enum UnidadeMedidaInsumo {

    GRAMA("Grama"),
    ML("Mililitro"),
    UNIDADE("Unidade"),
    QUARTO("Quarto"),
    MEIO("Meio"),
    TERCO("Terço");


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

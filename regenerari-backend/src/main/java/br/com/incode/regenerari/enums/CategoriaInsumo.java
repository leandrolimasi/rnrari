package br.com.incode.regenerari.enums;

/**
 * Created by leandrolima on 10/01/17.
 */
public enum CategoriaInsumo {

    CASTANHA("Castanha"),
    EMBALAGEM("Embalagem"),
    ERVA("Erva"),
    EXTRATO("Extrato"),
    FRUTA_FRESCA("Fruta Fresca"),
    FRUTA_SECA("Fruta Seca"),
    LACRE("Lacre"),
    LEGUME("Legume"),
    POLPA("Polpa"),
    ROTULO("Rotulo"),
    SEMENTE("Semente"),
    TAMPA("Tampa"),
    TEMPERO("Tempero"),
    TAG_FLYER("Tag ou Flyer"),
    VERDURA("Verdume"),
    VASILHAME("Vasilhame");


    private String label;


    CategoriaInsumo(String label){
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

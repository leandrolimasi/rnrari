package br.com.incode.regenerari.enums;

/**
 * Created by leandrolima on 10/01/17.
 */
public enum Categoria {

    VASILHAME("Vasilhame"),
    EMBALAGEM("Embalagem"),
    TAMPA("Tampa"),
    LACRE("Lacre"),
    ROTULO("Rotulo"),
    TAG_FLYER("Tag ou Flyer"),
    VERDURA("Verdume"),
    ERVA("Erva"),
    LEGUME("Legume"),
    FRUTA_FRESCA("Fruta Fresca"),
    FRUTA_SECA("Fruta Seca"),
    CASTANHA("Castanha"),
    SEMENTE("Semente"),
    POLPA("Polpa"),
    TEMPERO("Tempero"),
    EXTRATO("Extrato");


    private String label;


    Categoria(String label){
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

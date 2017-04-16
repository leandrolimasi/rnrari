package br.com.incode.regenerari.enums;

/**
 * Created by leandrolima on 20/02/17.
 */
public enum CategoriaProduto {

    BEBIDA_FERM("Bebida Fermentada"),
    BEBIDA_FERM_ORG("Bebida Fermentada Orgânico"),
    ELIXIR("Elixir"),
    EXTRATO("Extrato"),
    PASTOSO_FERM("Pastoso Fermentada"),
    PASTOSO_FERM_ORG("Pastoso Fermentada Orgânico"),
    PRESCRITO("Prescrito"),
    SHAKE("Shake"),
    SHOT("Shot"),
    SUCO_FUNC("Suco Funcional"),
    SUCO_FUNC_ORG("Suco Funcional Orgânico"),
    SUCO_RECR("Suco Recr"),
    SUCO_RECR_ORG("Suco Recr Orgânico");


    private String label;


    CategoriaProduto(String label){
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

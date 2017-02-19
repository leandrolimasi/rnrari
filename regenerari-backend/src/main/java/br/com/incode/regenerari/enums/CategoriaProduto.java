package br.com.incode.regenerari.enums;

/**
 * Created by leandrolima on 20/02/17.
 */
public enum CategoriaProduto {

    SUCO_FUNC("Suco Func"),
    SUCO_FUNC_ORG("Suco Func Org"),
    SUCO_RECR("Suco Recr"),
    SUCO_RECR_ORG("Suco Recr Org"),
    BEBIDA_FERM("Bebida Ferm"),
    BEBIDA_FERM_ORG("Bebida Ferm Org"),
    SHOT("Shot"),
    ELIXIR("Elixir"),
    EXTRATO("Extrato"),
    SHAKE("Shake"),
    PASTOSO_FERM("Pastoso Ferm"),
    PASTOSO_FERM_ORG("Pastoso Ferm Org"),
    PRESCRITO("Prescrito");


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

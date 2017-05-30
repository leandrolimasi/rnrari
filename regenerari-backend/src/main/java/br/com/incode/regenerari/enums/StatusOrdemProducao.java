package br.com.incode.regenerari.enums;

/**
 * Created by leandrolima on 29/05/17.
 */
public enum StatusOrdemProducao {

    CANCELADA("Cancelada"),
    INICIADA("Iniciada"),
    FALTA_INSUMO("Venda Direta"),
    FINALIZADA("Finalizada"),
    NA_FILA("Na Fila");

    private String label;


    StatusOrdemProducao(String label){
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

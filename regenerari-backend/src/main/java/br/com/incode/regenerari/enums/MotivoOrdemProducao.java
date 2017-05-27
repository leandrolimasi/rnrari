package br.com.incode.regenerari.enums;

/**
 * Created by leandrolima on 26/05/17.
 */
public enum MotivoOrdemProducao {

    REPOSICAO_ESTOQUE("Reposição Estoque"),
    AVALIACAO("Avaliação"),
    VENDA_DIRETA("Venda Direta");

    private String label;


    MotivoOrdemProducao(String label){
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

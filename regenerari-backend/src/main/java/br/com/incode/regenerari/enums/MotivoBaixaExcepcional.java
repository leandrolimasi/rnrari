package br.com.incode.regenerari.enums;

/**
 * Created by leandrolima on 16/04/17.
 */
public enum MotivoBaixaExcepcional {

    CONSUMO_INTERNO("Consumo Interno"),
    DETERIORACAO("Deterioração"),
    DIFERENCA("Diferença"),
    EMPRESTIMO("Empréstimo"),
    ERRO_DIGITACAO("Erro Digitação");


    private String label;


    MotivoBaixaExcepcional(String label){
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

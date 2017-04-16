package br.com.incode.regenerari.enums;

/**
 * Created by leandrolima on 16/04/17.
 */
public enum EventoEstoque {

    AJUSTE("Ajuste"),
    ENTRADA("Entrada"),
    PRODUCAO("Produção");

    private String label;


    EventoEstoque(String label){
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

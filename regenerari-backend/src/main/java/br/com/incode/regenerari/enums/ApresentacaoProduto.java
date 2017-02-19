package br.com.incode.regenerari.enums;

/**
 * Created by leandrolima on 20/02/17.
 */
public enum ApresentacaoProduto {


    GARRAFA_VIDRO("Garrafa Vidro"),
    GARRAFA_PLASTICO("Garrafa Plástico"),
    POTE_VIDRO("Pote Vidro"),
    POTE_PLASTICO("Pote Plásticog"),
    SACO_PLASTICO("Saco Plástico"),
    CAIXA_PAPEL("Caixa Papel");


    private String label;


    ApresentacaoProduto(String label){
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

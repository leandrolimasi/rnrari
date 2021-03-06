package br.com.incode.regenerari.enums;

/**
 * Created by leandrolima on 20/02/17.
 */
public enum ApresentacaoProduto {

    CAIXA_PAPEL("Caixa Papel"),
    GARRAFA_PLASTICO("Garrafa Plástico"),
    GARRAFA_VIDRO("Garrafa Vidro"),
    POTE_PLASTICO("Pote Plásticog"),
    POTE_VIDRO("Pote Vidro"),
    SACO_PLASTICO("Saco Plástico");


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

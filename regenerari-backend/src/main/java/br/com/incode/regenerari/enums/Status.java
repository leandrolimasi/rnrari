package br.com.incode.regenerari.enums;

/**
 * Created by leandrolimadasilva on 21/12/16.
 */
public enum Status {


    ATIVO("Ativo"),
    INATIVO("Inativo");
    private String label;

    Status(String label){
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

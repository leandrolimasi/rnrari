package br.com.incode.regenerari.entity;

import br.com.incode.regenerari.listener.AuditListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by leandrolimadasilva on 10/07/17.
 */
@Entity
@Table(name = "NUMERO_ORDEM_PRODUCAO")
@Access(AccessType.FIELD)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@EntityListeners(AuditListener.class)
@SequenceGenerator(name = "SE_NUMERO_ORDEM_PRODUCAO", sequenceName = "SE_NUMERO_ORDEM_PRODUCAO")
public class NumeroOrdemProducaoEntity extends AppBaseEntity {

    /** atributo chave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_NUMERO_ORDEM_PRODUCAO")
    @Column(name = "ID_NUMERO_ORDEM_PRODUCAO", unique = true, nullable = false)
    private Long id;

    @Column(name = "NUMERO", nullable = false)
    @NotNull
    private Integer numero;

    @Column(name = "STAMP", nullable = false)
    @NotNull
    private String stamp;

    /**
     * @return the id
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @return the stamp
     */
    public String getStamp() {
        return stamp;
    }

    /**
     * @param stamp the stamp to set
     */
    public void setStamp(String stamp) {
        this.stamp = stamp;
    }
}

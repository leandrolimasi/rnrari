package br.com.incode.regenerari.entity;

import br.com.incode.regenerari.enums.MotivoBaixaExcepcional;
import br.com.incode.regenerari.listener.AuditListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by leandrolimadasilva on 12/04/17.
 */
@Entity
@Table(name = "BAIXA_INSUMO_EXCEPCIONAL")
@Access(AccessType.FIELD)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@EntityListeners(AuditListener.class)
@SequenceGenerator(name = "SE_BAIXA_INSUMO_EXCEPCIONAL", sequenceName = "SE_BAIXA_INSUMO_EXCEPCIONAL")
public class BaixaInsumoExcepcionalEntity extends AppBaseEntity {

    /** atributo chave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_BAIXA_INSUMO_EXCEPCIONAL")
    @Column(name = "ID_BAIXA_INSUMO_EXCEPCIONAL", unique = true, nullable = false)
    private Long id;

    @NotNull
    @ManyToOne (targetEntity = InsumoEntity.class)
    @JoinColumn(name = "ID_INSUMO")
    private InsumoEntity insumo;

    @NotNull
    @Column(name = "QUANTIDADE", precision = 15, scale = 3)
    private BigDecimal quantidade;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA")
    private Date data;

    @Enumerated(EnumType.STRING)
    @Column(name = "MOTIVO_BAIXA_EXCEPCIONAL", length = 30)
    private MotivoBaixaExcepcional motivoBaixaExcepcional;

    @Size(max = 400)
    @Column(name = "OBSERVACAO", length = 400)
    private String observacao;


    /**
     * Default
     */
    public BaixaInsumoExcepcionalEntity(){}

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
     * @return the insumo
     */
    public InsumoEntity getInsumo() {
        return insumo;
    }

    /**
     * @param insumo the insumo to set
     */
    public void setInsumo(InsumoEntity insumo) {
        this.insumo = insumo;
    }

    /**
     * @return the quantidade
     */
    public BigDecimal getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the motivoBaixaExcepcional
     */
    public MotivoBaixaExcepcional getMotivoBaixaExcepcional() {
        return motivoBaixaExcepcional;
    }

    /**
     * @param motivoBaixaExcepcional the motivoBaixaExcepcional to set
     */
    public void setMotivoBaixaExcepcional(MotivoBaixaExcepcional motivoBaixaExcepcional) {
        this.motivoBaixaExcepcional = motivoBaixaExcepcional;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }
}

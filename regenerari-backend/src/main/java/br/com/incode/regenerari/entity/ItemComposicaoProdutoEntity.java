package br.com.incode.regenerari.entity;

import br.com.incode.regenerari.listener.AuditListener;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by leandrolimadasilva on 20/02/17.
 */
@Entity
@Table(name = "ITEM_COMPOSICAO_PRODUTO")
@Access(AccessType.FIELD)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@EntityListeners(AuditListener.class)
@SequenceGenerator(name = "SE_ITEM_COMPOSICAO_PRODUTO", sequenceName = "SE_ITEM_COMPOSICAO_PRODUTO")
public class ItemComposicaoProdutoEntity extends AppBaseEntity {

    /** atributo chave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_ITEM_COMPOSICAO_PRODUTO")
    @Column(name = "ID_ITEM_COMPOSICAO_PRODUTO", unique = true, nullable = false)
    private Long id;

    @ManyToOne (targetEntity = InsumoEntity.class)
    @JoinColumn(name = "ID_INSUMO")
    @NotNull(message = "O campo 'Insumo' é obrigatório.")
    private InsumoEntity insumo;

    @NotNull(message = "O campo 'Quantidade Insumo' é obrigatório.")
    @Column(name = "QUANTIDADE_INSUMO")
    private Integer quantidadeInsumo;

    @Column(name = "OBSERVACAO")
    @Size(max = 80)
    @NotBlank(message = "O campo 'Observação' é obrigatório.")
    private String observacao;

    @XmlTransient
    @ManyToOne (targetEntity = ComposicaoProdutoEntity.class)
    @JoinColumn(name = "ID_COMPOSICAO_PRODUTO")
    private ComposicaoProdutoEntity composicaoProduto;

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
     * @return the quantidadeInsumo
     */
    public Integer getQuantidadeInsumo() {
        return quantidadeInsumo;
    }

    /**
     * @param quantidadeInsumo the quantidadeInsumo to set
     */
    public void setQuantidadeInsumo(Integer quantidadeInsumo) {
        this.quantidadeInsumo = quantidadeInsumo;
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
     * @return the composicaoProduto
     */
    public ComposicaoProdutoEntity getComposicaoProduto() {
        return composicaoProduto;
    }

    /**
     * @param composicaoProduto the composicaoProduto to set
     */
    public void setComposicaoProduto(ComposicaoProdutoEntity composicaoProduto) {
        this.composicaoProduto = composicaoProduto;
    }
}

package br.com.incode.regenerari.entity;

import br.com.incode.regenerari.enums.EventoEstoque;
import br.com.incode.regenerari.listener.AuditListener;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Created by leandrolimadasilva on 06/06/17.
 */
@Entity
@Audited
@Table(name = "POSICAO_ESTOQUE_PRODUTO")
@Access(AccessType.FIELD)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@EntityListeners(AuditListener.class)
@SequenceGenerator(name = "SE_POSICAO_ESTOQUE_PRODUTO", sequenceName = "SE_POSICAO_ESTOQUE_PRODUTO")
public class PosicaoEstoqueProdutoEntity extends AppBaseEntity {

    /** atributo chave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_POSICAO_ESTOQUE_PRODUTO")
    @Column(name = "ID_POSICAO_ESTOQUE_PRODUTO", unique = true, nullable = false)
    private Long id;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @NotNull
    @ManyToOne (targetEntity = ProdutoEntity.class)
    @JoinColumn(name = "ID_PRODUTO")
    private ProdutoEntity produto;

    @NotNull
    @Column(name = "QUANTIDADE", precision = 15, scale = 3)
    private BigDecimal quantidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "EVENTO", length = 10)
    private EventoEstoque eventoEstoque;


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
     * @return the produto
     */
    public ProdutoEntity getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(ProdutoEntity produto) {
        this.produto = produto;
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
     * @return the eventoEstoque
     */
    public EventoEstoque getEventoEstoque() {
        return eventoEstoque;
    }

    /**
     * @param eventoEstoque the eventoEstoque to set
     */
    public void setEventoEstoque(EventoEstoque eventoEstoque) {
        this.eventoEstoque = eventoEstoque;
    }
}

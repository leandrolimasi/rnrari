package br.com.incode.regenerari.entity;

import br.com.incode.regenerari.enums.MotivoOrdemProducao;
import br.com.incode.regenerari.enums.StatusOrdemProducao;
import br.com.incode.regenerari.listener.AuditListener;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by leandrolimadasilva on 24/05/17.
 */
@Entity
@Table(name = "ORDEM_PRODUCAO")
@Access(AccessType.FIELD)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@EntityListeners(AuditListener.class)
@SequenceGenerator(name = "SE_ORDEM_PRODUCAO", sequenceName = "SE_ORDEM_PRODUCAO")
public class OrdemProducaoEntity extends AppBaseEntity {

    /** atributo chave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_ORDEM_PRODUCAO")
    @Column(name = "ID_ORDEM_PRODUCAO", unique = true, nullable = false)
    private Long id;

    @Column(name = "NUMERO", nullable = false)
    @Size(max = 18)
    @NotBlank(message = "O campo 'Número' é obrigatório.")
    private String numero;

    @ManyToOne (targetEntity = ProdutoEntity.class)
    @JoinColumn(name = "PRODUTO", nullable = false)
    @NotNull(message = "O campo 'Produto' é obrigatório.")
    private ProdutoEntity produto;

    @Column(name = "QUANTIDADE", nullable = false, precision = 15, scale = 2)
    @NotNull(message = "O campo 'Quantidade' é obrigatório.")
    private BigDecimal quantidade;

    @Column(name = "DATA_LIMITE", nullable = false)
    @NotNull(message = "O campo 'Data Limite' é obrigatório.")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataLimite;

    @Column(name = "DATA_GERACAO", nullable = false)
    @NotNull(message = "O campo 'Data Geração' é obrigatório.")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataGeracao;

    @Enumerated(EnumType.STRING)
    @Column(name = "MOTIVO_ORDEM_PRODUCAO", nullable = false)
    @NotNull(message = "O campo 'Motivo' é obrigatório.")
    private MotivoOrdemProducao motivoOrdemProducao;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_ORDEM_PRODUCAO", nullable = false)
    @NotNull(message = "O campo 'Status' é obrigatório.")
    private StatusOrdemProducao statusOrdemProducao;

    @ManyToOne (targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "USUARIO_GERACAO")
    private UsuarioEntity usuarioGeracao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_STATUS")
    private Date dataStatus;

    @ManyToOne (targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "USUARIO_STATUS")
    private UsuarioEntity usuarioStatus;

    /* Trasients */

    @Transient
    private String statusOrdemProducaoDescricao;

    @Transient
    private String motivoOrdemProducaoDescricao;

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
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
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
     * @return the dataLimite
     */
    public Date getDataLimite() {
        return dataLimite;
    }

    /**
     * @param dataLimite the dataLimite to set
     */
    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
    }

    /**
     * @return the dataGeracao
     */
    public Date getDataGeracao() {
        return dataGeracao;
    }

    /**
     * @param dataGeracao the dataGeracao to set
     */
    public void setDataGeracao(Date dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    /**
     * @return the motivoOrdemProducao
     */
    public MotivoOrdemProducao getMotivoOrdemProducao() {
        return motivoOrdemProducao;
    }

    /**
     * @param motivoOrdemProducao the motivoOrdemProducao to set
     */
    public void setMotivoOrdemProducao(MotivoOrdemProducao motivoOrdemProducao) {
        this.motivoOrdemProducao = motivoOrdemProducao;
    }

    /**
     * @return the usuarioGeracao
     */
    public UsuarioEntity getUsuarioGeracao() {
        return usuarioGeracao;
    }

    /**
     * @param usuarioGeracao the usuarioGeracao to set
     */
    public void setUsuarioGeracao(UsuarioEntity usuarioGeracao) {
        this.usuarioGeracao = usuarioGeracao;
    }

    /**
     * @return the dataStatus
     */
    public Date getDataStatus() {
        return dataStatus;
    }

    /**
     * @param dataStatus the dataStatus to set
     */
    public void setDataStatus(Date dataStatus) {
        this.dataStatus = dataStatus;
    }

    /**
     * @return the usuarioStatus
     */
    public UsuarioEntity getUsuarioStatus() {
        return usuarioStatus;
    }

    /**
     * @param usuarioStatus the usuarioStatus to set
     */
    public void setUsuarioStatus(UsuarioEntity usuarioStatus) {
        this.usuarioStatus = usuarioStatus;
    }

    /**
     * @return the statusOrdemProducao
     */
    public StatusOrdemProducao getStatusOrdemProducao() {
        return statusOrdemProducao;
    }

    /**
     * @param statusOrdemProducao the statusOrdemProducao to set
     */
    public void setStatusOrdemProducao(StatusOrdemProducao statusOrdemProducao) {
        this.statusOrdemProducao = statusOrdemProducao;
    }

    /**
     * @return the statusOrdemProducaoDescricao
     */
    public String getStatusOrdemProducaoDescricao() {
        return statusOrdemProducaoDescricao;
    }

    /**
     * @param statusOrdemProducaoDescricao the statusOrdemProducaoDescricao to set
     */
    public void setStatusOrdemProducaoDescricao(String statusOrdemProducaoDescricao) {
        this.statusOrdemProducaoDescricao = statusOrdemProducaoDescricao;
    }

    /**
     * @return the motivoOrdemProducaoDescricao
     */
    public String getMotivoOrdemProducaoDescricao() {
        return motivoOrdemProducaoDescricao;
    }

    /**
     * @param motivoOrdemProducaoDescricao the motivoOrdemProducaoDescricao to set
     */
    public void setMotivoOrdemProducaoDescricao(String motivoOrdemProducaoDescricao) {
        this.motivoOrdemProducaoDescricao = motivoOrdemProducaoDescricao;
    }
}

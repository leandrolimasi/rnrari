package br.com.incode.regenerari.entity;

import br.com.incode.regenerari.listener.AuditListener;
import com.powerlogic.jcompany.core.model.domain.PlcSituacao;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

/**
 * Created by leandrolimadasilva on 20/02/17.
 */
@Entity
@Table(name = "COMPOSICAO_PRODUTO")
@Access(AccessType.FIELD)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@EntityListeners(AuditListener.class)
@SequenceGenerator(name = "SE_COMPOSICAO_PRODUTO", sequenceName = "SE_COMPOSICAO_PRODUTO")
@NamedQueries({@NamedQuery(
        name = "ComposicaoProdutoEntity.findComposicaoByInsumo",
        query = "SELECT c from ComposicaoProdutoEntity c " +
                "left join c.itemComposicaoProduto itemComposicaoProduto " +
                "where itemComposicaoProduto.insumo.id = :idInsumo " +
                "order by c.id asc"
)})
public class ComposicaoProdutoEntity extends AppBaseEntity {

    /** atributo chave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_COMPOSICAO_PRODUTO")
    @Column(name = "ID_COMPOSICAO_PRODUTO", unique = true, nullable = false)
    private Long id;

    @ManyToOne (targetEntity = ProdutoEntity.class)
    @NotNull(message = "O campo 'Produto' é obrigatório.")
    @JoinColumn(name = "ID_PRODUTO")
    private ProdutoEntity produto;

    @Column(name = "COMPOSICAO_EXPERIMENTAL")
    private Boolean composicaoExperimental;

    @NotNull(message = "O campo 'Rendimento' é obrigatório.")
    @Column(name = "RENDIMENTO")
    private Integer rendimento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_CRIACAO")
    private Date dataCriacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private PlcSituacao situacao;

    @ManyToOne (targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "USUARIO_CRIACAO")
    private UsuarioEntity usuarioCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_HOMOLOGACAO")
    private Date dataHomologacao;

    @ManyToOne (targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "USUARIO_HOMOLOGACAO")
    private UsuarioEntity usuarioHomologacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_INATIVACAO")
    private Date dataInativacao;

    @ManyToOne (targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "USUARIO_INATIVACAO")
    private UsuarioEntity usuarioInativacao;

    @Valid
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "composicaoProduto",cascade = CascadeType.ALL,
            targetEntity = ItemComposicaoProdutoEntity.class, orphanRemoval=true)
    private List<ItemComposicaoProdutoEntity> itemComposicaoProduto;

    /**
     * Default Constructor
     */
    public ComposicaoProdutoEntity(){}

    /** Constructor for query sel
     *
     * @param id
     * @param produtoNome
     * @param composicaoExperimental
     */
    public ComposicaoProdutoEntity(Long id, String produtoNome, Boolean composicaoExperimental, Long versao) {
        this.id = id;
        this.composicaoExperimental = composicaoExperimental;
        this.produto = new ProdutoEntity();
        this.produto.setNome(produtoNome);
        this.setVersao(versao);
    }

    /* trasients */
    @Transient
    private String composicaoExperimentalDescricao;

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
     * @return the composicaoExperimental
     */
    public Boolean getComposicaoExperimental() {
        return composicaoExperimental;
    }

    /**
     * @param composicaoExperimental the composicaoExperimental to set
     */
    public void setComposicaoExperimental(Boolean composicaoExperimental) {
        this.composicaoExperimental = composicaoExperimental;
    }

    /**
     * @return the rendimento
     */
    public Integer getRendimento() {
        return rendimento;
    }

    /**
     * @param rendimento the rendimento to set
     */
    public void setRendimento(Integer rendimento) {
        this.rendimento = rendimento;
    }

    /**
     * @return the dataCriacao
     */
    public Date getDataCriacao() {
        return dataCriacao;
    }

    /**
     * @param dataCriacao the dataCriacao to set
     */
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    /**
     * @return the situacao
     */
    public PlcSituacao getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(PlcSituacao situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the usuarioCriacao
     */
    public UsuarioEntity getUsuarioCriacao() {
        return usuarioCriacao;
    }

    /**
     * @param usuarioCriacao the usuarioCriacao to set
     */
    public void setUsuarioCriacao(UsuarioEntity usuarioCriacao) {
        this.usuarioCriacao = usuarioCriacao;
    }

    /**
     * @return the dataHomologacao
     */
    public Date getDataHomologacao() {
        return dataHomologacao;
    }

    /**
     * @param dataHomologacao the dataHomologacao to set
     */
    public void setDataHomologacao(Date dataHomologacao) {
        this.dataHomologacao = dataHomologacao;
    }

    /**
     * @return the usuarioHomologacao
     */
    public UsuarioEntity getUsuarioHomologacao() {
        return usuarioHomologacao;
    }

    /**
     * @param usuarioHomologacao the usuarioHomologacao to set
     */
    public void setUsuarioHomologacao(UsuarioEntity usuarioHomologacao) {
        this.usuarioHomologacao = usuarioHomologacao;
    }

    /**
     * @return the dataInativacao
     */
    public Date getDataInativacao() {
        return dataInativacao;
    }

    /**
     * @param dataInativacao the dataInativacao to set
     */
    public void setDataInativacao(Date dataInativacao) {
        this.dataInativacao = dataInativacao;
    }

    /**
     * @return the usuarioInativacao
     */
    public UsuarioEntity getUsuarioInativacao() {
        return usuarioInativacao;
    }

    /**
     * @param usuarioInativacao the usuarioInativacao to set
     */
    public void setUsuarioInativacao(UsuarioEntity usuarioInativacao) {
        this.usuarioInativacao = usuarioInativacao;
    }

    /**
     * @return the itemComposicaoProduto
     */
    public List<ItemComposicaoProdutoEntity> getItemComposicaoProduto() {
        return itemComposicaoProduto;
    }

    /**
     * @param itemComposicaoProduto the itemComposicaoProduto to set
     */
    public void setItemComposicaoProduto(List<ItemComposicaoProdutoEntity> itemComposicaoProduto) {
        this.itemComposicaoProduto = itemComposicaoProduto;
    }

    /**
     * @return the composicaoExperimentalDescricao
     */
    public String getComposicaoExperimentalDescricao() {
        return composicaoExperimentalDescricao;
    }

    /**
     * @param composicaoExperimentalDescricao the composicaoExperimentalDescricao to set
     */
    public void setComposicaoExperimentalDescricao(String composicaoExperimentalDescricao) {
        this.composicaoExperimentalDescricao = composicaoExperimentalDescricao;
    }
}

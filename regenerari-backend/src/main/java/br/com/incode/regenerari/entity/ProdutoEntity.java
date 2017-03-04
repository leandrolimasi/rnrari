package br.com.incode.regenerari.entity;

import br.com.incode.regenerari.enums.ApresentacaoProduto;
import br.com.incode.regenerari.enums.CategoriaProduto;
import br.com.incode.regenerari.enums.UnidadeMedidaProduto;
import br.com.incode.regenerari.listener.AuditListener;
import com.powerlogic.jcompany.core.model.domain.PlcSituacao;
import com.powerlogic.jcompany.core.model.entity.IPlcLogicalExclusion;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
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
 * Created by leandrolimadasilva on 20/02/17.
 */
@Entity
@Audited
@Table(name = "PRODUTO")
@Access(AccessType.FIELD)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@EntityListeners(AuditListener.class)
@SequenceGenerator(name = "SE_PRODUTO", sequenceName = "SE_PRODUTO")
public class ProdutoEntity extends AppBaseEntity implements IPlcLogicalExclusion {

    /** atributo chave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_PRODUTO")
    @Column(name = "ID_PRODUTO", unique = true, nullable = false)
    private Long id;

    @Column(name = "CODIGO", nullable = false)
    @Size(max = 10)
    @NotBlank(message = "O campo 'Código' é obrigatório.")
    private String codigo;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORIA_PRODUTO", nullable = false)
    @NotNull(message = "O campo 'Categoria' é obrigatório.")
    private CategoriaProduto categoriaProduto;

    @Column(name = "NOME")
    @Size(max = 40)
    @NotBlank(message = "O campo 'Nome' é obrigatório.")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "UNIDADE_MEDIDA_PRODUTO", nullable = false)
    @NotNull(message = "O campo 'Unidade Medida' é obrigatório.")
    private UnidadeMedidaProduto unidadeMedidaProduto;

    @Column(name = "PRESCRICAO")
    @Size(max = 120)
    private String prescricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "APRESENTACAO_PRODUTO", nullable = false)
    @NotNull(message = "O campo 'Apresentação' é obrigatório.")
    private ApresentacaoProduto apresentacaoProduto;

    @Column(name = "QUANTIDADE_APRESENTACAO", nullable = false)
    @NotNull(message = "O campo 'Quantidade Apresentação' é obrigatório.")
    private Integer quantidadeApresentacao;

    @Column(name = "VALIDADE", nullable = false)
    @NotNull(message = "O campo 'Validade' é obrigatório.")
    private Integer validadeProduto;

    @Column(name = "PRECO_MAXIMO", nullable = false)
    @NotNull(message = "O campo 'Preço Máximo' é obrigatório.")
    private BigDecimal precoMaximo;

    @Column(name = "PRECO_MINIMO", nullable = false)
    @NotNull(message = "O campo 'Preço Mínimo' é obrigatório.")
    private BigDecimal precoMinimo;

    @Column(name = "PRODUTO_EXPERIMENTAL")
    private Boolean produtoExperimental;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private PlcSituacao situacao = PlcSituacao.A;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_INATIVACAO")
    private Date dataInativacao;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @ManyToOne (targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "USUARIO_INATIVACAO")
    private UsuarioEntity usuarioInativacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_ULT_PRECO")
    private Date dataUltimoPreco;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @ManyToOne (targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "USUARIO_ULT_PRECO")
    private UsuarioEntity usuarioUltimoPreco;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_HOMOLOGACAO")
    private Date dataHomologacao;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @ManyToOne (targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "USUARIO_HOMOLOGACAO")
    private UsuarioEntity usuarioHomologacao;

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
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the categoriaProduto
     */
    public CategoriaProduto getCategoriaProduto() {
        return categoriaProduto;
    }

    /**
     * @param categoriaProduto the categoriaProduto to set
     */
    public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the unidadeMedidaProduto
     */
    public UnidadeMedidaProduto getUnidadeMedidaProduto() {
        return unidadeMedidaProduto;
    }

    /**
     * @param unidadeMedidaProduto the unidadeMedidaProduto to set
     */
    public void setUnidadeMedidaProduto(UnidadeMedidaProduto unidadeMedidaProduto) {
        this.unidadeMedidaProduto = unidadeMedidaProduto;
    }

    /**
     * @return the prescricao
     */
    public String getPrescricao() {
        return prescricao;
    }

    /**
     * @param prescricao the prescricao to set
     */
    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    /**
     * @return the apresentacaoProduto
     */
    public ApresentacaoProduto getApresentacaoProduto() {
        return apresentacaoProduto;
    }

    /**
     * @param apresentacaoProduto the apresentacaoProduto to set
     */
    public void setApresentacaoProduto(ApresentacaoProduto apresentacaoProduto) {
        this.apresentacaoProduto = apresentacaoProduto;
    }

    /**
     * @return the quantidadeApresentacao
     */
    public Integer getQuantidadeApresentacao() {
        return quantidadeApresentacao;
    }

    /**
     * @param quantidadeApresentacao the quantidadeApresentacao to set
     */
    public void setQuantidadeApresentacao(Integer quantidadeApresentacao) {
        this.quantidadeApresentacao = quantidadeApresentacao;
    }

    /**
     * @return the validadeProduto
     */
    public Integer getValidadeProduto() {
        return validadeProduto;
    }

    /**
     * @param validadeProduto the validadeProduto to set
     */
    public void setValidadeProduto(Integer validadeProduto) {
        this.validadeProduto = validadeProduto;
    }

    /**
     * @return the precoMaximo
     */
    public BigDecimal getPrecoMaximo() {
        return precoMaximo;
    }

    /**
     * @param precoMaximo the precoMaximo to set
     */
    public void setPrecoMaximo(BigDecimal precoMaximo) {
        this.precoMaximo = precoMaximo;
    }

    /**
     * @return the precoMinimo
     */
    public BigDecimal getPrecoMinimo() {
        return precoMinimo;
    }

    /**
     * @param precoMinimo the precoMinimo to set
     */
    public void setPrecoMinimo(BigDecimal precoMinimo) {
        this.precoMinimo = precoMinimo;
    }

    /**
     * @return the produtoExperimental
     */
    public Boolean getProdutoExperimental() {
        return produtoExperimental;
    }

    /**
     * @param produtoExperimental the produtoExperimental to set
     */
    public void setProdutoExperimental(Boolean produtoExperimental) {
        this.produtoExperimental = produtoExperimental;
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
     * @return the dataUltimoPreco
     */
    public Date getDataUltimoPreco() {
        return dataUltimoPreco;
    }

    /**
     * @param dataUltimoPreco the dataUltimoPreco to set
     */
    public void setDataUltimoPreco(Date dataUltimoPreco) {
        this.dataUltimoPreco = dataUltimoPreco;
    }

    /**
     * @return the usuarioUltimoPreco
     */
    public UsuarioEntity getUsuarioUltimoPreco() {
        return usuarioUltimoPreco;
    }

    /**
     * @param usuarioUltimoPreco the usuarioUltimoPreco to set
     */
    public void setUsuarioUltimoPreco(UsuarioEntity usuarioUltimoPreco) {
        this.usuarioUltimoPreco = usuarioUltimoPreco;
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
}

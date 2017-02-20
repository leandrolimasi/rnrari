package br.com.incode.regenerari.entity;

import br.com.incode.regenerari.enums.CategoriaInsumo;
import br.com.incode.regenerari.enums.UnidadeMedidaInsumo;
import br.com.incode.regenerari.listener.AuditListener;
import com.powerlogic.jcompany.core.model.domain.PlcSituacao;
import com.powerlogic.jcompany.core.model.entity.IPlcLogicalExclusion;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by leandrolimadasilva on 20/12/16.
 */
@Entity
@Table(name = "INSUMO")
@Access(AccessType.FIELD)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@EntityListeners(AuditListener.class)
@SequenceGenerator(name = "SE_INSUMO", sequenceName = "SE_INSUMO")
public class InsumoEntity extends AppBaseEntity implements IPlcLogicalExclusion{

    /** atributo chave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_INSUMO")
    @Column(name = "ID_INSUMO", unique = true, nullable = false)
    private Long id;

    @Column(name = "CODIGO", nullable = false)
    @Size(max = 10)
    @NotBlank(message = "O campo 'Código' é obrigatório.")
    private String codigo;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORIA_INSUMO", nullable = false)
    @NotNull(message = "O campo 'Categoria' é obrigatório.")
    private CategoriaInsumo categoriaInsumo;

    @Column(name = "NOME")
    @Size(max = 40)
    @NotBlank(message = "O campo 'Nome' é obrigatório.")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "UNIDADE_MEDIDA_INSUMO", nullable = false)
    @NotNull(message = "O campo 'Unidade Medida' é obrigatório.")
    private UnidadeMedidaInsumo unidadeMedidaInsumo;

    @Column(name = "VALIDADE", nullable = false)
    @NotNull(message = "O campo 'Validade' é obrigatório.")
    private Integer validadeInsumo;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private PlcSituacao situacao = PlcSituacao.A;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_INATIVACAO")
    private Date dataInativacao;

    @ManyToOne (targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "USUARIO_INATIVACAO")
    private UsuarioEntity usuarioInativacao;

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
     * @return the categoriaInsumo
     */
    public CategoriaInsumo getCategoriaInsumo() {
        return categoriaInsumo;
    }

    /**
     * @param categoriaInsumo the categoriaInsumo to set
     */
    public void setCategoriaInsumo(CategoriaInsumo categoriaInsumo) {
        this.categoriaInsumo = categoriaInsumo;
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
     * @return the unidadeMedida
     */
    public UnidadeMedidaInsumo getUnidadeMedida() {
        return unidadeMedidaInsumo;
    }

    /**
     * @param unidadeMedidaInsumo the unidadeMedidaInsumo to set
     */
    public void setUnidadeMedida(UnidadeMedidaInsumo unidadeMedidaInsumo) {
        this.unidadeMedidaInsumo = unidadeMedidaInsumo;
    }

    /**
     * @return the validadeInsumo
     */
    public Integer getValidadeInsumo() {
        return validadeInsumo;
    }

    /**
     * @param validadeInsumo the validadeInsumo to set
     */
    public void setValidadeInsumo(Integer validadeInsumo) {
        this.validadeInsumo = validadeInsumo;
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
     * @return the unidadeMedidaInsumo
     */
    public UnidadeMedidaInsumo getUnidadeMedidaInsumo() {
        return unidadeMedidaInsumo;
    }

    /**
     * @param unidadeMedidaInsumo the unidadeMedidaInsumo to set
     */
    public void setUnidadeMedidaInsumo(UnidadeMedidaInsumo unidadeMedidaInsumo) {
        this.unidadeMedidaInsumo = unidadeMedidaInsumo;
    }

    /**
     * @return the situacao
     */
    @Override
    public PlcSituacao getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    @Override
    public void setSituacao(PlcSituacao situacao) {
        this.situacao = situacao;
    }
}

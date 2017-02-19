package br.com.incode.regenerari.entity;

import br.com.incode.regenerari.enums.Categoria;
import br.com.incode.regenerari.enums.UnidadeMedidaInsumo;
import br.com.incode.regenerari.enums.converter.StatusConverter;
import br.com.incode.regenerari.enums.Status;
import br.com.incode.regenerari.listener.AuditListener;
import com.powerlogic.jcompany.commons.validation.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

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
public class InsumoEntity extends AppBaseEntity {

    /** atributo chave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_INSUMO")
    @Column(name = "ID_INSUMO", unique = true, nullable = false)
    private Long id;

    @Column(name = "CODIGO", nullable = false)
    @Size(max = 10)
    @NotBlank(message = "O campo 'Códido' é obrigatório.")
    private String codigo;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORIA", nullable = false)
    @NotNull(message = "O campo 'Categoria' é obrigatório.")
    private Categoria categoria;

    @Column(name = "NOME")
    @Size(max = 40)
    @NotBlank(message = "O campo 'Nome' é obrigatório.")
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "UNIDADE_MEDIDA", nullable = false)
    @NotNull(message = "O campo 'Unidade Medida' é obrigatório.")
    private UnidadeMedidaInsumo unidadeMedida;

    @Column(name = "VALIDADE", nullable = false)
    @NotNull(message = "O campo 'Validade' é obrigatório.")
    private Integer validadeInsumo;

    @Convert(converter = StatusConverter.class)
    @Column(name = "STATUS", nullable = false)
    private Status status = Status.ATIVO;

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
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
        return unidadeMedida;
    }

    /**
     * @param unidadeMedida the unidadeMedida to set
     */
    public void setUnidadeMedida(UnidadeMedidaInsumo unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
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
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
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
}

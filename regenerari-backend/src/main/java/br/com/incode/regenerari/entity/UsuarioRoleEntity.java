package br.com.incode.regenerari.entity;

import br.com.incode.regenerari.enums.Perfil;
import br.com.incode.regenerari.enums.converter.PerfilConverter;
import br.com.incode.regenerari.listener.AuditListener;
import com.powerlogic.jcompany.commons.validation.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
/**
 * @author leandrolimasi
 *
 */
@Entity
@Table(name = "USUARIO_ROLE")
@Access(AccessType.FIELD)
@EntityListeners(AuditListener.class)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@SequenceGenerator(name = "SE_USUARIO_ROLE", sequenceName = "SE_USUARIO_ROLE")
public class UsuarioRoleEntity extends AppBaseEntity {

    /** atributo chave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_USUARIO_ROLE")
    @Column(name = "ID_USUARIO_ROLE", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "ID_USUARIO")
    @XmlTransient
    private UsuarioEntity usuario;

    @Column(name = "LOGIN")
    @Size(max = 255)
    @NotNull
    private String login;

    @Convert(converter = PerfilConverter.class)
    @Column(name = "PERFIL")
    @NotNull(message = "campo 'PERFIL' é obrigatório!")
    private Perfil perfil;

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
     * @return the usuario
     */
    public UsuarioEntity getUsuario() {
        return usuario;
    }
    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}

package br.com.incode.regenerari.entity;

import br.com.incode.regenerari.enums.Perfil;
import br.com.incode.regenerari.enums.converter.TipoPerfilConverter;
import br.com.incode.regenerari.listener.AuditListener;
import com.powerlogic.jcompany.commons.validation.Email;

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
public class UsuarioRoleEntity extends AppBaseEntity {
    /** atributo chave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_USUARIO_ROLE", unique = true, nullable = false)
    private Long id;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "ID_USUARIO")
    @XmlTransient
    private UsuarioEntity usuario;
    @Column(name = "ROLE")
    @Size(max = 255)
    @NotNull
    private String role;
    @Column(name = "LOGIN")
    @Size(max = 255)
    @NotNull
    private String login;

    @Convert(converter = TipoPerfilConverter.class)
    @Column(name = "TP_PERFIL")
    @NotNull
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
    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }
    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
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

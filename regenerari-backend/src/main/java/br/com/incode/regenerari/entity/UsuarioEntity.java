package br.com.incode.regenerari.entity;

import br.com.incode.regenerari.enums.converter.StatusConverter;
import br.com.incode.regenerari.enums.Status;
import br.com.incode.regenerari.listener.AuditListener;
import com.powerlogic.jcompany.commons.validation.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by leandrolimadasilva on 20/12/16.
 */
@Entity
@Table(name = "USUARIO")
@Access(AccessType.FIELD)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@EntityListeners(AuditListener.class)
@SequenceGenerator(name = "SE_USUARIO", sequenceName = "SE_USUARIO")
@NamedQueries(@NamedQuery(name = "UsuarioEntity.findUsuarioByLogin",
        query = "select obj from UsuarioEntity obj " +
                " where ( obj.login = :login ) "))
public class UsuarioEntity extends AppBaseEntity {
    /** atributo chave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SE_USUARIO")
    @Column(name = "ID_USUARIO", unique = true, nullable = false)
    private Long id;

    @Column(name = "SENHA")
    @Size(max = 255)
    @NotNull
    private String senha;

    @Column(name = "PRIMEIRO_NOME")
    @Size(max = 50)
    @NotNull
    private String primeiroNome;

    @Column(name = "ULTIMO_NOME")
    @Size(max = 255)
    @NotNull
    private String ultimoNome;

    @Column(name = "LOGIN")
    @Size(max = 255)
    @NotNull
    private String login;

    @Email
    @Column(name = "EMAIL")
    @Size(max = 255)
    @NotNull
    private String email;

    @Convert(converter = StatusConverter.class)
    @Column(name = "STATUS")
    @NotNull
    private Status status;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "usuario",cascade = CascadeType.ALL)
    private List<UsuarioRoleEntity> roles;

    /**
     * Transients
     */
    @Transient
    private String confirmaSenha;
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
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }
    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the confirmaSenha
     */
    public String getConfirmaSenha() {
        return confirmaSenha;
    }
    /**
     * @param confirmaSenha the confirmaSenha to set
     */
    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }
    /**
     * @return the roles
     */
    public List<UsuarioRoleEntity> getRoles() {
        return roles;
    }
    /**
     * @param roles the roles to set
     */
    public void setRoles(List<UsuarioRoleEntity> roles) {
        this.roles = roles;
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
     * @return the primeiroNome
     */
    public String getPrimeiroNome() {
        return primeiroNome;
    }
    /**
     * @param primeiroNome the primeiroNome to set
     */
    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }
    /**
     * @return the ultimoNome
     */
    public String getUltimoNome() {
        return ultimoNome;
    }
    /**
     * @param ultimoNome the ultimoNome to set
     */
    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }
}

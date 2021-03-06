package br.com.incode.regenerari.entity;

import br.com.incode.regenerari.listener.AuditListener;
import com.powerlogic.jcompany.core.model.domain.PlcSituacao;
import com.powerlogic.jcompany.core.model.entity.IPlcLogicalExclusion;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
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
public class UsuarioEntity extends AppBaseEntity implements IPlcLogicalExclusion {

    /** atributo chave primaria
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_USUARIO")
    @Column(name = "ID_USUARIO", unique = true, nullable = false)
    private Long id;

    @Column(name = "SENHA", nullable = false)
    @Size(max = 100)
    private String senha;

    @Column(name = "PRIMEIRO_NOME", nullable = false)
    @Size(max = 50)
    @NotBlank(message = "O campo 'Primeiro Nome' é obrigatório.")
    private String primeiroNome;

    @Column(name = "ULTIMO_NOME")
    @Size(max = 150)
    @NotBlank(message = "O campo 'Último Nome' é obrigatório.")
    private String ultimoNome;

    @Column(name = "LOGIN", nullable = false)
    @Size(max = 255)
    @NotBlank(message = "O campo 'Login' é obrigatório.")
    private String login;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private PlcSituacao situacao = PlcSituacao.A;

    @Valid
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

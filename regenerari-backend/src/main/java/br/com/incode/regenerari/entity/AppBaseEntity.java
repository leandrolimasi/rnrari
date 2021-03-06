package br.com.incode.regenerari.entity;

import com.powerlogic.jcompany.core.model.entity.PlcBaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by leandrolimadasilva on 20/12/16.
 */
@MappedSuperclass
public abstract class AppBaseEntity extends PlcBaseEntity<Long> {

    @Version
    @Column(name = "versao", nullable = false)
    private Long versao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_ult_alteracao", nullable = false)
    private Date dataUltimaAlteracao;

    @Column(name = "usu_ult_alteracao", nullable = false)
    private String usuarioUltimaAlteracao;

    /**
     * @return the versao
     */
    public Long getVersao() {
        return versao;
    }
    /**
     * @param versao the versao to set
     */
    public void setVersao(Long versao) {
        this.versao = versao;
    }
    /**
     * @return the dataUltimaAlteracao
     */
    public Date getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }
    /**
     * @param dataUltimaAlteracao the dataUltimaAlteracao to set
     */
    public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }
    /**
     * @return the usuarioUltimaAlteracao
     */
    public String getUsuarioUltimaAlteracao() {
        return usuarioUltimaAlteracao;
    }
    /**
     * @param usuarioUltimaAlteracao the usuarioUltimaAlteracao to set
     */
    public void setUsuarioUltimaAlteracao(String usuarioUltimaAlteracao) {
        this.usuarioUltimaAlteracao = usuarioUltimaAlteracao;
    }
}

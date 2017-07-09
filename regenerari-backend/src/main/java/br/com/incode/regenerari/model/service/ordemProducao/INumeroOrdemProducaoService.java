package br.com.incode.regenerari.model.service.ordemProducao;

import br.com.incode.regenerari.entity.NumeroOrdemProducaoEntity;
import com.powerlogic.jcompany.core.model.service.IPlcEntityService;

import javax.ejb.Local;

/**
 * Created by leandrolimadasilva on 10/07/17.
 */
@Local
public  interface INumeroOrdemProducaoService extends IPlcEntityService<Long, NumeroOrdemProducaoEntity> {


    /** Recupera numero ordem producao
     *
     * @param stamp
     * @return
     */
    String getNumeroOrdemProducao(String stamp);

}

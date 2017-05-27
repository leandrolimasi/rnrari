package br.com.incode.regenerari.model.service.ordemProducao;

import br.com.incode.regenerari.entity.OrdemProducaoEntity;
import com.powerlogic.jcompany.core.model.service.IPlcEntityService;

import javax.ejb.Local;

/**
 * Created by leandrolimadasilva on 26/05/17.
 */
@Local
public  interface IOrdemProducaoService extends IPlcEntityService<Long, OrdemProducaoEntity> {


}

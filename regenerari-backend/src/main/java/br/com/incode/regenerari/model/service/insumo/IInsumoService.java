package br.com.incode.regenerari.model.service.insumo;

import br.com.incode.regenerari.entity.InsumoEntity;
import com.powerlogic.jcompany.core.model.service.IPlcEntityService;

import javax.ejb.Local;

/**
 * Created by leandrolimadasilva on 19/12/16.
 */
@Local
public  interface IInsumoService extends IPlcEntityService<Long, InsumoEntity> {


}

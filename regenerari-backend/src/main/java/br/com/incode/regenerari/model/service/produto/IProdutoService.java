package br.com.incode.regenerari.model.service.produto;

import br.com.incode.regenerari.entity.ProdutoEntity;
import com.powerlogic.jcompany.core.model.service.IPlcEntityService;

import javax.ejb.Local;

/**
 * Created by leandrolimadasilva on 19/12/16.
 */
@Local
public  interface IProdutoService extends IPlcEntityService<Long, ProdutoEntity> {


}

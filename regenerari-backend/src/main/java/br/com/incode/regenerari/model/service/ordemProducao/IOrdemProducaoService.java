package br.com.incode.regenerari.model.service.ordemProducao;

import br.com.incode.regenerari.dto.OrdemProducaoGeracaoDTO;
import br.com.incode.regenerari.entity.OrdemProducaoEntity;
import com.powerlogic.jcompany.core.model.service.IPlcEntityService;

import javax.ejb.Local;
import javax.validation.Valid;

/**
 * Created by leandrolimadasilva on 26/05/17.
 */
@Local
public  interface IOrdemProducaoService extends IPlcEntityService<Long, OrdemProducaoEntity> {


    /**
     *  Gerar Ordem de Producao
     *
     * @param dto
     * @return
     */
    OrdemProducaoEntity gerar(@Valid OrdemProducaoGeracaoDTO dto);


}

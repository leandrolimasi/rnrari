package br.com.incode.regenerari.model.service.estoqueInsumo;

import br.com.incode.regenerari.dto.EntradaEstoqueInsumoDTO;
import br.com.incode.regenerari.entity.EstoqueInsumoEntity;
import br.com.incode.regenerari.entity.InsumoEntity;
import com.powerlogic.jcompany.core.model.service.IPlcEntityService;

/**
 * Created by leandrolimadasilva on 12/04/17.
 */
public interface IEstoqueInsumoService extends IPlcEntityService<Long, EstoqueInsumoEntity> {

    EstoqueInsumoEntity entrada(EntradaEstoqueInsumoDTO dto);

}

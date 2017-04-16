package br.com.incode.regenerari.model.service.estoqueInsumo.impl;

import br.com.incode.regenerari.bo.EstoqueInsumoBO;
import br.com.incode.regenerari.dto.EntradaEstoqueInsumoDTO;
import br.com.incode.regenerari.entity.EstoqueInsumoEntity;
import br.com.incode.regenerari.model.repository.estoqueInsumo.EstoqueInsumoRepository;
import br.com.incode.regenerari.model.service.estoqueInsumo.IEstoqueInsumoService;
import com.powerlogic.jcompany.commons.interceptor.validation.PlcValidationInterceptor;
import com.powerlogic.jcompany.core.model.repository.IPlcEntityRepository;
import com.powerlogic.jcompany.core.model.service.PlcAbstractServiceEntity;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

/**
 * Created by leandrolimadasilva on 12/04/17.
 */
@Stateless
@Interceptors({PlcValidationInterceptor.class})
public class EstoqueInsumoServiceImpl extends PlcAbstractServiceEntity<Long, EstoqueInsumoEntity> implements IEstoqueInsumoService {

    private static final Logger log = LoggerFactory.getLogger(EstoqueInsumoServiceImpl.class);

    @Inject
    private EstoqueInsumoRepository estoqueInsumoRepository;

    @Inject
    private EstoqueInsumoBO estoqueInsumoBO;

    @Override
    protected IPlcEntityRepository<Long, EstoqueInsumoEntity> getEntityRepository() {
        return estoqueInsumoRepository;
    }

    /** Entrada de Estoque de insumo
     *
     * @param dto
     * @return
     */
    @Override
    public EstoqueInsumoEntity entrada(@Valid EntradaEstoqueInsumoDTO dto) {

        EstoqueInsumoEntity estoqueInsumo = new EstoqueInsumoEntity();

        try {
            BeanUtils.copyProperties(estoqueInsumo, dto);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error(e.getLocalizedMessage(), e);
        }

        estoqueInsumoBO.validaEntradaEstoque(estoqueInsumo);

        estoqueInsumo.setValorCompraUnitario(estoqueInsumo.getValorCompraTotal()
                .divide( estoqueInsumo.getQuantidade()));

        return estoqueInsumoRepository.save(estoqueInsumo);
    }
}

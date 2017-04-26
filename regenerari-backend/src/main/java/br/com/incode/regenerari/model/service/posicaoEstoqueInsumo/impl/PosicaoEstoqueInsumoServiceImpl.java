package br.com.incode.regenerari.model.service.posicaoEstoqueInsumo.impl;

import br.com.incode.regenerari.entity.InsumoEntity;
import br.com.incode.regenerari.entity.PosicaoEstoqueInsumoEntity;
import br.com.incode.regenerari.model.repository.posicaoEstoqueInsumo.PosicaoEstoqueInsumoRepository;
import br.com.incode.regenerari.model.service.posicaoEstoqueInsumo.IPosicaoEstoqueInsumoService;
import com.powerlogic.jcompany.commons.interceptor.validation.PlcValidationInterceptor;
import com.powerlogic.jcompany.core.model.repository.IPlcEntityRepository;
import com.powerlogic.jcompany.core.model.service.PlcAbstractServiceEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

/**
 * Created by leandrolimadasilva on 12/04/17.
 */
@Stateless
@Interceptors({PlcValidationInterceptor.class})
public class PosicaoEstoqueInsumoServiceImpl extends PlcAbstractServiceEntity<Long, PosicaoEstoqueInsumoEntity> implements IPosicaoEstoqueInsumoService {

    private static final Logger log = LoggerFactory.getLogger(PosicaoEstoqueInsumoServiceImpl.class);

    @Inject
    private PosicaoEstoqueInsumoRepository posicaoEstoqueInsumoRepository;

    @Override
    protected IPlcEntityRepository<Long, PosicaoEstoqueInsumoEntity> getEntityRepository() {
        return posicaoEstoqueInsumoRepository;
    }

    /**
     * Recupera posicao estoque de insumo
     *
     * @param insumo
     * @return
     */
    @Override
    public PosicaoEstoqueInsumoEntity recuperaPosicaoEstoqueInsumo(InsumoEntity insumo) {
        return posicaoEstoqueInsumoRepository.recuperaPosicaoAtual(insumo);
    }
}

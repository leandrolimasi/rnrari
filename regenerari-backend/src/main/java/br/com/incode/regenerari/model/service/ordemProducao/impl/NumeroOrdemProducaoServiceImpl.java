package br.com.incode.regenerari.model.service.ordemProducao.impl;

import br.com.incode.regenerari.entity.NumeroOrdemProducaoEntity;
import br.com.incode.regenerari.model.repository.ordemProducao.NumeroOrdemProducaoRepository;
import br.com.incode.regenerari.model.service.ordemProducao.INumeroOrdemProducaoService;
import com.powerlogic.jcompany.commons.interceptor.validation.PlcValidationInterceptor;
import com.powerlogic.jcompany.core.model.repository.IPlcEntityRepository;
import com.powerlogic.jcompany.core.model.service.PlcAbstractServiceEntity;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

/**
 * Created by leandrolimadasilva on 26/05/17.
 */
@Stateless
@Interceptors({PlcValidationInterceptor.class})
public class NumeroOrdemProducaoServiceImpl extends PlcAbstractServiceEntity<Long, NumeroOrdemProducaoEntity> implements INumeroOrdemProducaoService {

    @Inject
    private NumeroOrdemProducaoRepository numeroOrdemProducaoRepository;

    @Override
    protected IPlcEntityRepository<Long, NumeroOrdemProducaoEntity> getEntityRepository() {
        return numeroOrdemProducaoRepository;
    }

    /** Recupera numero ordem producao
     *
     * @param stamp
     * @return
     */
    @Override
    public String getNumeroOrdemProducao(String stamp) {
        NumeroOrdemProducaoEntity numeroOrdemProducao = new NumeroOrdemProducaoEntity();
        numeroOrdemProducao.setStamp(stamp);
        numeroOrdemProducao = numeroOrdemProducaoRepository.findUniqueOrNew(numeroOrdemProducao);
        if (numeroOrdemProducao.getId() == null){
            numeroOrdemProducao.setStamp(stamp);
            numeroOrdemProducao.setNumero(1);
        }else{
            numeroOrdemProducao.setNumero(numeroOrdemProducao.getNumero() + 1);
        }
        numeroOrdemProducao = numeroOrdemProducaoRepository.save(numeroOrdemProducao);
        return numeroOrdemProducao.getStamp() + StringUtils.leftPad(numeroOrdemProducao.getNumero().toString(), 3, "0");
    }
}
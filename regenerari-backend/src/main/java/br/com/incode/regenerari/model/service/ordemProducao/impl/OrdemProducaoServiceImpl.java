package br.com.incode.regenerari.model.service.ordemProducao.impl;

import br.com.incode.regenerari.auth.AppAuthenticatedUserInfo;
import br.com.incode.regenerari.bo.OrdemProducaoBO;
import br.com.incode.regenerari.dto.OrdemProducaoGeracaoDTO;
import br.com.incode.regenerari.entity.OrdemProducaoEntity;
import br.com.incode.regenerari.enums.StatusOrdemProducao;
import br.com.incode.regenerari.model.repository.ordemProducao.OrdemProducaoRepository;
import br.com.incode.regenerari.model.service.ordemProducao.IOrdemProducaoService;
import com.powerlogic.jcompany.commons.interceptor.validation.PlcValidationInterceptor;
import com.powerlogic.jcompany.core.model.repository.IPlcEntityRepository;
import com.powerlogic.jcompany.core.model.service.PlcAbstractServiceEntity;
import com.powerlogic.jcompany.core.rest.auth.PlcAuthenticatedUserInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * Created by leandrolimadasilva on 26/05/17.
 */
@Stateless
@Interceptors({PlcValidationInterceptor.class})
public class OrdemProducaoServiceImpl extends PlcAbstractServiceEntity<Long, OrdemProducaoEntity> implements IOrdemProducaoService {

    private static final Logger log = LoggerFactory.getLogger(OrdemProducaoServiceImpl.class);

    @Inject
    private OrdemProducaoRepository ordemProducaoRepository;

    @Inject
    private OrdemProducaoBO ordemProducaoBO;

    @Override
    protected IPlcEntityRepository<Long, OrdemProducaoEntity> getEntityRepository() {
        return ordemProducaoRepository;
    }

    /**
     *  Gerar Ordem de Producao
     *
     * @param dto
     * @return
     */
    @Override
    public OrdemProducaoEntity gerar(@Valid OrdemProducaoGeracaoDTO dto) {

        OrdemProducaoEntity ordemProducao = new OrdemProducaoEntity();

        try {
            BeanUtils.copyProperties(ordemProducao, dto);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error(e.getLocalizedMessage(), e);
        }

        ordemProducaoBO.validaGeracaoOrdemProducao(ordemProducao);
        ordemProducao.setStatusOrdemProducao(StatusOrdemProducao.NA_FILA);
        ordemProducao.setListaInsumos(ordemProducaoBO.montaListaInsumos(ordemProducao));

        HttpServletRequest request = CDI.current().select(HttpServletRequest.class).get();
        AppAuthenticatedUserInfo userInfo = (AppAuthenticatedUserInfo)
                request.getSession().getAttribute(PlcAuthenticatedUserInfo.PROPERTY);

        ordemProducao.setUsuarioStatus(userInfo.getUsuario());
        ordemProducao.setDataGeracao(new Date());
        ordemProducao.setUsuarioGeracao(userInfo.getUsuario());
        ordemProducao.setDataStatus(new Date());


        return getEntityRepository().save(ordemProducao);
    }

    /**
     * Cancelar Ordem de Producao
     *
     * @param entity
     * @return
     */
    @Override
    public OrdemProducaoEntity cancelar(@Valid OrdemProducaoEntity entity) {

        entity.setStatusOrdemProducao(StatusOrdemProducao.CANCELADA);

        HttpServletRequest request = CDI.current().select(HttpServletRequest.class).get();
        AppAuthenticatedUserInfo userInfo = (AppAuthenticatedUserInfo)
                request.getSession().getAttribute(PlcAuthenticatedUserInfo.PROPERTY);

        entity.setUsuarioStatus(userInfo.getUsuario());
        entity.setDataStatus(new Date());

        return getEntityRepository().save(entity);
    }

    /**
     * Finalizar Ordem de Producao
     *
     * @param entity
     * @return
     */
    @Override
    public OrdemProducaoEntity finalizar(@Valid OrdemProducaoEntity entity) {
        return null;
    }

    /**
     * Iniciar Ordem de Producao
     *
     * @param entity
     * @return
     */
    @Override
    public OrdemProducaoEntity iniciar(@Valid OrdemProducaoEntity entity) {

        if (ordemProducaoBO.validaQuantidadeInsumo(entity)){
            entity.setStatusOrdemProducao(StatusOrdemProducao.INICIADA);
        }else{
            entity.setStatusOrdemProducao(StatusOrdemProducao.FALTA_INSUMO);
        }

        entity.setListaInsumos(ordemProducaoBO.montaListaInsumos(entity));

        HttpServletRequest request = CDI.current().select(HttpServletRequest.class).get();
        AppAuthenticatedUserInfo userInfo = (AppAuthenticatedUserInfo)
                request.getSession().getAttribute(PlcAuthenticatedUserInfo.PROPERTY);

        entity.setUsuarioStatus(userInfo.getUsuario());
        entity.setDataStatus(new Date());

        return getEntityRepository().save(entity);
    }


}
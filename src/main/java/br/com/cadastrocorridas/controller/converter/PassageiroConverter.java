package br.com.cadastrocorridas.controller.converter;

import br.com.cadastrocorridas.domain.Passageiro;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class PassageiroConverter implements Converter<String, Passageiro>  {

    @Override
    public Passageiro convert(String id) {
        if (!StringUtils.isEmpty(id)) {
            return new Passageiro(Integer.valueOf(id));
        }
        return null;
    }
}

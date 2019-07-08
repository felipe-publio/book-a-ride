package br.com.cadastrocorridas.controller.converter;

import br.com.cadastrocorridas.domain.Motorista;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class MotoristaConverter implements Converter<String, Motorista> {

    @Override
    public Motorista convert(String id) {
        if (!StringUtils.isEmpty(id)) {
            return new Motorista(Integer.valueOf(id));
        }
        return null;
    }
}

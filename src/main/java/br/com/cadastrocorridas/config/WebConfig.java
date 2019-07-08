package br.com.cadastrocorridas.config;

import br.com.cadastrocorridas.controller.converter.MotoristaConverter;
import br.com.cadastrocorridas.controller.converter.PassageiroConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new MotoristaConverter());
        registry.addConverter(new PassageiroConverter());
    }
}

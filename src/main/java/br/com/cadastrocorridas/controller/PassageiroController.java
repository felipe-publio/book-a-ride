package br.com.cadastrocorridas.controller;

import br.com.cadastrocorridas.domain.Passageiro;
import br.com.cadastrocorridas.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RequestMapping("/passageiros")
@Controller
public class PassageiroController {

    @Autowired
    private PassageiroRepository repository;

    @GetMapping
    public ModelAndView passageiro(){
        ModelAndView mv = new ModelAndView("passageiros-list");
        mv.addObject("passageiros", repository.findAll());
        return mv;
    }

    @GetMapping("/novo")
    public ModelAndView passageirosForm(Passageiro passageiro) {

        return new ModelAndView("passageiros-form");
    }

    @PostMapping
    public ModelAndView passageirosSubmit(@Valid Passageiro passageiro, BindingResult result) {
        if (result.hasErrors()) {
            return passageirosForm(passageiro);
        }

        repository.save(passageiro);
        return new ModelAndView("redirect:/passageiros");
    }

}

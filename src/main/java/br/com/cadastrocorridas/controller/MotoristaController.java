package br.com.cadastrocorridas.controller;

import br.com.cadastrocorridas.domain.Motorista;
import br.com.cadastrocorridas.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/motoristas")
@Controller
public class MotoristaController {

    @Autowired
    private MotoristaRepository repository;

    @GetMapping
    public ModelAndView motorista(){
        ModelAndView mv = new ModelAndView("motoristas-list");
        mv.addObject("motoristas", repository.findAll());
        return mv;
    }
    @GetMapping("/novo")
    public ModelAndView motoristaForm(Motorista motorista) {

        return new ModelAndView("motoristas-form");
    }

    @PostMapping
    public ModelAndView motoristaSubmit(@Valid Motorista motorista, BindingResult result) {
        if (result.hasErrors()) {
            return motoristaForm(motorista);
        }

        repository.save(motorista);
        return new ModelAndView("redirect:/motoristas");
    }

    @GetMapping("/{id}")
    public ModelAndView editar(@PathVariable("id") Motorista motorista) {
       Optional<Motorista> moto = repository.findById(motorista.getId());
        ModelAndView mv = motoristaForm(moto.get());
        mv.addObject(moto.get());

        return mv;
    }

}

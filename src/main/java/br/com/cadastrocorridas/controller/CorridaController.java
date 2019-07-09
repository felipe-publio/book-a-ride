package br.com.cadastrocorridas.controller;

import br.com.cadastrocorridas.domain.Corrida;
import br.com.cadastrocorridas.domain.Motorista;
import br.com.cadastrocorridas.repository.CorridaRepository;
import br.com.cadastrocorridas.repository.MotoristaRepository;
import br.com.cadastrocorridas.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/corridas")
public class CorridaController {


    @Autowired
    private CorridaRepository repository;
    @Autowired
    private PassageiroRepository passageiroRepository;
    @Autowired
    private MotoristaRepository motoristaRepository;

    @GetMapping
    public ModelAndView  corrida(){
        ModelAndView mv = new ModelAndView("corridas-list");
        mv.addObject("corridas", repository.findAll());
        return mv;
    }

    @GetMapping("/novo")
    public ModelAndView corridasForm(Corrida corrida) {

        ModelAndView mv = new ModelAndView("corridas-form");
        mv.addObject("motoristas", motoristaRepository.findAll());
        mv.addObject("passageiros", passageiroRepository.findAll());

        return mv;
    }

    @PostMapping
    public ModelAndView corridasSubmit(@Valid Corrida corrida, BindingResult result) {
        if (result.hasErrors()) {
            return corridasForm(corrida);
        }

        Optional<Motorista> motorista = motoristaRepository.findById(corrida.getMotorista().getId());

        if ("Inativo".equals(motorista.get().getStatus())){
            result.addError(new ObjectError("motorista", "Motorista inativo não pode realizar corrida!") );
            return corridasForm(corrida);

        }

        repository.save(corrida);
        return new ModelAndView("redirect:/corridas");
    }



}

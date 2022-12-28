package br.com.projeto.contas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.projeto.contas.model.Contas;
import br.com.projeto.contas.services.ContasService;

@Controller
@RequestMapping("/contas")
public class ContasController {
	
	@Autowired
	private ContasService contasService;
	
	@RequestMapping("listar")
	public String index(Model model) {
		
		List<Contas> listContas = contasService.listAll();
		model.addAttribute("listContas", listContas);
		
		return "index";
	}
	
	@RequestMapping("adicionar")
	public ModelAndView add(Contas conta) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adicionar");
		mv.addObject("conta", conta);
		
		return mv;
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute("conta") Contas conta, BindingResult result) {
		
		if (result.hasErrors()) {
			return add(conta);
		}
		
		contasService.save(conta);
		
		ModelAndView mv = new ModelAndView("redirect:/contas/listar");
		
		return mv;
	}

}

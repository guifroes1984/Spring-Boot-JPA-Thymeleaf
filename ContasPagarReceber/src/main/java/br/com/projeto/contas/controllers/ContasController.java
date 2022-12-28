package br.com.projeto.contas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.projeto.contas.model.Contas;
import br.com.projeto.contas.services.ContasService;

@Controller
@RequestMapping("/contas")
public class ContasController {
	
	@Autowired
	private ContasService contasService;
	
	@RequestMapping("listar")
	public String index(@RequestParam(value = "search", required = false) String q, Model model) {
		List<Contas> listContas = null;
		
		if ((q != null) && (q.length() > 1) && (!q.matches("[+-]?[0-9]*\\.?[0-9]+"))) {
			listContas = contasService.listAllByLikeDescricao(q);
			model.addAttribute("search", q);
		} else if ((q != null) && (q.length() > 1) && (q.matches("[+-]?[0-9]*\\.?[0-9]+"))) {
			listContas = contasService.listAllFindByValor(Float.parseFloat(q));
			model.addAttribute("search", q);
		} else {
			listContas = contasService.listAll();
			model.addAttribute("search", "");
		}
		
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
	
	@RequestMapping("delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		contasService.delete(id);
		
		ModelAndView mv = new ModelAndView("redirect:/contas/listar");
		
		return mv;
	}
	
	@RequestMapping("editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		
		return add(contasService.get(id));
		
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

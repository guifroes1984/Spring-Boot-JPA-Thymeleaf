package br.com.projeto.contas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.projeto.contas.model.Categoria;
import br.com.projeto.contas.services.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping("listar")
	public String index(@RequestParam(value = "search", required = false) String q, Model model) {
		List<Categoria> listCategoria = null;
		
		if ((q != null) && (q.length() > 1)) {
			listCategoria = categoriaService.listAllByLikeNome(q);
			model.addAttribute("search", q);
		}  else {
			listCategoria = categoriaService.listAll();
			model.addAttribute("search", "");
		}
		
		model.addAttribute("listCategorias", listCategoria);
		
		return "categorias/index";
	}
	
	@RequestMapping("adicionar")
	public ModelAndView add(Categoria categoria) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("categoria/adicionar");
		mv.addObject("categoria", categoria);
		
		List<Categoria> cat = categoriaService.listAll();
		mv.addObject("categoria_list", cat);
		
		return mv;
	}

}

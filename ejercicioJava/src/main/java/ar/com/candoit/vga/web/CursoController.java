package ar.com.candoit.vga.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import ar.com.candoit.vga.business.CursoBo;
import ar.com.candoit.vga.business.exception.BusinessException;
import ar.com.candoit.vga.common.entities.Curso;
import ar.com.candoit.vga.common.search.SearchResult;
import ar.com.candoit.vga.common.search.filter.SearchFilterCurso;

@Controller
@RequestMapping(value = "/curso")
public class CursoController {

    private static Logger LOGGER = LoggerFactory.getLogger(CursoController.class);

    @Resource(name = "curso.bo")
    private CursoBo cursoBo;

    @RequestMapping(value = "/ver")
    public ModelAndView ver(@ModelAttribute("filter") SearchFilterCurso filter) {
	return new ModelAndView("curso/ver");
    }

    @RequestMapping(value = "/alta")
    public ModelAndView alta(@ModelAttribute("curso") Curso curso) {
	return new ModelAndView("curso/alta");
    }

    @RequestMapping(value = "/init")
    public ModelAndView init() {
	SearchResult<Curso> result;
	try {
	    SearchFilterCurso filter = new SearchFilterCurso();
	    result = cursoBo.searchCursosByFilter(filter);
	    return new ModelAndView("curso/grilla", "cursos", result.getResults());
	} catch (BusinessException e) {
	    LOGGER.error("Hubo un error al buscar los cursos", e);
	    return null;
	}
    }

    @RequestMapping(value = "/buscar")
    public ModelAndView buscar(@ModelAttribute("filter") SearchFilterCurso filter) {
	SearchResult<Curso> result;
	try {
	    result = cursoBo.searchCursosByFilter(filter);
	    return new ModelAndView("curso/grilla", "cursos", result.getResults());
	} catch (BusinessException e) {
	    LOGGER.error("Hubo un error al buscar los alumnos", e);
	    return null;
	}
    }

    @RequestMapping(value = "/guardar")
    @ResponseStatus(value = HttpStatus.OK)
    public void guardar(@ModelAttribute("curso") Curso curso) {
	try {
	    cursoBo.guardar(curso);
	} catch (BusinessException e) {
	    LOGGER.error("Hubo un error al guardar el alumno", e);
	}
    }

    /* IOC */

    public CursoBo getCursoBo() {
	return cursoBo;
    }

    public void setCursoBo(CursoBo cursoBo) {
	this.cursoBo = cursoBo;
    }

}

package ar.com.candoit.vga.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import ar.com.candoit.vga.business.AlumnoCursoBo;
import ar.com.candoit.vga.business.exception.BusinessException;
import ar.com.candoit.vga.common.entities.Alumno;
import ar.com.candoit.vga.common.search.SearchResult;
import ar.com.candoit.vga.common.search.filter.SearchFilterAlumnoCurso;
import ar.com.candoit.vga.web.util.IdsContainer;

@Controller
@RequestMapping(value = "/alumnocurso")
public class AlumnoCursoController {

    private static Logger LOGGER = LoggerFactory.getLogger(AlumnoCursoController.class);

    @Resource(name = "alumnocurso.bo")
    private AlumnoCursoBo alumnoCursoBo;

    @RequestMapping(value = "/ver")
    public ModelAndView ver(@ModelAttribute("filter") SearchFilterAlumnoCurso filter) {
	return new ModelAndView("alumnocurso/ver");
    }

    @RequestMapping(value = "/buscarinscriptos")
    public ModelAndView buscarInscriptos(@ModelAttribute("filter") SearchFilterAlumnoCurso filter) {
	SearchResult<Alumno> result;
	try {
	    result = alumnoCursoBo.getAlumnosInscriptos(filter);
	    return new ModelAndView("alumnocurso/grilla-inscriptos", "alumnos", result.getResults());
	} catch (BusinessException e) {
	    LOGGER.error("Hubo un error al buscar los alumnos", e);
	    return null;
	}
    }

    @RequestMapping(value = "/buscarnoinscriptos")
    public ModelAndView buscarNoInscriptos(@ModelAttribute("filter") SearchFilterAlumnoCurso filter) {
	SearchResult<Alumno> result;
	try {
	    result = alumnoCursoBo.getAlumnosNoInscriptos(filter);
	    return new ModelAndView("alumnocurso/grilla-no-inscriptos", "alumnos", result.getResults());
	} catch (BusinessException e) {
	    LOGGER.error("Hubo un error al buscar los alumnos", e);
	    return null;
	}
    }

    @RequestMapping(value = "/inscribir")
    @ResponseStatus(value = HttpStatus.OK)
    public void inscribir(@ModelAttribute("id") IdsContainer ids, @RequestParam("idCurso") Long idCurso) {
	try {
	    alumnoCursoBo.inscribir(ids.getIds(), idCurso);
	} catch (BusinessException e) {
	    LOGGER.error("Hubo un error al inscribir los alumnos", e);
	}
    }

    @RequestMapping(value = "/borrar")
    @ResponseStatus(value = HttpStatus.OK)
    public void borrar(@ModelAttribute("id") IdsContainer ids, @RequestParam("idCurso") Long idCurso) {
	try {
	    alumnoCursoBo.borrar(ids.getIds(), idCurso);
	} catch (BusinessException e) {
	    LOGGER.error("Hubo un error al borrar los alumnos", e);
	}
    }

  

    /* IOC */

    public AlumnoCursoBo getAlumnoCursoBo() {
	return alumnoCursoBo;
    }

    public void setAlumnoCursoBo(AlumnoCursoBo alumnoCursoBo) {
	this.alumnoCursoBo = alumnoCursoBo;
    }

}

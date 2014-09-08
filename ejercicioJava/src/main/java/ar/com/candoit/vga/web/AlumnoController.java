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

import ar.com.candoit.vga.business.AlumnoBo;
import ar.com.candoit.vga.business.exception.BusinessException;
import ar.com.candoit.vga.common.entities.Alumno;
import ar.com.candoit.vga.common.search.SearchResult;
import ar.com.candoit.vga.common.search.filter.SearchFilterAlumno;

@Controller
@RequestMapping(value = "/alumno")
public class AlumnoController {

    private static Logger LOGGER = LoggerFactory.getLogger(AlumnoController.class);
    private static int PAGE_SIZE = 10;

    @Resource(name = "alumno.bo")
    private AlumnoBo alumnoBo;

    @RequestMapping(value = "/ver")
    public ModelAndView ver(@ModelAttribute("filter") SearchFilterAlumno filter) {
	return new ModelAndView("alumno/ver");
    }

    @RequestMapping(value = "/alta")
    public ModelAndView alta(@ModelAttribute("alumno") Alumno alumno) {
	return new ModelAndView("alumno/alta");
    }

    @RequestMapping(value = "/buscar")
    public ModelAndView buscar(@ModelAttribute("filter") SearchFilterAlumno filter) {
	SearchResult<Alumno> result;
	try {
	    result = alumnoBo.searchAlumnosByFilter(filter);
	    return new ModelAndView("alumno/grilla", "alumnos", result.getResults());
	} catch (BusinessException e) {
	    LOGGER.error("Hubo un error al buscar los alumnos", e);
	    return null;
	}
    }

    @RequestMapping(value = "/guardar")
    @ResponseStatus(value = HttpStatus.OK)
    public void guardar(@ModelAttribute("alumno") Alumno alumno) {
	try {
	    alumnoBo.guardar(alumno);
	} catch (BusinessException e) {
	    LOGGER.error("Hubo un error al guardar el alumno", e);
	}
    }

    /* IOC */

    public AlumnoBo getAlumnoBo() {
	return alumnoBo;
    }

    public void setAlumnoBo(AlumnoBo alumnoBo) {
	this.alumnoBo = alumnoBo;
    }

}

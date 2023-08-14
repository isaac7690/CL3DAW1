package com.cibertec.cl3.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.cl3.examen.business.ProductoService;
import com.cibertec.cl3.examen.business.impl.ProductoServiceImpl;
import com.cibertec.cl3.examen.model.Producto;

@Controller
public class ProductoController {

	@Autowired
	private ProductoService service;

	// listado de productos
	@GetMapping("/")
	public String listadoProductos(Model model) {
		model.addAttribute("listaProductos", service.listaProducto());
		return "index";
	}

	// mostrar el formulario de registro de productos
	@GetMapping("/nuevoProducto")
	public String registroProductoFormulario(Model model) {
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		return "registroProducto";
	}

	// guardar el nuevo producto
	@PostMapping("/guardarProducto")
	public String registroProducto(@ModelAttribute("producto") Producto producto) {
		service.registroProducto(producto);
		return "redirect:/";
	}

	// Actualizar Producto
	@GetMapping("/actualizaProducto/{id}")
	public String actualizaProductoFormulario(@PathVariable(value = "id") int id, Model model) {
		Producto producto = service.listaProductoPorId(id);
		model.addAttribute("producto", producto);
		return "actualizaProducto";
	}

	// eliminar producto
	@GetMapping("/eliminarProducto/{id}")
	public String eliminarProducto(@PathVariable(value = "id") int id) {
		service.EliminarProducto(id);
		return "redirect:/";
	}

}

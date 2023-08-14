package com.cibertec.cl3.examen.business.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cibertec.cl3.examen.business.ProductoService;
import com.cibertec.cl3.examen.dao.ProductoRepository;
import com.cibertec.cl3.examen.model.Producto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

	private ProductoRepository repository;
	
	@Override
	public List<Producto> listaProducto() {
		return repository.findAll();
	}

	@Override
	public void registroProducto(Producto producto) {
		repository.save(producto);
		
	}

	@Override
	public Producto listaProductoPorId(int id) {
		Optional<Producto> objeto = repository.findById(id);
		Producto producto = null;
		
		if(objeto.isPresent()) {
			producto = objeto.get();
		}else {
			throw new RuntimeException("Producto con el id" + id + "no fue encontrado");
		}
		
		return producto;
	}

	@Override
	public void EliminarProducto(int id) {
		repository.deleteById(id);
		
	}
}

package com.cibertec.cl3.examen.business;

import java.util.List;

import com.cibertec.cl3.examen.model.Producto;

public interface ProductoService {

	List<Producto> listaProducto();

	void registroProducto(Producto producto);

	Producto listaProductoPorId(int id);

	void EliminarProducto(int id);

}

package com.miguel.crudclientes.model.dao;

import com.miguel.crudclientes.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente,Integer> {

}

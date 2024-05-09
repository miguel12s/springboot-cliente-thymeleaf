package com.miguel.crudclientes.services;

import com.miguel.crudclientes.model.dto.ClienteDto;
import com.miguel.crudclientes.model.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    List<Cliente> getClientes();
    Cliente createCliente(ClienteDto cliente);
    void deleteById(Integer id);
    Cliente getClienteById(Integer id);

}

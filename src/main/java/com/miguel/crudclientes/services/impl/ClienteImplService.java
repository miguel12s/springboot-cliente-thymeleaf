package com.miguel.crudclientes.services.impl;

import com.miguel.crudclientes.model.dao.ClienteDao;
import com.miguel.crudclientes.model.dto.ClienteDto;
import com.miguel.crudclientes.model.entity.Cliente;
import com.miguel.crudclientes.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;

@Service
public class ClienteImplService implements IClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    public List<Cliente> getClientes() {
        return (List) clienteDao.findAll();
    }

    @Override
    public Cliente createCliente(ClienteDto clienteDto) {
        Cliente cliente = Cliente.builder()
                .idCliente(clienteDto.getIdCliente())
                .fechaNacimiento(clienteDto.getFechaNacimiento())
                .apellido(clienteDto.getApellido())
                .correo(clienteDto.getCorreo())
                .nombre(clienteDto.getNombre())
                .telefono(clienteDto.getTelefono())
                .build();
     return  clienteDao.save(cliente);
    }

    @Override
    public void deleteById(Integer id) {
        clienteDao.deleteById(id);
    }

    @Override
    public Cliente getClienteById(Integer id) {
       return clienteDao.findById(id).orElse(null);
    }


}

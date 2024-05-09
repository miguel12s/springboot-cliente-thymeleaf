package com.miguel.crudclientes.controller;

import com.miguel.crudclientes.model.dao.ClienteDao;
import com.miguel.crudclientes.model.dto.ClienteDto;
import com.miguel.crudclientes.model.entity.Cliente;
import com.miguel.crudclientes.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


//@RequestMapping("api/v1")
@Controller 
public class ClienteController {

    @Autowired
    public IClienteService clienteService;
    @Autowired
    private ClienteDao clienteDao;

    @GetMapping("/")
    public String home(Model model, RedirectAttributes redirectAttributes){
    List<Cliente> clientes=clienteService.getClientes();
    model.addAttribute("clientes",clientes);
        System.out.println(redirectAttributes.getAttribute("mensaje"));
    if(redirectAttributes.containsAttribute("mensaje")){

        model.addAttribute("mensaje",redirectAttributes.getAttribute("mensaje"));
    }
    return "listarClientes";
}

@GetMapping("/agregarCliente")
    public String mostrarAgregar(Model model){
    model.addAttribute("cliente",new ClienteDto());
    return "agregarCliente";
}

    @PostMapping ("/agregarCliente")
    public String agregarCliente(@ModelAttribute ClienteDto clienteDto, RedirectAttributes redirectAttributes){
      Cliente cliente=null;
      cliente=clienteService.createCliente(clienteDto);
        System.out.println(cliente);
        redirectAttributes.addFlashAttribute("mensaje","el cliente ha sido añadido con exito");

        redirectAttributes.addFlashAttribute("class","success");
        return "redirect:";
    }

    @GetMapping("/deleteCliente/{id}")

    public String deleteCliente(@PathVariable Integer id){
        System.out.println(id);
        clienteService.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("actualizarCliente/{id}")

    public String actualizarCliente(@PathVariable Integer id,Model model ,RedirectAttributes redirectAttributes){
        Cliente cliente =null;
        cliente=clienteService.getClienteById(id);

        if(cliente!=null) {
            model.addAttribute("cliente", cliente);

            return "modificarCliente";
        }
            redirectAttributes.addFlashAttribute("mensaje","no se pudo encontrar el cliente asociado con ese id");
            redirectAttributes.addFlashAttribute("class","danger");
            return "redirect:/";

    }
    @PostMapping("actualizarCliente/{id}")

    public String actualizarClienteForId(@ModelAttribute ClienteDto clienteDto ,RedirectAttributes redirectAttr,@PathVariable Integer id){
        clienteDto.setIdCliente(id);
        clienteService.createCliente(clienteDto);
        redirectAttr.addFlashAttribute("mensaje","el cliente ha sido actualizado con exito");
        redirectAttr.addFlashAttribute("class","success");
        return "redirect:/";
    }




}

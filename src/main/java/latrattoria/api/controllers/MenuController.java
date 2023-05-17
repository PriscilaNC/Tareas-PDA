package latrattoria.api.controllers;

import latrattoria.api.models.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import latrattoria.api.services.MenuServices;

@Controller
    public class MenuController {
    @Autowired
    private MenuServices menuServices;

    @PostMapping("api/registrar")
    public Menu registrarMenu(@RequestBody Menu menu) {

        menuServices.registrarMenu(menu);

        return menu;
    }

    @PutMapping("api/editar/{id}")
    public ResponseEntity<?> editarMenu(@RequestBody Menu menu, @PathVariable Long id) {
        try {
            menuServices.editarMenu(menu, id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Menu editado correctamente");

    }

    @DeleteMapping("api/eliminar/{id}")
    public ResponseEntity<?> eliminarMenu(@PathVariable Long id) {
        try {
            menuServices.eliminarMenu(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Menu eliminado correctamente");

    }

    @GetMapping("/inicio")
    public String iniciar(Model model) {
        model.addAttribute("menus",menuServices.showMenu());
        return "landing-page";
    }
}
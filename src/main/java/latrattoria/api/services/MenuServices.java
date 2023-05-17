package latrattoria.api.services;

import latrattoria.api.models.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Service;
import latrattoria.api.repositories.MenuRepository;

import java.util.List;

@Service
public class MenuServices {
    @Autowired
    private MenuRepository menuRepository;

    public void registrarMenu(Menu menu) {
        menuRepository.save(menu);
    }

    public void editarMenu(Menu menuInfo, Long id) {
        Menu menu = menuRepository.findById(id).get();
        menu.setNombre_menu(menuInfo.getNombre_menu());
        menu.setDescripcion(menuInfo.getDescripcion());
        menu.setPrecio(menuInfo.getPrecio());
        menu.setValoracion(menuInfo.getValoracion());
        menu.setUrl_img(menu.getUrl_img());

        menuRepository.save(menu);
    }

    public void eliminarMenu(Long id) {

        menuRepository.deleteById(id);
    }

    public List<Menu> showMenu(){
        return menuRepository.findAll();
    }

}


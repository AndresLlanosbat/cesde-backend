import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping
    public List<Docente> listarDocentes() {
        return docenteService.listarDocentes();
    }

    @PostMapping
    public ResponseEntity<Docente> crearDocente(@RequestBody Docente docente) {
        Docente docenteCreado = docenteService.crearDocente(docente);
        return ResponseEntity.status(201).body(docenteCreado);  // 201 - Created
    }

    @PutMapping("/{id}")
    public ResponseEntity<Docente> actualizarDocente(@PathVariable Long id, @RequestBody Docente docente) {
        try {
            Docente docenteActualizado = docenteService.actualizarDocente(id, docente);
            return ResponseEntity.ok(docenteActualizado);  // 200 - OK
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();  // 404 - Not Found
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDocente(@PathVariable Long id) {
        try {
            docenteService.eliminarDocente(id);
            return ResponseEntity.status(204).build();  // 204 - No Content
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();  // 404 - Not Found
        }
    }
}

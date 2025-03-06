import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.math.BigDecimal;
import com.cesde_backend.service.CursoService;
import com.cesde_backend.dto.CursoDTO;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

 @Autowired
 private CursoService cursoService;

 @GetMapping
 public List<CursoDTO> getCursos(@RequestParam(required = false) String nombre,
                                 @RequestParam(required = false) BigDecimal precio,
                                 @RequestParam(required = false) Integer duracion) {
  return cursoService.buscarCursos(nombre, precio, duracion);
 }

 // Método para agregar un nuevo curso
 @PostMapping
 public ResponseEntity<CursoDTO> agregarCurso(@RequestBody CursoDTO cursoDTO) {
  CursoDTO cursoCreado = cursoService.agregarCurso(cursoDTO);
  return ResponseEntity.status(201).body(cursoCreado);

 @PutMapping("/{id}")
 public ResponseEntity<CursoDTO> editarCurso(@PathVariable Long id, @RequestBody CursoDTO cursoDTO) {
  try {
   CursoDTO cursoActualizado = cursoService.editarCurso(id, cursoDTO);
   return ResponseEntity.ok(cursoActualizado);
  } catch (RuntimeException e) {
   return ResponseEntity.status(404).build();
  }
 }

 // Método para eliminar un curso
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
  try {
   cursoService.eliminarCurso(id);
   return ResponseEntity.status(204).build();
  } catch (RuntimeException e) {
   return ResponseEntity.status(404).build();
  }
 }
}

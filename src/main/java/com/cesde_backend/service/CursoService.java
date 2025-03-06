import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import com.cesde_backend.dto.CursoDTO;
import com.cesde_backend.repository.CursoRepository;
import com.cesde_backend.entity.Curso;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoDTO> buscarCursos(String nombre, BigDecimal precio, Integer duracion) {
        List<Curso> cursos = cursoRepository.findAll();

        if (nombre != null) {
            cursos = cursoRepository.findByNombreContaining(nombre);
        }
        if (precio != null) {
            cursos = cursoRepository.findByPrecioLessThan(precio);
        }
        if (duracion != null) {
            cursos = cursoRepository.findByDuracionGreaterThan(duracion);
        }

        return cursos.stream()
                .map(curso -> new CursoDTO(curso))
                .toList();
    }

    public CursoDTO agregarCurso(CursoDTO cursoDTO) {
        Curso curso = new Curso();
        curso.setNombre(cursoDTO.getNombre());
        curso.setDescripcion(cursoDTO.getDescripcion());
        curso.setDuracion(cursoDTO.getDuracion());
        curso.setPrecio(cursoDTO.getPrecio());
        curso.setFechaInicio(cursoDTO.getFechaInicio());
        curso.setDocente(cursoDTO.getDocente());

        Curso nuevoCurso = cursoRepository.save(curso);
        return new CursoDTO(nuevoCurso);
    }

    public CursoDTO editarCurso(Long id, CursoDTO cursoDTO) {
        Optional<Curso> cursoExistente = cursoRepository.findById(id);

        if (cursoExistente.isPresent()) {
            Curso curso = cursoExistente.get();
            curso.setNombre(cursoDTO.getNombre());
            curso.setDescripcion(cursoDTO.getDescripcion());
            curso.setDuracion(cursoDTO.getDuracion());
            curso.setPrecio(cursoDTO.getPrecio());
            curso.setFechaInicio(cursoDTO.getFechaInicio());
            curso.setDocente(cursoDTO.getDocente());

            Curso cursoActualizado = cursoRepository.save(curso);
            return new CursoDTO(cursoActualizado);
        } else {
            throw new RuntimeException("Curso no encontrado con id " + id);
        }
    }

    public void eliminarCurso(Long id) {
        Optional<Curso> cursoExistente = cursoRepository.findById(id);

        if (cursoExistente.isPresent()) {
            cursoRepository.delete(cursoExistente.get());
        } else {
            throw new RuntimeException("Curso no encontrado con id " + id);
        }
    }
}

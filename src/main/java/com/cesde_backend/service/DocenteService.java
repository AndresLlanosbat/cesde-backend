import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.cesde_backend.repository.DocenteRepository;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    public List<Docente> listarDocentes() {
        return docenteRepository.findAll();
    }

    public Docente crearDocente(Docente docente) {
        return docenteRepository.save(docente);
    }

    public Docente actualizarDocente(Long id, Docente docente) {
        Optional<Docente> docenteExistente = docenteRepository.findById(id);
        if (docenteExistente.isPresent()) {
            docente.setId(id);
            return docenteRepository.save(docente);
        }
        throw new RuntimeException("Docente no encontrado");
    }

    public void eliminarDocente(Long id) {
        Optional<Docente> docente = docenteRepository.findById(id);
        if (docente.isPresent()) {
            docenteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Docente no encontrado");
        }
    }
}

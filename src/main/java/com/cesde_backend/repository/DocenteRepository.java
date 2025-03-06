import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cesde_backend.model.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {
    // Métodos adicionales si son necesarios, como buscar por correo
    Docente findByCorreo(String correo);
}

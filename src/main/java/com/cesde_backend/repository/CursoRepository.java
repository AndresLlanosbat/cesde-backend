import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import com.cesde_backend.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    // Métodos de búsqueda personalizados
    List<Curso> findByNombreContaining(String nombre);
    List<Curso> findByPrecioLessThan(BigDecimal precio);
    List<Curso> findByDuracionGreaterThan(Integer duracion);

    // No es necesario implementar agregar, editar y eliminar explícitamente, JpaRepository ya lo gestiona

    // Método para encontrar un curso por nombre y precio
    List<Curso> findByNombreAndPrecio(String nombre, BigDecimal precio);

    // Método para eliminar cursos basados en una condición personalizada (por ejemplo, eliminar todos los cursos con un precio mayor a un valor dado)
    void deleteByPrecioGreaterThan(BigDecimal precio);
}

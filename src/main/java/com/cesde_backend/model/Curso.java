import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.cesde_backend.model.Docente;

@Data
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    
    private String descripcion;

    private Integer duracion;

    private BigDecimal precio;

    private LocalDateTime fechaInicio;
    
    @ManyToOne
    @JoinColumn(name = "docenteId", referencedColumnName = "id")
    private Docente docente;


}
import br.com.duxusdesafio.model.Integrante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegranteRepository extends JpaRepository<Integrante, Long> {
    //como vou apenas usar os métodos CRUD, tipo save, delete, etc, nenhum método precisa ser adicionado
}

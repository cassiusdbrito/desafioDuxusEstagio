import br.com.duxusdesafio.model.ComposicaoTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComposicaoTimeRepository extends JpaRepository<ComposicaoTime, Long> {
    //como vou apenas usar os métodos CRUD, tipo save, delete, etc, nenhum método precisa ser adicionado
}
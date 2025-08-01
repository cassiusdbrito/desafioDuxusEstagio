import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;

public class ComposicaoTimePostDTO {
    private Time time;
    private Integrante integrante;

    ComposicaoTimePostDTO(Time time, Integrante integrante) {
        this.time = time;
        this.integrante = integrante;
    }
}
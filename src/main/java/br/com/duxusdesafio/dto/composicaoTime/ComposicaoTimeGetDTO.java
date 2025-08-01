import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;


public class ComposicaoTimeGetDTO {
    private Time time;
    private Integrante integrante;

    public ComposicaoTimeGetDTO(Time time, Integrante integrante) {
        this.time = time;
        this.integrante = integrante;
    }
}
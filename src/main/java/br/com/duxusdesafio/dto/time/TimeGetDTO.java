import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.ComposicaoTime;

public class TimeGetDTO {
    private LocalDate data;
    private List<ComposicaoTime> composicaoTime;

    public TimeGetDTO(LocalDate data, List<ComposicaoTime> composicaoTime) {
        this.data = data;
        this.composicaoTime = composicaoTime;
    }
}
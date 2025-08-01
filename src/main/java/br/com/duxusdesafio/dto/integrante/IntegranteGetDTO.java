import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Time;

public class IntegranteGetDTO {
    private String nome;
    private String funcao;
    private franquia;
    private List<ComposicaoTime> composicaoTime;

    public IntegranteGetDTO(String nome, String funcao, String franquia, List<ComposicaoTime> composicaoTime) {
        this.nome = nome;
        this.funcao = funcao;
        this.franquia = franquia;
        this.composicaoTime = composicaoTime;
    }
}
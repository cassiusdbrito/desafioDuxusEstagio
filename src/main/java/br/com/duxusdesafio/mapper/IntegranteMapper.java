import br.com.duxusdesafio.dto.integrante.IntegranteGetDTO;
import br.com.duxusdesafio.dto.integrante.IntegrantePostDTO;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.model.ComposicaoTime;

public class IntegranteMapper {
    public IntegranteMapper() {}

    public IntegranteGetDTO toGetDto(Integrante integrante){
        IntegranteGetDTO integranteGetDto =  new IntegranteGetDTO(integrante.getNome(), integrante.getFuncao(), integrante.getFranquia(), integrante.getComposicaoTime());

        return integranteGetDto;
    }

    public IntegrantePostDTO toPostDto(Integrante integrante){
        IntegrantePostDTO integrantePostDto = new IntegrantePostDTO(integrante.getNome(), integrante.getFuncao(), integrante.getFranquia);

        return integrantePostDto;
    }
}
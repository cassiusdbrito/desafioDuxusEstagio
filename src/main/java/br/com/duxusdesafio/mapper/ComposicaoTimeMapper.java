import br.com.duxusdesafio.dto.composicaoTime.ComposicaoTimeGetDTO;
import br.com.duxusdesafio.dto.composicaoTime.ComposicaoTimePostDTO;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.model.ComposicaoTime;

public class ComposicaoTimeMapper {
    public ComposicaoTimeMapper(){}

    public toGetDto(ComposicaoTime composicaoTime){
        ComposicaoTimeGetDTO composicaoTimeGetDto = new ComposicaoTimeGetDTO(composicaoTime.getTime(), composicaoTime.getIntegrante());

        return composicaoTimeGetDto;
    }
    public toPostDto(ComposicaoTime composicaoTime){
        ComposicaoTimePostDTO composicaoTimePostDto = new ComposicaoTimeGetDTO(composicaoTime.getTime(), composicaoTime.getIntegrante());

        return composicaoTimePostDto;
    }
}
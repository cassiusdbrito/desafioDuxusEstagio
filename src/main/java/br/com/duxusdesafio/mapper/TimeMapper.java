import br.com.duxusdesafio.dto.time.TimeGetDTO;
import br.com.duxusdesafio.dto.time.TimePostDTO;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;
import br.com.duxusdesafio.model.ComposicaoTime;


public class TimeMapper {
    public TimeMapper() {}

    public TimeGetDTO toGetDto(Time time){
        TimeGetDTO timeGetDto =  new TimeGetDTO(time.getData(), time.getComposicaoTime);

        return timeGetDto;
    }

    public TimePostDTO topostDto(Time time){
        TimeGetDTO timeGetDto =  new TimeGetDTO(time.getData());

        return timeGetDto;
    }
}
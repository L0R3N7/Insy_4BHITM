package at.htl.workloads.hobby;

import at.htl.models.HobbyDTO;
import at.htl.workloads.person.PersonServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.*;

class HobbyServiceImplTest {

    @Test
    void addHobby() {
        var dto = new HobbyDTO();
        dto.setDescription("Coding for Insy");
        dto.setOutdoor(false);

        var repoMock = Mockito.mock(HobbyRepo.class);
        ArgumentCaptor<Hobby> storedHobby = ArgumentCaptor.forClass(Hobby.class);

        var service = new HobbyServiceImpl(repoMock);
        var res = service.addHobby(dto.getDescription(), dto.getOutdoor());

        assertThat(res);
        Mockito.verify(repoMock, Mockito.times(1)).add(storedHobby.capture());

        var hobbyEntity = storedHobby.getValue();
        assertThat(hobbyEntity).isNotNull();
        assertThat(hobbyEntity.getDescription()).isEqualTo(dto.getDescription());
        assertThat(hobbyEntity.getOutdoor()).isEqualTo(dto.getOutdoor());
    }
}
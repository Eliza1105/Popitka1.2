package holidayservice.service;

import holidayservice.entity.Marinade;
import holidayservice.repository.MarinadesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarinadeService {
    private final MarinadesRepo marinadesRepo;
    public List<Marinade> findAll(){ return marinadesRepo.findAll();}

    public Marinade save(Marinade marinade){return marinadesRepo.save(marinade);}

}

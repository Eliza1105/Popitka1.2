package holidayservice.service;

import holidayservice.entity.AlcoholFree;
import holidayservice.entity.Marinade;
import holidayservice.repository.AlcoFreeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlcoholFreeService {
    private final AlcoFreeRepo alcoFreeRepo;
    public List<AlcoholFree> findAll(){ return alcoFreeRepo.findAll();}

}

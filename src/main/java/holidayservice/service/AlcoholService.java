package holidayservice.service;

import holidayservice.entity.Alcohol;
import holidayservice.entity.Food;
import holidayservice.repository.AlcoholRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlcoholService {
    private final AlcoholRepo alcoholRepo;
    public List<Alcohol> findAll(){ return alcoholRepo.findAll();}
}

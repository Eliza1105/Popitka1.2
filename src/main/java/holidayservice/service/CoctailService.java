package holidayservice.service;

import holidayservice.entity.Coctail;
import holidayservice.repository.CoctailRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoctailService {
    private final CoctailRepo coctailRepo;

    public List<Coctail> findAll(){return coctailRepo.findAll();}
}

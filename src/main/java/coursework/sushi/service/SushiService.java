package coursework.sushi.service;

import coursework.sushi.entity.SushiEntity;
import coursework.sushi.exceptions.SushiAlreadyExistException;
import coursework.sushi.exceptions.SushiNotFoundException;
import coursework.sushi.repository.SushiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SushiService {
    @Autowired
    private SushiRepo sushiRepo;
    public SushiEntity addSushi(SushiEntity sushi) throws SushiAlreadyExistException {
        if (sushiRepo.findByName(sushi.getName()) != null) {
            throw new SushiAlreadyExistException("Sushi with this name already exist.");
        }
        return sushiRepo.save(sushi);
    }
    
    public List<SushiEntity> search(String name) throws SushiNotFoundException {
        List<SushiEntity> sushiEntities;
        sushiEntities = (sushiRepo.findByNameContaining(name));
        if (sushiEntities == null) {
            throw new SushiNotFoundException("Sushi not found");
        }
        return sushiEntities;
    }

    public List<SushiEntity> getAllSushi() {
        return (List<SushiEntity>) sushiRepo.findAll();
    }

    public Long delete(Long id) {
        sushiRepo.deleteById(id);
        return id;
    }
}

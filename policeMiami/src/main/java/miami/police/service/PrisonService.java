package miami.police.service;



import miami.police.model.Prison;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PrisonService {

     void savePrison(Prison prison);
     List<Prison> findAll();
     public void deletePrisonById(long id);
}

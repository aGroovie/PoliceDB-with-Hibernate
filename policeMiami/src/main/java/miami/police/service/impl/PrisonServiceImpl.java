package miami.police.service.impl;

import miami.police.dao.PrisonDao;
import miami.police.model.Prison;
import miami.police.service.PrisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrisonServiceImpl implements PrisonService {


    PrisonDao prisonDao;

    @Autowired
    public void setPrisonDao(PrisonDao prisonDao) {
        this.prisonDao = prisonDao;
    }

    @Override
    public void savePrison(Prison prison) {
        prisonDao.savePrison(prison);
    }

    @Override
    public List<Prison> findAll() {
        return prisonDao.findAll();
    }

    @Override
    public void deletePrisonById(long id) {
        prisonDao.deletePrisonById(id);
    }
}

package miami.police.dao;



import miami.police.model.Prison;

import java.util.List;

public interface PrisonDao {
    public void savePrison(Prison prison);
    public List<Prison> findAll();
    public void deletePrisonById(long id);
}

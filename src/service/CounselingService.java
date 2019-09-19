package service;

import dao.CounselingDao;
import entity.Counseling;

import java.util.List;

public class CounselingService {
    public int getAllCount() {
        return new CounselingDao().getAllCount();
    }

    public List<Counseling> getAllContent(int indexPage, int row) {
        return new CounselingDao().getAllContent(indexPage,row);
    }
    public Counseling getById(int id) {
        return new CounselingDao().getById(id);
    }
}

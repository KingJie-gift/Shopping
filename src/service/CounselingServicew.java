package service;

import dao.CounselingDaow;
import entity.Counseling;

import java.util.List;

public class CounselingServicew {
    public int getAllCount() {
        return new CounselingDaow().getAllCount();
    }

    public List<Counseling> getAllContent(int indexPage, int row) {
        return new CounselingDaow().getAllContent(indexPage,row);
    }
    public Counseling getById(int id) {
        return new CounselingDaow().getById(id);
    }
}

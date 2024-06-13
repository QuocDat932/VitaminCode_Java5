package com.quocdat.java5.service.impl;

import com.quocdat.java5.convert.HocKiConvert;
import com.quocdat.java5.data.dto.request.HocKiDto;
import com.quocdat.java5.data.entity.HocKiE;
import com.quocdat.java5.data.model.HocKiM;
import com.quocdat.java5.repository.HocKiRepo;
import com.quocdat.java5.service.HocKiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HocKyServiceImpl implements HocKiService {

    private final HocKiRepo repo;

    @Override
    public List<HocKiM> getAllHocKy() {
        return HocKiM.convertListHocKyEToListHocKyM(repo.findAll());
    }

    @Override
    public int deleteHocKyByMaHocKy(String maHK){
        if(existsHocKyByMaHk(maHK)){
            return repo.deleteHocKy(maHK);
        }else
            return 0;
    }

    @Override
    public HocKiM saveHocKi(HocKiDto hocKiDto) {
        return HocKiM.convertHocKyEToHocKyM(
                repo.save(HocKiConvert.convertHocKiDtoToHocKiE(hocKiDto))
        );
    }

    @Override
    public boolean existsHocKyByMaHk(String maHK) {
        return repo.existsHocKiByMaHk(maHK);
    }

    @Override
    public List<HocKiM> getListHocKyByTime(String time) {
        List<HocKiE> listHocKiE = repo.getListHocKiByTime(time);
        if(listHocKiE != null){
            return HocKiM.convertListHocKyEToListHocKyM(listHocKiE);
        }
        return null;
    }
}
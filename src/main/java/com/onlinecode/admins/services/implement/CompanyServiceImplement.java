package com.onlinecode.admins.services.implement;


import com.onlinecode.admins.dao.CompanyDao;
import com.onlinecode.admins.services.CompanyService;
import com.onlinecode.core.map.MMap;
import com.onlinecode.core.map.MultiMap;
import com.onlinecode.utils.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImplement implements CompanyService {

    @Autowired
    private CompanyDao companyDao;

    @Override
    public MultiMap getList(MMap param) {
        return companyDao.getList(param);
    }

    @Override
    public Long save(MMap param) throws Exception {
        ValidatorUtil.validate(param, "name", "contact", "email");
        return companyDao.save(param);
    }

    @Override
    public Long delete(MMap param) {
        return companyDao.delete(param);
    }

    @Override
    public MMap getValueById(MMap param) throws Exception {
        ValidatorUtil.validate(param, "id");
        return companyDao.getValueById(param);
    }

    @Override
    public Long update(MMap param) throws Exception {
        ValidatorUtil.validate(param, "id", "name", "contact", "email");
        return companyDao.update(param);
    }

    @Override
    public int count() {
        return companyDao.count();
    }
}

package com.chw.chw.settings.service.impl;

import com.chw.chw.settings.domain.DicType;
import com.chw.chw.settings.mapper.DicTypeMapper;
import com.chw.chw.settings.mapper.DicValueMapper;
import com.chw.chw.settings.service.DicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dicTypeService")
public class DicTypeServiceImpl implements DicTypeService {
    @Autowired
    private DicTypeMapper dicTypeMapper;

    @Autowired
    private DicValueMapper dicValueMapper;

    @Override
    public List<DicType> queryAllDicTypes() {
        return dicTypeMapper.selectAllDicTypes();
    }

    @Override
    public DicType queryDicTypeByCode(String code) {
        return dicTypeMapper.selectDicTypeByCode(code);
    }

    @Override
    public int saveCreateDicType(DicType dicType) {
        return dicTypeMapper.insertDicType(dicType);
    }

    @Override
    public int deleteDicTypeByCodes(String[] codes) {
        //先删除这些类型下的所有数据字典值
        dicValueMapper.deleteDicValueByTypeCodes(codes);

        return dicTypeMapper.deleteDicTypeByCodes(codes);
    }

    @Override
    public int saveEditDicType(DicType dicType) {
        return dicTypeMapper.updateDicType(dicType);
    }
}

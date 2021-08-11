package com.chw.chw.settings.service;

import com.chw.chw.settings.domain.DicType;

import java.util.List;

public interface DicTypeService {
    List<DicType> queryAllDicTypes();

    DicType queryDicTypeByCode(String code);

    int saveCreateDicType(DicType dicType);

    int deleteDicTypeByCodes(String[] codes);

    int saveEditDicType(DicType dicType);
}

package com.chw.chw.settings.service;

import com.chw.chw.settings.domain.DicValue;

import java.util.List;

public interface DicValueService {
    List<DicValue> queryDicValueByTypeCode(String typeCode);

    List<DicValue> queryAllDicValues();

    int saveCreateDicValue(DicValue dicValue);

    int deleteDicValueByIds(String[] ids);

    DicValue queryDicValueById(String id);

    int saveEditDicValue(DicValue dicValue);
}

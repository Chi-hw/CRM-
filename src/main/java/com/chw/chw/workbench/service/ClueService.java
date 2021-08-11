package com.chw.chw.workbench.service;

import com.chw.chw.workbench.domain.Clue;

import java.util.List;
import java.util.Map;

public interface ClueService {
    int saveCreateClue(Clue clue);

    List<Clue> queryClueForPageByCondition(Map<String, Object> map);

    long queryCountOfClueByCondition(Map<String, Object> map);

    Clue queryClueForDetailById(String id);

    void saveConvert(Map<String, Object> map);
}

package com.jizhang.jizhang.service.impl;

import com.jizhang.jizhang.dao.SuggestMapper;
import com.jizhang.jizhang.model.Suggest;
import com.jizhang.jizhang.service.SuggestService;
import com.jizhang.jizhang.utils.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by alwaysacc on 2019/03/13.
 */
@Service
@Transactional
public class SuggestServiceImpl extends AbstractService<Suggest> implements SuggestService {
    @Resource
    private SuggestMapper suggestMapper;

}

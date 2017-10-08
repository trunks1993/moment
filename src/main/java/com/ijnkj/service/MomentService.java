package com.ijnkj.service;

import com.ijnkj.dao.domain.Moment;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

public interface MomentService extends BaseService<Moment> {

    Moment insertCache(Moment entity);

}

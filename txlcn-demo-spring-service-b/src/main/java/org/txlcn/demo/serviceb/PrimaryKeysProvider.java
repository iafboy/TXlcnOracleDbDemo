package org.txlcn.demo.serviceb;

import com.codingapi.txlcn.common.util.Maps;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * Date: 19-1-25 下午4:29
 *
 * @author ujued
 */
@Component
public class PrimaryKeysProvider implements com.codingapi.txlcn.tc.core.transaction.txc.analy.def.PrimaryKeysProvider {

    @Override
    public Map<String, List<String>> provide() {
        return Maps.of("t_demo", Collections.singletonList("id"));
    }
}

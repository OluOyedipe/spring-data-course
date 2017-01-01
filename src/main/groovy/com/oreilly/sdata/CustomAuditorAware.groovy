package com.oreilly.sdata

import org.springframework.data.domain.AuditorAware

/**
 * Created by oo185005 on 1/1/17.
 */
class CustomAuditorAware implements AuditorAware<String> {

    @Override
    String getCurrentAuditor() {
        'Olu Oyedipe'
    }
}

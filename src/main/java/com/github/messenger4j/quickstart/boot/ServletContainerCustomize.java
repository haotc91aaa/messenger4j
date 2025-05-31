package com.github.messenger4j.quickstart.boot;

import com.github.messenger4j.quickstart.boot.config.AppCfg;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;


@Component
public class ServletContainerCustomize implements EmbeddedServletContainerCustomizer {

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(AppCfg.getPropertyAsInt("US_PORT"));
	}

}

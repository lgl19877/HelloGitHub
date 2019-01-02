package com.boot.datamybatis.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import java.util.Collections;
/**
 * @Auther: 刘贵龙
 * @Date: 2018/12/27 0027 16:36
 * @Description:
 */
@ConfigurationProperties(prefix = "spring.resources", ignoreUnknownFields = false)
public class ResourceProperties implements ResourceLoaderAware {
    private static final Logger logger = LoggerFactory.getLogger(ResourceProperties.class);
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        //可以设置和静态资源有关的参数，缓存时间等
    }
    /*  @Override
      public void addResourceHandlers(ResourceHandlerRegistry registry) {
          if (!this.resourceProperties.isAddMappings()) {
              logger.debug("Default resource handling disabled");
              return;
          }
        Integer cachePeriod = this.resourceProperties.getCachePeriod();
        if (!registry.hasMappingForPattern("/webjars/**")) {
            customizeResourceHandlerRegistration(
                    registry.addResourceHandler("/webjars/**")
                            .addResourceLocations(
                                    "classpath:/META-INF/resources/webjars/")
                            .setCachePeriod(cachePeriod));
        }
        String staticPathPattern = this.mvcProperties.getStaticPathPattern();
        //静态资源文件夹映射
        if (!registry.hasMappingForPattern(staticPathPattern)) {
            customizeResourceHandlerRegistration(
                    registry.addResourceHandler(staticPathPattern)
                            .addResourceLocations(
                                    this.resourceProperties.getStaticLocations())
                            .setCachePeriod(cachePeriod));
        }
    }

    //配置欢迎页映射
    @Bean
    public WelcomePageHandlerMapping welcomePageHandlerMapping(
            org.springframework.boot.autoconfigure.web.ResourceProperties resourceProperties) {
        return new WelcomePageHandlerMapping(resourceProperties.getWelcomePage(),
                this.mvcProperties.getStaticPathPattern());
    }

    //配置喜欢的图标
    @Configuration
    @ConditionalOnProperty(value = "spring.mvc.favicon.enabled", matchIfMissing = true)
    public static class FaviconConfiguration {

        private final org.springframework.boot.autoconfigure.web.ResourceProperties resourceProperties;

        public FaviconConfiguration(org.springframework.boot.autoconfigure.web.ResourceProperties resourceProperties) {
            this.resourceProperties = resourceProperties;
        } */

    //  @Bean
     /*   public SimpleUrlHandlerMapping faviconHandlerMapping() {
             SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
             mapping.setOrder(Ordered.HIGHEST_PRECEDENCE + 1);*/
            //所有  **/favicon.ico
    //   mapping.setUrlMap(Collections.singletonMap("**/favicon.ico",
    //         faviconRequestHandler()));
    //      return mapping;
    //     }

      //  @Bean
       /* public ResourceHttpRequestHandler faviconRequestHandler() {
            ResourceHttpRequestHandler requestHandler = new ResourceHttpRequestHandler();
            requestHandler
                    .setLocations(this.resourceProperties.getFaviconLocations());
            return requestHandler;
        }
        }*/


}

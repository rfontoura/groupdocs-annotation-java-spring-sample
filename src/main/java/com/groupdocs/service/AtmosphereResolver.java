package com.groupdocs.service;

import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Meteor;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * Atmosphere class resolver
 * Created by Aleksey Permyakov on 13.06.14.
 */
public class AtmosphereResolver implements HandlerMethodArgumentResolver {
    /**
     * Check that parameter is supported
     *
     * @param methodParameter parameter to check
     * @return true if support else false
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return AtmosphereResource.class.isAssignableFrom(methodParameter.getParameterType());
    }

    /**
     * Resolve argument
     *
     * @param methodParameter       Method parameter
     * @param modelAndViewContainer Model and view container
     * @param nativeWebRequest      Native web request
     * @param webDataBinderFactory  Web data binder factory
     * @return argument object
     * @throws Exception
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Meteor m = Meteor.build(nativeWebRequest.getNativeRequest(HttpServletRequest.class));
        return m.getAtmosphereResource();
    }
}

package com.groupdocs.connector;

import com.groupdocs.annotation.connector.data.AbstractDataConnector;
import com.groupdocs.annotation.db.dao.interfaces.*;
import com.groupdocs.annotation.exception.AnnotationException;
import com.groupdocs.connector.dao.*;

/**
 * @author Aleksey Permyakov (13.10.2014)
 */
public class CustomXmlDataConnector extends AbstractDataConnector {
    @Override
    public IAnnotationDao getAnnotationDao() throws AnnotationException {
        return new CustomXmlAnnotationDaoImpl();
    }

    @Override
    public ICollaboratorDao getCollaboratorDao() throws AnnotationException {
        return new CustomXmlCollaboratorDaoImpl();
    }

    @Override
    public IDocumentDao getDocumentDao() throws AnnotationException {
        return new CustomXmlDocumentDaoImpl();
    }

    @Override
    public IReplyDao getReplyDao() throws AnnotationException {
        return new CustomXmlReplyDaoImpl();
    }

    @Override
    public ISessionDao getSessionDao() throws AnnotationException {
        return new CustomXmlSessionDaoImpl();
    }

    @Override
    public ISystemInfoDao getSystemInfoDao() throws AnnotationException {
        return new CustomXmlSystemInfoDaoImpl();
    }

    @Override
    public IUserDao getUserDao() throws AnnotationException {
        return new CustomXmlUserDaoImpl();
    }

    @Override
    public IAnnDocDao getAnnDocDao() throws AnnotationException {
        return new CustomXmlAnnDocDaoImpl();
    }
}
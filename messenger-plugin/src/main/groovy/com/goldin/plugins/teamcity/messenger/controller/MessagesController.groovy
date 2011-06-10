package com.goldin.plugins.teamcity.messenger.controller

import com.goldin.plugins.teamcity.messenger.api.MessagesContext
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import jetbrains.buildServer.controllers.BaseController
import jetbrains.buildServer.serverSide.SBuildServer
import jetbrains.buildServer.web.openapi.WebControllerManager
import org.gcontracts.annotations.Requires
import org.springframework.web.servlet.ModelAndView


/**
 * Controller returning messages to be displayed
 */
class MessagesController extends BaseController
{

    final MessagesContext context

    @Requires({ server && manager && context })
    MessagesController ( SBuildServer         server,
                         WebControllerManager manager,
                         MessagesContext      context )
    {
        super( server )
        this.context = context
        manager.registerController( '/messagesDisplay.html', this )
    }


    @Override
    protected ModelAndView doHandle ( HttpServletRequest  request,
                                      HttpServletResponse response )
    {
        new ModelAndView( "/plugins/${ context.pluginName }/messages.jsp",
                          [ a:'b', c:'d' ] )
    }
}

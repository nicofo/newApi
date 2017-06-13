/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crumbits.API;

import com.crumbits.Bean;
import com.crumbits.Info.*;
//import com.crumbits.Entrada.EntradaCrumb;
import com.crumbits.Error.Success;
//import com.crumbits.ReturnClasses.IsSharing;
//import com.crumbits.ReturnClasses.IsThanking;
import com.crumbits.Utilities.MockUtilities;
import com.google.api.server.spi.auth.EspAuthenticator;
import com.google.api.server.spi.auth.common.User;
import com.google.api.auth.Authenticator;
import com.google.api.auth.UnauthenticatedException;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiIssuer;
import com.google.api.server.spi.config.ApiIssuerAudience;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.UnauthorizedException;
import com.google.api.server.spi.response.NotFoundException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Nico Forteza
 */
@Api(
        name = "crumb",
        version="v2",
        //namespace = @ApiNamespace(ownerDomain = "com.crumbits",
        //ownerName = "com.crumbits",
        //packagePath="")
        authenticators = {EspAuthenticator.class},
        issuers = {
                @ApiIssuer(
                        name = "firebase",
                        issuer = "https://securetoken.google.com/YOUR-PROJECT-ID",
                        jwksUri = "https://www.googleapis.com/service_accounts/v1/metadata/x509/securetoken@system.gserviceaccount.com")
        },
        issuerAudiences = {
                @ApiIssuerAudience(name = "firebase", audiences = "YOUR-PROJECT-ID")
        }
        )

public class crumbAPI {


    /**
    * @api {get} /crumb/v2/:id Crumb by Id
    * @apiName getCrumbById
    * @apiGroup Crumb
    *
     * @apiPermission none
    * @apiParam {String} id Crumb unique ID.
    *
    * @apiSuccess {String} description Description of the crumb
     * @apiSuccess {Date} date Date related to th crumb
     * @apiSuccess {fileInfo[]} crumbFile Files of the content of the crumb
     * @apiSuccess {Number} relevance Relevance of the crumb
     * @apiSuccess {Number} nreShares Number of shares of the crumb.
     * @apiSuccess {Number} nreThanks Numeber of thanks of the crumb
     * @apiSuccess {Number} nreReports Number of reports of the crumb
     * @apiSuccess {Number} nreComments Number of comments of the crumb
     * @apiSuccess {Number} nreViews Number of views of the crumb
     * @apiSuccess {number} epochDate The epoch date of publication o the crumb
     * @apiSuccess {Boolean} isUserShare if the user liked the crumb
     * @apiSuccess {Boolean} isUserThanks if the user tahnked the crumb
     * @apiSuccess {Boolean} isOwner if the crumb is yours
     * @apiSuccess {placeInfo} place Place of the crumb
     * @apiSuccess {themeInfo[]} themes Array of all themes related to the crumb
     *
     *
     *
    *
    *  @apiSuccessExample {json} Success-Response:
    *     HTTP/1.1 200 OK
    *   {
        "data" : {
            "id" : "21333331",
            "description" : "This is a crumb description",
            "date" : "2017-06-12T12:14:12.296+02:00",
            "crumbFile" : [ {
                "isVideo" : false
            } ],
            "relevance" : 5,
            "nreShares" : 3,
            "nreThanks" : 4,
            "nreReports" : 0,
            "nreComments" : 2,
            "nreViews" : 3,
            "epochDate" : "1497262452",
            "isUserShare" : false,
            "isUserThanks" : true,
            "thumbnail" : {
                "isVideo" : false
            },
            "isOwner" : false,
            "place" : {
                "name" : "Barcelona",
                "coordinate" : {
                    "lat" : 41.3963097,
                    "lng" : 2.1653831
                },
                "type" : "type",
                "nreCrumbs" : 10,
                "nreUsersFollowing" : 12,
                "isFollowing" : true,
                "placeFile" : {
                    "isVideo" : false
                },
                "googleId" : "ChIJ_5rXKOyipBIRkvCCQOH6ACY"
            },
            "themes" : [ {
                "name" : "#barcelona",
                "nreCrumbs" : 10,
                "nreUsersFollowing" : 12,
                "isFollowing" : true,
                "themeFile" : {
                    "isVideo" : false
                }
            } ]
        }
    }

    * @apiError {404} NotFound The id of the Crumb was not found.
    *
    * @apiErrorExample Error-Response:
    *     HTTP/1.1 404 Not Found
    *     {
                "error" : {
                    "message" : "Crumb not found with id: 2133",
                    "code" : 404,
                    "errors" : [ {
                        "domain" : "global",
                        "reason" : "notFound",
                        "message" : "Crumb not found with id: 2133"
                    }   ]
                }
            }
    *
    *
    */
    @ApiMethod(name = "getCrumbById",path = "{crumbId}",httpMethod = ApiMethod.HttpMethod.GET)
    public Object getCrumbById(@Named("crumbId") String crumbId) throws IOException, NotFoundException, UnauthorizedException {

        try{


            if(crumbId.length() <=6){
                throw new NotFoundException("Crumb not found with id"+ crumbId);
            }
            //TODO Only for the mock
            MockUtilities u = new MockUtilities();
            CrumbInfo ci = u.entityToCrumb(crumbId);
            Bean response = new Bean();
            response.setData(ci);
            return response;

        }
        /*
        TODO Quit False exeption and add the corrects
        catch(IllegalAccessException iae){
            throw new UnauthorizedException("");
        }
        catch (EntityNotFoundException e){
            throw new NotFoundException("Not found by this Id");
        }
        */
        catch(Exception e){
            throw new NotFoundException("Crumb not found with id: "+ crumbId);
        }
    }


    /**
     * @api {get} /crumb/v2/:id Crumb by Id
     * @apiName getCrumbByIdUser
     * @apiGroup Crumb
     * @apiPermission User
     *
     * @apiParam {String} id Crumb unique ID.
     *
     * @apiSuccess {String} description Description of the crumb
     * @apiSuccess {Date} date Date related to th crumb
     * @apiSuccess {fileInfo[]} crumbFile Files of the content of the crumb
     * @apiSuccess {Number} relevance Relevance of the crumb
     * @apiSuccess {Number} nreShares Number of shares of the crumb.
     * @apiSuccess {Number} nreThanks Numeber of thanks of the crumb
     * @apiSuccess {Number} nreReports Number of reports of the crumb
     * @apiSuccess {Number} nreComments Number of comments of the crumb
     * @apiSuccess {Number} nreViews Number of views of the crumb
     * @apiSuccess {number} epochDate The epoch date of publication o the crumb
     * @apiSuccess {Boolean} isUserShare if the user liked the crumb
     * @apiSuccess {Boolean} isUserThanks if the user tahnked the crumb
     * @apiSuccess {Boolean} isOwner if the crumb is yours
     * @apiSuccess {placeInfo} place Place of the crumb
     * @apiSuccess {themeInfo[]} themes Array of all themes related to the crumb
     *
     *
     *
     *
     *  @apiSuccessExample {json} Success-Response:
     *     HTTP/1.1 200 OK
     *   {
    "data" : {
    "id" : "21333331",
    "description" : "This is a crumb description",
    "date" : "2017-06-12T12:14:12.296+02:00",
    "crumbFile" : [ {
    "isVideo" : false
    } ],
    "relevance" : 5,
    "nreShares" : 3,
    "nreThanks" : 4,
    "nreReports" : 0,
    "nreComments" : 2,
    "nreViews" : 3,
    "epochDate" : "1497262452",
    "isUserShare" : false,
    "isUserThanks" : true,
    "thumbnail" : {
    "isVideo" : false
    },
    "isOwner" : false,
    "place" : {
    "name" : "Barcelona",
    "coordinate" : {
    "lat" : 41.3963097,
    "lng" : 2.1653831
    },
    "type" : "type",
    "nreCrumbs" : 10,
    "nreUsersFollowing" : 12,
    "isFollowing" : true,
    "placeFile" : {
    "isVideo" : false
    },
    "googleId" : "ChIJ_5rXKOyipBIRkvCCQOH6ACY"
    },
    "themes" : [ {
    "name" : "#barcelona",
    "nreCrumbs" : 10,
    "nreUsersFollowing" : 12,
    "isFollowing" : true,
    "themeFile" : {
    "isVideo" : false
    }
    } ]
    }
    }

     * @apiError {404} NotFound The id of the Crumb was not found.
     *
     * @apiErrorExample Error-Response:
     *     HTTP/1.1 404 Not Found
     *     {
    "error" : {
    "message" : "Crumb not found with id: 2133",
    "code" : 404,
    "errors" : [ {
    "domain" : "global",
    "reason" : "notFound",
    "message" : "Crumb not found with id: 2133"
    }   ]
    }
    }
     *
     *
     */
    @ApiMethod(name = "getCrumbByIdUser",path = "{crumbId}",httpMethod = ApiMethod.HttpMethod.GET)
    public Object getCrumbById(@Named("crumbId") String crumbId,User user) throws IOException, NotFoundException {

        try{


            if(crumbId.length() <=6){
                throw new NotFoundException("Crumb not found with id"+ crumbId);
            }
            //TODO Only for the mock
            MockUtilities u = new MockUtilities();
            CrumbInfo ci = u.entityToCrumb(crumbId);
            Bean response = new Bean();
            response.setData(ci);
            return response;

        }
        /*
        TODO Quit False exeption and add the corrects
        catch(IllegalAccessException iae){
            throw new UnauthorizedException("");
        }
        catch (EntityNotFoundException e){
            throw new NotFoundException("Not found by this Id");
        }
        */
        catch(Exception e){
            throw new NotFoundException("Crumb not found with id: "+ crumbId);
        }
    }



    /**
     * @api {post} /crumb/v2/ Create crumb
     * @apiName createCrumb
     * @apiGroup Crumb
     * @apiPermission User
     *
     * @apiParam {String} creatorId Creator unique ID.
     *
     * @apiParam {String} description Description of the crumb
     * @apiParam {Date} date Date related to th crumb
     * @apiParam {Double} lat Latitude coordinate
     * @apiParam {Double} long Longitude coordinate
     * @apiParam {String} googlePlaceId googlePlace Id
     * @apiParam {Sting} placeName Name of the place where this is take
     * @apiParam {files} files Number of reports of the crumb
     * @apiParam {Strin[]} themesId Number of comments of the crumb
     * @apiParam {Boolean} sensitiveContent Number of views of the crumb
     * @apiParam {Boolean} signature The epoch date of publication o the crumb
     *
     * @apiSuccess {String} crumbId Id of the crumb just created
     *
     *
     *
     *  @apiSuccessExample {json} Success-Response:
     *     HTTP/1.1 200 OK
     *
     * @apiError {404} NotFound The id of the Crumb was not found.
     *
     * @apiErrorExample Error-Response:
     *     HTTP/1.1 404 Not Found
     *     {
    "error" : {
    "message" : "Crumb not found with id: 2133",
    "code" : 404,
    "errors" : [ {
    "domain" : "global",
    "reason" : "notFound",
    "message" : "Crumb not found with id: 2133"
    }   ]
    }
    }
     *
     *
     */
    @ApiMethod(name = "createCrumb",path = "",httpMethod = ApiMethod.HttpMethod.POST)
    public Object createCrumb(@Named("creatorId") String creatorId, @Named("description") String description, @Named("date") Date date, @Named("lat") Double lat, @Named("lng") Double lng, @Named("googlePlaceId") String googlePlaceId, @Named("placeName") String placeName, @Named("files") ArrayList<String> files, @Named("themesId") ArrayList<String> themesId, @Named("sensitiveContent") Boolean sensitiveContent, @Named("signature") String signature ,User user) throws IOException, NotFoundException, UnauthorizedException {
        throw new UnauthorizedException("");

    }



    @ApiMethod(name = "editCrumb",path = "{crumbId}",httpMethod = ApiMethod.HttpMethod.PUT)
    public Object editCrumb(@Named("crumbId") String crumbId, @Named("description") String description, @Named("date") Date date, @Named("lat") Double lat, @Named("lng") Double lng, @Named("googlePlaceId") String googlePlaceId, @Named("placeName") String placeName, @Named("files") ArrayList<String> files, @Named("themesId") ArrayList<String> themesId, @Named("sensitiveContent") Boolean sensitiveContent, @Named("signature") String signature ,User user) throws IOException, NotFoundException, UnauthorizedException {
        throw new UnauthorizedException("");

    }

    @ApiMethod(name = "deleteCrumb",path = "{crumbId}",httpMethod = ApiMethod.HttpMethod.DELETE)
    public Object deleteCrumb(@Named("crumbId") String crumbId, User user) throws IOException, NotFoundException, UnauthorizedException {
        throw new UnauthorizedException("");

    }

    @ApiMethod(name = "thankedCrumb",path = "{crumbId}/thanks",httpMethod = ApiMethod.HttpMethod.GET)
    public Object thankedCrumb(@Named("crumbId") String crumbId, User user) throws IOException, NotFoundException, UnauthorizedException {
        throw new UnauthorizedException("");

    }
    @ApiMethod(name = "thanksCrumb",path = "{crumbId}/thanks",httpMethod = ApiMethod.HttpMethod.PUT)
    public Object thanksCrumb(@Named("crumbId") String crumbId, @Named("thanks") Boolean thanks, User user) throws IOException, NotFoundException, UnauthorizedException {
        throw new UnauthorizedException("");

    }
    @ApiMethod(name = "sharedCrumb",path = "{crumbId}/share",httpMethod = ApiMethod.HttpMethod.GET)
    public void sharedCrumb(@Named("crumbId") String crumbId) throws IOException, NotFoundException, UnauthorizedException {
        return ;

    }

    @ApiMethod(name = "shareCrumb",path = "{crumbId}/share",httpMethod = ApiMethod.HttpMethod.PUT)
    public Object shareCrumb(@Named("crumbId") String crumbId) throws IOException, NotFoundException {
        return 2;

    }
    @ApiMethod(name = "viewedCrumb",path = "{crumbId}/view",httpMethod = ApiMethod.HttpMethod.GET)
    public void viewedCrumb(@Named("crumbId") String crumbId, User user) throws IOException, NotFoundException {
        return;

    }

    @ApiMethod(name = "viewCrumb",path = "{crumbId}/view",httpMethod = ApiMethod.HttpMethod.PUT)
    public Object viewCrumb(@Named("crumbId") String crumbId, User user) throws IOException, NotFoundException, UnauthorizedException {
        return 5;

    }

    @ApiMethod(name = "lastCommentsCrumb",path = "{crumbId}/lastComments",httpMethod = ApiMethod.HttpMethod.GET)
    public Object lastCommentsCrumb(@Named("crumbId") String crumbId) throws IOException, NotFoundException {
        try {


            if (crumbId.length() <= 6) {
                throw new NotFoundException("Crumb not found with id" + crumbId);
            }
            MockUtilities u = new MockUtilities();
            ArrayList<CommentInfo> ci = new ArrayList<CommentInfo>();

            for (int i = 0; i < 3; i++) {
                ci.add(u.entityToComments(crumbId));
            }
            Success s = new Success();
            s.setRet(ci);
            return s;
        }
        catch(Exception e){
            throw new NotFoundException("Crumb not found with id: "+ crumbId);
        }

    }

    @ApiMethod(name = "getEmbedUrl",path = "{crumbId}/url",httpMethod = ApiMethod.HttpMethod.GET)
    public Object getEmbedUrl(@Named("crumbId") String crumbId) throws IOException, NotFoundException{
        return 5;

    }

    @ApiMethod(name = "buyContent",path = "{crumbId}/buy",httpMethod = ApiMethod.HttpMethod.POST)
    public Object buyContent(@Named("crumbId") String crumbId, User user) throws IOException, NotFoundException,  UnauthorizedException {
        return 5;

    }


}

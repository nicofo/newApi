/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crumbits.API;

import com.crumbits.Info.*;
//import com.crumbits.Entrada.EntradaCrumb;
import com.crumbits.Error.Success;
//import com.crumbits.ReturnClasses.IsSharing;
//import com.crumbits.ReturnClasses.IsThanking;
import com.crumbits.Utilities.MockUtilities;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.UnauthorizedException;
import com.google.api.server.spi.response.NotFoundException;

import java.io.IOException;

/**
 *
 * @author Miquel Ferriol
 */
@Api(name = "crumbAPI",
        version = "v1",
        namespace = @ApiNamespace(ownerDomain = "com.crumbits",
        ownerName = "com.crumbits",
        packagePath=""))

public class crumbAPI {

    /**
     *
     * @param en
     * @param req
     * @return
     */
     /**
     * @api {get} /user/:id Request User information
     * @apiName getCrumbById
     * @apiGroup Crumb
     *
     * @apiParam {Number} id Crumb unique ID.
     *
     * @apiSuccess {String} firstname Firstname of the User.
     *
     * @apiError UserNotFound The id of the User was not found.
     *
     * @apiErrorExample Error-Response:
     *     HTTP/1.1 404 Not Found
     *     {
     *       "error": "UserNotFound"
     *     }
     *
     *
     */
    @ApiMethod(name = "getCrumbById",path = "getCrumbById",httpMethod = ApiMethod.HttpMethod.GET)
    public Object getCrumbById(String id) throws IOException, NotFoundException, UnauthorizedException {

        try{


            if(id.length() <=6){
                throw new NotFoundException("Not found by this Id");
            }
            //TODO Only for the mock
            MockUtilities u = new MockUtilities();
            CrumbInfo ci = u.entityToCrumb(id);
            Success s = new Success();
            s.setRet(ci);
            return s;

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
            throw new NotFoundException("Not found by this Id");
        }
    }

  /*  *//**
     *
     * @param en
     * @param req
     * @return
     *//*
    @ApiMethod(name = "getIsUserThanksCrumb", path = "getIsUserThanksCrumb",httpMethod = ApiMethod.HttpMethod.POST)
    public Object getIsUserThanksCrumb(EntradaCrumb en, HttpServletRequest req){
        try{
            Crumb c = new Crumb((String)req.getHeader("accessToken"));
            IsThanking b = c.getIsUserThanksCrumb(en.getCrumbId());
            Success s = new Success();
            s.setRet(b);
            return s;

        }
        catch(IllegalAccessException iae){
            return new Errors().tokenError;
        }
        catch (EntityNotFoundException e){
            return new Errors().idError;
        }
    }
    //createCrumb(String creatorId, String description, ArrayList<String> themesId, String place, String googlePlaceId, double lat, double lng, Date date, ArrayList<String> fileId)

    *//**
     *
     * @param en
     * @param req
     * @return
     *//*
        @ApiMethod(name = "createCrumbWeb",path = "createCrumbWeb",httpMethod = ApiMethod.HttpMethod.POST)
    public Object createCrumbWeb(EntradaCrumb en, HttpServletRequest req) throws IOException {
        try{
            Crumb c = new Crumb((String)req.getHeader("accessToken"));
            Success s = new Success();
            ArrayList<String> filesId = new ArrayList<>();
            Storage f = new Storage();
            for(int i = 0; i < en.getBase64().size(); ++i){
                filesId.add(f.upLoadFile(Base64.decodeBase64(en.getBase64().get(i).getBytes())));
            }
            c.createCrumb(en.getCreatorId(),en.getDescription(), en.getThemesId(), en.getPlace(), en.getGooglePlaceId(), en.getLat(), en.getLng(), en.getDate(), filesId,null,0,false);
            return s;
        }
        catch(IllegalAccessException iae){
            return new Errors().tokenError;
        }
        catch (EntityNotFoundException e){
            return new Errors().idError;
        }
    }

    *//**
     *
     * @param en
     * @param req
     * @return
     *//*
    @ApiMethod(name = "getIsUserSharesCrumb",path = "getIsUserSharesCrumb",httpMethod = ApiMethod.HttpMethod.POST)
    public Object getIsUserSharesCrumb(EntradaCrumb en, HttpServletRequest req){
        try{
            Crumb c = new Crumb((String)req.getHeader("accessToken"));
            IsSharing b = c.getIsUserSharesCrumb(en.getCrumbId());
            Success s = new Success();
            s.setRet(b);
            return s;

        }
        catch(IllegalAccessException iae){
            return new Errors().tokenError;
        }
        catch (EntityNotFoundException e){
            return new Errors().idError;
        }
    }

    *//**
     *
     * @param en
     * @param req
     * @return
     *//*
    @ApiMethod(name = "getLastComments",path = "getLastComments",httpMethod = ApiMethod.HttpMethod.POST)
    public Object getLastComments(EntradaCrumb en, HttpServletRequest req) {
        try{
            Crumb c = new Crumb((String)req.getHeader("accessToken"));
            return c.getLastComments(en.getCrumbId());

        }
        catch(IllegalAccessException iae){
            return new Errors().tokenError;
        }
        catch (EntityNotFoundException e){
            return new Errors().idError;
        }
    }

    *//**
     *
     * @param en
     * @param req
     * @return
     *//*
    @ApiMethod(name = "getRelatedCrumbs",path = "getRelatedCrumbs",httpMethod = ApiMethod.HttpMethod.POST)
    public Object getRelatedCrumbs(EntradaCrumb en, HttpServletRequest req) throws IOException {
        try{
            Crumb c = new Crumb((String)req.getHeader("accessToken"));
            Success s = new Success();
            s.setRet(c.getRelatedCrumbs(en.getCrumbId()));
            return s;

        }
        catch(IllegalAccessException iae){
            return new Errors().tokenError;
        }
        catch (EntityNotFoundException e){
            return new Errors().idError;
        }
    }

    *//**
     *
     * @param en
     * @param req
     * @return
     *//*
    @ApiMethod(name = "thanksCrumb",path = "thanksCrumb",httpMethod = ApiMethod.HttpMethod.POST)
    public Object thanksCrumb(EntradaCrumb en, HttpServletRequest req) throws IOException {
        try{
            Crumb c = new Crumb((String)req.getHeader("accessToken"));
            c.thanksCrumb( en.getCrumbId());

            return new Success();

        }
        catch(IllegalAccessException iae){
            return new Errors().tokenError;
        }
        catch (EntityNotFoundException e){
            return new Errors().idError;
        }
    }

    *//**
     *
     * @param en
     * @param req
     * @return
     *//*
    @ApiMethod(name = "unthanksCrumb",path = "unthanksCrumb",httpMethod = ApiMethod.HttpMethod.POST)
    public Object unthanksCrumb(EntradaCrumb en, HttpServletRequest req) {
        try{
            Crumb c = new Crumb((String)req.getHeader("accessToken"));
            c.unthanksCrumb( en.getCrumbId());

            return new Success();

        }
        catch(IllegalAccessException iae){
            return new Errors().tokenError;
        }
        catch (EntityNotFoundException e){
            return new Errors().idError;
        }
    }

    *//**
     *
     * @param en
     * @param req
     * @return
     *//*
    @ApiMethod(name = "shareCrumb",path = "shareCrumb",httpMethod = ApiMethod.HttpMethod.POST)
    public Object shareCrumb(EntradaCrumb en, HttpServletRequest req) throws IOException {
        try{
            Crumb c = new Crumb((String)req.getHeader("accessToken"));
            c.shareCrumb( en.getCrumbId(), en.getType());

            return new Success();

        }
        catch(IllegalAccessException iae){
            return new Errors().tokenError;
        }
        catch (EntityNotFoundException e){
            return new Errors().idError;
        }
    }

    *//**
     *
     * @param en
     * @param req
     * @return
     *//*
    @ApiMethod(name = "reportCrumb",path = "reportCrumb",httpMethod = ApiMethod.HttpMethod.POST)
    public Object reportCrumb(EntradaCrumb en, HttpServletRequest req) {
        try{
            Crumb c = new Crumb((String)req.getHeader("accessToken"));
            c.reportCrumb( en.getCrumbId(), en.getType(), en.getComments());

            return new Success();

        }
        catch(IllegalAccessException iae){
            return new Errors().tokenError;
        }
        catch (EntityNotFoundException e){
            return new Errors().idError;
        }
    }

    *//**
     *
     * @param en
     * @param req
     * @return
     *//*
    @ApiMethod(name = "getCrumbsByPlace",path = "getCrumbsByPlace",httpMethod = ApiMethod.HttpMethod.POST)
    public Object getCrumbsByPlace(EntradaCrumb en, HttpServletRequest req) throws IOException {
        try{
            Crumb c = new Crumb((String)req.getHeader("accessToken"));
            Success s = new Success();
            s.setRet(c.getCrumbsByPlace(en.getBotLat(), en.getBotLng(), en.getTopLat(), en.getTopLng()));
            return s;
        }
        catch(IllegalAccessException iae){
            return new Errors().tokenError;
        }
        catch (EntityNotFoundException e){
            return new Errors().idError;
        }
    }

    *//**
     *
     * @param en
     * @param req
     * @return
     *//*
    @ApiMethod(name = "getLocalCrumbs",path = "getLocalCrumbs",httpMethod = ApiMethod.HttpMethod.POST)
    public Object getLocalCrumbs(EntradaCrumb en, HttpServletRequest req) throws IOException {
        try{
            Crumb c = new Crumb((String)req.getHeader("accessToken"));
            Success s = new Success();
            s.setRet(c.getLocalCrumbs(en.getBotLat(), en.getBotLng(), en.getTopLat(), en.getTopLng(), en.getInitDate(), en.getEndDate(), en.getPage(), en.getPageSize()));
            return s;
        }
        catch(IllegalAccessException iae){
            return new Errors().tokenError;
        }
        catch (EntityNotFoundException e){
            return new Errors().idError;
        }
    }

    *//**
     *
     * @param en
     * @param req
     * @return
     *//*
    @ApiMethod(name = "combinedSearchCrumbs",path = "combinedSearchCrumbs",httpMethod = ApiMethod.HttpMethod.POST)
    public Object combinedSearchCrumbs(EntradaCrumb en, HttpServletRequest req) throws IOException {
        try{
            Crumb c = new Crumb((String)req.getHeader("accessToken"));
            Success s = new Success();
            s.setRet(c.combinedSearchCrumbs(en.getInitDate(),en.getEndDate(),en.getThemes(),en.getPlaces(), en.getPage(),en.getPageSize()));
            return s;
        }
        catch(IllegalAccessException iae){
            return new Errors().tokenError;
        }
        catch (EntityNotFoundException e){
            return new Errors().idError;
        }
    }

    @ApiMethod(name = "combinedSearch",path = "combinedSearch",httpMethod = ApiMethod.HttpMethod.POST)
    public Object combinedSearch(EntradaCrumb en, HttpServletRequest req) throws IOException {
        try{
            Crumb c = new Crumb((String)req.getHeader("accessToken"));
            Success s = new Success();
            s.setRet(c.combinedSearch(en.getThemes(),en.getPlaces(),en.getDescription(),en.getPage(),en.getPageSize()));
            return s;
        }
        catch(IllegalAccessException iae){
            return new Errors().tokenError;
        }
        catch (EntityNotFoundException e){
            return new Errors().idError;
        }
    }

    *//**
     *
     * @param en
     * @param req
     * @return
     *//*
    @ApiMethod(name = "getLastCrumbs",path = "getLastCrumbs",httpMethod = ApiMethod.HttpMethod.POST)
    public Object getLastCrumbs(EntradaCrumb en, HttpServletRequest req) throws EntityNotFoundException, IOException {
        try{
            Crumb c = new Crumb((String)req.getHeader("accessToken"));
            Success s = new Success();
            s.setRet(c.getLastCrumbs(en.getBotLat(), en.getBotLng(), en.getTopLat(), en.getTopLng(), en.getInitDate(), en.getEndDate(), en.getPage(), en.getPageSize()));
            return s;
        }
        catch(IllegalAccessException iae){
            return new Errors().tokenError;
        }
    }

    @ApiMethod(name = "getSuggestedCrumbs",path = "getSuggestedCrumbs",httpMethod = ApiMethod.HttpMethod.POST)
    public Object getSuggestedCrumbs(EntradaCrumb en, HttpServletRequest req) throws EntityNotFoundException, IOException {
        try{
            Crumb c = new Crumb((String)req.getHeader("accessToken"));
            Success s = new Success();
            s.setRet(c.getLastCrumbs(en.getBotLat(), en.getBotLng(), en.getTopLat(), en.getTopLng(), en.getInitDate(), en.getEndDate(), en.getPage(), en.getPageSize()));
            return s;
        }
        catch(IllegalAccessException iae){
            return new Errors().tokenError;
        }
    }

    *//**
     *
     * @param en
     * @param req
     * @return
     *//*
    @ApiMethod(name = "addViewToCrumb",path = "addViewToCrumb",httpMethod = ApiMethod.HttpMethod.POST)
    public Object addViewToCrumb(EntradaCrumb en, HttpServletRequest req) {
        try{
            Crumb c = new Crumb((String)req.getHeader("accessToken"));
            Success s = new Success();
            c.addViewToCrumb(en.getCrumbId());
            return s;
        }
        catch(IllegalAccessException iae){
            return new Errors().tokenError;
        }
        catch (EntityNotFoundException e){
            return new Errors().idError;
        }
    }

    *//**
     *
     * @param en
     * @param req
     * @return
     *//*
    @ApiMethod(name = "getCrumbsByDate",path = "getCrumbsByDate",httpMethod = ApiMethod.HttpMethod.POST)
    public Object getCrumbsByDate(EntradaCrumb en, HttpServletRequest req) throws IOException {
        try{
            Crumb c = new Crumb((String)req.getHeader("accessToken"));
            Success s = new Success();
            s.setRet(c.getCrumbsByDate(en.getInitDate(), en.getEndDate()));
            return s;
        }
        catch(IllegalAccessException iae){
            return new Errors().tokenError;
        }
        catch (EntityNotFoundException e){
            return new Errors().idError;
        }
    }

    @ApiMethod(name = "deleteCrumb",path = "deleteCrumb",httpMethod = ApiMethod.HttpMethod.POST)
    public Object deleteCrumb(EntradaCrumb en, HttpServletRequest req) throws IOException {
        try{
            Crumb c = new Crumb((String)req.getHeader("accessToken"));
            Success s = new Success();
            c.deleteCrumb(en.getCrumbId());
            return s;
        }
        catch(IllegalArgumentException iae){
            return new Errors().permissionDenied;
        }
        catch(IllegalAccessException iae){
            return new Errors().tokenError;
        }
        catch (EntityNotFoundException e){
            return new Errors().idError;
        }
    }

    @ApiMethod(name = "getEmbedUrl",path = "getEmbedUrl",httpMethod = ApiMethod.HttpMethod.POST)
    public Object getEmbedUrl(EntradaCrumb en, HttpServletRequest req) throws IOException {
        try{
            Crumb c = new Crumb((String)req.getHeader("accessToken"));
            Success s = new Success();
            s.setRet(c.getEmbedUrl(en.getCrumbId()));
            return s;
        }
        catch(IllegalArgumentException iae){
            return new Errors().permissionDenied;
        }
        catch(IllegalAccessException iae){
            return new Errors().tokenError;
        }
        catch (EntityNotFoundException e){
            return new Errors().idError;
        }
    }

    @ApiMethod(name = "buyContent",path = "buyContent",httpMethod = ApiMethod.HttpMethod.POST)
    public Object buyContent(EntradaCrumb en, HttpServletRequest req) throws IOException {
        try{
            Crumb c = new Crumb((String)req.getHeader("accessToken"));

            Success s = new Success();
            return s;
        }
        catch(IllegalArgumentException iae){
            return new Errors().permissionDenied;
        }
        catch(IllegalAccessException iae){
            return new Errors().tokenError;
        }
    }*/
}

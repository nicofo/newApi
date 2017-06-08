package com.crumbits.Utilities;

import com.crumbits.Info.CrumbInfo;
import com.crumbits.Info.FileInfo;
import com.crumbits.Info.PlaceInfo;
import com.crumbits.Info.ThemeInfo;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.tools.cloudstorage.GcsService;
import com.google.appengine.tools.cloudstorage.GcsServiceFactory;
import com.google.appengine.tools.cloudstorage.RetryParams;
import com.google.maps.model.LatLng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by nico on 8/06/17.
 */
public class MockUtilities {
    private final int TOKEN_TIME = 60 * 24;
    private final String KEY = "01000000d08c9ddf0115d1118c7a00c04fc297eb010000001a114d45b8dd3f4aa11ad7c0abdae9800000000002000000000003660000a8000000100000005df63cea84bfb7d70bd6842e7efa79820000000004800000a000000010000000f10cd0f4a99a8d5814d94e0687d7430b100000008bf11f1960158405b2779613e9352c6d14000000e6b7bf46a9d485ff211b9b2a2df3bd\n" +
            "6eb67aae41";

    private final GcsService gcsService = GcsServiceFactory.createGcsService(new RetryParams.Builder()
            .initialRetryDelayMillis(10)
            .retryMaxAttempts(10)
            .totalRetryPeriodMillis(15000)
            .build());


    private final String bucket = "crumbit";
    private final String thumbnailBucket = "crumbit/thumbnails";

    //TODO Change all the fileInfo objects to a correct one
    public CrumbInfo entityToCrumb(String userId) throws EntityNotFoundException, IOException {
        ArrayList<ThemeInfo> themesList= new ArrayList<ThemeInfo>();
        ArrayList<FileInfo> infoList= new ArrayList<FileInfo>();
        FileInfo info =new FileInfo();
        PlaceInfo place= new PlaceInfo("Barcelona",
                new LatLng(41.3963097,2.1653831),
                "type",
                10,
                12,
                true,
                info,
                "ChIJ_5rXKOyipBIRkvCCQOH6ACY"
                );
        ThemeInfo theme = new ThemeInfo("#barcelona",
                10,
                12,
                true,
                info);
        themesList.add(theme);
        CrumbInfo crumb;
        infoList.add(info);
        crumb = new CrumbInfo("This is a crumb description",
                themesList,
                place,
                new Date(),
                infoList,
                5,
                3,
                4,
                0,
                2,
                3,
                new Date().getTime()/1000,
                false,
                true,
                info,
                false);


        return crumb;
    }
//
//    /**
//     *
//     * @param e
//     * @param userId
//     * @param op
//     * @return
//     * @throws EntityNotFoundException
//     */
//    public ThemeInfo entityToTheme(Entity e, String userId, int op) throws EntityNotFoundException {
//        ThemeInfo ti = new ThemeInfo();
//
//        ti.setName((String) e.getProperty("name"));
//        ti.setId(KeyFactory.keyToString(e.getKey()));
//
//        ArrayList<Key> userKeys = (ArrayList<Key>)e.getProperty("followed");
//        if(userKeys != null){
//            ti.setNreUsersFollowing(userKeys.size());
//            if(userId != null) ti.setIsFollowing(userKeys.contains(KeyFactory.stringToKey(userId)));
//        }
//        else{
//            ti.setNreUsersFollowing(0);
//            ti.setIsFollowing(false);
//        }
//        ArrayList<Key> crumbKeys = (ArrayList<Key>)e.getProperty("crumbs");
//        if(crumbKeys != null){
//            ti.setNreCrumbs(crumbKeys.size());
//        }
//        else{
//            ti.setNreCrumbs(0);
//        }
//
//        if(op == 1){
//            if(crumbKeys != null){
//                Entity c = DB.getById(crumbKeys.get(0));
//                ArrayList<Key> keyFiles = (ArrayList<Key>) c.getProperty("file");
//                if(keyFiles!= null){
//                    Entity file = DB.getById(keyFiles.get(0));
//                    Key thumbnail = (Key) file.getProperty("thumbnail");
//                    FileInfo fi = new FileInfo();
//                    if(thumbnail != null){
//                        Entity thumbnailFile = DB.getById(thumbnail);
//                        fi.setFileId((String) thumbnailFile.getProperty("storageId"));
//                        fi.setFileUrl((String) thumbnailFile.getProperty("fileUrl"));
//                        fi.setBucket((String) thumbnailFile.getProperty("bucket"));
//                    }
//                    else{
//                        fi.setFileId((String) file.getProperty("storageId"));
//                        fi.setFileUrl((String) file.getProperty("fileUrl"));
//                        fi.setBucket((String) file.getProperty("bucket"));
//                    }
//                    ti.setThemeFile(fi);
//                }
//            }
//        }
//        return ti;
//    }
//
//    /**
//     *
//     * @param e
//     * @param userId
//     * @param op
//     * @return
//     * @throws EntityNotFoundException
//     */
//    public PlaceInfo entityToPlace(Entity e, String userId, int op) throws EntityNotFoundException {
//        PlaceInfo p = new PlaceInfo();
//
//        p.setName((String) e.getProperty("name"));
//        p.setCoordinate(new LatLng((double)e.getProperty("lat"),(double)e.getProperty("lng")));
//        p.setId(KeyFactory.keyToString(e.getKey()));
//        p.setGoogleId((String) e.getProperty("googlePlaceId"));
//        ArrayList<Key> userKeys = (ArrayList<Key>)e.getProperty("followed");
//        if(userKeys != null){
//            p.setNreUsersFollowing(userKeys.size());
//            if(userId != null) p.setIsFollowing(userKeys.contains(KeyFactory.stringToKey(userId)));
//        }
//        else{
//            p.setNreUsersFollowing(0);
//            p.setIsFollowing(false);
//        }
//        ArrayList<Key> crumbKeys = (ArrayList<Key>)e.getProperty("crumbs");
//        if(crumbKeys != null){
//            p.setNreCrumbs(crumbKeys.size());
//        }
//        else{
//            p.setNreCrumbs(0);
//        }
//        if(op == 1){
//            if(crumbKeys != null){
//                Entity c = DB.getById(crumbKeys.get(0));
//                ArrayList<Key> keyFiles = (ArrayList<Key>) c.getProperty("file");
//                if(keyFiles!= null){
//                    Entity file = DB.getById(keyFiles.get(0));
//                    Key thumbnail = (Key) file.getProperty("thumbnail");
//                    FileInfo fi = new FileInfo();
//                    if(thumbnail != null){
//                        Entity thumbnailFile = DB.getById(thumbnail);
//                        fi.setFileId((String) thumbnailFile.getProperty("storageId"));
//                        fi.setFileUrl((String) thumbnailFile.getProperty("fileUrl"));
//                        fi.setBucket((String) thumbnailFile.getProperty("bucket"));
//                    }
//                    else{
//                        fi.setFileId((String) file.getProperty("storageId"));
//                        fi.setFileUrl((String) file.getProperty("fileUrl"));
//                        fi.setBucket((String) file.getProperty("bucket"));
//                    }
//                    p.setPlaceFile(fi);
//                }
//            }
//            if(crumbKeys != null){
//                Entity c = DB.getById(crumbKeys.get(0));
//                ArrayList<String> files = (ArrayList<String>)c.getProperty("crumbFile");
//                if(files != null){
//                    p.setPlaceFile(new FileInfo(bucket,files.get(0),null));
//                }
//            }
//        }
//        return p;
//    }
}

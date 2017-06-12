define({ "api": [
  {
    "type": "get",
    "url": "/crumb/v2/:id",
    "title": "Request Crumb information",
    "name": "getCrumbById",
    "group": "Crumb",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>Crumb unique ID.</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "description",
            "description": "<p>Description of the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "Date",
            "optional": false,
            "field": "date",
            "description": "<p>Date related to th crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "fileInfo[]",
            "optional": false,
            "field": "crumbFile",
            "description": "<p>Files of the content of the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "Number",
            "optional": false,
            "field": "relevance",
            "description": "<p>Relevance of the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "Number",
            "optional": false,
            "field": "nreShares",
            "description": "<p>Number of shares of the crumb.</p>"
          },
          {
            "group": "Success 200",
            "type": "Number",
            "optional": false,
            "field": "nreThanks",
            "description": "<p>Numeber of thanks of the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "Number",
            "optional": false,
            "field": "nreReports",
            "description": "<p>Number of reports of the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "Number",
            "optional": false,
            "field": "nreComments",
            "description": "<p>Number of comments of the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "Number",
            "optional": false,
            "field": "nreViews",
            "description": "<p>Number of views of the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "number",
            "optional": false,
            "field": "epochDate",
            "description": "<p>The epoch date of publication o the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "Boolean",
            "optional": false,
            "field": "isUserShare",
            "description": "<p>if the user liked the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "Boolean",
            "optional": false,
            "field": "isUserThanks",
            "description": "<p>if the user tahnked the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "Boolean",
            "optional": false,
            "field": "isOwner",
            "description": "<p>if the crumb is yours</p>"
          },
          {
            "group": "Success 200",
            "type": "placeInfo",
            "optional": false,
            "field": "place",
            "description": "<p>Place of the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "themeInfo[]",
            "optional": false,
            "field": "themes",
            "description": "<p>Array of all themes related to the crumb</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Success-Response:",
          "content": "  HTTP/1.1 200 OK\n{\n      \"data\" : {\n          \"id\" : \"21333331\",\n          \"description\" : \"This is a crumb description\",\n          \"date\" : \"2017-06-12T12:14:12.296+02:00\",\n          \"crumbFile\" : [ {\n              \"isVideo\" : false\n          } ],\n          \"relevance\" : 5,\n          \"nreShares\" : 3,\n          \"nreThanks\" : 4,\n          \"nreReports\" : 0,\n          \"nreComments\" : 2,\n          \"nreViews\" : 3,\n          \"epochDate\" : \"1497262452\",\n          \"isUserShare\" : false,\n          \"isUserThanks\" : true,\n          \"thumbnail\" : {\n              \"isVideo\" : false\n          },\n          \"isOwner\" : false,\n          \"place\" : {\n              \"name\" : \"Barcelona\",\n              \"coordinate\" : {\n                  \"lat\" : 41.3963097,\n                  \"lng\" : 2.1653831\n              },\n              \"type\" : \"type\",\n              \"nreCrumbs\" : 10,\n              \"nreUsersFollowing\" : 12,\n              \"isFollowing\" : true,\n              \"placeFile\" : {\n                  \"isVideo\" : false\n              },\n              \"googleId\" : \"ChIJ_5rXKOyipBIRkvCCQOH6ACY\"\n          },\n          \"themes\" : [ {\n              \"name\" : \"#barcelona\",\n              \"nreCrumbs\" : 10,\n              \"nreUsersFollowing\" : 12,\n              \"isFollowing\" : true,\n              \"themeFile\" : {\n                  \"isVideo\" : false\n              }\n          } ]\n      }\n  }",
          "type": "json"
        }
      ]
    },
    "error": {
      "fields": {
        "Error 4xx": [
          {
            "group": "Error 4xx",
            "type": "404",
            "optional": false,
            "field": "NotFound",
            "description": "<p>The id of the Crumb was not found.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n{\n            \"error\" : {\n                \"message\" : \"Crumb not found with id: 2133\",\n                \"code\" : 404,\n                \"errors\" : [ {\n                    \"domain\" : \"global\",\n                    \"reason\" : \"notFound\",\n                    \"message\" : \"Crumb not found with id: 2133\"\n                }   ]\n            }\n        }",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "Crumbits/src/main/java/com/crumbits/API/crumbAPI.java",
    "groupTitle": "Crumb"
  },
  {
    "type": "get",
    "url": "/crumb/v2/:id",
    "title": "Request Crumb information",
    "name": "getCrumbByIdUser",
    "group": "Crumb",
    "permission": [
      {
        "name": "User"
      }
    ],
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "id",
            "description": "<p>Crumb unique ID.</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "description",
            "description": "<p>Description of the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "Date",
            "optional": false,
            "field": "date",
            "description": "<p>Date related to th crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "fileInfo[]",
            "optional": false,
            "field": "crumbFile",
            "description": "<p>Files of the content of the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "Number",
            "optional": false,
            "field": "relevance",
            "description": "<p>Relevance of the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "Number",
            "optional": false,
            "field": "nreShares",
            "description": "<p>Number of shares of the crumb.</p>"
          },
          {
            "group": "Success 200",
            "type": "Number",
            "optional": false,
            "field": "nreThanks",
            "description": "<p>Numeber of thanks of the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "Number",
            "optional": false,
            "field": "nreReports",
            "description": "<p>Number of reports of the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "Number",
            "optional": false,
            "field": "nreComments",
            "description": "<p>Number of comments of the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "Number",
            "optional": false,
            "field": "nreViews",
            "description": "<p>Number of views of the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "number",
            "optional": false,
            "field": "epochDate",
            "description": "<p>The epoch date of publication o the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "Boolean",
            "optional": false,
            "field": "isUserShare",
            "description": "<p>if the user liked the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "Boolean",
            "optional": false,
            "field": "isUserThanks",
            "description": "<p>if the user tahnked the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "Boolean",
            "optional": false,
            "field": "isOwner",
            "description": "<p>if the crumb is yours</p>"
          },
          {
            "group": "Success 200",
            "type": "placeInfo",
            "optional": false,
            "field": "place",
            "description": "<p>Place of the crumb</p>"
          },
          {
            "group": "Success 200",
            "type": "themeInfo[]",
            "optional": false,
            "field": "themes",
            "description": "<p>Array of all themes related to the crumb</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Success-Response:",
          "content": "  HTTP/1.1 200 OK\n{\n  \"data\" : {\n  \"id\" : \"21333331\",\n  \"description\" : \"This is a crumb description\",\n  \"date\" : \"2017-06-12T12:14:12.296+02:00\",\n  \"crumbFile\" : [ {\n  \"isVideo\" : false\n  } ],\n  \"relevance\" : 5,\n  \"nreShares\" : 3,\n  \"nreThanks\" : 4,\n  \"nreReports\" : 0,\n  \"nreComments\" : 2,\n  \"nreViews\" : 3,\n  \"epochDate\" : \"1497262452\",\n  \"isUserShare\" : false,\n  \"isUserThanks\" : true,\n  \"thumbnail\" : {\n  \"isVideo\" : false\n  },\n  \"isOwner\" : false,\n  \"place\" : {\n  \"name\" : \"Barcelona\",\n  \"coordinate\" : {\n  \"lat\" : 41.3963097,\n  \"lng\" : 2.1653831\n  },\n  \"type\" : \"type\",\n  \"nreCrumbs\" : 10,\n  \"nreUsersFollowing\" : 12,\n  \"isFollowing\" : true,\n  \"placeFile\" : {\n  \"isVideo\" : false\n  },\n  \"googleId\" : \"ChIJ_5rXKOyipBIRkvCCQOH6ACY\"\n  },\n  \"themes\" : [ {\n  \"name\" : \"#barcelona\",\n  \"nreCrumbs\" : 10,\n  \"nreUsersFollowing\" : 12,\n  \"isFollowing\" : true,\n  \"themeFile\" : {\n  \"isVideo\" : false\n  }\n  } ]\n  }\n  }",
          "type": "json"
        }
      ]
    },
    "error": {
      "fields": {
        "Error 4xx": [
          {
            "group": "Error 4xx",
            "type": "404",
            "optional": false,
            "field": "NotFound",
            "description": "<p>The id of the Crumb was not found.</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n{\n\"error\" : {\n\"message\" : \"Crumb not found with id: 2133\",\n\"code\" : 404,\n\"errors\" : [ {\n\"domain\" : \"global\",\n\"reason\" : \"notFound\",\n\"message\" : \"Crumb not found with id: 2133\"\n}   ]\n}\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "Crumbits/src/main/java/com/crumbits/API/crumbAPI.java",
    "groupTitle": "Crumb"
  }
] });

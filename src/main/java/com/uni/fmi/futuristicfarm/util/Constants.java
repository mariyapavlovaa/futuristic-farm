package com.uni.fmi.futuristicfarm.util;

public class Constants {

    //Path variables
    public static final String API_V1 = "/api/v1";
    public static final String USER = "/user";
    public static final String COMMENT = "/comment";
    public static final String SEASON_PHASE = "/season/phase";
    public static final String USER_ROLE_PATH = "/user/role";
    public static final String ARTICLE = "/article";
    public static final String TAG = "/tag";

    //User
    public static final int USERNAME_SIZE = 150;
    public static final int PASSWORD_SIZE = 200;
    public static final int NAME_SIZE = 200;
    public static final int USER_EMAIL_SIZE = 250;

    public static final String USER_TABLE_NAME = "users";
    public static final String USER_USERNAME = "username";
    public static final String USER_PASSWORD = "password";
    public static final String USER_FIRST_NAME = "first_name";
    public static final String USER_LAST_NAME = "last_name";
    public static final String USER_EMAIL = "email";
    public static final String USER_USER_POSITION_ID = "role_id";
    public static final String IS_DELETED = "is_deleted";

    //UserPosition
    public static final String USER_ROLE_TABLE_NAME = "user_role";
    public static final int USER_ROLE_SIZE = 100;
    public static final String USER_ROLE = "role";

    //Admin
    public static final String ADMIN_TABLE_NAME = "admin";

    //Client
    public static final int CLIENT_BIRTH_DATE_SIZE = 100;
    public static final String CLIENT_TABLE_NAME = "client";
    public static final String CLIENT_BIRTH_DATE = "birth_date";

    //Article
    public static final String ARTICLE_TABLE_NAME = "article";
    public static final String ARTICLE_TAG_TABLE_NAME = "tag";

    public static final String ARTICLE_TOPIC_NAME = "topic_name";
    public static final int ARTICLE_TOPIC_NAME_SIZE = 200;
    public static final String ARTICLE_DESCRIPTION = "description";
    public static final int ARTICLE_DESCRIPTION_SIZE = 300;
    public static final String ARTICLE_COLUMN_TAG = "tag";
    public static final int ARTICLE_TAG_SIZE_NAME = 100;
    public static final int ARTICLE_TAG_SIZE_ABBREVIATION = 50;
    public static final String ARTICLE_TAG_ABBREVIATION = "abbreviation";
    public static final String ARTICLE_TAG_NAME = "name";
    public static final String ARTICLE_COLUMN_POSTED_AT = "posted_at";

    //SeasonPhase
    public static final String SEASON_PHASE_TABLE_NAME = "season_phase";

    public static final String SEASON_PHASE_NAME = "phase_name";
    public static final int SEASON_PHASE_PHASE_NAME_SIZE = 50;
    public static final String SEASON_PHASE_DESCRIPTION = "description";
    public static final int SEASON_PHASE_DESCRIPTION_SIZE = 150;
    public static final String SEASON_START_DATE = "season_start_date";
    public static final int SEASON_START_DATE_SIZE = 50;
    public static final String SEASON_END_DATE = "season_end_date";
    public static final int SEASON_END_DATE_SIZE = 50;

    //Comment
    public static final String COMMENT_TABLE_NAME = "comment";

    public static final String COMMENT_DESCRIPTION = "description";
    public static final int COMMENT_DESCRIPTION_SIZE = 500;

    public static final String COMMENT_CREATE_DATE = "comment_create_date";
    public static final int COMMENT_DATE_SIZE = 50;

    //Crop
    public static final String CROP_TABLE_NAME = "crop";
    public static final int CROP_NAME_SIZE = 300;

    //Sort
    public static final String SORT_TABLE_NAME = "sort";
    public static final int SORT_NAME_SIZE = 400;
    public static final String SORT_DESCRIPTION = "description";
    public static final int SORT_DESCRIPTION_SIZE = 500;

    //Soil
    public static final String SOIL_TABLE_NAME = "soil";
    public static final int SOIL_NAME_SIZE = 300;
    public static final int SOIL_DESCRIPTION_SIZE = 500;
    public static final int SOIL_TEMPERATURE_SIZE = 50;

    //Plant
    public static final String PLANT_TABLE_NAME = "plant";
    public static final int PLANT_NAME_SIZE = 500;
    public static final int PLANT_DESCRIPTION_SIZE = 600;

    //IllnessSymptom
    public static final String SYMPTOMS_TABLE_NAME = "symptom";
    public static final int ILLNESS_SYMPTOMS_NAME_SIZE = 600;

    //Illness
    public static final String ILLNESS_TABLE_NAME = "illness";
    public static final int ILLNESS_NAME_SIZE = 600;
    public static final int ILLNESS_DESCRIPTION_SIZE = 800;

    //Consultation
    public static final String CONSULTATION_TABLE_NAME = "consultation";
    public static final String CONSULTATION_TREATMENT_DESCRIPTION = "treatment_description";
    public static final int CONSULTATION_TREATMENT_DESCRIPTION_SIZE = 700;
    public static final String CONSULTATION_PLANT_NAME = "plant_name";
    public static final int CONSULTATION_PLANT_NAME_SIZE = 700;
    public static final String CONSULTATION_ILLNESS_SYMPTOMS_NAME = "illness_symptoms";

    //Diagnose
    public static final String DIAGNOSE_TABLE_NAME = "diagnose";
    public static final int DIAGNOSE_NAME = 300;

}

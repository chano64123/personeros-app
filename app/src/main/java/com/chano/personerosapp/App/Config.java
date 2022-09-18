package com.chano.personerosapp.App;

import com.chano.personerosapp.Model.Usuario;

public class Config {
    //API SAETA
    public static final String BASE_URL_API_PERSONEROS = "https://personerosbackend.herokuapp.com/";

    //API RENIEC
    public static final String TOKEN_API_RENIEC = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6InByb21vMjAxNjc0QGdtYWlsLmNvbSJ9.SDxqQGi2nMScGlxP_EP6TXOo-mwksYzZgA4y-GvB5oc";
    public static final String BASE_URL_API_RENIEC = "https://dniruc.apisperu.com/api/v1/";

    //PARA LA CARGA INICIAL
    public static Usuario USER = new Usuario();
    public static final String BASE_URL_IMAGE_USER = BASE_URL_API_PERSONEROS + "/api/uploads/";
    public static final String DEFAULT_IMAGE_NAME = "no-image";

    //TIEMPO PARA SOLICITUDES
    public static final int CONNECT_TIMEOUT = 10;
    public static final int WRITE_TIMEOUT = 15;
    public static final int READ_TIMEOUT = 30;

    //para TIPOS DE USUARIO
    public static final int USER_TYPE_PERSONERO = 1;
    public static final int USER_TYPE_COORDINADOR = 2;
    public static final int USER_TYPE_ENLACE = 3;

    //para recuperar valores de activities
    public static final String ALERT_ID = "ID_ALERT_USER";
    public static final String USER_ID = "ID_USER";

    //PARA REGISTRAR UN USUARIO CIUDADANO
    public static final String CITIZEN_ROLE = "CIUDADANO";
    public static final String DEFAULT_STATE_USER = "HABILITADO";

    //PARA VALIDAR ALGUNAS COSAS
    public static boolean ALERT_TYPES_IS_LOAD = false;
    public static boolean USER_ALERTS_IS_LOAD = false;

    //PERMISOS
    public static final int REQUEST_PERMISSION_CAMERA = 100;
    public static final int REQUEST_PERMISSION_READ_EXTERNAL_STORAGE = 101;
    public static final int REQUEST_PERMISSION_ACCESS_FINE_LOCATION = 102;
    public static final int REQUEST_PERMISSION_CONTACTS = 103;
    public static final int REQUEST_PERMISSION_SEND_SMS = 104;
    public static final int REQUEST_PERMISSION_LOCATION_AND_SEND_SMS = 105;

    //ENCENDER GPS
    public static final int ENABLE_GPS = 400;

    //NETWORK
    public static final int ENABLE_NETWORK = 500;

    //PARA ALERTAS
    public static final String DEFAULT_ID_STATE_ALERT = "6163a7eac89043838a762432";
    public static String ALERT_ID_VARIABLE = "6163a7eac89043838a762432";

    //MAP
    public static final float MAP_ZOM = 16;
    public static final String LINK_MAP = "maps.google.com/?q=";

    //CONTACTOS
    public static final int CANTIDAD_MAXIMA_CONTACTOS = 5;

    //PARA LA FOTO
    public static final CharSequence[] OPTIONS_PHOTO = {"Tomar Foto", "Elegir de Galería", "Cancelar"};
    public static final int IMAGE_FROM_GALLERY = 10;
    public static final int IMAGE_FROM_CAMERA = 20;
    public static final int CONTACT_FROM_CONTACTS = 30;
    public static final String DIRECTORY_IMAGES = "CIUDADANO";

    //NUMEROS
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;

    //ESTADOS DE ALERTAS
    public static final String ALERT_STATE_RESOLVED = "Resuelta";
    public static final String ALERT_STATE_IN_PROCESS = "En proceso";
    public static final String ALERT_STATE_PENDING = "Pendiente";
    public static final String ALERT_STATE_CANCELLED = "Cancelada";

    //TIPOS DE ALERTAS
    public static final String ALERT_TYPE_STOLE = "Robo";
    public static final String ALERT_TYPE_FIRE = "Incendio";
    public static final String ALERT_TYPE_DOMESTIC_VIOLENCE = "Violencia Familiar";
    public static final String ALERT_TYPE_CAR_ACCIDENT = "Accidente de Tránsito";
    public static final String ALERT_TYPE_GANG = "Pandillaje";
    public static final String ALERT_TYPE_OTHER = "Otro";
    public static final String ALERT_TYPE_EMERGENCY = "Emergencia";

    //POSITION TIPOS DE ALERTAAS
    public static final int POSITION_ALERT_TYPE_STOLE = 0;
    public static final int POSITION_ALERT_TYPE_CAR_ACCIDENT =1;
    public static final int POSITION_ALERT_TYPE_GANG = 2;
    public static final int POSITION_ALERT_TYPE_DOMESTIC_VIOLENCE =3;
    public static final int POSITION_ALERT_TYPE_FIRE = 4;
    public static final int POSITION_ALERT_TYPE_OTHER = 5;
    public static final int POSITION_ALERT_TYPE_EMERGENCY = 6;

    //EVENTOS SOCKET
    public static final String SOCKET_UPDATE_ALERT = "updatedAlert";
    public static final String SOCKET_UPDATE_PROFILE = "updatedProfile";
    public static final String SOCKET_UPDATE_VALUATION = "updatedValuation";
    public static final String SOCKET_DISABLE_USER = "disableUser";

    //TAG's
    public static final String TAG_FILTER = "Filter";
    public static final String TAG_SOCKET = "Socket";

    //PARA SABER EN QUE FRAGMENT ESTOY
    public static String CURRENT_FRAGMENT = "emergency";

    //FRAGMENTS
    public static final String FRAGMENT_EMERGENCY = "emergency";
    public static final String FRAGMENT_ALERTS = "alerts";
    public static final String FRAGMENT_ALERT_DETAIL = "alertDetail";
    public static final String FRAGMENT_PROFILE = "profile";
    public static final String ACTIVITY_MAIN = "main";

    //AUXULIARES
    public static final String TEXT_EMPTY = "";
    public static final String TEXT_HYPHEN = "-";
    public static final String TEXT_HYPHEN_SPACES = " - ";
    public static final String TEXT_COMMA = ",";
    public static final String TEXT_QUOTATION_QUESTION = "\"?";
    public static final String TEXT_POINT_SPACE = ". ";
    public static final String TEXT_UNDERSCORE = "_";
}

package br.com.joaocorreia.searchcodegithub.banco;

/**
 * Created by joaocorreia on 30/10/16.
 */
public interface OwnerContrato {

    String DB_NAME = "dbOwner";
    String DB_TABLE = "OWNER";
    String _ID = "_ID";

    String COL_LOGIN  = "login";
    String COL_BLOG    = "blog";
    String COL_AVATAR     = "avatar_url";
    String COL_ID   = "id";
    String COL_EMAIL    = "email";
    String COL_DT   = "created_at";


    String[] ALL_COLUMNS = new String[] {
            _ID         ,
            COL_LOGIN   ,
            COL_BLOG    ,
            COL_AVATAR  ,
            COL_ID      ,
            COL_EMAIL   ,
            COL_DT
    };
    String[] LIST_COLUMNS = new String[]{
            OwnerContrato._ID,
            OwnerContrato.COL_LOGIN ,
            OwnerContrato.COL_BLOG  ,
            OwnerContrato.COL_AVATAR,
            OwnerContrato.COL_ID    ,
            OwnerContrato.COL_EMAIL ,
            OwnerContrato.COL_DT
    };

}

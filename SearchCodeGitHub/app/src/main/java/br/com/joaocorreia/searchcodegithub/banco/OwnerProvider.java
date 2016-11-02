package br.com.joaocorreia.searchcodegithub.banco;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class OwnerProvider extends ContentProvider {

    private static final String AUTHORITY ="br.com.joaocorreia.owner";
    private static final String PATH = "owner";
    private static final int TIPO_GERAL = 1;
    private static final int TIPO_OWNER_ESPECIFICO = 2;

    public static Uri BASE_URI = Uri.parse("content://" + AUTHORITY);
    public static Uri OWNER_URI = BASE_URI.withAppendedPath(BASE_URI, PATH);

    private UriMatcher mMatcher;
    private OwnerDBHelper ownerDBHelper;

    public OwnerProvider() {
        mMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        mMatcher.addURI(AUTHORITY,PATH,TIPO_GERAL);
        mMatcher.addURI(AUTHORITY,PATH + "/#", TIPO_OWNER_ESPECIFICO);
    }

    @Override
    public boolean onCreate() {
        ownerDBHelper = new OwnerDBHelper(getContext());
        return true;
    }

    @Override
    public String getType(Uri uri) {
       int uriType = mMatcher.match(uri);
        switch (uriType){
            case TIPO_GERAL:
                return ContentResolver.CURSOR_DIR_BASE_TYPE + "/"+ AUTHORITY;
            case TIPO_OWNER_ESPECIFICO:
                return ContentResolver.CURSOR_ITEM_BASE_TYPE+ "/" + AUTHORITY;
            default:
                throw new IllegalArgumentException("Invalid Uri");
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int uriType = mMatcher.match(uri);
        if(uriType == TIPO_GERAL){
            SQLiteDatabase db = ownerDBHelper.getWritableDatabase();
            long id = db.insert(OwnerContrato.DB_TABLE, null, values);
            db.close();
            getContext().getContentResolver().notifyChange(uri,null);
            return ContentUris.withAppendedId(OWNER_URI,id);
        }else{
            throw new IllegalArgumentException("Invalid Uri");
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int uriType = mMatcher.match(uri);
        if(uriType == TIPO_OWNER_ESPECIFICO){
            SQLiteDatabase db = ownerDBHelper.getWritableDatabase();
            long id = ContentUris.parseId(uri);
            int linhasAfetadas = db.delete(
                    OwnerContrato.DB_TABLE,
                    OwnerContrato._ID,
                    new String[]{String.valueOf(id)}
            );
            db.close();
            getContext().getContentResolver().notifyChange(uri,null);
            return linhasAfetadas;

        }else{
            throw new IllegalArgumentException("Invalid Uri");
        }
    }


       @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
           int uriType = mMatcher.match(uri);
           SQLiteDatabase db = ownerDBHelper.getReadableDatabase();
           Cursor cursor;
           switch (uriType){
               case TIPO_GERAL:
                   cursor = db.query(OwnerContrato.DB_TABLE,
                           projection, selection, selectionArgs, null, null, sortOrder);
                   break;

               case TIPO_OWNER_ESPECIFICO:
                   long id = ContentUris.parseId(uri);
                   cursor = db.query(OwnerContrato.DB_TABLE,
                           projection, OwnerContrato._ID +" = ?",
                           new String[] { String.valueOf(id) }, null, null, sortOrder);
                   break;

               default:
                   throw new IllegalArgumentException("Invalid Uri");
           }
           cursor.setNotificationUri(getContext().getContentResolver(), uri);
           return cursor;
       }


    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

package br.com.joaocorreia.searchcodegithub.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;

import br.com.joaocorreia.searchcodegithub.banco.OwnerContrato;
import br.com.joaocorreia.searchcodegithub.banco.OwnerProvider;
import br.com.joaocorreia.searchcodegithub.modelo.Owner;

/**
 * Created by joaocorreia on 30/10/16.
 */
public class OwnerRepositorio {


    private Context ctx;

    public OwnerRepositorio(Context ctx) {
        this.ctx = ctx;
    }

    private long inserir(Owner owner){
        Uri uri = ctx.getContentResolver().insert(
                OwnerProvider.OWNER_URI,
                getValues(owner));
        long id = Long.parseLong(uri.getLastPathSegment());
        if(id!=-1){
            owner.set_id(id);
        }
        return id;
    }

    public int delete (Owner owner){
        Uri uri = Uri.withAppendedPath(OwnerProvider.OWNER_URI,String.valueOf(owner.get_id()));

        int linhasAfetadas = ctx.getContentResolver().delete(uri,null,null);

        return linhasAfetadas;

    }

    public void salvar(Owner owner){
        if(owner.get_id() == 0){
            inserir(owner);
        }else{
            delete(owner);
        }
    }

    public CursorLoader buscar(Context ctx, String s){
        return new CursorLoader(ctx,OwnerProvider.OWNER_URI,null,null,null,null);
    }

    private ContentValues getValues(Owner owner){
        ContentValues cv = new ContentValues();
        cv.put(OwnerContrato.COL_LOGIN, owner.getLogin());

        cv.put(OwnerContrato.COL_AVATAR, owner.getAvatar_url());
        if(owner.getBlog() !=null && !owner.getBlog().isEmpty()) {
            cv.put(OwnerContrato.COL_BLOG, owner.getBlog());
        }else{
            cv.put(OwnerContrato.COL_BLOG, owner.getHtml_url());
        }
        cv.put(OwnerContrato.COL_ID, owner.getId());
        if(owner.getEmail()!=null && !owner.getEmail().isEmpty()){
            cv.put(OwnerContrato.COL_EMAIL, owner.getEmail());
        }else {
            cv.put(OwnerContrato.COL_EMAIL, "-");
        }
       // cv.put(OwnerContrato.COL_DT, owner.getCreated_at());
        return cv;
    }

    public static Owner parseCursor(Cursor cursor){
        long _id = cursor.getLong(cursor.getColumnIndex(OwnerContrato._ID));
        Integer id = cursor.getInt(cursor.getColumnIndex(OwnerContrato.COL_ID));
        String login = cursor.getString(cursor.getColumnIndex(OwnerContrato.COL_LOGIN));
        String email = cursor.getString(cursor.getColumnIndex(OwnerContrato.COL_EMAIL));
        String blog = cursor.getString(cursor.getColumnIndex(OwnerContrato.COL_BLOG));
        String avatar = cursor.getString(cursor.getColumnIndex(OwnerContrato.COL_AVATAR));
        //montar objeto
        Owner owner = new Owner();
        owner.set_id(_id);
        owner.setId(id);
        owner.setLogin(login);
        owner.setEmail(email);
        owner.setBlog(blog);
        owner.setAvatar_url(avatar);

        return owner;

    }
}

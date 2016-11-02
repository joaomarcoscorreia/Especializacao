package br.com.joaocorreia.searchcodegithub.util;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import br.com.joaocorreia.searchcodegithub.R;
import br.com.joaocorreia.searchcodegithub.banco.OwnerContrato;

/**
 * Created by joaocorreia on 01/11/16.
 */
public class OwnerCursosAdapter extends CursorAdapter {

    public OwnerCursosAdapter(Context context, Cursor c) {
        super(context, c,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.lista_favoritos,null);
    }


    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txLogin = (TextView) view.findViewById(R.id.id_text_login);
        TextView txEmail = (TextView) view.findViewById(R.id.id_text_email);

        txLogin.setText(cursor.getColumnIndex(OwnerContrato.COL_LOGIN));
        txEmail.setText(cursor.getColumnIndex(OwnerContrato.COL_EMAIL));

    }
}
